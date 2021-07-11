import java.util.Scanner;

public class VaccinationCenter {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        String customerName;
        int boothNum=0;
        String []ServiceCenter = new String[7];

        initialise(ServiceCenter);

        while(boothNum<6){
            for(int x=0;x<6;x++){
                if(ServiceCenter[x].equals("e")){
                    System.out.println("Booth number "+x+" is empty. Enter "+x+" to assign a customer to this booth.");
                }
                else{
                    System.out.println("Booth number "+x+ " is occupied by "+ServiceCenter[x]);
                }
            }
            System.out.println("Enter booth number (0-5) that you want to assign a new customer. " +
                    "Enter number 6 to exit the system and display assigned booths.");
            boothNum = input.nextInt();
            if(boothNum==6){
                break;
            }
            else{
                System.out.println("Enter customer name for booth " + boothNum + " :");
                customerName = input.next();
                ServiceCenter[boothNum] = customerName;
            }

        }
        for(int x=0;x<6;x++){
            if(ServiceCenter[x].equals("e")){
                System.out.println("Booth number "+x+" is empty. You can assign a new customer to this booth.");
            }
            else{
                System.out.println("booth " + x + " occupied by " + ServiceCenter[x]);
            }

        }

//        String userValue = "0";

//        while((userValue!="999")||(userValue!="EXT")){
//            userValue = input.next();
//            if((userValue=="100")||(userValue=="VVB")){
//                System.out.println("Viewing all booths");
//            }
//            else if((userValue=="101")||(userValue=="VEB")) {
//                System.out.println("View all empty booths");
//            }
//            else if((userValue=="999")||(userValue=="EXT")){
//                System.out.println("Thanks");
//            }
//            else{
//                System.out.println("Invali choice!");
//            }
//
//        }



        int userValue=0;
        while(userValue!=999){
            System.out.println("View all Vaccination Booths:--------------------"+"100 or VVB");
            System.out.println("View all Empty Booths:--------------------------"+"101 or VEB");
            System.out.println("Add Patient to a Booth:-------------------------"+"102 or APB");
            System.out.println("Remove Patient from a Booth:--------------------"+"103 or RPB");
            System.out.println("View Patients Sorted in alphabetical order:-----"+"104 or VPS");
            System.out.println("Store Program Data into file:-------------------"+"105 or SPD");
            System.out.println("Load Program Data from file:--------------------"+"106 or LPD");
            System.out.println("View Remaining Vaccinations:--------------------"+"107 or VRV");
            System.out.println("Add Vaccinations to the Stock:------------------"+"108 or AVS");
            System.out.println("Exit the Program:-------------------------------"+"999 or EXT");



            String user=input.next();
            switch (user){
                case "100":
                    System.out.println("View all Vaccination Booths");
                    break;
                case "VVB":
                    System.out.println("View all Vaccination Booths");
                    break;

                case "101":
                    System.out.println("View all Empty Booths");
                    break;
                case "VEB":
                    System.out.println("View all Empty Booths");
                    break;
                case "102":
                    System.out.println("Add Patient to a Booth");
                    break;

                case "APB":
                    System.out.println("Add Patient to a Booth");
                    break;
                case "103":
                    System.out.println("Remove Patient from a Booth");
                    break;
                case "RPB":
                    System.out.println("Remove Patient from a Booth");
                    break;

                case "104":
                    System.out.println("View Patients Sorted in alphabetical order");
                    break;
                case "VPS":
                    System.out.println("View Patients Sorted in alphabetical order");
                    break;
                case "105":
                    System.out.println("Store Program Data into file");
                    break;
                case "SPD":
                    System.out.println("Store Program Data into file");
                    break;
                case "106":
                    System.out.println("Load Program Data from file");
                    break;
                case "LPD":
                    System.out.println("Load Program Data from file");
                    break;
                case "107":
                    System.out.println("View Remaining Vaccinations");
                    break;
                case "VRV":
                    System.out.println("View Remaining Vaccinations");
                    break;
                case "108":
                    System.out.println("Add Vaccinations to the Stock");
                    break;
                case "AVS":
                    System.out.println("Add Vaccinations to the Stock");
                    break;
                case "999":
                    System.out.println("Exit the Program");
                    userValue = 999;
                    break;
                case "EXT":
                    System.out.println("Exit the Program");
                    userValue = 999;
                    break;

            }






        }

    }
    private static void initialise(String booth[]){
        for(int x=0;x<6;x++){
            booth[x]="e";
        }
        System.out.println("Vaccination booths initialized!");
    }
//    public ViewVaccinationBooths(){
//        for(int x=0;x<6;x++){
//            System.out.println("Booth number "+x+ " is occupied by "+ServiceCenter[x]);
//        }
//
//    }
}
