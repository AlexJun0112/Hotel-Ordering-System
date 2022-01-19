package Package2;


public class SingleRoom extends Room{
    
    private Room room;
    private int quantity;
    
    SingleRoom(int roomNo,String status,String roomType,String bedType,double price){
        super(roomNo,status,roomType,bedType,price);
    }  
    @Override
    public void printRoomDetails(){
        super.printRoomDetails();
    }
    
    @Override
    public double getRoomPrice(){
        return super.getRoomPrice();
    }
 
  
}
