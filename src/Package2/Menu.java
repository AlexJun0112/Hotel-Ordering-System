package Package2;

public class Menu {

    private String meal = "";
    private double price = 0.0;
    private int num = 0;
    private static int lineNo = 1;

    public Menu() {
    }
    
    public Menu(String meal, double price) {
        this.meal = meal;
        this.price = price;
        num = lineNo;
        lineNo++;
    }

    public String getMeal() {
        return meal;
    }

    public double getPrice() {
        return price;
    }

    public static void setLineNo(int lineNo) {
        Menu.lineNo = lineNo;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String printMenuDetails() {
        return String.format("%-4d %-40s RM%6.2f",num, meal, price); 
    }

}
