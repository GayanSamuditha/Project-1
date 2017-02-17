public class Customer{
	private String name;
	private int roomNumber;
		public void setName(String name){
			this.name = name;
		}
		
		public String getName(){
			return this.name;
		}
		
		public int getRoomNumber() {
			return roomNumber;
		}
		
		public void setRoomNumber(int roomNumber) {
			this.roomNumber = roomNumber;
		}
	
		@Override public String toString() {
			return name;
		}
	}


