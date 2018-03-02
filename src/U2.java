public class U2 extends Rocket {
    U2() {
        cost = 120;
        weight = 18000;
        maxWeight = 29000;
        currentWeight = weight;
        cargoLimit = maxWeight - weight;
    }

    public boolean launch() {
        this.chanceLaunchExplosion = 0.45 *  ( (double)cargoCarried / (double)cargoLimit);
        double a=Math.random();
        return !(this.chanceLaunchExplosion >= a);
    }

    public boolean land() {
        this.chanceLandingCrash = 0.55* ((double)cargoCarried / (double)cargoLimit);
        double a=Math.random();
        return !(this.chanceLandingCrash >= a);
    }
}
