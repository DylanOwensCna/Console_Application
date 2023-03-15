import java.util.Scanner;

public class CarInsurancePolicy {

    public static void main() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Car Quote Application!");

        // Get input from user

        System.out.print("Enter the blue book value of your car: ");
        int carValue = scanner.nextInt();

        System.out.print("Enter number of accidents in the last 5 years: ");
        int accidents = scanner.nextInt();

        System.out.print("Enter driver age: ");
        int driverAge = scanner.nextInt();

        System.out.print("Enter location (1 for Dense Urban, 2 for Urban, 3 for Rural): ");
        int location = scanner.nextInt();

        int basePremium;

        // Calculate premium
        if (carValue <= 55000) {
            basePremium = 750;
        } else if (carValue > 55000 && carValue <= 75000) {
            basePremium = 900;
        } else if (carValue > 75000 && carValue <= 95000) {
            basePremium = 1200;
        } else {
            basePremium = 1500;
        }

        double ageFactor = 1.0;
        double accidentFactor = 1.0;
        double locationFactor = 1.0;

        // Apply age factor
        if (driverAge < 25) {
            ageFactor = 2.0;
        } else if (driverAge >= 25 && driverAge < 50) {
            ageFactor = 1.0;
        } else {
            ageFactor = 1.0;
        }

        // Apply accident factor
        if (accidents == 0) {
            accidentFactor = 1.00;
        } if (accidents == 1) {
            accidentFactor = 1.25;
        } if (accidents == 2) {
            accidentFactor = 2.50;
        }

        // Apply location factor
        if (location == 1) {
            locationFactor = 1.5;
        } else if (location == 2) {
            locationFactor = 1.25;
        } else {
            locationFactor = 1.0;
        }

        // Calculate final premium
        double premium = basePremium * ageFactor * accidentFactor * locationFactor;

        // Display premium to user
        System.out.println("Your premium is: $" + premium);

        ApplicationMenu.printMenu();


    }




}