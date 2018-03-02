public class U1 extends Rocket {
    U1(){
        cost=100;
        weight=10000;
        maxWeight=18000;
        currentWeight=weight;
        cargoLimit=maxWeight-weight;
    }
    public boolean launch() {
        this.chanceLaunchExplosion = 0.49 *  ( (double)cargoCarried / (double)cargoLimit);
        double a=Math.random();
        return !(this.chanceLaunchExplosion >= a);

    }
    public boolean land(){
        this.chanceLandingCrash = 0.53* ((double)cargoCarried / (double)cargoLimit);
        double a=Math.random();
        return !(this.chanceLandingCrash >= a);
    }
}
