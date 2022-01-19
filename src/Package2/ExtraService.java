package Package2;

public class ExtraService {

    private final String service;
    private final double price;
    private int num = 0;
    private static int lineNo = 1;

    public ExtraService(String service, double price) {
        this.service = service;
        this.price = price;
        num = lineNo;
        lineNo++;
    }

    public String getService() {
        return service;
    }

    public double getPrice() {
        return price;
    }

    public String printServiceDetails() {
        return String.format("%-4d %-40s RM%6.2f",num, service, price);
    }
}