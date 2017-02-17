public class Room{
	private Queue customerQueue;
	private int roomNumber;

	
	public Room(){
		customerQueue = new Queue();
	}
	
	
	public void setRoomNumber(int roomNumber){
		this.roomNumber = roomNumber;
	}
	
	public int getRoomNumber(){
		return roomNumber;
	}
	
	
	public void AddCustomerToRoom(Customer customer){
		customerQueue.addCustomerToQueue(customer);
	}
	
	public void DisplayCustomer(){
		Customer customer = customerQueue.takeCustomerFromQueue();
			if(customer != null){
				System.out.println("Customer Name : " + customer.getName());
			}
			else{
				System.out.println("No more customers in this room. ");
			}
		}
	
	
	public void DisplayFirstThreeCustomers(){
			int i = 3;
				while(i > 0){
					DisplayCustomer();
					i--;
				}
			}
	
	public Queue getCustomerQueue() {
			return customerQueue;
		}
	
	public void setCustomerQueue(Queue customerQueue) {
		this.customerQueue = customerQueue;
	}
	
	}