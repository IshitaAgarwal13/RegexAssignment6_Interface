package java_InterfaceDemo;
import java.util.Scanner;

interface RoomBillComponent{
	double TAX=12;
	double EXTRA_PERSON_CHARGE=500.00;
	double FOOD_CHARGE=800.00;
	
	float calculateBill();
}

class RoomDetails implements RoomBillComponent{
	int billId;
	String customerName;
	String typeOfRoom;
	int noOfExtraPersons;
	int noOfDaysOfStay;
	static int counter=101;
	public RoomDetails(String customerName, String typeOfRoom, int noOfExtraPersons, int noOfDaysOfStay) {
		super();
		this.customerName = customerName;
		this.typeOfRoom = typeOfRoom;
		this.noOfExtraPersons = noOfExtraPersons;
		this.noOfDaysOfStay = noOfDaysOfStay;
	}
	public int getBillId() {
		return billId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public String getTypeOfRoom() {
		return typeOfRoom;
	}
	public int getNoOfExtraPersons() {
		return noOfExtraPersons;
	}
	public int getNoOfDaysOfStay() {
		return noOfDaysOfStay;
	}
	boolean validateNoOfDaysOfStay() {
		if(noOfDaysOfStay>=1 && noOfDaysOfStay<=15)
			return true;
		System.out.println("Invalid no. of days of stay it should be between 1-15.");
		return false;
	}
	boolean validateNoOfExtraPerson() {
		if(noOfExtraPersons>=0 && noOfExtraPersons<=2)
			return true;
		System.out.println("Invalid no. of extra persons it should be between 0-2.");
		return false;
	}
	boolean validateTypeOfRoom() {
		if(typeOfRoom.equals("Standard") ||typeOfRoom.equals("Deluxe")||typeOfRoom.equals("Cottage") ) {
			return true;
		}
		System.out.println("Invalid type of room it should be either Standard, Deluxe or Cottage.");
		return false;
	}
	
	@Override
	public float calculateBill() {
		if(validateNoOfDaysOfStay() &&validateNoOfExtraPerson() &&  validateTypeOfRoom()) {
			billId=counter++;
			double totalBill=0.0;
			int baseRoomFare=0;
			if(getTypeOfRoom().equals("Standard"))
				baseRoomFare=2500;
			else if(getTypeOfRoom().equals("Deluxe"))
				baseRoomFare=3500;
			else if(getTypeOfRoom().equals("Cottage"))
				baseRoomFare=5500;
			
			totalBill = (noOfDaysOfStay*baseRoomFare) +noOfDaysOfStay *( FOOD_CHARGE) +
					(EXTRA_PERSON_CHARGE* noOfExtraPersons);
			totalBill = totalBill + TAX*totalBill;
			return (float)totalBill;
		}
		
		return 0.0f;
		
	}
	
}

public class Tester {

	public static void main(String[] args) {
		RoomDetails room1=new RoomDetails("Ishita","Deluxe",2,5);
        Scanner sc=new Scanner(System.in);
		System.out.print("Enter Customer name: ");
        room1.customerName=sc.nextLine();
		System.out.print("Enter Type of Room: ");
        room1.typeOfRoom=sc.nextLine();
		System.out.print("Enter number of extra persons: ");
        room1.noOfExtraPersons=sc.nextInt();
		System.out.print("Enter number of days of stay: ");
        room1.noOfDaysOfStay=sc.nextInt();
        
        if(room1.calculateBill()==0.0f)
        	return;
        System.out.println();
        //output
        System.out.println("BillId: "+room1.getBillId());
        System.out.println("Customer name: "+room1.getCustomerName());
        System.out.println("No. of days of stay: "+room1.getNoOfDaysOfStay());
        System.out.println("Total Bill: "+room1.calculateBill());
	}

}
