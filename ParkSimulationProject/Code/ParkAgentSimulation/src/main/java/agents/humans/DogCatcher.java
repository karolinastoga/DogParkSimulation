package agents.humans;

import agents.dogs.Rottweiler;

/**
 * Class of dog catcher
 */
public class DogCatcher extends Human{

    private float experienceLevel;
    private int caughtDogsCount;
    private int bitesCount;

    public DogCatcher(){}

    public DogCatcher(String name, String surname, int age, int experienceLevel){
        super(name, surname, age);
        this.experienceLevel = experienceLevel;
        caughtDogsCount = 0;
        bitesCount = 0;
    }

    public boolean catchDog(Rottweiler rottweiler){
        if(rottweiler.getAggressionLevel() > experienceLevel){
            bitesCount++;
            experienceLevel -= rottweiler.getAggressionLevel()*0.2;
            return false;
        }
        caughtDogsCount++;
        experienceLevel += rottweiler.getAggressionLevel()*0.2;
        rottweiler.setCaught(true);
        return true;
    }

    public int getCaughtDogsCount() {
        return caughtDogsCount;
    }

    public void setCaughtDogsCount(int caughtDogsCount) {
        this.caughtDogsCount = caughtDogsCount;
    }

    public int getBitesCount() {
        return bitesCount;
    }

    public void setBitesCount(int bitesCount) {
        this.bitesCount = bitesCount;
    }

    public float getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(float experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    @Override
    public String toString() {
        return "DogCatcher{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", age=" + getAge() +
                ", experienceLevel=" + experienceLevel +
                ", caughtDogsCount=" + caughtDogsCount +
                ", bitesCount=" + bitesCount +
                '}';
    }
}
