package park;

import agents.dogs.Dachshund;
import agents.dogs.GoldenRetriever;
import agents.dogs.Rottweiler;
import agents.humans.DogCatcher;
import agents.humans.Walker;

import java.util.*;

/**
 * Class representing board
 */
public class Board {

    Field[][] board;
    private final int x;
    private final int y;
    private final int boneAmount;
    private final int poisonAmount;
    private ArrayList<GoldenRetriever> killedDogs;
    private ArrayList<GoldenRetriever> adoptedDogs;
    private ArrayList<Rottweiler> killedRottweilers;
    private ArrayList<Rottweiler> caughtRottweilers;

    public Board(int x, int y, int boneAmount, int poisonAmount){
        this.x = x;
        this.y = y;
        this.boneAmount = boneAmount;
        this.poisonAmount = poisonAmount;
        killedDogs = new ArrayList<>();
        adoptedDogs = new ArrayList<>();
        killedRottweilers = new ArrayList<>();
        caughtRottweilers = new ArrayList<>();
    }

    /**
     * Method creating starting board based on given resources and agents
     * @param dachshunds Given list of dachshunds
     * @param goldenRetrievers Given list of goldens
     * @param rottweilers Given list of rottweilers
     * @param dogCatchers Given list of dog catchers
     * @param walkers Given list of walkers
     */
    public void prepareBoard(
            ArrayList<Dachshund> dachshunds,
            ArrayList<GoldenRetriever> goldenRetrievers,
            ArrayList<Rottweiler> rottweilers,
            ArrayList<DogCatcher> dogCatchers,
            ArrayList<Walker> walkers){

        createEmptyBoard();
        placeResources();
        placeAgents(dachshunds, goldenRetrievers, rottweilers,dogCatchers, walkers);
    }


    private void createEmptyBoard(){
        board = new Field[x][y];
        for(int r = 0; r < x; r++){
            for(int c = 0; c < y; c++){
                board[r][c] = new Field(r, c);
            }
        }
    }

    /**
     * Method that places resources on the board
     */
    private void placeResources(){
        placeBones();
        placePoison();
    }

    /**
     * Method that places agents on the board
     * @param dachshundArrayList List of dachshunds
     * @param goldenRetrieverArrayList List of goldens
     * @param rottweilerArrayList List of rottweilers
     * @param dogCatcherArrayList List of dog catchers
     * @param walkerArrayList List of walkers
     */
    private void placeAgents(ArrayList<Dachshund> dachshundArrayList,
                            ArrayList<GoldenRetriever> goldenRetrieverArrayList,
                            ArrayList<Rottweiler> rottweilerArrayList,
                            ArrayList<DogCatcher> dogCatcherArrayList,
                            ArrayList<Walker> walkerArrayList) {

        placeDogs(dachshundArrayList, goldenRetrieverArrayList, rottweilerArrayList);
        placeHumans(dogCatcherArrayList, walkerArrayList);
    }

    /**
     * Method of placing dogs
     * @param dachshundArrayList  List of dachshunds
     * @param goldenRetrieverArrayList List of goldens
     * @param rottweilerArrayList List of rottweilers
     */
    private void placeDogs(
            ArrayList<Dachshund> dachshundArrayList,
            ArrayList<GoldenRetriever> goldenRetrieverArrayList,
            ArrayList<Rottweiler> rottweilerArrayList) {

        placeDachshund(dachshundArrayList);
        placeGoldenRetrievers(goldenRetrieverArrayList);
        placeRottweilers(rottweilerArrayList);
    }

    /**
     * Method placing humans on Board
     * @param dogCatcherArrayList List of dog catchers
     * @param walkerArrayList List of walkers
     */
    private void placeHumans(ArrayList<DogCatcher> dogCatcherArrayList, ArrayList<Walker> walkerArrayList) {
        placeDogCatchers(dogCatcherArrayList);
        placeWalkers(walkerArrayList);
    }
    
    private void placeBones(){
        for(int b = 0; b < boneAmount; b++) {
            List<Integer> pos = getInitialPosition();
            board[pos.get(0)][pos.get(1)].setAssigned(true);
            board[pos.get(0)][pos.get(1)].setHasBone(true);
        }
    }
    
    private void placePoison(){
        for(int p = 0; p < poisonAmount; p++) {
            List<Integer> pos = getInitialPosition();
            board[pos.get(0)][pos.get(1)].setAssigned(true);
            board[pos.get(0)][pos.get(1)].setHasPoison(true);
        }
    }
    
    private void placeDachshund(ArrayList<Dachshund> dachshundArrayList){
        for (Dachshund dachshund: dachshundArrayList) {
            List<Integer> pos = getInitialPosition();

            board[pos.get(0)][pos.get(1)].setAssigned(true);
            board[pos.get(0)][pos.get(1)].getDachshundArrayList().add(dachshund);
        }
    }
    
    private void placeGoldenRetrievers(ArrayList<GoldenRetriever> goldenRetrieverArrayList){
        for (GoldenRetriever goldenRetriever: goldenRetrieverArrayList) {
            List<Integer> pos = getInitialPosition();

            board[pos.get(0)][pos.get(1)].setAssigned(true);
            board[pos.get(0)][pos.get(1)].getGoldenRetrieverArrayList().add(goldenRetriever);
        }
    }
    
    private void placeRottweilers(ArrayList<Rottweiler> rottweilerArrayList){
        for (Rottweiler rottweiler: rottweilerArrayList) {
            List<Integer> pos = getInitialPosition();

            board[pos.get(0)][pos.get(1)].setAssigned(true);
            board[pos.get(0)][pos.get(1)].getRottweilerArrayList().add(rottweiler);
        }

    }
    
    private void placeDogCatchers(ArrayList<DogCatcher> dogCatcherArrayList){
        for(DogCatcher dogCatcher: dogCatcherArrayList){
            List<Integer> pos = getInitialPosition();

            board[pos.get(0)][pos.get(1)].setAssigned(true);
            board[pos.get(0)][pos.get(1)].getDogCatcherArrayList().add(dogCatcher);
        }
    }
    
    private void placeWalkers(ArrayList<Walker> walkerArrayList){
        for(Walker walker: walkerArrayList){
            List<Integer> pos = getInitialPosition();

            board[pos.get(0)][pos.get(1)].setAssigned(true);
            board[pos.get(0)][pos.get(1)].getWalkerArrayList().add(walker);
        }
    }

    /**
     * Method that gives initial position
     * @return List where index = 0 is x position and index = 1 is y position
     */
    private List<Integer> getInitialPosition() {
        int newX = getRandomPosition(x);
        int newY = getRandomPosition(y);

        while (board[newX][newY].isAssigned()) {
            newX = getRandomPosition(x);
            newY = getRandomPosition(y);
        }
        return Arrays.asList(newX, newY);

    }

    /**
     * Method of getting new position
     * @param pos Current position
     * @param maxVal Maximum value
     * @return New position
     */
    public int getNewPosition(int pos, int maxVal){

        int min = -3;
        int max = 3;

        int newPos = pos + (int)Math.floor(Math.random()*(max-min+1)+min);

        while(newPos < 0 || newPos >= maxVal){
            newPos = pos + (int)Math.floor(Math.random()*(max-min+1)+min);
        }

        return newPos;
    }

    private int getRandomPosition(int max){
        Random r = new Random();
        return r.nextInt(max);}

    public Field[][] getBoard() {
        return board;
    }

    public void setBoard(Field[][] board) {
        this.board = board;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getBoneAmount() {
        return boneAmount;
    }

    public int getPoisonAmount() {
        return poisonAmount;
    }

    public ArrayList<GoldenRetriever> getKilledDogs() {
        return killedDogs;
    }

    public void setKilledDogs(ArrayList<GoldenRetriever> killedDogs) {
        this.killedDogs = killedDogs;
    }

    public ArrayList<GoldenRetriever> getAdoptedDogs() {
        return adoptedDogs;
    }

    public void setAdoptedDogs(ArrayList<GoldenRetriever> adoptedDogs) {
        this.adoptedDogs = adoptedDogs;
    }

    public ArrayList<Rottweiler> getKilledRottweilers() {
        return killedRottweilers;
    }

    public void setKilledRottweilers(ArrayList<Rottweiler> killedRottweilers) {
        this.killedRottweilers = killedRottweilers;
    }

    public ArrayList<Rottweiler> getCaughtRottweilers() {
        return caughtRottweilers;
    }

    public void setCaughtRottweilers(ArrayList<Rottweiler> caughtRottweilers) {
        this.caughtRottweilers = caughtRottweilers;
    }
}
