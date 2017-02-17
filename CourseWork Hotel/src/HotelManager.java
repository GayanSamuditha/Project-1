import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class HotelManager{

		private Queue customerQueue;
		private int roomNumber;
			Room[] roomArray;
			Customer[] cusArray;
		public HotelManager() {
			roomArray = new Room[10];
				for (int i = 0; i < roomArray.length; i++) {
						roomArray[i] = new Room();
							roomArray[i].setRoomNumber(i + 1);
								}
							}
		
		
		public void addCustomerToRoom(int roomNumber, String customerName) {
			try{
				if (IsValidRoomNumber(roomNumber)) {
						Customer customer = new Customer();
						customer.setName(customerName);
							roomArray[roomNumber - 1].AddCustomerToRoom(customer);
								System.out.println("customer " + customerName + " added to room");
				}
			}catch(InputMismatchException e ){
								System.out.println("Error: Room number is not valid.");
								System.out.println("Valid room numbers are from 1 to " + roomArray.length);
							}
						}
		
		public void viewAllRooms() {
			for (Room room : roomArray) {
				if (IsValidRoomNumber(room.getRoomNumber())) {
					System.out.println("Room number : " + room.getRoomNumber());
						roomArray[room.getRoomNumber() - 1].DisplayFirstThreeCustomers();
							}
						}
					}
		
		
		public void deleteCustomerFromRoom(int roomNumber) {
			if (IsValidRoomNumber(roomNumber)) {
				roomArray[roomNumber - 1].DisplayCustomer();
					System.out.println("customer deleted from room");
				} else {
					System.out.println("Error: Room number is not valid.");
					System.out.println("Valid room numbers are from 1 to " + roomArray.length);
				}
		}
		
		
		public void displayThreeCustomersAllocatedToRoom(int roomNumber) {
			if (IsValidRoomNumber(roomNumber)) {
				roomArray[roomNumber - 1].DisplayFirstThreeCustomers();
				} else {
					System.out.println("Error: Room number is not valid.");
					System.out.println("Valid room numbers are from 1 to " + roomArray.length);
				}
			}
		
		
		public void StoreArrayDataInTextFile() throws Exception {
			// print array to the text file
			PrintWriter pw = new PrintWriter("Bookings.txt");
				for (Room room : roomArray) {
					int roomNumber = room.getRoomNumber();
						List<Customer> customers = Arrays.asList(room.getCustomerQueue().getCustomerArray());
							pw.println(roomNumber + ":" + customers.toString());
						}
							System.out.println("File write succsessful");
								pw.flush();
								pw.close();
							}
		
		
		public void LoadDataBackFromTheFile() {
			BufferedReader br = null;
				try {
					String sCurrentLine;
					br = new BufferedReader(new FileReader("Bookings.txt"));
						while ((sCurrentLine = br.readLine()) != null) { 
							String roomNumber=sCurrentLine.split(":")[0];
							String customersLine=sCurrentLine.split(":")[1];
							customersLine=customersLine.substring(1, customersLine.length()-1);
							String[] customers=customersLine.split(", ");
								for(String customer:customers){
									if(!"null".equals(customer)){
										System.out.println("Load data back from file to the array successfully ! ");
									}
								}
						}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (br != null)
							br.close();

					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
		}
		
		
		public static void main(String[] args) throws Exception {
			System.out.println("               ************************* WELCOME *************************" );
			System.out.println("\n");
			System.out.println("          ^^^^^^^^^^^^^^^^^^^^^^^^^# Hotel-Fortress #^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			System.out.println("\n");
			System.out.println("               <<<<<<<<<<<<<<<< Please Login to the System >>>>>>>>>>>>>>>");
			System.out.println("\n");
			// Display Current date and time
			String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm").format(Calendar.getInstance().getTime());
			System.out.println("\nCurrent Time: " + timeStamp);
			
			System.out.println("               ######################### $$$$$$$ #########################");
			
			System.out.println("\n");
			Scanner input=new Scanner(System.in);
			System.out.println("Enter Username: ");
			String userName = input.nextLine();
			
			System.out.println("Enter Password : ");
			String password = input.nextLine();
			
			if ("123".equalsIgnoreCase(userName) && "123".equals(password)) {
				System.out.println("Login Successful!");
				System.out.println("Loading...");
			
			HotelManager hotelManager = new HotelManager();
				int value = 0;
				// set all rooms as empty
					while (value < 100) {
						System.out.println("\n");
						System.out.println("..................Menu..................");
						System.out.println("\n");
						System.out.println("A. Add a customer to room");
						System.out.println("V. View all rooms");
						System.out.println("D. Delete customer from room");
						System.out.println("S. Store program array data into a plain text file");
						System.out.println("L. Load program data back from the file into the array");
						System.out.println("3. Display the names of the first 3 customers who have been allocated to a room");
						System.out.println("C. Exit");
					
					Scanner input1 = new Scanner(System.in);
						String option = input1.next().toUpperCase();
							switch (option) {
								case "A":
									System.out.println("Enter room Number :");
										int roomNumber = input1.nextInt();
											System.out.println("Enter the Customer name : ");
												String customerName = input1.next();
												hotelManager.addCustomerToRoom(roomNumber, customerName);
												break;
								
								case "V":
									hotelManager.viewAllRooms();
												break;
								
								case "D":
									System.out.println("Enter room Number to delete a customer from room :");
										int delroomNumber = input1.nextInt();
											hotelManager.deleteCustomerFromRoom(delroomNumber);
												break;

								case "S":
									hotelManager.StoreArrayDataInTextFile();
												break;

								case "L":
									hotelManager.LoadDataBackFromTheFile();
												break;
												
												
								case "3":
									System.out.println("Enter room Number to Display the names of the first 3 customers:");
										int displayroomNumber = input1.nextInt();
											hotelManager.displayThreeCustomersAllocatedToRoom(displayroomNumber);
												break;

								case "C":
									hotelManager.Close();
												break;
									
								case "H":
									hotelManager.helpDesk();
							}
					}
			
			
			} else {
				System.err.println("The username and password is incorrect. System Exit.");
				// Exit the system
				System.exit(0);
				}
			}				
			



			private void helpDesk() {
				System.out.println("<<<<<<<<< - HELP - >>>>>>>>> ");
				System.out.println("");
				System.out.println("Please Read this instruction CAREFULLY !!!");
				System.out.println("");

				System.out.println("A. Add a customer to room");
				System.out.println("Add Customer name and room number");
				System.out.println("");

				System.out.println("V. View all rooms");
				System.out.println("You can see all rooms details");
				System.out.println("");

				System.out.println("D. Delete customer from room");
				System.out.println("Delete customer by entering room number");
				System.out.println("");

				System.out.println("S. Store program array data into a plain text file");
				System.out.println("if u added all customers , then please save that data to the file !!!");
				System.out.println("");

				System.out.println("L. Load program data back from the file into the array");
				System.out.println("Loading data back from the file");
				System.out.println("");
				System.out.println("H. Help Book");
				System.out.println("Getting instructions from here !!!!!!!");
				System.out.println("");

				System.out.println("X. EXIT");
				System.out.println("You can exit the programme in here !!!!!");
				System.out.println("");

				System.out.println("\nThe above KeyWords are not Case-sensitive.");

		}


			public void Close() throws Exception {
				Object exit;
				Scanner input=new Scanner(System.in);
				do {
					
					System.out.println("Are you sure? (Y/N)");
					exit = input.next();
					if ("y".equalsIgnoreCase((String) exit)) {
						System.out.println("************ < Thank You. > ***********");
						System.out.println("  Developed by M.M.A.Gayan Samuditha");
						System.out.println("            Have a nice day !!!"      );
						System.exit(0);
					} else if ("n".equalsIgnoreCase((String) exit)) {
						main(null);
					} else {
						System.out.println("Enter a valid command.");
					}
				} while (!"n".equalsIgnoreCase((String) exit) && !"y".equalsIgnoreCase((String) exit));
				}
			
			private boolean IsValidRoomNumber(int roomNumber) {
				boolean isValid = false;
					for (Room room : roomArray) {
						if (room.getRoomNumber() == roomNumber) {
							isValid = true;
							break;
						}
					}
					return isValid;
				}
		}
