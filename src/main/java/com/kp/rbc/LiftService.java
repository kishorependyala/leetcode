package com.kp.rbc;

public class LiftService {

    public static void main(String[] args){
        new LiftService().liftTest();
    }

    public void liftTest(){
        int floors = 4;
        int lifts = 3;
        int liftLocations[] = new int[lifts];
        boolean liftInUse[] = new boolean[lifts];

        for (int i=0; i< lifts; i++){
            liftLocations[i]=0;
            liftInUse[i]=false;
        }

        printLiftLocation(liftLocations);

        getLift(2,liftLocations,floors,liftInUse);
        getLift(2,liftLocations,floors,liftInUse);
        getLift(3,liftLocations,floors,liftInUse);
        getLift(1,liftLocations,floors,liftInUse);


    }

    private int getLift(int requestedFromFloor, int[] liftLocations, int floors, boolean[] liftInUse) {
        int liftSelected = -1;
        int shortestDistance = Integer.MAX_VALUE;
        for(int i=0;i< liftLocations.length; i++){
            if (liftInUse[i]){
                continue;
            }
            int distance = Math.abs(liftLocations[i]-requestedFromFloor);
            if ( distance < shortestDistance ){
                shortestDistance = distance;
                liftSelected = i;
            }

        }
        if( liftSelected == -1 ){
            System.out.print("Tough luck --- no lifts available ");
            return -1;
        }
        liftLocations[liftSelected] = requestedFromFloor;
        liftInUse[liftSelected] = true;
        printLiftLocation(liftLocations);
        printLiftLocation(liftInUse);
        return liftSelected;
    }

    private void printLiftLocation(boolean[] liftInUse) {
        for (int i=0; i<liftInUse.length; i++){
            System.out.print(liftInUse[i]);
            System.out.print(" ");
        }
        System.out.println();
    }
    private void printLiftLocation(int[] liftLocation) {
        for (int i=0; i<liftLocation.length; i++){
            System.out.print(liftLocation[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

}
