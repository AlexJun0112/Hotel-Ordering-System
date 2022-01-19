/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Package2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Booking {

    private int bookingID;
    private java.util.Date checkInDate;
    private java.util.Date checkOutDate;
    private ExpensesList expList;
    private BookingList single_bookinglist;
    private BookingList double_bookinglist;
    private BookingList family_bookinglist;
    private BookingList smoking_bookinglist;

    public Booking() {
    }

    public Booking(int bookingID, Date checkInDate, Date checkOutDate, BookingList single_bookinglist, BookingList double_bookinglist, BookingList family_bookinglist, BookingList smoking_bookinglist, ExpensesList expList) {
        this.bookingID = bookingID;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.single_bookinglist = single_bookinglist;
        this.double_bookinglist = double_bookinglist;
        this.family_bookinglist = family_bookinglist;
        this.smoking_bookinglist = smoking_bookinglist;
        this.expList = expList;
    }

    public Date getCheckInDate() {

        System.out.println("Enter your check In date (DD/MM/YYYY) :" + checkInDate);
        return checkInDate;
    }

    public Date getCheckOutDate() {
        System.out.println("Enter your check Out date (DD/MM/YYYY) :" + checkOutDate);
        return checkOutDate;
    }

    public long getDayDiff() {
        long diff = checkOutDate.getTime() - checkInDate.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void printBookingDetails() {

        System.out.printf("Booking ID: %-10s\nCheck In Date: %tF %nCheck Out Date: %tF %n", bookingID, checkInDate, checkOutDate);
        System.out.println("\n \t \t \t \t \t \t   ROOM LIST");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-30s %-20s %-20s %20s", "Room Number", "Room Type", "Bed Type", "Price per day", "Additions");
        System.out.println("\n-----------------------------------------------------------------------------------------------------------------------");
        single_bookinglist.printBookingListDetails();
        double_bookinglist.printBookingListDetails();
        family_bookinglist.printBookingListDetails();
        smoking_bookinglist.printBookingListDetails();
        System.out.println("");
        System.out.println("\nSingle Room Price : RM " + (this.getDayDiff() * single_bookinglist.getBookingListPrice()));
        System.out.println("\nDouble Room Price : RM " + (this.getDayDiff() * double_bookinglist.getBookingListPrice()));
        System.out.println("\nFamily Suite Price : RM " + (this.getDayDiff() * family_bookinglist.getBookingListPrice()));
        System.out.println("\nSmoking Room Price : RM " + (this.getDayDiff() * smoking_bookinglist.getBookingListPrice()));
        System.out.println("");
        System.out.println(" \t \t \t \t \t \t Expenses List");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        expList.printExpensesListDetails();
        System.out.println("\t\t\t\t\t\t\t\t\t\tTotal Expenses Fees: RM" + expList.getTotalExpenses()+"0");
        System.out.println("");
    }
    
    public double getTotalExpensesFee(){
        return expList.getTotalExpenses();
    }
    
    public double getSingleRoomPrice() {
        return this.getDayDiff() * single_bookinglist.getBookingListPrice();
    }

    public double getDoubleRoomPrice() {
        return this.getDayDiff() * double_bookinglist.getBookingListPrice();
    }

    public double getFamilyRoomPrice() {
        return this.getDayDiff() * family_bookinglist.getBookingListPrice();
    }

    public double getSmokingRoomPrice() {
        return this.getDayDiff() * smoking_bookinglist.getBookingListPrice();
    }

    public boolean validateJavaDate(String strDate) {
        /* Check if date is 'null' */
        if (strDate.trim().equals("")) {
            return true;          //null should return false right ??????????????????????????????????????????????????
        } /* Date is not 'null' */ else {
            /*
	     * Set preferred date format,
	     * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
            SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
            sdfrmt.setLenient(false);
            /* Create Date object
	     * parse the string into date 
             */
            try {
                Date javaDate = sdfrmt.parse(strDate);
                System.out.println(strDate + " is valid date format");
            } /* Date format is invalid */ catch (ParseException e) {
                System.out.println(strDate + " is Invalid Date format");
                return false;
            }
            /* Return true if date format is valid */
            return true;
        }
    }
}
