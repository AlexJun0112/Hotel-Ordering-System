package Package2;

public class MealOrder {

    private MealQuantity[] items;
    private int totalItem;
    private double totalMealFees;

    public MealOrder() {
    }

    public MealOrder(MealQuantity[] items, int totalItem) {
        this.items = items;
        this.totalItem = totalItem;
    }

    public void getItemDetails(){
        for(MealQuantity x:items){
            x.printMenuDetails();
            System.out.println("");
        }
    }
    
    public int getTotalItem() {
        return totalItem;
    }

    public void calculateGrandTotal() {
        double total = 0.0;
        for (int i = 0; i < items.length; i++) {
            total += items[i].getSubTotalPrice();
        }
        totalMealFees = total;
    }

    public double getTotalMealFees() {
        return totalMealFees;
    }
}
