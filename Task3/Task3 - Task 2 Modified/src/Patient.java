import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Patient {
    private String firstName;
    private static String secondName;
    private int age;
    private String city;
    private String vaccineType;
    private long nicNumber;

    public Patient(String firstName,String secondName,int age,String city,String vaccineType,long nicNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.city = city;
        this.vaccineType = vaccineType;
        this.nicNumber = nicNumber;
    }

    public String toStringFirstName(){
        return  firstName;
    }
    public String toStringSecondName(){
        return  secondName;
    }
    public int Age(){
        return  age;
    }
    public String toStringCity(){
        return  city;
    }
    public String toStringVaccine(){
        return vaccineType;
    }
    public long toStringNIC(){
        return nicNumber;
    }

    void ViewVaccinationBooths(Patient[] customerInfo,int x) {
        //Viewing all vaccination booth including both occupied and empty booths.
        String check = "e";
        if (firstName == check) {
            System.out.println("Booth number " + x + " is empty. Please assign a customer to this booth.");
        } else {
            System.out.println("Booth number " + x + " is occupied by " + customerInfo[x].firstName );
        }
    }

    void ViewEmptyBooths(int x) {
        //Viewing all empty booths.
        String check = "e";
        if (firstName == check) {
            System.out.println("Booth number " + x + " is empty. Please assign a customer to this booth.");
        }
    }

    void AddPatientEmptyList(int x) {
        //This executes only when you are going to add a new patient to the booth. Shows the empty booths.
        String check = "e";
        if (firstName == check) {
            System.out.println("Booth number " + x + " is empty. Enter" + x + " to assign a customer to this booth.");
        }
    }

    static int AddPatient(Patient[] customerInfo, int vaccineStock) {
        //Lets you add a new patient to the booth. And also gives a list of empty booths to make the task easy.

        System.out.println("");
        System.out.println("Booth 0 & 1 --- AstraZeneca");
        System.out.println("Booth 2 & 3 --- Sinopharm");
        System.out.println("Booth 4 & 5 --- Pfizer");

        Scanner input = new Scanner(System.in);
        System.out.println("Your selection of booth number according to the vaccine type to add the new customer: ");
        int boothNum = input.nextInt();

        if(customerInfo[boothNum].firstName.equals("e")){
            System.out.println("Enter the first name of the customer for booth number " + boothNum + ":");
            String newCustomerFirstName = input.next();

            System.out.println("Enter the second name of the customer :");
            String newCustomerSecondName = input.next();

            System.out.println("Enter the age of the customer : ");
            int newCustomerAge = input.nextInt();

            System.out.println("City of the customer : ");
            String newCustomerCity = input.next();

            System.out.println("Enter NIC number of the customer :");
            long newCustomerNIC = input.nextLong();

            String newCustomerVaccineType;
            if((boothNum==0)||(boothNum==1)){
                newCustomerVaccineType = "AstraZeneca";
            }
            else if((boothNum==2)||(boothNum==3)){
                newCustomerVaccineType = "Sinopharm";
            }
            else{
                newCustomerVaccineType = "Pfizer";
            }

            customerInfo[boothNum] = new Patient(newCustomerFirstName,newCustomerSecondName,newCustomerAge,newCustomerCity,newCustomerVaccineType,newCustomerNIC);
            vaccineStock -= 1;
            System.out.println("Customer " + customerInfo[boothNum].firstName +" "+customerInfo[boothNum].secondName +" successfully added to the booth.");
            System.out.println("");
            //Checking if the amount of vaccines reach 20 to display a warning message
            if(vaccineStock==20){
                System.out.println("WARNING! ||| This center running out of vaccines. You only have 20 vaccines. ||| WARNING!");
            }
        }
        else{
            System.out.println("Already occupied by a customer. Please use an empty booth to assign a new customer.");
        }
        System.out.println("");
        return vaccineStock;
    }

    static void RemovePatient(Patient[] customerInfo) {
        //Lets you remove a patient in a booth.
        System.out.println("");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the booth number that you want to free?");
        int boothNum = input.nextInt();
        customerInfo[boothNum] = new Patient("e","e",0,"e","e",0000);
        System.out.println("The customer in the booth number "+boothNum+" successfully removed from the booth list.");
        System.out.println("");
    }

    static void ViewPatientsSorted(Patient[] customerInfo){
        //Viewing names of patients in alphabetical order.

        String[] stringArray = new String[6];
        // copy elements from object array to string array
        for (int i = 0; i < 6; i++) {
            stringArray[i] = customerInfo[i].firstName;
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
            if(stringArray[i].equals("ee")){
                continue;
            }
            else {
                System.out.println(stringArray[i]);
            }
        }
        System.out.println("");
    }

    static void StoreFile(Patient[] customerInfo) throws IOException {
        //Storing booth numbers with patient's names to a file
        FileWriter myFile = new FileWriter("vacccinationData.txt");
        for (int i = 0; i < 6; i++) {
            if(!(customerInfo[i].toStringFirstName().equals("e"))){
                myFile.write("Booth Number "+i+"\nPatient Name: "+customerInfo[i].toStringFirstName()+"\n"+
                        "Age: "+customerInfo[i].Age()+"\n"+
                        "City: "+customerInfo[i].toStringCity()+"\n"+
                        "NIC: "+customerInfo[i].toStringNIC()+"\n"+
                        "Vaccine type: "+customerInfo[i].toStringVaccine()+"\n");
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
