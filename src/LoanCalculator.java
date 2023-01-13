import java.util.Scanner;

public class LoanCalculator {
    // Declare fields to store loan amount, interest rate, and loan term
    private final float loanAmount;
    private final float interestRate;
    private final int loanTerm;

    // Constructor that reads loan amount, interest rate, and loan term from user input
    public LoanCalculator() {
        Scanner scanner = new Scanner(System.in);

        // Read loan amount from user input
        System.out.print("Enter loan amount: ");


        // Check if the input is an integer, and prompt the user to enter a valid number if it isn't
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid number.");
            scanner.next();
        }

        // If the input is an integer, store it in the loanAmount field
        loanAmount = scanner.nextInt();

        // Check if the loan amount is less than 1000, and throw an error if it is
        if (loanAmount < 1000) {
            throw new IllegalArgumentException("Minimum loan amount is 1000.");
        }

        // Read interest rate from user input
        System.out.print("Enter interest rate: ");
        interestRate = scanner.nextFloat();

        // Read loan term from user input
        System.out.print("Enter loan term (in years): ");
        loanTerm = scanner.nextInt();
    }

    // Method that calculates and returns the monthly payment for the loan
    public float calculateMonthlyPayment() {
        // Convert interest rate from a decimal to a percentage
        float monthlyInterestRate = interestRate / 100 / 12;

        // Calculate total number of payments
        float numberOfPayments = loanTerm * 12;

        // Calculate and return monthly payment
        return (float) (loanAmount * (monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments))));
    }
    // Calculate the total amount paid on the loan
    public float calculateTotalAmountPaid() {
        float numberOfPayments = loanTerm * 12;
        return numberOfPayments * calculateMonthlyPayment();
    }


    // Main method that creates an instance of LoanCalculator and prints the monthly payment and  the total amount paid on the loan
    public static void main(String[] args) {
        LoanCalculator calculator = new LoanCalculator();
        float monthlyPayment = calculator.calculateMonthlyPayment();
        float totalAmountPaid = calculator.calculateTotalAmountPaid();
        System.out.println("Monthly payment: " + monthlyPayment);
        System.out.println("Total amount paid: " + totalAmountPaid);
    }
}
