import java.util.Scanner;

public class HomeInsurancePolicy {
    public static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Home Quote Application!");

        System.out.print("Enter home age: ");
        int homeAge = scanner.nextInt();

        System.out.println("Select heating type:");
        System.out.println("1. Electric");
        System.out.println("2. Oil");
        System.out.println("3. Wood");
        System.out.println("4. Gas");
        System.out.println("5. Other");
        int heatingType = scanner.nextInt();

        System.out.println("Select dwelling type:");
        System.out.println("1. Single Dwelling");
        System.out.println("2. Apartment");
        System.out.println("3. Bungalow");
        System.out.println("4. Semi-attached");
        int dwellingType = scanner.nextInt();

        double basePremium = 500.0;
        double ageFactor = getAgeFactor(homeAge);
        double heatingTypeFactor = getHeatingTypeFactor(heatingType);
        double dwellingTypeFactor = getDwellingTypeFactor(dwellingType);
        double premiumAmount = basePremium * ageFactor * heatingTypeFactor * dwellingTypeFactor;

        System.out.println("Policy Quote:");
        System.out.println("Coverage Type: Home");
        System.out.println("Base Premium: $" + basePremium);
        System.out.println("Premium Amount: $" + premiumAmount);
    }

    private static double getAgeFactor(int homeAge) {
        if (homeAge < 25) {
            return 1.0;
        } else if (homeAge < 50) {
            return 1.25;
        } else {
            return 1.5;
        }
    }
    private static double getHeatingTypeFactor(int heatingType) {
        switch (heatingType) {
            case 1:
                return 1.0;
            case 2:
                return 2.0;
            case 3:
                return 1.25;
            case 4:
                return 1.0;
            case 5:
                return 1.0;
            default:
                throw new IllegalArgumentException("Invalid heating type");
        }
    }

    private static double getDwellingTypeFactor(int dwellingType) {
        switch (dwellingType) {
            case 1:
                return 1.0;
            case 2:
                return 0.75;
            case 3:
                return 1.0;
            case 4:
                return 1.15;
            default:
                throw new IllegalArgumentException("Invalid dwelling type");
        }
    }
}