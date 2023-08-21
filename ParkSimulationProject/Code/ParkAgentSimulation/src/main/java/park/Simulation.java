package park;

import agents.dogs.Dachshund;
import agents.dogs.Dog;
import agents.dogs.GoldenRetriever;
import agents.dogs.Rottweiler;
import agents.humans.DogCatcher;
import agents.humans.Human;
import agents.humans.Walker;

import java.util.ArrayList;
import java.util.List;

import static simulation.Configuration.config;

/**
 * Class performing simulation
 */
public class Simulation {

    private final Board board;
    private final Field[][] park;

    public Simulation(Board board) {

        this.board = board;
        this.park = board.getBoard();
    }

    /**
     * General method starting simulation
     */
    public void performSimulation() {
        performInteractions();
        changePosition();
        setCorrectHasMoved();
    }

    /**
     * Method performing all interactions
     */
    public void performInteractions() {
        for (Field[] fields : park) {
            for (Field field : fields) {
                if (field.isAssigned()) {

                    if (!field.getDachshundArrayList().isEmpty() && (field.isHasBone() || field.isHasPoison()))
                        performInteractionsForDachshund(field);

                    if (!field.getGoldenRetrieverArrayList().isEmpty())
                        performInteractionsForGoldenRetriever(field);

                    if (!field.getRottweilerArrayList().isEmpty())
                        performInteractionsForRottweiler(field);

                    if (!field.getDogCatcherArrayList().isEmpty() && !field.getRottweilerArrayList().isEmpty())
                        performInteractionsForDogCatcher(field);

                    if (!field.getWalkerArrayList().isEmpty() && !field.getGoldenRetrieverArrayList().isEmpty())
                        performInteractionsForWalker(field);
                }
            }
        }
    }

    /**
     * Method that changes position of all agents
     */
    public void changePosition() {

        for (Field[] fields : park) {
            for (Field field : fields) {
                if (field.isAssigned()) {
                    moveDogs(config.agents.dog_breeds.DACHSHUNDS, field, field.getDachshundArrayList());
                    moveDogs(config.agents.dog_breeds.GOLDEN_RETRIEVERS, field, field.getGoldenRetrieverArrayList());
                    moveDogs(config.agents.dog_breeds.ROTTWEILERS, field, field.getRottweilerArrayList());
                    moveHumans(config.agents.human_types.DOG_CATCHERS, field, field.getDogCatcherArrayList());
                    moveHumans(config.agents.human_types.WALKERS, field, field.getWalkerArrayList());
                    field.checkIfFieldIsEmpty();
                }
            }
        }
    }

    /**
     * Method that performs interaction of Dachshunds on given field
     * @param field Field on which interactions are performed
     */
    public void performInteractionsForDachshund(Field field) {
        for (Dachshund dachshund : field.getDachshundArrayList()) {
            searchForBonesOrPoisons(field, dachshund);
        }
    }
    /**
     * Method that performs interaction of Goldens on given field
     * @param field Field on which interactions are performed
     */
    public void performInteractionsForGoldenRetriever(Field field) {
        for (int g = 0; g < field.getGoldenRetrieverArrayList().size(); g++) {
            if (g + 1 < field.getGoldenRetrieverArrayList().size()) {
                field.getGoldenRetrieverArrayList().get(g).play(field.getGoldenRetrieverArrayList().get(g + 1));
            }
            searchForBonesOrPoisons(field, field.getGoldenRetrieverArrayList().get(g));
        }
    }
    /**
     * Method that performs interaction of Rottweiler on given field
     * @param field Field on which interactions are performed
     */
    public void performInteractionsForRottweiler(Field field) {

        List<Integer> killedRottweilers = new ArrayList<>();
        List<Integer> killedGoldenRetrievers = new ArrayList<>();

        for (int r = 0; r < field.getRottweilerArrayList().size(); r++) {
            if (r + 1 < field.getRottweilerArrayList().size()) {
                if(field.getRottweilerArrayList().get(r).isAlive() && field.getRottweilerArrayList().get(r + 1).isAlive()) {
                    Rottweiler looser = field.getRottweilerArrayList().get(r).attack(field.getRottweilerArrayList().get(r + 1));
                    board.getKilledRottweilers().add(looser);
                    if (looser == field.getRottweilerArrayList().get(r)) killedRottweilers.add(r);
                    else killedRottweilers.add(r + 1);
                }
            }
            for (int g = 0; g < field.getGoldenRetrieverArrayList().size(); g++) {
                if(!field.getGoldenRetrieverArrayList().get(g).isAdopted() && field.getGoldenRetrieverArrayList().get(g).isAlive()) {
                    field.getRottweilerArrayList().get(r).attack(field.getGoldenRetrieverArrayList().get(g));
                    board.getKilledDogs().add(field.getGoldenRetrieverArrayList().get(g));
                    killedGoldenRetrievers.add(g);
                }
            }
            searchForBonesOrPoisons(field, field.getRottweilerArrayList().get(r));
        }

        if(!killedRottweilers.isEmpty()){
            removeDogsFromField(killedRottweilers, config.agents.dog_breeds.ROTTWEILERS, field);
        }

        if(!killedGoldenRetrievers.isEmpty()){
            removeDogsFromField(killedGoldenRetrievers, config.agents.dog_breeds.GOLDEN_RETRIEVERS, field);
        }
    }
    /**
     * Method that performs interaction of Dog Catcher on given field
     * @param field Field on which interactions are performed
     */
    public void performInteractionsForDogCatcher(Field field){

        ArrayList<Integer> caughtRottweilers = new ArrayList<>();

        for (DogCatcher dogCatcher : field.getDogCatcherArrayList()) {
            for (int r = 0; r < field.getRottweilerArrayList().size(); r++) {
                if(field.getRottweilerArrayList().get(r).isAlive()) {
                    dogCatcher.catchDog(field.getRottweilerArrayList().get(r));
                    if (field.getRottweilerArrayList().get(r).isCaught()) {
                        board.getCaughtRottweilers().add(field.getRottweilerArrayList().get(r));
                        caughtRottweilers.add(r);
                    }
                }
            }
        }

        removeDogsFromField(caughtRottweilers, config.agents.dog_breeds.ROTTWEILERS, field);
    }
    /**
     * Method that performs interaction of Walker on given field
     * @param field Field on which interactions are performed
     */
    public void performInteractionsForWalker(Field field) {
        for (Walker walker : field.getWalkerArrayList()) {
            for (int g = 0; g < field.getGoldenRetrieverArrayList().size(); g++) {
                if (!field.getGoldenRetrieverArrayList().get(g).isAdopted() && field.getGoldenRetrieverArrayList().get(g).isAlive()) {
                    boolean dogWasAdopted = walker.adoptDog(field.getGoldenRetrieverArrayList().get(g));
                    if (dogWasAdopted) board.getAdoptedDogs().add(field.getGoldenRetrieverArrayList().get(g));
                }
                else walker.strokeDog(field.getGoldenRetrieverArrayList().get(g));
            }
        }
    }

    /**
     * Method that search given field for poison or bone
     * @param field Field where we are searching
     * @param dog Dog present on that field that can interact with found resource
     */
    public void searchForBonesOrPoisons(Field field, Dog dog) {
        if (field.isHasBone()) {
            dog.pickBone();
            field.setHasBone(false);
        }
        if (field.isHasPoison()) {
            dog.pickPoison();
            field.setHasPoison(false);
        }
    }

    /**
     * Method that move dogs position
     * @param breed Breed of dog
     * @param field Field on which is dog
     * @param dogs List of dogs on given field
     */
    public void moveDogs(String breed, Field field, ArrayList<? extends Dog> dogs) {

        List<Integer> dogsIndexForRemoveList = new ArrayList<>();

        if (!dogs.isEmpty()) {
            for (int d = 0; d < dogs.size(); d++) {
                if (!dogs.get(d).isWasMoved()) {

                    int newX = board.getNewPosition(field.getPositionX(), board.getX());
                    int newY = board.getNewPosition(field.getPositionY(), board.getY());

                    dogsIndexForRemoveList.add(d);
                    dogs.get(d).setWasMoved(true);
                    addDogToNewField(dogs, breed, newX, newY, d);
                }
                else dogs.get(d).setWasMoved(false);
            }
            removeDogsFromField(dogsIndexForRemoveList, breed, field);
        }
    }

    /**
     * Method that add dog to new field
     * @param dogs List of dogs in new field
     * @param breed Breed of added dog
     * @param newX New x position
     * @param newY New y position
     * @param d Index of added dog
     */
    public void addDogToNewField(ArrayList<? extends Dog> dogs, String breed, int newX, int newY, int d){
        if (breed.equals(config.agents.dog_breeds.DACHSHUNDS)) {
            park[newX][newY].getDachshundArrayList().add((Dachshund) dogs.get(d));
        } else if (breed.equals(config.agents.dog_breeds.GOLDEN_RETRIEVERS)) {
            park[newX][newY].getGoldenRetrieverArrayList().add((GoldenRetriever) dogs.get(d));
        } else {
            park[newX][newY].getRottweilerArrayList().add((Rottweiler) dogs.get(d));
        }
        park[newX][newY].setAssigned(true);
    }

    /**
     * Method that removes dog from field
     * @param dogsIndexForRemoveList Helper list of dogs being removed from field
     * @param breed Breed of dog
     * @param field Given field
     */
    public void removeDogsFromField(List<Integer> dogsIndexForRemoveList, String breed, Field field){
        if (breed.equals(config.agents.dog_breeds.DACHSHUNDS)) {
            for (int i = 0; i < dogsIndexForRemoveList.size(); i++) {
                try{
                    field.getDachshundArrayList().remove((dogsIndexForRemoveList.get(i) - i));
                }
                catch (IndexOutOfBoundsException ignored){}
            }
        } else if (breed.equals(config.agents.dog_breeds.GOLDEN_RETRIEVERS)) {
            for (int i = 0; i < dogsIndexForRemoveList.size(); i++) {
                try{
                    field.getGoldenRetrieverArrayList().remove((dogsIndexForRemoveList.get(i) - i));
                }
                catch (IndexOutOfBoundsException ignored){}
            }
        } else {
            for (int i = 0; i < dogsIndexForRemoveList.size(); i++)
                try{
                    field.getRottweilerArrayList().remove((dogsIndexForRemoveList.get(i) - i));
                }
                catch (IndexOutOfBoundsException ignored){}

        }
    }

    /**
     * Method of moving humans
     * @param type Dog Cather or Walker
     * @param field Given field
     * @param humans List of humans in given field
     */
    public void moveHumans(String type, Field field, ArrayList<? extends Human> humans) {

        List<Integer> humansIndexForRemoveList = new ArrayList<>();

        if (!humans.isEmpty()) {
            for (int h = 0; h < humans.size(); h++) {
                if (!humans.get(h).isWasMoved()) {
                    int newX = board.getNewPosition(field.getPositionX(), board.getX());
                    int newY = board.getNewPosition(field.getPositionY(), board.getY());

                    humansIndexForRemoveList.add(h);
                    humans.get(h).setWasMoved(true);
                    addHumanToNewField(humans, type, newX, newY, h);
                } else humans.get(h).setWasMoved(false);
            }
            removeHumansFromField(humansIndexForRemoveList, type, field);
        }
    }

    /**
     * Correcting flag setMoved after iteration
     */
    public void setCorrectHasMoved() {
        for (Field[] fields : park) {
            for (Field field : fields) {
                if (field.isAssigned()) {
                    for (Dachshund d : field.getDachshundArrayList()) {
                        d.setWasMoved(false);
                    }
                    for (GoldenRetriever g : field.getGoldenRetrieverArrayList()) {
                        g.setWasMoved(false);
                    }
                    for (Rottweiler r : field.getRottweilerArrayList()) {
                        r.setWasMoved(false);
                    }
                    for (DogCatcher dc : field.getDogCatcherArrayList()) {
                        dc.setWasMoved(false);
                    }
                    for (Walker w : field.getWalkerArrayList()) {
                        w.setWasMoved(false);
                    }

                }
            }
        }
    }

    /**
     * Adding human to new field
     * @param humans List of humans in new field
     * @param type Dog Catcher or Walker
     * @param newX New x position
     * @param newY New y position
     * @param h Index of human
     */
    public void addHumanToNewField(ArrayList<? extends Human> humans, String type, int newX, int newY, int h) {
        if (type.equals(config.agents.human_types.DOG_CATCHERS)) {
            park[newX][newY].getDogCatcherArrayList().add((DogCatcher) humans.get(h));
        } else {
            park[newX][newY].getWalkerArrayList().add((Walker) humans.get(h));
        }
        park[newX][newY].setAssigned(true);
    }

    /**
     * Removing human from field
     * @param humansIndexForRemoveList Helper list of humans being removed from field
     * @param type Dog Catcher or Walker
     * @param field Given field
     */
    public void removeHumansFromField(List<Integer> humansIndexForRemoveList, String type, Field field){
        if (type.equals(config.agents.human_types.DOG_CATCHERS)) {
            for (int i = 0; i < humansIndexForRemoveList.size(); i++) {
                field.getDogCatcherArrayList().remove(humansIndexForRemoveList.get(i) - i);
            }
        } else {
            for (int i = 0; i < humansIndexForRemoveList.size(); i++) {
                field.getWalkerArrayList().remove(humansIndexForRemoveList.get(i) - i);
            }
        }
    }
}

