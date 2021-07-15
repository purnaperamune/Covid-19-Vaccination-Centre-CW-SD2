import java.util.Scanner;
public class VaccinationCenter {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int vaccinationStock = 150;  //Amount of Vaccines
        String []ServiceCenter = new String[6];  //Storing names of customers
        Initialise(ServiceCenter);  //Getting ready the booth

        int userValue=0;
        while(userValue!=999){
            System.out.println("View all Vaccination Booths:--------------------"+"100 or VVB\n"+
            "View all Empty Booths:--------------------------"+"101 or VEB\n"+
            "Add Patient to a Booth:-------------------------"+"102 or APB\n"+
            "Remove Patient from a Booth:--------------------"+"103 or RPB\n"+
            "View Patients Sorted in alphabetical order:-----"+"104 or VPS\n"+
            "Store Program Data into file:-------------------"+"105 or SPD\n"+
            "Load Program Data from file:--------------------"+"106 or LPD\n"+
            "View Remaining Vaccinations:--------------------"+"107 or VRV\n"+
            "Add Vaccinations to the Stock:------------------"+"108 or AVS\n"+
            "Exit the Program:-------------------------------"+"999 or EXT");


            System.out.println("");
            System.out.println("Your selection: ");
            String user=input.next();
            switch (user){
                case "100":
                case "VVB":
                    ViewVaccinationBooths(ServiceCenter);
                    break;

                case "101":
                case "VEB":
                    ViewEmptyBooths(ServiceCenter);
                    break;
                case "102":
                case "APB":
                    vaccinationStock = AddPatient(ServiceCenter,vaccinationStock);
                    break;

                case "103":
                case "RPB":
                    RemovePatient(ServiceCenter);
                    break;

                case "104":
                case "VPS":
                    ViewPatientsSorted(ServiceCenter);
                    break;

                case "105":
                case "SPD":
                    System.out.println("Store Program Data into file");
                    StoreFile();
                    break;

                case "106":
                case "LPD":
                    System.out.println("Load Program Data from file");
                    LoadFile();
                    break;

                case "107":
                case "VRV":
                    RemainingVaccinations(vaccinationStock);
                    break;

                case "108":
                case "AVS":
                    vaccinationStock = AddVaccinations(vaccinationStock);
                    break;

                case "999":
                case "EXT":
                    userValue = 999;
                    System.out.println("Thank you for using this e-vaccine system. Good day!");
                    break;

                default:
                    System.out.println("Sorry, Invalid choice. Please try again.");
                    System.out.println("");
            }
        }
    }
    private static void Initialise(String booth[]){
        //Getting ready all 6 booths to store names of customers.
        System.out.println("---Welcome to the e-vaccination system!---");
        for(int x=0;x<6;x++){
            booth[x]="e";
            System.out.println("Booth number "+x+" initialized!");
        }
        System.out.println("All vaccination booths successfully initialized! Please assign customers to each booth.");
        System.out.println("");
    }
    private static void ViewVaccinationBooths(String booth[]){
        //This views all vaccination booths  including empty booths.
        System.out.println("---Viewing all vaccination booths---");
        for(int x=0;x<6;x++){
            if(booth[x].equals("e")){
                System.out.println("Booth number "+x+" is empty. Please assign a customer to this booth.");
            }
            else{
                System.out.println("Booth number "+x+ " is occupied by "+booth[x]);
            }
        }
        System.out.println("");
    }
    private static void ViewEmptyBooths(String booth[]){
        //This views only empty booths which can assign a new customer.
        System.out.println("---Viewing all empty vaccination booths---");
        int checkEmpty=0;  //A variable which used to check if all the booth are occupied or not.
        for(int x=0;x<6;x++){
            if(booth[x].equals("e")){
                checkEmpty=1;
                System.out.println("Booth number "+x+" is empty. Please assign a customer to this booth.");
            }
        }
        if(checkEmpty==0){
            System.out.println("All booths are occupied by patients.");
        }
        System.out.println("");
    }
    private static int AddPatient(String booth[],int vaccineStock){
        //This lets you to add a new customer to the booth. Also shows empty booths to make the adding task easy.
        System.out.println("---Viewing empty booths that you can add a new customer---");
        for(int x=0;x<6;x++){
            if(booth[x].equals("e")){
                System.out.println("Booth number "+x+" is empty. Enter "+x+" to assign a customer to this booth.");
            }
        }
        System.out.println("");
        Scanner input = new Scanner(System.in);
        System.out.println("Your selection of booth number: ");
        int boothNum = input.nextInt();
        System.out.println("Enter customer name for booth " + boothNum + " :");
        booth[boothNum] = input.next();
        vaccineStock-=1;
        System.out.println("Customer "+booth[boothNum]+" successfully added to the booth.");
        System.out.println("");

        //Checking if the amount of vaccines reach 20 to display a warning message
        if(vaccineStock==20){
            System.out.println("WARNING! ||| This center running out of vaccines. You only have 20 vaccines. ||| WARNING!");
        }
        System.out.println("");
        return vaccineStock;
    }
    private static void RemovePatient(String booth[]){
        //This lets you to remove a customer and free a booth. To make the task easy, it shows occupied booths too.
        System.out.println("---Here is the current vaccination booth list---");
        ViewVaccinationBooths(booth);
        System.out.println("");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the booth number that you want to free?");
        int boothFree = input.nextInt();
        booth[boothFree] = "e";
        System.out.println("The customer in the booth number "+boothFree+" successfully removed from the booth list.");
        System.out.println("");

    }
    private static void ViewPatientsSorted(String booth[]){
        //Viewing customer names in alphabetical order.
        System.out.println("---Viewing customer names according to the alphabetical order---");
        int n = 6;

        String temporary;
        for(int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if (booth[i].compareTo(booth[j])>0){
                    temporary = booth[i];
                    booth[i] = booth[j];
                    booth[j] = temporary;
                }
            }
        }
        System.out.println("Sorted booth customer list: ");
        for (int i = 0; i < n; i++) {
            if(booth[i].equals("e")){
                continue;
            }
            else {
                System.out.println(booth[i]);
            }
        }
        System.out.println("");
    }
    public static void StoreFile(){

    }
    public static void LoadFile(){


    }
    private static void RemainingVaccinations(int stockRemain){
        //Shows remaining amount of vaccines.
        System.out.println("---Viewing remaining vaccines---");
        System.out.println("This center currently has "+stockRemain+" of vaccines.");
        System.out.println("");
    }

    public static int AddVaccinations(int stockAdd){
        //Lets you add vaccines.
        Scanner input = new Scanner(System.in);
        System.out.println("How many vaccinations do you want to add to the stock?");
        int add = input.nextInt();
        stockAdd+=add;
        System.out.println("Vaccination stock level successfully updated.");
        System.out.println("");
        return stockAdd;
    }
}
