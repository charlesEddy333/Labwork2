import java.util.Scanner;
public class SalaryCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);//input


        for (int i = 1; i <= 3; i++) {   //iterates 3 times
            System.out.print("Enter hours worked for employee " + i + ": ");
            double hoursWorked = scanner.nextDouble();
            System.out.print("Enter hourly rate for employee " + i + ": $");
            double hourlyRate = scanner.nextDouble();

            double grossPay = calculateGrossPay(hoursWorked, hourlyRate);

            System.out.println("Gross pay for employee " + i + ": $" + grossPay);


        }
    }


    public static double calculateGrossPay(double hoursWorked, double hourlyRate) {
        double straightTimeHours = Math.min(hoursWorked, 40);
        double overtimeHours = Math.max(0, hoursWorked - 40);

        return straightTimeHours * hourlyRate + overtimeHours * hourlyRate * 1.5;
    }
}