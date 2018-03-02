import java.util.Random;
public class Rocket implements SpaceShip {
    int cost;
    int weight;
    int currentWeight;
    int maxWeight;
    int cargoCarried;
    int cargoLimit;
    double chanceLaunchExplosion;
    double chanceLandingCrash;
    //double randomAssum = new Random().nextDouble();
    public boolean launch() {
        return true;
    }
    public boolean land(){
        return true;
    }
    public boolean canCarry(Item smth){
        currentWeight+=smth.weight;
        if (currentWeight>maxWeight){
            currentWeight-=smth.weight;
            return false;
        }else{
            currentWeight-=smth.weight;
            return true;
        }

    }
    public void carry(Item smth){
        currentWeight+=smth.weight;
    }

}
