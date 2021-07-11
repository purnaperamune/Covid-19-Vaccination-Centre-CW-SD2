import java.util.Scanner;
public class VaccinationCenter {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        System.out.println("---Welcome to the e-vaccine system!---");
        Booth []customerName = new Booth[6];
        int vaccinationStock = 150;
        for(int x=0;x<6;x++){
            customerName[x] = new Booth("e");
        }
        System.out.println("All vaccination booths successfully initialized! Please assign customers to each booth.");
        System.out.println("");

        int userValue=0;
        while(userValue!=999) {
            System.out.println("View all Vaccination Booths:--------------------" + "100 or VVB");
            System.out.println("View all Empty Booths:--------------------------" + "101 or VEB");
            System.out.println("Add Patient to a Booth:-------------------------" + "102 or APB");
            System.out.println("Remove Patient from a Booth:--------------------" + "103 or RPB");
            System.out.println("View Patients Sorted in alphabetical order:-----" + "104 or VPS");
            System.out.println("Store Program Data into file:-------------------" + "105 or SPD");
            System.out.println("Load Program Data from file:--------------------" + "106 or LPD");
            System.out.println("View Remaining Vaccinations:--------------------" + "107 or VRV");
            System.out.println("Add Vaccinations to the Stock:------------------" + "108 or AVS");
            System.out.println("Exit the Program:-------------------------------" + "999 or EXT");


            System.out.println("");
            System.out.println("Your selection: ");
            String user = input.next();
            switch (user) {
                case "100":
                    System.out.println("---Viewing all vaccination booths---");
                    for(int x=0;x<6;x++){
                        customerName[x].ViewVaccinationBooths(x);
                    }
                    System.out.println("");
                    break;
                case "VVB":
                    System.out.println("---Viewing all vaccination booths---");
                    for(int x=0;x<6;x++){
                        customerName[x].ViewVaccinationBooths(x);
                    }
                    System.out.println("");
                    break;

                case "101":
                    System.out.println("---Viewing all empty vaccination booths---");
                    for(int x=0;x<6;x++){
                        customerName[x].ViewEmptyBooths(x);
                    }
                    System.out.println("");
                    break;
                case "VEB":
                    System.out.println("---Viewing all empty vaccination booths---");
                    for(int x=0;x<6;x++){
                        customerName[x].ViewEmptyBooths(x);
                    }
                    System.out.println("");
                    break;
                case "102":
                    System.out.println("---Viewing empty booths that you can add a new customer---");
                    for(int x=0;x<6;x++){
                        customerName[x].AddPatientEmptyList(x);
                    }
                    System.out.println("");
                    vaccinationStock = Booth.AddPatient(customerName,vaccinationStock);
                    break;

                case "APB":
                    System.out.println("---Viewing empty booths that you can add a new customer---");
                    for(int x=0;x<6;x++){
                        customerName[x].AddPatientEmptyList(x);
                    }
                    System.out.println("");
                    vaccinationStock = Booth.AddPatient(customerName,vaccinationStock);
                    break;
                case "103":
                    System.out.println("---Here is the current vaccination booth list---");
                    for(int x=0;x<6;x++){
                        customerName[x].ViewVaccinationBooths(x);
                    }
                    System.out.println("");
                    Booth.RemovePatient(customerName);
                    break;
                case "RPB":
                    System.out.println("---Here is the current vaccination booth list---");
                    for(int x=0;x<6;x++){
                        customerName[x].ViewVaccinationBooths(x);
                    }
                    System.out.println("");
                    Booth.RemovePatient(customerName);
                    break;
                case "104":
                    Booth.ViewPatientsSorted(customerName);
                    break;
                case "VPS":
                    Booth.ViewPatientsSorted(customerName);
                    break;
                case "105":
                    System.out.println("Store Program Data into file");
                    Booth.StoreFile();
                    break;
                case "SPD":
                    System.out.println("Store Program Data into file");
                    Booth.StoreFile();
                    break;
                case "106":
                    Booth.LoadFile();
                    break;
                case "LPD":
                    System.out.println("Load Program Data from file");
                    Booth.LoadFile();
                    break;
                case "107":
                    Booth.RemainingVaccinations(vaccinationStock);
                    break;
                case "VRV":
                    Booth.RemainingVaccinations(vaccinationStock);
                    break;
                case "108":
                    vaccinationStock = Booth.AddVaccinations(vaccinationStock);
                    break;
                case "AVS":
                    vaccinationStock = Booth.AddVaccinations(vaccinationStock);
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
}
