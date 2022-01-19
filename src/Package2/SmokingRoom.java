package Package2;

 public class SmokingRoom extends Room{
    private String additions;
        
    SmokingRoom(int roomNo,String status,String roomType,String bedType,double price,String additions){
        super(roomNo,status,roomType,bedType,price);
        this.additions = additions;
    }  
        
    @Override
    public void printRoomDetails(){
        super.printRoomDetails();
        System.out.printf("              " + additions );
    }
    
    @Override
    public double getRoomPrice(){
        return super.getRoomPrice();
    }
 

}
