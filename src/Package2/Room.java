package Package2;

public abstract class Room {

    private int roomNo;
    private String status;
    private String roomType;
    private String bedType;
    private double price;

    public Room() {

    }

    public Room(int roomNo, String status, String roomType, String bedType, double price) {
        this.roomNo = roomNo;
        this.status = status;
        this.roomType = roomType;
        this.bedType = bedType;
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void printRoomDetails() {
        System.out.printf("\n%-15d %-30s %-20s RM%3.2f %9s", roomNo, roomType, bedType, price, "");
    }

    public double getRoomPrice() {
        return price;
    }

}
