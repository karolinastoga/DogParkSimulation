package park;

import agents.dogs.Dachshund;
import agents.dogs.GoldenRetriever;
import agents.dogs.Rottweiler;
import agents.humans.DogCatcher;
import agents.humans.Walker;

import java.util.ArrayList;

/**
 * Class representing single field in board
 */
public class Field {

    private ArrayList<Dachshund> dachshundArrayList;
    private ArrayList<GoldenRetriever> goldenRetrieverArrayList;
    private ArrayList<Rottweiler> rottweilerArrayList;
    private ArrayList<DogCatcher> dogCatcherArrayList;
    private ArrayList<Walker> walkerArrayList;

    private int positionX;
    private int positionY;

    private boolean hasBone;
    private boolean hasPoison;

    private boolean hasMoved;
    private boolean isAssigned;
    
    public Field(int x, int y){

        positionX = x;
        positionY = y;

        dachshundArrayList = new ArrayList<>();
        goldenRetrieverArrayList = new ArrayList<>();
        rottweilerArrayList = new ArrayList<>();
        dogCatcherArrayList = new ArrayList<>();
        walkerArrayList = new ArrayList<>();

        hasBone = false;
        hasPoison = false;
        hasMoved = false;
        isAssigned = false;
    }

    /**
     * Method that checks is field is empty (meaning has no resources or agents on it)
     */
    public void checkIfFieldIsEmpty(){
        isAssigned = !dachshundArrayList.isEmpty() || !goldenRetrieverArrayList.isEmpty() || !rottweilerArrayList.isEmpty() ||
                !dogCatcherArrayList.isEmpty() || !walkerArrayList.isEmpty() || hasBone || hasPoison;
    }

    public ArrayList<Dachshund> getDachshundArrayList() {
        return dachshundArrayList;
    }

    public void setDachshundArrayList(ArrayList<Dachshund> dachshundArrayList) {
        this.dachshundArrayList = dachshundArrayList;
    }

    public ArrayList<GoldenRetriever> getGoldenRetrieverArrayList() {
        return goldenRetrieverArrayList;
    }

    public void setGoldenRetrieverArrayList(ArrayList<GoldenRetriever> goldenRetrieverArrayList) {
        this.goldenRetrieverArrayList = goldenRetrieverArrayList;
    }

    public ArrayList<Rottweiler> getRottweilerArrayList() {
        return rottweilerArrayList;
    }

    public void setRottweilerArrayList(ArrayList<Rottweiler> rottweilerArrayList) {
        this.rottweilerArrayList = rottweilerArrayList;
    }

    public ArrayList<DogCatcher> getDogCatcherArrayList() {
        return dogCatcherArrayList;
    }

    public void setDogCatcherArrayList(ArrayList<DogCatcher> dogCatcherArrayList) {
        this.dogCatcherArrayList = dogCatcherArrayList;
    }

    public ArrayList<Walker> getWalkerArrayList() {
        return walkerArrayList;
    }

    public void setWalkerArrayList(ArrayList<Walker> walkerArrayList) {
        this.walkerArrayList = walkerArrayList;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public boolean isHasBone() {
        return hasBone;
    }

    public void setHasBone(boolean hasBone) {
        this.hasBone = hasBone;
    }

    public boolean isHasPoison() {
        return hasPoison;
    }

    public void setHasPoison(boolean hasPoison) {
        this.hasPoison = hasPoison;
    }

    public boolean isHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    public void setAssigned(boolean assigned) {
        isAssigned = assigned;
    }
}
