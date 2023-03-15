import java.util.Scanner;

public class ApplicationMenu {
    public static void main(String[] args) {


        printMenu();
//        System.out.println("Welcome to the Policy Quote Application!");
//        // Get input from user
//        System.out.print("Enter the Policy you would like a quote for: ");
//        System.out.print("\nAuto: 1");
//        System.out.print("\nHome: 2");
//        System.out.print("\nExit: 3");
//        System.out.print("\n:");


    }

    public static void printMenu() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Policy Quote Application!");
        // Get input from user
        System.out.print("Enter the Policy you would like a quote for: ");
        System.out.print("\nAuto: 1");
        System.out.print("\nHome: 2");
        System.out.print("\nExit: 3");
        System.out.print("\n:");

        int choice = scanner.nextInt();

        if(choice == 1){
            CarInsurancePolicy.main();
        } else if(choice == 2){
            HomeInsurancePolicy.main();
        }else if(choice == 3){
            System.exit(0);
        }
    }
}
