import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class VaccinationCenter {
    public static void main(String[]args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("---Welcome to the e-vaccine system!---");
        Booth []customerName = new Booth[6]; //Array of booth objects to store details of customers
        int vaccinationStock = 150; //Amount of vaccines

        File myFile = new File("vacccinationData.txt"); //Creating a file

        for(int x=0;x<6;x++){  //Getting ready all booths
            customerName[x] = new Booth("e");
        }
        System.out.println("All vaccination booths successfully initialized! Please assign customers to each booth.");
        System.out.println("");


        int userValue=0;
        while(userValue!=999) {

            System.out.println("View all Vaccination Booths:--------------------" + "100 or VVB\n"+
            "View all Empty Booths:--------------------------" + "101 or VEB\n"+
            "Add Patient to a Booth:-------------------------" + "102 or APB\n"+
            "Remove Patient from a Booth:--------------------" + "103 or RPB\n"+
            "View Patients Sorted in alphabetical order:-----" + "104 or VPS\n"+
            "Store Program Data into file:-------------------" + "105 or SPD\n"+
            "Load Program Data from file:--------------------" + "106 or LPD\n"+
            "View Remaining Vaccinations:--------------------" + "107 or VRV\n"+
            "Add Vaccinations to the Stock:------------------" + "108 or AVS\n"+
            "Exit the Program:-------------------------------" + "999 or EXT");


            System.out.println("");
            System.out.println("Your selection: ");
            String user = input.next();
            switch (user) {
                case "100":
                case "VVB":
                    System.out.println("---Viewing all vaccination booths---");
                    for(int x=0;x<6;x++){
                        customerName[x].ViewVaccinationBooths(x);
                    }
                    System.out.println("");
                    break;

                case "101":
                case "VEB":
                    System.out.println("---Viewing all empty vaccination booths---");
                    for(int x=0;x<6;x++){
                        customerName[x].ViewEmptyBooths(x);
                    }
                    System.out.println("");
                    break;

                case "102":
                case "APB":
                    System.out.println("---Viewing empty booths that you can add a new customer---");
                    for(int x=0;x<6;x++){
                        customerName[x].AddPatientEmptyList(x);
                    }
                    System.out.println("");
                    vaccinationStock = Booth.AddPatient(customerName,vaccinationStock);
                    break;

                case "103":
                case "RPB":
                    System.out.println("---Here is the current vaccination booth list---");
                    for(int x=0;x<6;x++){
                        customerName[x].ViewVaccinationBooths(x);
                    }
                    System.out.println("");
                    Booth.RemovePatient(customerName);
                    break;

                case "104":
                case "VPS":
                    Booth.ViewPatientsSorted(customerName);
                    break;

                case "105":
                case "SPD":
                    Booth.StoreFile(customerName);
                    break;

                case "106":
                case "LPD":
                    Booth.LoadFile();
                    break;

                case "107":
                case "VRV":
                    Booth.RemainingVaccinations(vaccinationStock);
                    break;

                case "108":
                case "AVS":
                    vaccinationStock = Booth.AddVaccinations(vaccinationStock);
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
}
