package agents.dogs;

import park.Board;
import park.Field;

public abstract class Dog implements  Cloneable {

    private String name;
    private int age;
    private String colour;
    private int bonesCount;
    private int poisonCount;
    private boolean isAlive;
    private boolean isAdopted;
    private boolean wasMoved;

    public Dog() {
        this.bonesCount = 0;
        this.poisonCount = 0;
        isAlive = true;
        isAdopted = false;
        wasMoved = false;
    }

    public Dog(String name, int age, String colour) {
        this.name = name;
        this.age = age;
        this.colour = colour;
        this.bonesCount = 0;
        this.poisonCount = 0;
        isAlive = true;
        isAdopted = false;
        wasMoved = false;
    }

    public void pickBone() {
        bonesCount++;
    }

    public void pickPoison() {
        poisonCount++;
        getSick();
    }

    public void getSick() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getBonesCount() {
        return bonesCount;
    }

    public void setBonesCount(int bonesCount) {
        this.bonesCount = bonesCount;
    }

    public int getPoisonCount() {
        return poisonCount;
    }

    public void setPoisonCount(int poisonCount) {
        this.poisonCount = poisonCount;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }

    public boolean isAdopted() {
        return isAdopted;
    }

    public void setAdopted(boolean adopted) {
        isAdopted = adopted;
    }

    public boolean isWasMoved() {
        return wasMoved;
    }

    public void setWasMoved(boolean wasMoved) {
        this.wasMoved = wasMoved;
    }
}
