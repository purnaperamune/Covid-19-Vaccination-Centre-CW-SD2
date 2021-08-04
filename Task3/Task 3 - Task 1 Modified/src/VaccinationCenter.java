import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class VaccinationCenter {
    public static void main(String[]args) throws IOException {
        Scanner input = new Scanner(System.in);
        int vaccinationStock = 150; //Amount of Vaccines

        String[] firstName = new String[6]; //Array to store first name
        String[] secondName = new String[6]; //Array to store second name
        String[] vaccineType = new String[6]; //Array to store vaccine type related to each customer
        Initialise(firstName,secondName,vaccineType); //Getting ready the booth

        File myFile = new File("vacccinationData.txt"); //Creating a file

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
                    ViewVaccinationBooths(firstName,secondName);
                    break;

                case "101":
                case "VEB":
                    ViewEmptyBooths(firstName,secondName);
                    break;

                case "102":
                case "APB":
                    vaccinationStock = AddPatient(firstName,secondName,vaccineType,vaccinationStock);
                    break;

                case "103":
                case "RPB":
                    RemovePatient(firstName,secondName,vaccineType);
                    break;

                case "104":
                case "VPS":
                    ViewPatientsSorted(firstName,secondName);
                    break;

                case "105":
                case "SPD":
                    System.out.println("Store Program Data into file");
                    StoreFile(firstName,secondName,vaccineType);
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
    private static void Initialise(String[] fName,String[] sName,String[] vaccineType){
        //Getting ready all 6 booths to store names of customers.
        System.out.println("---Welcome to the e-vaccine system!---");
        for(int x=0;x<fName.length;x++){
            fName[x] = "e";

        }
        for(int y=0;y<sName.length;y++){
            sName[y] = "e";
        }

        for(int z=0;z<vaccineType.length;z++){
            vaccineType[z] = "e";
            System.out.println("Booth number "+z+" initialized!");
        }
        System.out.println("");
        System.out.println("All vaccination booths successfully initialized! Please assign customers to each booth.");
        System.out.println("");
    }

    public static void ViewVaccinationBooths(String[] fName,String[] sName){
        //This views all vaccination booths  including empty booths.
        System.out.println("---Viewing all vaccination booths---");
        for(int x=0;x<6;x++){
            if((fName[x].equals("e"))&&(sName[x].equals("e"))){
                System.out.println("Booth number "+x+" is empty. Please assign a customer to this booth.");
            }
            else{
                System.out.println("Booth number "+x+ " is occupied by "+fName[x]+" "+sName[x]);
            }
        }
        System.out.println("");
    }
    public static void ViewEmptyBooths(String[] fName,String[] sName){
        //This views only empty booths which can assign a new customer.
        System.out.println("---Viewing all empty vaccination booths---");
        int checkEmpty=0; //A variable which used to check if all the booth are occupied or not.
        for(int x=0;x<6;x++){
            if((fName[x].equals("e"))&&(sName[x].equals("e"))){
                checkEmpty=1;
                System.out.println("Booth number "+x+" is empty. Please assign a customer to this booth.");
            }
        }
        if(checkEmpty==0){
            System.out.println("All booths are occupied by patients.");
        }
        System.out.println("");
    }
    public static int AddPatient(String[] fName,String[] sName,String[] vaccineType,int vaccineStock){
        //This lets you to add a new customer to the booth. Also shows empty booths to make the adding task easy.
        System.out.println("---Viewing empty booths that you can add a new customer---");
        ViewEmptyBooths(fName,sName);

        System.out.println("");
        System.out.println("Booth 0 & 1 --- AstraZeneca");
        System.out.println("Booth 2 & 3 --- Sinopharm");
        System.out.println("Booth 4 & 5 --- Pfizer");
        Scanner input = new Scanner(System.in);
        System.out.println("Your selection of booth number according to the vaccine type to add the new customer: ");
        int boothNum = input.nextInt();
        if(fName[boothNum].equals("e")){
            System.out.println("---Getting details of the customer to add to the booth number "+boothNum+"---");
            System.out.println("Enter the first name of the customer:  " );
            fName[boothNum]=input.next();
            System.out.println("Enter the second name of the customer:  " );
            sName[boothNum]=input.next();
            System.out.println("Customer "+fName[boothNum]+" "+sName[boothNum]+" successfully added to the booth.");
            System.out.println("");

            vaccineStock-=1;

            if((boothNum==0)||(boothNum==1)){
                vaccineType[boothNum] = "AstraZeneca";
            }
            else if((boothNum==2)||(boothNum==3)){
                vaccineType[boothNum] = "Sinopharm";
            }
            else{
                vaccineType[boothNum] = "Pfizer";
            }

            //Checking if the amount of vaccines reach 20 to display a warning message
            if(vaccineStock==20){
                System.out.println("WARNING! ||| This center running out of vaccines. You only have 20 vaccines. ||| WARNING!");
            }
        }
        else {
            System.out.println("Already assigned a customer. Please use an empty booth to add a new customer.");
        }
        System.out.println("");
        return vaccineStock;
    }

    public static void RemovePatient(String[] fName,String[] sName,String[] vaccineType){
        //This lets you to remove a customer and free a booth. To make the task easy, it shows occupied booths too.
        System.out.println("---Here is the current vaccination booth list---");
        ViewVaccinationBooths(fName,sName);
        System.out.println("");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the booth number that you want to free?");
        int boothFree = input.nextInt();

        fName[boothFree] = "e";
        sName[boothFree] = "e";
        vaccineType[boothFree] = "e";

        System.out.println("The customer in the booth number "+boothFree+" successfully removed from the booth list.");
        System.out.println("");
    }
    public static void ViewPatientsSorted(String[] fName,String[] sName){
        //Viewing customer names in alphabetical order.
        System.out.println("---Viewing customer names according to the alphabetical order---");
        String[] fullName = new String[6];
        for(int m=0;m<6;m++){
            fullName[m] = fName[m]+" "+sName[m];
        }

        int n = 6;
        String temporary;
        for(int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if (fullName[i].compareTo(fullName[j])>0){
                    temporary = fullName[i];
                    fullName[i] = fullName[j];
                    fullName[j] = temporary;
                }
            }
        }
        System.out.println("Sorted booth customer list: ");
        for (int i = 0; i < n; i++) {
            if(fullName[i].equals("e e")){
                continue;
            }
            else {
                System.out.println(fullName[i]);
            }
        }
        System.out.println("");
    }
    public static void StoreFile(String[] fName,String[] sName,String[] vaccineType) throws IOException {
        //Storing booth numbers with patient's names to a file
        FileWriter myFile = new FileWriter("vacccinationData.txt");
        for(int x=0;x<fName.length;x++){
            if(!(fName[x].equals("e"))){
                myFile.write("Booth Number "+x+"\nPatient Name: "+fName[x]+" "+sName[x]+"\n"+"Vaccine type: "+vaccineType[x]+"\n");
                myFile.write("------------------\n");
                myFile.write("");
            }
            else{
                continue;
            }
        }
        myFile.close();
        System.out.println("Vaccination data successfully updated to a file.");
        System.out.println("");

    }
    public static void LoadFile() throws FileNotFoundException {
        //Loading booth numbers with patient's names to the console
        System.out.println("--- Printing information in the file to the console---");
        File myFile = new File("vacccinationData.txt");
        Scanner myReader = new Scanner(myFile);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
        }
        myReader.close();
        System.out.println("");


    }
    public static void RemainingVaccinations(int stockRemain){
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

