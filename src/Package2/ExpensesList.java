package Package2;

public class ExpensesList {

    private ExtraServiceOrder extraServiceOrder;
    private MealOrder mealOrder;
    private double totalExpenses;

    public ExpensesList() {
    }

    public ExpensesList(ExtraServiceOrder e, MealOrder m) {
        extraServiceOrder = e;
        mealOrder = m;

    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public void calculateExpensesList() {
        totalExpenses = extraServiceOrder.getTotalExtraServiceFees() + mealOrder.getTotalMealFees();
    }

    public void printExpensesListDetails() {
        System.out.printf("%-10s %-40s %-18s %-24s %-18s\n", "NO", "SET MEAL", "UNIT PRICE", "QUANTITY", "SUBTOTAL");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        mealOrder.getItemDetails();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-40s %-18s %-24s %-18s\n", "NO", "EXTRA SERVICE", "UNIT PRICE", "QUANTITY", "TOTAL PRICE");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        extraServiceOrder.getItemDetails();
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");

    }
}
