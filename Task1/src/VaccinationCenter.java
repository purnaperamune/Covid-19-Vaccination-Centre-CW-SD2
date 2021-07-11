import java.util.Scanner;

public class VaccinationCenter {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        int vaccinationStock = 150;
        String []ServiceCenter = new String[6];
        Initialise(ServiceCenter);

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


            System.out.println("");
            System.out.println("Your selection: ");
            String user=input.next();
            switch (user){
                case "100":
                    ViewVaccinationBooths(ServiceCenter);
                    break;
                case "VVB":
                    ViewVaccinationBooths(ServiceCenter);
                    break;

                case "101":
                    ViewEmptyBooths(ServiceCenter);
                    break;
                case "VEB":
                    ViewEmptyBooths(ServiceCenter);
                    break;
                case "102":
                    vaccinationStock = AddPatient(ServiceCenter,vaccinationStock);
                    break;

                case "APB":
                    vaccinationStock = AddPatient(ServiceCenter,vaccinationStock);
                    break;
                case "103":
                    RemovePatient(ServiceCenter);
                    break;
                case "RPB":
                    RemovePatient(ServiceCenter);
                    break;

                case "104":
                    ViewPatientsSorted(ServiceCenter);
                    break;
                case "VPS":
                    ViewPatientsSorted(ServiceCenter);
                    break;
                case "105":
                    System.out.println("Store Program Data into file");
                    StoreFile();

                    break;
                case "SPD":
                    System.out.println("Store Program Data into file");
                    StoreFile();
                    break;
                case "106":
                    System.out.println("Load Program Data from file");
                    LoadFile();
                    break;
                case "LPD":
                    System.out.println("Load Program Data from file");
                    LoadFile();
                    break;
                case "107":
                    RemainingVaccinations(vaccinationStock);
                    break;
                case "VRV":
                    RemainingVaccinations(vaccinationStock);
                    break;
                case "108":
                    vaccinationStock = AddVaccinations(vaccinationStock);
                    break;
                case "AVS":
                    vaccinationStock = AddVaccinations(vaccinationStock);
                    break;
                case "999":
                    userValue = 999;
                    System.out.println("Thank you for using this e-vaccine system. Good day!");
                    break;
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
        System.out.println("---Welcome to the e-vaccine system!---");
        for(int x=0;x<6;x++){
            booth[x]="e";
            System.out.println("Booth number "+x+" initialized!");
        }
        System.out.println("All vaccination booths successfully initialized! Please assign customers to each booth.");
        System.out.println("");
    }
    public static void ViewVaccinationBooths(String booth[]){
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
    public static void ViewEmptyBooths(String booth[]){
        System.out.println("---Viewing all empty vaccination booths---");
        for(int x=0;x<6;x++){
            if(booth[x].equals("e")){
                System.out.println("Booth number "+x+" is empty. Please assign a customer to this booth.");
            }
        }
        System.out.println("");
    }
    public static int AddPatient(String booth[],int vaccineStock){
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
        return vaccineStock;
    }
    public static void RemovePatient(String booth[]){
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
    public static void ViewPatientsSorted(String booth[]){
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
    public static void RemainingVaccinations(int stockRemain){
        System.out.println("---Viewing remaining vaccines---");
        System.out.println("This center currently has "+stockRemain+" of vaccines.");
        System.out.println("");
    }

    public static int AddVaccinations(int stockAdd){
        Scanner input = new Scanner(System.in);
        System.out.println("How many vaccinations do you want to add to the stock?");
        int add = input.nextInt();
        stockAdd+=add;
        System.out.println("Vaccination stock level successfully updated.");
        System.out.println("");
        return stockAdd;
    }
}
