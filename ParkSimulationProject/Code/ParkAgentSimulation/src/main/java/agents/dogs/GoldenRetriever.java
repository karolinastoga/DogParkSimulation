package agents.dogs;

/**
 * Class of golden
 */
public class GoldenRetriever extends Dog{

    private float cutenessLevel;
    private int playCount;
    private int strokeCount;


    public GoldenRetriever(String name, int age, String colour, int cutenessLevel){
        super(name, age, colour);
        this.cutenessLevel = cutenessLevel;
        playCount = 0;
        strokeCount = 0;
    }

    public void increaseCutenessLevel(){
        cutenessLevel += cutenessLevel + 0.5f;
    }

    public void increaseCutenessLevel(GoldenRetriever friend){cutenessLevel += friend.getCutenessLevel()*0.2f;}

    public void play(){
        strokeCount++;
        increaseCutenessLevel();
    }

    public void play(GoldenRetriever friend){
        playCount++;
        friend.setPlayCount(getPlayCount() + 1);
        increaseCutenessLevel(friend);
        friend.increaseCutenessLevel(this);
    }

    @Override
    public void pickBone() {
        super.pickBone();
        increaseCutenessLevel();
    }

    @Override
    public void getSick() {
        super.getSick();
        cutenessLevel -= cutenessLevel * 0.2f;
    }

    public float getCutenessLevel() {
        return cutenessLevel;
    }

    public void setCutenessLevel(int cutenessLevel) {
        this.cutenessLevel = cutenessLevel;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public int getStrokeCount() {
        return strokeCount;
    }

    public void setStrokeCount(int strokeCount) {
        this.strokeCount = strokeCount;
    }

    @Override
    public String toString() {
        return "GoldenRetriever{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", colour='" + getColour() + '\'' +
                ", cutenessLevel=" + cutenessLevel +
                ", playCount=" + playCount +
                ", strokeCount=" + strokeCount +
                ", bonesCount=" + getBonesCount() +
                ", poisonCount=" + getPoisonCount() +
                ", isAlive=" + isAlive() +
                '}';
    }
}
