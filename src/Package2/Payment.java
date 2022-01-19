package Package2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Payment {

    private double amountReceived;
    private final double SST = 0.06;
    private final double serviceTax = 0.10;
    private double expensesFees;
    private double totalFees;
    private Booking booking;
    Scanner sc = new Scanner(System.in);
    private long cardNumber[] = new long[3];
    private int cardExpiryDate[] = new int[3];
    private int cardCCV[] = new int[3];

    public Payment() {

    }

    public Payment(Booking booking) {
        this.booking = booking;
        this.expensesFees = booking.getTotalExpensesFee();
        cardNumber[0] = 1111;
        cardExpiryDate[0] = 1122;
        cardCCV[0] = 111;
        cardNumber[1] = 2222;
        cardExpiryDate[1] = 1222;
        cardCCV[1] = 222;
        cardNumber[2] = 3333;
        cardExpiryDate[2] = 1322;
        cardCCV[2] = 333;
    }

    public double gettotalRoomFees() { //setter
        return (booking.getDoubleRoomPrice() + booking.getSingleRoomPrice() + booking.getFamilyRoomPrice() + booking.getSmokingRoomPrice());

    }

    public double getExpensesFees() {   //setter
        return expensesFees;
    }

    public double getSST() {
        double SSTfees = (this.gettotalRoomFees() + expensesFees) * SST;
        return SSTfees;
    }

    public double getServiceTax() {
        double serviceTaxFees = (this.gettotalRoomFees() + expensesFees) * serviceTax;
        return serviceTaxFees;
    }

    public double calculateTotalFees() {
        totalFees = this.gettotalRoomFees() + this.getExpensesFees() + this.getSST() + this.getServiceTax();
        BigDecimal bd = new BigDecimal(totalFees).setScale(2, RoundingMode.HALF_UP);
        double newTotalFees = bd.doubleValue();
        totalFees = newTotalFees;
        return totalFees;
    }

    public int validateCardNo(long cardNumber, int cardExpiryDate, int cardCCV) {
        for (int i = 0; i < 3; i++) {
            if ((cardNumber == this.cardNumber[i])) {
                if ((cardExpiryDate == this.cardExpiryDate[i])) {
                    if ((cardCCV == this.cardCCV[i])) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public void printPaymentDetails() {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s %-25s %-23s %-24s %-23s\n", "Total Room Fees", "Total Expenses Fees", "SST Charge", "Service Tax", "Grand Total");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.printf("RM%-18.2f RM%-23.2f RM%-21.2f RM%-22.2f RM%-21.2f", this.gettotalRoomFees(), this.getExpensesFees(), this.getSST(), this.getServiceTax(), this.calculateTotalFees());
        System.out.println("");
        boolean flag = false;
        do {
            System.out.println("\nTotal fees : RM" + this.calculateTotalFees());
            System.out.print("\nEnter Amount: RM");
            amountReceived = sc.nextInt();
            if (amountReceived > this.calculateTotalFees()) {

                System.out.println("\nPayment Complete!");
                flag = true;
            } else {
                System.out.println("\nPayment Not Enough");
                System.out.println("Please try again !!");

            }
        } while (flag == false);
        System.out.print("Balance: ");
        System.out.printf("RM%-10.2f", this.amountReceived - this.calculateTotalFees());
        System.out.println("\n");
        System.out.println("Thank you! Please come again.");
        //booking.printBookingDetails();
    }

}
