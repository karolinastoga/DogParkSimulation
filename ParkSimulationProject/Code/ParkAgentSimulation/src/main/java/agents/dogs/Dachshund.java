package agents.dogs;

/**
 * Class of dachshund
 */
public class Dachshund extends Dog{

    private float length;

    public Dachshund(String name, int age, String colour, int length){
        super(name, age, colour);
        this.length = length;
    }

    public void grow(){
        if(length < 5f) length *= 2f;
        else length += length * 0.5f;
    }

    @Override
    public void pickBone() {
        super.pickBone();
        grow();
    }

    @Override
    public void getSick() {
        super.getSick();
        length -= 10f;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Dachshund{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", colour='" + getColour() + '\'' +
                ", length=" + length +
                ", bonesCount=" + getBonesCount() +
                ", poisonCount=" + getPoisonCount() +
                ", isAlive=" + isAlive() +
                '}';
    }
}
