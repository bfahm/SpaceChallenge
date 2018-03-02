import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    //fields
    private ArrayList <Item>items=new ArrayList<>();
    private ArrayList <Rocket> SimuRockets_U1 =new ArrayList<>();
    private ArrayList <Rocket> SimuRockets_U2 =new ArrayList<>();
    //methods
    public void loadItems(String filename)throws Exception{//ArrayList
        File file = new File(filename);
        Scanner scanner=new Scanner(file);
        while (scanner.hasNextLine()){
            Item item=new Item();
            String[] tmp;
            String delimiter="=";
            tmp=scanner.nextLine().split(delimiter);
            item.name=tmp[0];
            item.weight=Integer.parseInt(tmp[1]);
            items.add(item);
        }
        //return items;
    }
    public ArrayList<Rocket> loadU1(){
        boolean weStillNeedRockets=true;
        while (weStillNeedRockets){
            U1 aRocket=new U1();
            for(int i=0;i<items.size();){
                if (aRocket.canCarry(items.get(i))){
                    aRocket.carry(items.get(i));
                    aRocket.cargoCarried+=items.get(i).weight;
                    items.remove(items.get(i));
                }else {
                    i++;
                }
            }
            SimuRockets_U1.add(aRocket);
            if (items.size()==0){
                weStillNeedRockets=false;
            }
        }
        return SimuRockets_U1;
    }
    public ArrayList<Rocket> loadU2(){
        boolean weStillNeedRockets=true;
        while (weStillNeedRockets){
            U2 aRocket=new U2();
            for(int i=0;i<items.size();){
                if (aRocket.canCarry(items.get(i))){
                    aRocket.carry(items.get(i));
                    aRocket.cargoCarried+=items.get(i).weight;
                    items.remove(items.get(i));
                }else {
                    i++;
                }
            }
            SimuRockets_U2.add(aRocket);
            if (items.size()==0){
                weStillNeedRockets=false;
            }
        }
        return SimuRockets_U2;
    }
    public void runSimulation(ArrayList <Rocket> testRockets){
        boolean launch;
        boolean land;
        boolean relaunch=false;
        Rocket uTemp;
        //System.out.println(testRockets.get(2).cargoCarried);
        int totalCost=0;
        for(int i=0;i<testRockets.size();i++){
            uTemp=testRockets.get(i);
            System.out.println("------");
            System.out.println("Launching Rocket number "+i);
            launch=uTemp.launch();
            land=uTemp.land();
                if (launch){
                    System.out.println("Rocket "+i+" launched successfully.");
                    if (land){System.out.println("and landed on mars successfully.");}
                    else{System.out.println("and crashed while landing.");}
                }
                else{System.out.println("Rocket "+i+" exploded while launching.");}
            totalCost+=uTemp.cost;
            if(!land || !launch){
                relaunch=true;
                System.out.println("Relaunching Rocket "+i);
            }
            while(relaunch){
                Rocket uTemp_new;
                uTemp_new=testRockets.get(i);
                launch=uTemp_new.launch();
                land=uTemp_new.land();
                if (launch){
                    System.out.println("Rocket "+i+" launched successfully.");
                    if (land){System.out.println("and landed on mars successfully.");}
                    else{System.out.println("and crashed while landing..");}
                }
                else{System.out.println("Rocket "+i+" exploded while Relaunching..");}
                totalCost+=uTemp_new.cost;
                if(land && launch){
                    relaunch=false;
                }else {System.out.println("Relaunching again.");}
            }
        }
      System.out.println("Total cost required = "+ totalCost+" million dollars");
    }

}



