package agents.dogs;

import java.util.Random;

/**
 * Class of Rottweiler
 */
public class Rottweiler extends Dog{

    private float aggressionLevel;
    private int defeatedDogsCount;
    private boolean isCaught;

    public Rottweiler(String name, int age, String colour, int aggressionLevel){
        super(name, age, colour);
        this.aggressionLevel = aggressionLevel;
        defeatedDogsCount = 0;
    }

    @Override
    public void pickBone() {
        super.pickBone();
        aggressionLevel++;
    }

    public void increaseAggressionLevel(Rottweiler enemy){
        aggressionLevel += enemy.getAggressionLevel()*0.3;
    }

    public void increaseAggressionLevel(GoldenRetriever victim){
        aggressionLevel += victim.getCutenessLevel()*0.15;
    }

    public void increaseWinnerAttributesAfterFight(Rottweiler winner, Rottweiler looser){
        looser.setAlive(false);
        winner.setDefeatedDogsCount(winner.getDefeatedDogsCount() + 1);
        winner.increaseAggressionLevel(looser);
        winner.setBonesCount(winner.getBonesCount() + looser.getBonesCount());
    }

    public Rottweiler attack(Rottweiler enemy){
        if(enemy.getAggressionLevel() > aggressionLevel){
            increaseWinnerAttributesAfterFight(enemy, this);
            return this;
        }
        else if(enemy.getAggressionLevel() < aggressionLevel){
            increaseWinnerAttributesAfterFight(this, enemy);
            return enemy;
        }
        else{
            Random r = new Random();
            int x = r.nextInt(2);
            if(x == 0){
                increaseWinnerAttributesAfterFight(this, enemy);
                return enemy;
            }
            else {
                increaseWinnerAttributesAfterFight(enemy, this);
                return this;
            }
        }
    }

    public void attack(GoldenRetriever victim) {
        victim.setAlive(false);
        increaseAggressionLevel(victim);
        this.setBonesCount(getBonesCount() + victim.getBonesCount());
    }

    public float getAggressionLevel() {
        return aggressionLevel;
    }

    public void setAggressionLevel(int aggressionLevel) {
        this.aggressionLevel = aggressionLevel;
    }

    public int getDefeatedDogsCount() {
        return defeatedDogsCount;
    }

    public void setDefeatedDogsCount(int defeatedDogsCount) {
        this.defeatedDogsCount = defeatedDogsCount;
    }

    public boolean isCaught() {
        return isCaught;
    }

    public void setCaught(boolean caught) {
        isCaught = caught;
    }

    @Override
    public String toString() {
        return "Rottweiler{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", colour='" + getColour() + '\'' +
                ", aggressionLevel=" + aggressionLevel +
                ", defeatedDogsCount=" + defeatedDogsCount +
                ", bonesCount=" + getBonesCount() +
                ", poisonCount=" + getPoisonCount() +
                ", isAlive=" + isAlive() +
                '}';
    }

}
