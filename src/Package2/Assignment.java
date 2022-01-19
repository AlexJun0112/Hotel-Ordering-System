package Package2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Assignment {

    //Declaring different types of room
    private static SingleRoom singleRoom[] = new SingleRoom[11];
    private static DoubleRoom doubleRoom[] = new DoubleRoom[11];
    private static FamilySuite familySuite[] = new FamilySuite[11];
    private static SmokingRoom smokingRoom[] = new SmokingRoom[11];
    //Declare variables
    private static int bookingID = 0;
    private static int exp_no;
    private static long cardNo;
    private static int ccv_no;
    private static int staffps;

    //Main driver program
    public static void main(String[] args) throws ParseException {
        //declare scanner
        Scanner sc = new Scanner(System.in);
        //set date format
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        boolean isDo = true; //loop for next customer
        Customer newCustomer;

        //Initializing the room
        for (int j = 1; j <= 10; j++) {
            singleRoom[j] = new SingleRoom(j + 1, "Available", "SingleRoom", "Queen", 300);
            doubleRoom[j] = new DoubleRoom(j + 10, "Available", "DoubleRoom", "King", 500);
            familySuite[j] = new FamilySuite(j + 20, "Available", "FamilySuite", "King", 1000, "Balcony");
            smokingRoom[j] = new SmokingRoom(j + 30, "Available", "SmokingRoom", "Queen", 600, "Air Purifier");
        }
        //declaring for room number
        int single_room_num = 1;
        int double_room_num = 1;
        int family_suite_num = 1;
        int smoking_room_num = 1;

        //Initializing the set meal menu  
        Menu[] menuArray = {new Menu("Nasi Lemak + Iced Milo", 12.00),
            new Menu("Hainanese Chicken Rice + Orange Juice", 15.00),
            new Menu("Banana Leaf + Lychee Juice", 18.50),
            new Menu("Chicken Chop + Iced Lemon Tea", 19.90)};
        
        //Declaring for mealQuantityArray & mealOrder
        MealQuantity[] mealQuantityArray;
        MealOrder mealOrder;

        //Initializing the set meal menu 
        ExtraService[] extraServiceArray = {new ExtraService("SPA", 50.00),
            new ExtraService("MASSAGE", 60.00),
            new ExtraService("EXTRA BED", 70.00)};
        
        //Declaring for extraServicePaxArray & extraServiceOrder
        ExtraServicePax[] extraServicePaxArray;
        ExtraServiceOrder extraServiceOrder;

        //Declaring expList & newBooking & payment
        ExpensesList expList;
        Booking newBooking;
        Payment payment;

        //DECLARATION FOR SALES REPORT
        int total_customer = 0;
        int total_singleroom = 0;
        int total_doubleroom = 0;
        int total_familysuite = 0;
        int total_smokingroom = 0;
        int[] total_setmeal = new int[4];
        int[] total_extraservice = new int[3];
        double total_revenue = 0.0;
        double room_sales = 0.0;
        double setmeal_sales = 0.0;
        double extraservice_sales = 0.0;
        String skip, skip2;
        
        //Do While Loop for continuous customer booking
        do {
            skip = sc.nextLine();
            //Show greetings
            System.out.println("\t \t \t \t \t \tWelcome to WX Hotel");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------");
            
            //Declaring variables for customer
            String name, icno, contactno, passportno, email;
            int nationality;
            //Prompt for personal information
            System.out.println("Please enter your personal information. \n");
            System.out.println("Local(1) or foreigner(2)?");
            nationality = sc.nextInt();
            skip2 = sc.nextLine();
            
            
            //If customer nationality is local, ic number will be prompt else passport number will be prompt
            if (nationality == 1) {
                System.out.print("Name: ");
                name = sc.nextLine();
                System.out.print("Contact No: ");
                contactno = sc.nextLine();
                System.out.print("IC No: ");
                icno = sc.nextLine();
                passportno = "-";
                System.out.print("Email: ");
                email = sc.nextLine();
                //Declaring for new Customer
                newCustomer = new Customer(name, contactno, icno, passportno, email);
                
            } else if (nationality == 2) {
                System.out.print("Name: ");
                name = sc.nextLine();
                System.out.print("Contact No: ");
                contactno = sc.nextLine();
                icno = "-";
                System.out.print("Passport No: ");
                passportno = sc.nextLine();
                System.out.print("Email: ");
                email = sc.nextLine();
                newCustomer = new Customer(name, contactno, icno, passportno, email);
            }

            System.out.println("");

            // 
            //  BOOK ROOM
            //
            // Declare,prompt and get check in and check out date
            String checkin, checkout;
            System.out.println("Please enter the date (DD/MM/YYYY): ");
            System.out.print("Check In Date: ");
            checkin = sc.nextLine();
            System.out.print("Check Out Date: ");
            checkout = sc.nextLine();
            
            //Display Room Details
            System.out.println("\n \t \t \t \t ROOM DETAILS");
            System.out.println("-----------------------------------------------------------------------------");
            System.out.printf("%-20s  %-20s %-20s %-20s", "Room Number", "Room Types", "Bed Types", "Price per Day");
            System.out.println("\n-----------------------------------------------------------------------------");
            System.out.println("   0-10               Single Room           Queen               RM 300.00");
            System.out.println("   11-20              Double Room           King                RM 500.00");
            System.out.println("   21-30              Family Suite          King                RM 1000.00");
            System.out.println("   31-40              Smoking Room          Queen               RM 600.00");

            //Prompt for the number of room needed depending on the room type
            System.out.println("\nHow many Single Room do you want (Select 1,2,3):");
            int single_no = sc.nextInt();
            System.out.println("\nHow many Double Room do you want (Select 1,2,3):");
            int double_no = sc.nextInt();
            System.out.println("\nHow many Family Suite do you want (Select 1,2,3):");
            int family_no = sc.nextInt();
            System.out.println("\nHow many Smoking Room do you want (Select 1,2,3):");
            int smoking_no = sc.nextInt();

            //Declaring for different room type using array
            Room[] Single_room = {};
            Room[] Double_room = {};
            Room[] Family_suite = {};
            Room[] Smoking_room = {};

            //For different room type, book room according to customer request, and set the status to occupied, assign room number to the customer
            switch (single_no) {
                case 1: {
                    Room[] single_room = {singleRoom[single_room_num]};
                    singleRoom[single_room_num].setStatus("Occupied");
                    single_room_num++;
                    Single_room = single_room;
                    break;

                }
                case 2: {
                    Room[] single_room = {singleRoom[single_room_num], singleRoom[single_room_num + 1]};
                    singleRoom[single_room_num].setStatus("Occupied");
                    singleRoom[single_room_num + 1].setStatus("Occupied");
                    single_room_num++;
                    single_room_num++;
                    Single_room = single_room;
                    break;
                }
                case 3: {
                    Room[] single_room = {singleRoom[single_room_num], singleRoom[single_room_num + 1], singleRoom[single_room_num + 2]};
                    singleRoom[single_room_num].setStatus("Occupied");
                    singleRoom[single_room_num + 1].setStatus("Occupied");
                    singleRoom[single_room_num + 2].setStatus("Occupied");
                    single_room_num++;
                    single_room_num++;
                    single_room_num++;
                    Single_room = single_room;
                    break;
                }
            }

            switch (double_no) {
                case 1: {
                    Room[] double_room = {doubleRoom[double_room_num]};
                    doubleRoom[double_room_num].setStatus("Occupied");
                    double_room_num++;
                    Double_room = double_room;
                    break;

                }
                case 2: {
                    Room[] double_room = {doubleRoom[double_room_num], doubleRoom[double_room_num + 1]};
                    doubleRoom[double_room_num].setStatus("Occupied");
                    doubleRoom[double_room_num + 1].setStatus("Occupied");
                    double_room_num++;
                    double_room_num++;
                    Double_room = double_room;
                    break;
                }
                case 3: {
                    Room[] double_room = {doubleRoom[double_room_num], doubleRoom[double_room_num + 1], doubleRoom[double_room_num + 2]};
                    doubleRoom[double_room_num].setStatus("Occupied");
                    doubleRoom[double_room_num + 1].setStatus("Occupied");
                    doubleRoom[double_room_num + 2].setStatus("Occupied");
                    double_room_num++;
                    double_room_num++;
                    double_room_num++;
                    Double_room = double_room;
                    break;
                }
            }

            switch (family_no) {
                case 1: {
                    Room[] family_room = {familySuite[family_suite_num]};
                    familySuite[family_suite_num].setStatus("Occupied");
                    family_suite_num++;
                    Family_suite = family_room;
                    break;

                }
                case 2: {
                    Room[] family_room = {familySuite[family_suite_num], familySuite[family_suite_num + 1]};
                    familySuite[family_suite_num].setStatus("Occupied");
                    familySuite[family_suite_num + 1].setStatus("Occupied");
                    family_suite_num++;
                    family_suite_num++;
                    Family_suite = family_room;
                    break;
                }
                case 3: {
                    Room[] family_room = {familySuite[family_suite_num], familySuite[family_suite_num + 1], familySuite[family_suite_num + 2]};
                    familySuite[family_suite_num].setStatus("Occupied");
                    familySuite[family_suite_num + 1].setStatus("Occupied");
                    familySuite[family_suite_num + 2].setStatus("Occupied");
                    family_suite_num++;
                    family_suite_num++;
                    family_suite_num++;
                    Family_suite = family_room;
                    break;
                }
            }

            switch (smoking_no) {
                case 1: {
                    Room[] smoking_room = {smokingRoom[smoking_room_num]};
                    smokingRoom[smoking_room_num].setStatus("Occupied");
                    smoking_room_num++;
                    Smoking_room = smoking_room;
                    break;

                }
                case 2: {
                    Room[] smoking_room = {smokingRoom[smoking_room_num], smokingRoom[smoking_room_num + 1]};
                    smokingRoom[smoking_room_num].setStatus("Occupied");
                    smokingRoom[smoking_room_num + 1].setStatus("Occupied");
                    smoking_room_num++;
                    smoking_room_num++;
                    Smoking_room = smoking_room;
                    break;
                }
                case 3: {
                    Room[] smoking_room = {smokingRoom[smoking_room_num], smokingRoom[smoking_room_num + 1], smokingRoom[smoking_room_num + 2]};
                    smokingRoom[smoking_room_num].setStatus("Occupied");
                    smokingRoom[smoking_room_num + 1].setStatus("Occupied");
                    smokingRoom[smoking_room_num + 2].setStatus("Occupied");
                    smoking_room_num++;
                    smoking_room_num++;
                    smoking_room_num++;
                    Smoking_room = smoking_room;
                    break;
                }
            }
            
            //Declaring bookinglist for each room type
            BookingList single_bookinglist = new BookingList(single_no, Single_room);
            BookingList double_bookinglist = new BookingList(double_no, Double_room);
            BookingList family_bookinglist = new BookingList(family_no, Family_suite);
            BookingList smoking_bookinglist = new BookingList(smoking_no, Smoking_room);

            //
            //  END OF BOOK ROOM
            //
            //
            //  ORDER SET MEAL
            //
            System.out.println("\t\t Set Menu List");
            System.out.println("\t\t --------------");
            System.out.printf("%-4s %-40s %-10s\n", "NO", "SEAT MEAL", "PRICE");
            for (int i = 0; i < 4; i++) { //display menu
                System.out.println(menuArray[i].printMenuDetails());
            }
            System.out.println("");
            int totalQuantity = 4; //array size

            mealQuantityArray = new MealQuantity[totalQuantity];

            int mealQuantity, seatMeal = 0;

            for (int i = 0; i < totalQuantity; i++) {
                System.out.println("");
                System.out.println("Set Meal " + (i + 1));
                System.out.println("--------------");
                seatMeal++;

                System.out.println("Enter the quantity: ");
                do {
                    while (!sc.hasNextInt()) {
                        System.out.println("Please enter a positive number!");
                        sc.next();
                    }
                    mealQuantity = sc.nextInt();
                } while (mealQuantity < 0); //validation for quantity input

                mealQuantityArray[i] = new MealQuantity(menuArray[seatMeal - 1], mealQuantity);
            }
            System.out.println("");
            System.out.println("\t\t\t\t\tMeal Order Details");
            System.out.println("\t\t\t\t\t------------------");
            System.out.printf("%-10s %-40s %-18s %-24s %-18s\n", "NO", "SET MEAL", "UNIT PRICE", "QUANTITY", "SUBTOTAL");
            System.out.println("--------------------------------------------------------------------------------------------------------");
            for (int j = 0; j < totalQuantity; j++) { //print the meal order details
                mealQuantityArray[j].printMenuDetails();
                System.out.println("");
            }
            System.out.println("--------------------------------------------------------------------------------------------------------");
            mealOrder = new MealOrder(mealQuantityArray, totalQuantity);
            mealOrder.calculateGrandTotal();
            System.out.printf("%94s RM%-9.2f\n", "Grand Total: ", mealOrder.getTotalMealFees()); //print grand total
            System.out.println("");
            //
            // END OF ORDER SET MEAL
            // 
            //
            //  EXTRA SERVICE
            //
            System.out.println("\t\t Extra Service List");
            System.out.println("\t\t ------------------");
            System.out.printf("%-4s %-40s %-10s\n", "NO", "SERVICES", "PRICE");
            for (int i = 0; i < 3; i++) { //print extra service list
                System.out.println(extraServiceArray[i].printServiceDetails());
            }

            System.out.println("");
            int totalPax = 3; //array size

            extraServicePaxArray = new ExtraServicePax[totalPax];

            int ExtraServiceNoOfPax, services = 0;
            for (int i = 0; i < totalPax; i++) {
                System.out.println("");
                System.out.println("Extra Service " + (i + 1));
                System.out.println("--------------");
                services++;

                System.out.println("Enter the pax: ");
                do {
                    while (!sc.hasNextInt()) {
                        System.out.println("Please enter a positive number!");
                        sc.next();
                    }
                    ExtraServiceNoOfPax = sc.nextInt();
                } while (ExtraServiceNoOfPax < 0); //validation for no of pax
                extraServicePaxArray[i] = new ExtraServicePax(extraServiceArray[services - 1], ExtraServiceNoOfPax);
            }
            System.out.println("");
            System.out.println("\t\t\t\t\tExtra Service Details");
            System.out.println("\t\t\t\t\t---------------------");
            System.out.printf("%-10s %-40s %-18s %-24s %-18s\n", "NO", "EXTRA SERVICE", "UNIT PRICE", "QUANTITY", "TOTAL PRICE");
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < totalPax; i++) { //print Extra Service Details
                extraServicePaxArray[i].printServiceDetails();
                System.out.println("");
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------");
            extraServiceOrder = new ExtraServiceOrder(extraServicePaxArray, totalPax);
            extraServiceOrder.calculateGrandTotal();
            System.out.printf("%94s RM%-9.2f\n", "Grand Total: ", extraServiceOrder.getTotalExtraServiceFees()); //print grand total
            System.out.println("");
            System.out.println("");
            //
            // END OF EXTRA SERVICE
            // 
            //
            //  EXPENSES LIST
            //
            expList = new ExpensesList(extraServiceOrder, mealOrder);
            expList.calculateExpensesList(); //calcualte the total expenses fee
            //
            //  END OF EXPENSES LIST
            //
            
            //Declaing booking for the customer
            newBooking = new Booking(bookingID, formatter.parse(checkin), formatter.parse(checkout), single_bookinglist, double_bookinglist, family_bookinglist, smoking_bookinglist, expList);
            bookingID++;
            
            //Declare payment
            payment = new Payment(newBooking);
            //Prompt customer card information and validate it
            do {
                System.out.print("Enter your card number: ");
                cardNo = sc.nextLong();
                System.out.print("\nEnter your card expiry date (DDMM): ");
                exp_no = sc.nextInt();
                System.out.print("\nEnter your CCV number: ");
                ccv_no = sc.nextInt();
                if (payment.validateCardNo(cardNo, exp_no, ccv_no) == 0) {
                    System.out.println("Please try another card");
                }
            } while (payment.validateCardNo(cardNo, exp_no, ccv_no) == 0);
            System.out.println("Card validated sucessfully");

            //Display bill
            System.out.println("\t \t \t \t \t \t   HOTEL WX");
            System.out.println("\n");
            System.out.println("\t \t \t \t \t \t   YOUR BILL");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------");
            System.out.println("Nights Stay: " + newBooking.getDayDiff());
            System.out.println("");
            newBooking.printBookingDetails();
            System.out.println("");
            payment.calculateTotalFees();
            payment.printPaymentDetails();

            System.out.println("");
            
            //Prompt for next customer or end the program for staff to view sales report
            int status;
            System.out.println("Next Customer (1/0)");
            status = sc.nextInt();

            if (status == 1) {
                isDo = true;
            } else if (status == 0) {
                isDo = false;

            }
            //Cummulative increment of variables to be shown in the sales report
            total_customer += 1;
            total_singleroom += single_no;
            total_doubleroom += double_no;
            total_familysuite += family_no;
            total_smokingroom += smoking_no;
            for (int i = 0; i < 4; i++) {
                if (mealQuantityArray[i].getQuantity() <= 0) {
                    total_setmeal[i] += 0;
                } else {
                    total_setmeal[i] += mealQuantityArray[i].getQuantity();
                }
            }
            for (int i = 0; i < 3; i++) {
                if (extraServicePaxArray[i].getQuantity() <= 0) {
                    total_extraservice[i] += 0;
                } else {
                    total_extraservice[i] += extraServicePaxArray[i].getQuantity();
                }
            }
            room_sales += (newBooking.getSingleRoomPrice() + newBooking.getDoubleRoomPrice() + newBooking.getFamilyRoomPrice() + newBooking.getSmokingRoomPrice());
            setmeal_sales += mealOrder.getTotalMealFees();
            extraservice_sales += extraServiceOrder.getTotalExtraServiceFees();
            total_revenue += payment.calculateTotalFees();

        } while (isDo == true);
        
        //Authentication of staff password before viewing sales report
        do {
            System.out.print("Enter Staff Password: ");
            staffps = sc.nextInt();
            if (staffps == 9999) {
                printSalesReport(bookingID, total_customer, total_singleroom, total_doubleroom, total_familysuite, total_smokingroom, total_setmeal, total_extraservice, total_revenue,room_sales,setmeal_sales,extraservice_sales);
            } else {
                System.out.println("Wrong Password.");
            }
        } while (staffps != 9999);
    }
    //Display sales report
    public static void printSalesReport(int bookingID,
            int total_customer,
            int total_singleroom,
            int total_doubleroom,
            int total_familysuite,
            int total_smokingroom,
            int[] total_setmeal,
            int[] total_extraservice,
            double total_revenue,
            double room_sales,
            double setmeal_sales,
            double extraservice_sales) {
        System.out.printf("\n%28s", "Sales Report");
        System.out.println("");
        System.out.printf("%28s", "------------");
        System.out.println("");
        System.out.printf("%-40s %-10d", "No of Booking: ", bookingID);
        System.out.printf("\n%-40s %-10d", "Single Room: " , total_singleroom);
        System.out.printf("\n%-40s %-10d", "Double Room: " , total_doubleroom);
        System.out.printf("\n%-40s %-10d", "Family Suite: ", total_familysuite);
        System.out.printf("\n%-40s %-10d", "Smoking Room: " , total_smokingroom);
        System.out.printf("\n%-40s %-10d", "Total No of Room Booked: " , (total_singleroom + total_doubleroom + total_familysuite + total_smokingroom));
        System.out.printf("\n%-40s RM%.2f", "Room Sales: " ,  room_sales);
        System.out.printf("\n%-40s %-10d", "Seat Meal 1: " , total_setmeal[0]);
        System.out.printf("\n%-40s %-10d", "Seat Meal 2: " , total_setmeal[1]);
        System.out.printf("\n%-40s %-10d", "Seat Meal 3: " , total_setmeal[2]);
        System.out.printf("\n%-40s %-10d", "Seat Meal 4: " , total_setmeal[3]);
        System.out.printf("\n%-40s %-10d", "Total No of Set Meal Sold: " , (total_setmeal[0] + total_setmeal[1] + total_setmeal[2] + total_setmeal[3]));
        System.out.printf("\n%-40s RM%.2f", "Set Meal Sales: " , setmeal_sales);
        System.out.printf("\n%-40s %-10d", "Spa: " , total_extraservice[0]);
        System.out.printf("\n%-40s %-10d", "Massage: " , total_extraservice[1]);
        System.out.printf("\n%-40s %-10d", "Extra Bed: " , total_extraservice[2]);
        System.out.printf("\n%-40s %-10d", "Total No of Extra Services Reserved: " , (total_extraservice[0] + total_extraservice[1] + total_extraservice[2]));
        System.out.printf("\n%-40s RM%.2f", "Extra Services Sales: " , extraservice_sales);
        System.out.printf("\n%-40s RM%.2f", "Total Sales: " , total_revenue);
        System.out.println("");
    }
}

