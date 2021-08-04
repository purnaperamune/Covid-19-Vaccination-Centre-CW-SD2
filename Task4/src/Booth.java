import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
public class Booth {
    private String customerName;

    public String toString() {
        return customerName;
    }

    public Booth(String customerName) {
        this.customerName = customerName;
    }

    void ViewVaccinationBooths(int x) {
        //Viewing all vaccination booth including both occupied and empty booths.
        String check = "e";
        if (customerName == check) {
            System.out.println("Booth number " + x + " is empty. Please assign a customer to this booth.");
        } else {
            System.out.println("Booth number " + x + " is occupied by " + customerName);
        }
    }

    void ViewEmptyBooths(int x) {
        //Viewing all empty booths.
        String check = "e";
        if (customerName == check) {
            System.out.println("Booth number " + x + " is empty. Please assign a customer to this booth.");
        }
    }

    void AddPatientEmptyList(int x) {
        //This executes only when you are going to add a new patient to the booth. Shows the empty booths.
        String check = "e";
        if (customerName == check) {
            System.out.println("Booth number " + x + " is empty. Enter" + x + " to assign a customer to this booth.");
        }
    }

    static int AddPatient(Booth[] customerName,LinkedList<String> waitingList, int vaccineStock) {
        //Lets you add a new patient to the booth. And also gives a list of empty booths to make the task easy.
        Scanner input = new Scanner(System.in);
        System.out.println("Your selection of booth number to the new customer: ");
        int boothNum = input.nextInt();
        String check = String.valueOf(customerName[boothNum]);
        if(check.equals("e")){ //If booth is empty, patinet detials will go to main booth
            System.out.println("Enter customer name for booth " + boothNum + " :");
            String newCustomer = input.next();
            customerName[boothNum] = new Booth(newCustomer);
            vaccineStock -= 1;
            System.out.println("Customer " + newCustomer + " successfully added to the booth.");
        }
        else{ //If booth is occupied, patinet detials will go to a waiting list
            System.out.println("This booth has already occupied by a customer. New customer will be added to the waiting list\n");
            System.out.println("Enter customer name for waiting list: ");
            String newCustomer = input.next();
            waitingList.add(newCustomer);
            vaccineStock -= 1;
            System.out.println("Customer " + newCustomer + " successfully added to the waiting list");
        }
        System.out.println("");
        //Checking if the amount of vaccines reach 20 to display a warning message
        if(vaccineStock==20){
            System.out.println("WARNING! ||| This center running out of vaccines. You only have 20 vaccines. ||| WARNING!");
        }
        System.out.println("");
        return vaccineStock;
    }

    static void RemovePatient(Booth[] customerName, LinkedList<String> waitingList) {
        //Lets you remove a patient in a booth.
        System.out.println("");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the booth number that you want to free?");
        int boothNum = input.nextInt();
        customerName[boothNum] = new Booth("e");
        System.out.println("The customer in the booth number "+boothNum+" successfully removed from the booth list.");
        System.out.println("");
        if(!(waitingList.isEmpty())){ //Adding customers from waiting list to main booth
            customerName[boothNum] = new Booth(waitingList.getFirst());
            waitingList.removeFirst(); //After adding the first person in the waiting list to main booth
            System.out.println("A patient from the waiting list automatically added to the main booth.");
            System.out.println("");
        }
    }

    static void ViewPatientsSorted(Booth[] customerName){
        //Viewing names of patients in alphabetical order.

        String[] stringArray = new String[6];
        // copy elements from object array to string array
        for (int i = 0; i < 6; i++) {
            stringArray[i] = String.valueOf(customerName[i]);
        }
        int n = 6;

        String temporary;
        for(int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                if (stringArray[i].compareTo(stringArray[j])>0){
                    temporary = stringArray[i];
                    stringArray[i] = stringArray[j];
                    stringArray[j] = temporary;
                }
            }
        }
        System.out.println("Sorted booth customer list: ");
        for (int i = 0; i < n; i++) {
            if(stringArray[i].equals("e")){
                continue;
            }
            else {
                System.out.println(stringArray[i]);
            }
        }
        System.out.println("");
    }

    static void StoreFile(Booth[] customerName) throws IOException {
        //Storing booth numbers with patient's names to a file
        FileWriter myFile = new FileWriter("vacccinationData.txt");
        for (int i = 0; i < 6; i++) {
            String empty = "e";
            if(!(String.valueOf(customerName[i])=="e")){
                myFile.write("Booth Number "+i+"\nPatient Name: "+String.valueOf(customerName[i])+"\n");
                myFile.write("------------------\n");
                myFile.write("");
            }
        }
        myFile.close();
        System.out.println("Vaccination data successfully updated to a file.");
        System.out.println("");
    }

    static void LoadFile() throws FileNotFoundException {
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

    static void RemainingVaccinations(int stockLevel) {
        //Viewing remaining amount of vaccines.
        System.out.println("This center currently has " + stockLevel + " number of vaccines.");
        System.out.println("");
    }

    static int AddVaccinations(int addStock) {
        //Lets you update the amount of vaccines.
        Scanner input = new Scanner(System.in);
        System.out.println("How many vaccines do you want to add to the stock?");
        int add = input.nextInt();
        addStock += add;
        System.out.println("Vaccination stock level successfully updated.");
        System.out.println("");
        return addStock;
    }
}
