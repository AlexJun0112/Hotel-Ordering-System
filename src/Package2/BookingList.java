package Package2;

public class BookingList {
    private int noOfRoom;
    private Room room[] = new Room[40];
    
    public BookingList(){
        
    }
    
    public BookingList(int noOfRoom,Room [] room) {
        this.noOfRoom = noOfRoom;
        for (int i=0;i<noOfRoom;i++){ 
          this.room[i] = room[i];      
        }
    }
    
    public void printBookingListDetails(){
        
        for(int i=0;i<noOfRoom;i++){
            room[i].printRoomDetails();
        }
    }
    
    public double getBookingListPrice(){
        return this.room[0].getRoomPrice() * noOfRoom;
    }
}
    
    

