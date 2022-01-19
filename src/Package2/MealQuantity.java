package Package2;

public class MealQuantity {

    private int num;
    private static int lineNo = 1;
    private Menu menu;
    private int quantity;

    public MealQuantity() {
    }

    public MealQuantity(Menu menu, int quantity) {
        this.menu = menu;
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

    public static void setLineNo(int lineNo) {
        MealQuantity.lineNo = lineNo;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getSubTotalPrice() {
        return menu.getPrice() * quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void printMenuDetails() {
        System.out.printf("%-10d %-40s RM%-20.2f %-20d RM%-18.2f", num, menu.getMeal(), menu.getPrice(), quantity, getSubTotalPrice());
    }
}
