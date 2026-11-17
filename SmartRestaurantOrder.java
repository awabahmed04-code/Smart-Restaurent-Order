import java.util.Scanner;

public class SmartRestaurantOrder {
    public static void main(String[] args) {
        // Constant rates and prices
        final double COST_PER_DRINK = 15.50;
        final double RATE_STUDENT = 0.10;
        final double RATE_SENIOR = 0.05;
        final double RATE_TIP = 0.10;

        Scanner scanner = new Scanner(System.in);

        // Gathering order details from user
        System.out.print("Customer name: ");
        String fullName = scanner.nextLine();

        System.out.print("Customer age: ");
        int customerAge = scanner.nextInt();

        System.out.print("Meal price ($): ");
        double foodCost = scanner.nextDouble();

        System.out.print("Number of drinks: ");
        int drinkQuantity = scanner.nextInt();

        System.out.print("Student status (true/false): ");
        boolean studentStatus = scanner.nextBoolean();

        System.out.print("Service rating (1-5): ");
        int serviceScore = scanner.nextInt();

        // Check if the rating is inside the valid 1 to 5 range
        if (serviceScore >= 1 && serviceScore <= 5) {
            double totalDrinksCost = drinkQuantity * COST_PER_DRINK;
            double orderSubtotal = foodCost + totalDrinksCost;

            // Determine applicable discount rate
            double appliedDiscountRate = 0.0;
            if (studentStatus) {
                appliedDiscountRate = RATE_STUDENT;
            } else if (customerAge >= 60) {
                appliedDiscountRate = RATE_SENIOR;
            }
            double discountValue = orderSubtotal * appliedDiscountRate;

            // Determine tip amount for ratings 4 and 5
            double tipValue = 0.0;
            if (serviceScore >= 4) {
                tipValue = orderSubtotal * RATE_TIP;
            }

            // Final total and integer casting
            double exactTotal = (orderSubtotal - discountValue) + tipValue;
            int roundedTotal = (int) exactTotal;

            // Display formatted receipt
            System.out.println();
            System.out.println("SMART RESTAURANT");
            System.out.println("Customer: " + fullName);
            System.out.printf("Meal: $%.2f%n", foodCost);
            System.out.printf("Drinks: $%.2f%n", totalDrinksCost);
            System.out.printf("Discount: $%.2f%n", discountValue);
            System.out.printf("Tip: $%.2f%n", tipValue);
            System.out.printf("Final bill: $%.2f%n", exactTotal);
            System.out.println("Whole amount: $" + roundedTotal);
        } else {
            System.out.println("Invalid rating! Service rating must be between 1 and 5.");
        }

        scanner.close();
    }
}