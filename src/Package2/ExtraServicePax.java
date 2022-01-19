package Package2;

public class ExtraServicePax {

    private int num;
    private static int lineNo = 1;
    private ExtraService extraservice;
    private int quantity;


    public ExtraServicePax(ExtraService extraservice, int quantity) {
        this.extraservice = extraservice;
        this.quantity = quantity;
        num = lineNo;
        lineNo++;
    }

    public int getQuantity() {
        return quantity;
    }

    public static int getLineNo() {
        return lineNo;
    }

    public double getSubTotalPrice() {
        return extraservice.getPrice() * quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void printServiceDetails() {
        System.out.printf("%-10d %-40s RM%-20.2f %-20d RM%-18.2f", num, extraservice.getService(), extraservice.getPrice(), quantity, getSubTotalPrice());
    }
}
