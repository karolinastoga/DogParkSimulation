package agents;

import agents.dogs.Dachshund;
import agents.dogs.Dog;
import agents.dogs.GoldenRetriever;
import agents.dogs.Rottweiler;
import agents.humans.DogCatcher;
import agents.humans.Human;
import agents.humans.Walker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import static simulation.Configuration.config;

/**
 * This is class for generating agents
 * @author Karolina Stoga
 */
public class AgentsGenerator {

    private ArrayList<Dachshund> dachshunds;
    private ArrayList<GoldenRetriever> goldenRetrievers;
    private ArrayList<Rottweiler> rottweilers;
    private ArrayList<DogCatcher> dogCatchers;
    private ArrayList<Walker> walkers;

    /**
     * Method generating all agents based on amount of every kind
     * @param dachshundsAmount Amount of dachshunds
     * @param goldenRetrieversAmount Amount of goldens
     * @param rottweilersAmount Amount of rottweilers
     * @param dogCatchersAmount Amount of dog catchers
     * @param walkersAmount Amount of walkers
     * @throws IOException Exception thrown when cannot read a file
     */
    public void generateAgents(int dachshundsAmount, int goldenRetrieversAmount, int rottweilersAmount, int dogCatchersAmount, int walkersAmount) throws IOException {
        generateDachshunds(dachshundsAmount);
        generateGoldenRetrievers(goldenRetrieversAmount);
        generateRottweilers(rottweilersAmount);
        generateDogCatchers(dogCatchersAmount);
        generateWalkers(walkersAmount);
    }

    /**
     * Specific method of generating Dachshunds
     * @param dachshundsAmount Amount of dachshunds
     * @throws IOException Exception thrown when cannot read a file
     */
    private void generateDachshunds(int dachshundsAmount) throws IOException {
        dachshunds = new ArrayList<>();
        for(int d = 0; d < dachshundsAmount; d++){
            dachshunds.add(new Dachshund(getDogName(), getAge(config.agents.dog), getDogColour(config.agents.dog_breeds.DACHSHUNDS), getLength()));
        }
    }

    /**
     * Specific method of generating Goldens
     * @param goldenRetrieversAmount Amount of goldens
     * @throws IOException Exception thrown when cannot read a file
     */
    private void generateGoldenRetrievers(int goldenRetrieversAmount) throws IOException {
        goldenRetrievers = new ArrayList<>();
        for(int g = 0; g < goldenRetrieversAmount; g++){
            goldenRetrievers.add(new GoldenRetriever(getDogName(), getAge(config.agents.dog), getDogColour(config.agents.dog_breeds.GOLDEN_RETRIEVERS), getCutenessLevel()));
        }
    }

    /**
     * Specific method of generating Rottweilers
     * @param rottweilersAmount Amount of rottweilers
     * @throws IOException Exception thrown when cannot read a file
     */
    private void generateRottweilers(int rottweilersAmount) throws IOException {
        rottweilers = new ArrayList<>();
        for(int r = 0; r < rottweilersAmount; r++){
            rottweilers.add(new Rottweiler(getDogName(), getAge(config.agents.dog), getDogColour(config.agents.dog_breeds.ROTTWEILERS), getAggressionLevel()));
        }
    }

    /**
     * Specific method of generating dog catchers
     * @param dogCatchersAmount Amount of dog catchers
     * @throws IOException Exception thrown when cannot read a file
     */
    private void generateDogCatchers(int dogCatchersAmount) throws IOException {
        dogCatchers = new ArrayList<>();
        for(int d = 0; d < dogCatchersAmount; d++){
            dogCatchers.add(new DogCatcher(getHumanName(), getHumanSurname(), getAge(config.agents.human), getExperienceLevel()));
        }
    }

    /**
     * Specific method of generating walkers
     * @param walkersAmount Amount of walkers
     * @throws IOException Exception thrown when cannot read a file
     */
    private void generateWalkers(int walkersAmount) throws IOException {
        walkers = new ArrayList<>();
        for(int w = 0; w < walkersAmount; w++){
            walkers.add(new Walker(getHumanName(), getHumanSurname(), getAge(config.agents.human), getMinimumCutenessLevel()));
        }
    }

    /**
     * Method that return Random dog name from file
     * @return Random dog name
     * @throws IOException Exception thrown when cannot read a file
     */
    private String getDogName() throws IOException {
        return getRandomElementFromList(config.files_paths.agents_creation.dogs_creation.names.NAMES);
    }

    /**
     * Method that returns random age based of given kind
     * @param kind Human or Dog
     * @return Proper age for given kind
     */
    private int getAge(String kind){
        if(kind.equals(config.agents.human)) return getRandomNumber(25, 55);
        else return getRandomNumber(2, 10);
    }

    /**
     * Gives dog colour based on breed
     * @param breed Breed of dog
     * @return Dog color based on breed
     * @throws IOException Exception thrown when cannot read a file
     */
    private String getDogColour(String breed) throws IOException {
        if(breed.equals(config.agents.dog_breeds.DACHSHUNDS)) return getRandomElementFromList(config.files_paths.agents_creation.dogs_creation.colours.DACHSHUND);
        else if(breed.equals(config.agents.dog_breeds.GOLDEN_RETRIEVERS)) return getRandomElementFromList(config.files_paths.agents_creation.dogs_creation.colours.GOLDEN_RETRIEVER);
        else return getRandomElementFromList(config.files_paths.agents_creation.dogs_creation.colours.ROTTWEILER);
    }

    /**
     *
     * @return Random lenght
     */
    private int getLength(){
        return getRandomNumber(35, 47);
    }

    /**
     *
     * @return Random cuteness level
     */
    private int getCutenessLevel(){
        return getRandomNumber(1, 5);
    }

    /**
     *
     * @return random aggression level
     */
    private int getAggressionLevel(){
        return getRandomNumber(1, 5);
    }

    /**
     *
     * @return Random human name
     * @throws IOException Exception thrown when cannot read a file
     */
    private String getHumanName() throws IOException {
        return getRandomElementFromList(config.files_paths.agents_creation.humans_creation.names.NAMES);
    }

    /**
     *
     * @return Random Human surname
     * @throws IOException Exception thrown when cannot read a file
     */

    private String getHumanSurname() throws IOException {
        return getRandomElementFromList(config.files_paths.agents_creation.humans_creation.names.SURNAMES);
    }

    /**
     *
     * @return Random experience
     */
    private int getExperienceLevel(){
        return getRandomNumber(1, 5);
    }

    /**
     *
     * @return random mininum cuteness level
     */
    private int getMinimumCutenessLevel(){
        return getRandomNumber(7, 15);
    }

    /**
     * Method of getting random element from given file
     * @param fileName Name of file to read from
     * @return Random string from list in file
     * @throws IOException Exception thrown when cannot read a file
     */
    private String getRandomElementFromList(String fileName) throws IOException {
        ArrayList<String> allNames = new ArrayList<>();
        Random r = new Random();

        BufferedReader in = new BufferedReader(new FileReader(fileName));
        while (in.ready()) { allNames.add( in.readLine() );}
        in.close();
        return allNames.get(r.nextInt(allNames.size()));
    }

    private int getRandomNumber(int min, int max){return (int)Math.floor(Math.random()*(max-min+1)+min);}

    public ArrayList<Dachshund> getDachshunds() {
        return dachshunds;
    }

    public void setDachshunds(ArrayList<Dachshund> dachshunds) {
        this.dachshunds = dachshunds;
    }

    public ArrayList<GoldenRetriever> getGoldenRetrievers() {
        return goldenRetrievers;
    }

    public void setGoldenRetrievers(ArrayList<GoldenRetriever> goldenRetrievers) {
        this.goldenRetrievers = goldenRetrievers;
    }

    public ArrayList<Rottweiler> getRottweilers() {
        return rottweilers;
    }

    public void setRottweilers(ArrayList<Rottweiler> rottweilers) {
        this.rottweilers = rottweilers;
    }

    public ArrayList<DogCatcher> getDogCatchers() {
        return dogCatchers;
    }

    public void setDogCatchers(ArrayList<DogCatcher> dogCatchers) {
        this.dogCatchers = dogCatchers;
    }

    public ArrayList<Walker> getWalkers() {
        return walkers;
    }

    public void setWalkers(ArrayList<Walker> walkers) {
        this.walkers = walkers;
    }
}
