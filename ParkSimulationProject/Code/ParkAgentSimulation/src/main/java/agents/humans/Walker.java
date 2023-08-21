package agents.humans;

import agents.dogs.GoldenRetriever;

/**
 * Class of walker
 */
public class Walker extends Human{

    private int minimumCutenessLevel;
    private int strokedDogsCount;
    private boolean hasAdoptedDog;
    private GoldenRetriever adoptedDog;

    public Walker(){}

    public Walker(String name, String surname, int age, int minimumCutenessLevel){
        super(name, surname, age);
        this.minimumCutenessLevel = minimumCutenessLevel;
        strokedDogsCount = 0;
        hasAdoptedDog = false;
    }

    public void strokeDog(GoldenRetriever goldenRetriever){
        strokedDogsCount++;
        goldenRetriever.play();
    }

    public boolean adoptDog(GoldenRetriever goldenRetriever){
        if(goldenRetriever.getCutenessLevel() >= minimumCutenessLevel) {
            hasAdoptedDog = true;
            goldenRetriever.setAdopted(true);
            adoptedDog = goldenRetriever;
            return true;
        }
        strokeDog(goldenRetriever);
        return false;
    }

    public int getMinimumCutenessLevel() {
        return minimumCutenessLevel;
    }

    public void setMinimumCutenessLevel(int minimumCutenessLevel) {
        this.minimumCutenessLevel = minimumCutenessLevel;
    }

    public int getStrokedDogsCount() {
        return strokedDogsCount;
    }

    public void setStrokedDogsCount(int strokedDogsCount) {
        this.strokedDogsCount = strokedDogsCount;
    }

    public boolean isHasAdoptedDog() {
        return hasAdoptedDog;
    }

    public void setHasAdoptedDog(boolean hasAdoptedDog) {
        this.hasAdoptedDog = hasAdoptedDog;
    }

    public GoldenRetriever getAdoptedDog() {
        return adoptedDog;
    }

    public void setAdoptedDog(GoldenRetriever adoptedDog) {
        this.adoptedDog = adoptedDog;
    }

    @Override
    public String toString() {
        return "Walker{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", age=" + getAge() +
                ", minimumCutenessLevel=" + minimumCutenessLevel +
                ", strokedDogsCount=" + strokedDogsCount +
                ", hasAdoptedDog=" + hasAdoptedDog +
                ", adoptedDog=" + adoptedDog +
                '}';
    }
}
