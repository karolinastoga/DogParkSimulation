package agents.humans;

import agents.dogs.Dachshund;
import agents.dogs.Dog;
import agents.dogs.GoldenRetriever;
import agents.dogs.Rottweiler;

/**
 * Class of human
 */
public abstract class Human {

    private String name;
    private String surname;
    private int age;
    private boolean wasMoved;


    public Human() {
    }

    public Human(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        wasMoved = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isWasMoved() {
        return wasMoved;
    }

    public void setWasMoved(boolean wasMoved) {
        this.wasMoved = wasMoved;
    }
}
