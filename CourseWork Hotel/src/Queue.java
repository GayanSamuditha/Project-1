
public class Queue {
	
	private Customer[] customerArray;
	private int oldestEntryPosition;
	
	
	public Queue(){
		this.customerArray = new Customer[10];
		oldestEntryPosition = 0;
	}
	
	public void addCustomerToQueue(Customer customer){
		int positionInQueue = findCustomerPositionInQueue();
		if(positionInQueue >=0){
			customerArray[positionInQueue] = customer;
		}else{
			System.out.println("Error : Customer Queue is full now !");
			System.out.println("Oldest Entry : "+ customerArray[oldestEntryPosition]);
			
			customerArray[oldestEntryPosition] = customer;
			updateOlderEntryPosition();
		}
	}

	public Customer takeCustomerFromQueue(){
		Customer customer = customerArray[oldestEntryPosition];
		customerArray[oldestEntryPosition] = null;
		adjustQueuePosition();
		return customer;
	}
	
	public int getCustomerInQueue(){
		int count = 0;
			for(int i=0;i<customerArray.length;i++){
				if(customerArray[i] == null){
					break;
				}
				count ++;
			}
				return count;
	}
	
	private void adjustQueuePosition() {
		int currentPosition = 0;
		int nextOldestPosition = oldestEntryPosition + 1;
		Customer[] temporaryArray = new Customer [customerArray.length];
		
			for(int i=0; i <customerArray.length;i++){
				if (nextOldestPosition >= customerArray.length){
						nextOldestPosition = 0;
				}
				
				if(customerArray[nextOldestPosition]==null){
					break;
				}
				
			temporaryArray[currentPosition] = customerArray[nextOldestPosition];
				currentPosition++;
				nextOldestPosition++;
			}
			
			customerArray = temporaryArray;
			oldestEntryPosition = 0;	
			}
		
		
		
	

	private void updateOlderEntryPosition() {
		oldestEntryPosition = oldestEntryPosition +1;
			if(oldestEntryPosition >= customerArray.length){
				oldestEntryPosition=0;
			}
		}

	private int findCustomerPositionInQueue() {
		int position = -1;
			for(int i=0;i<customerArray.length;i++){
				if(customerArray[i] == null){
					position =i;
					break;
				}
			}
		return position;
	}
	
	
	public Customer[] getCustomerArray(){
		return customerArray;
	}
	
	public void setCustomerArray(Customer[] customerArray){
		this.customerArray = customerArray;
	}
	
	public int getOldestEntryPosition(){
		return oldestEntryPosition;
	}
	
	public void setOldestEntryPosition(int oldestEntryPosition){
		this.oldestEntryPosition = oldestEntryPosition;
	}
	
	
	
	
	
}
