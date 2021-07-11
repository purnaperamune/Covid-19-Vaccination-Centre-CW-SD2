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
        String check = "e";
        if (customerName == check) {
            System.out.println("Booth number " + x + " is empty. Please assign a customer to this booth.");
        } else {
            System.out.println("Booth number " + x + " is occupied by " + customerName);
        }
    }

    void ViewEmptyBooths(int x) {
        String check = "e";
        if (customerName == check) {
            System.out.println("Booth number " + x + " is empty. Please assign a customer to this booth.");
        }
    }

    void AddPatientEmptyList(int x) {  //Showing empty booth list when user asks to add a new customer to a booth.
        String check = "e";
        if (customerName == check) {
            System.out.println("Booth number " + x + " is empty. Enter" + x + " to assign a customer to this booth.");
        }
    }

    static int AddPatient(Booth[] customerName, int vaccineStock) {
        Scanner input = new Scanner(System.in);
        System.out.println("Your selection of booth number to the new customer: ");
        int boothNum = input.nextInt();
        System.out.println("Enter customer name for booth " + boothNum + " :");
        String newCustomer = input.next();
        customerName[boothNum] = new Booth(newCustomer);
        vaccineStock -= 1;
        System.out.println("Customer " + newCustomer + " successfully added to the booth.");
        System.out.println("");
        return vaccineStock;
    }

    static void RemovePatient(Booth[] customerName) {
        System.out.println("");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the booth number that you want to free?");
        int boothNum = input.nextInt();
        customerName[boothNum] = new Booth("e");
        System.out.println("The customer in the booth number "+boothNum+" successfully removed from the booth list.");
        System.out.println("");
    }

    static void ViewPatientsSorted(Booth[] customerName){
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

    static void StoreFile() {
        System.out.println("Still Processing");
    }

    static void LoadFile() {
        System.out.println("Still Processing");
    }

    static void RemainingVaccinations(int stockLevel) {
        System.out.println("This center currently has " + stockLevel + " number of vaccines.");
        System.out.println("");
    }

    static int AddVaccinations(int addStock) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many vaccines do you want to add to the stock?");
        int add = input.nextInt();
        addStock += add;
        System.out.println("Vaccination stock level successfully updated.");
        System.out.println("");
        return addStock;
    }
}
