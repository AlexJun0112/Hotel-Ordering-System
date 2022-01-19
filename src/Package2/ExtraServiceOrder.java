package Package2;

public class ExtraServiceOrder {

    private ExtraServicePax[] pax;
    private int totalItem;
    private double totalExtraServiceFees;

    public ExtraServiceOrder() {
    }

    public ExtraServiceOrder(ExtraServicePax[] pax, int totalItem) {
        this.pax = pax;
        this.totalItem = totalItem;
    }

    public void getItemDetails() {
        for (ExtraServicePax y : pax) {
            y.printServiceDetails();
            System.out.println("");
        }
    }

    public int getTotalItem() {
        return totalItem;
    }

    public void calculateGrandTotal() {
        double total = 0.0;
        for (int i = 0; i < pax.length; i++) {
            total += pax[i].getSubTotalPrice();
        }
        totalExtraServiceFees = total;
    }

    public double getTotalExtraServiceFees() {
        return totalExtraServiceFees;
    }

}
