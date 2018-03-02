import java.util.ArrayList;

public class Main {
    public static void main(String[]args)throws Exception{
        Simulation mysim=new Simulation();
        ArrayList<Rocket>u1s;
        ArrayList<Rocket>u2s;

        mysim.loadItems("phase1.txt");
        u1s=mysim.loadU1();

        mysim.loadItems("phase2.txt");
        u1s=mysim.loadU1();

        mysim.loadItems("phase1.txt");
        u2s=mysim.loadU2();

        mysim.loadItems("phase2.txt");
        u2s=mysim.loadU2();
        //----------------------------done loading----------------------

        mysim.runSimulation(u1s);
        System.out.println("for the U1 missiles");
        mysim.runSimulation(u2s);
        System.out.println("for the U2 missiles");


    }
}

