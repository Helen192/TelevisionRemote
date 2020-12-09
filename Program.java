package baitap_04;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		CTivi cTivi;
		int choose;
		Scanner scan = new Scanner(System.in);
		
		// choose a method to install Tivi's channels at the first time
		System.out.println("---------- Choose a method to install Tivi's channels ----------");
		System.out.println("1. As default");
		System.out.println("2. Setting channels");
		System.out.println("Choose: ");
		choose = Integer.parseInt(scan.nextLine());
		if(choose == 1) {
			cTivi = new CTivi();    // initialize object cTivi as default constructor
		}else {
			System.out.println("Number of channels you want to install: ");
			int n = Integer.parseInt(scan.nextLine());
			// create a list of channels 
			String[] channel = new String[n];
			for(int i=0; i<n; i++) {
				System.out.println("Adding channel "+ (i+1) +": ");
				channel[i] = scan.nextLine();
			}
			cTivi = new CTivi(channel);    // initialize object cTivi after having a list of channels
		}
		
		// cac che do tren dieu khien tivi 
		do {
			showMenu();
			choose = Integer.parseInt(scan.nextLine());
			
			switch (choose) {
			case 1:
				cTivi.Switch();
				break;
			case 2:
				System.out.println("Switch to channel: ");
				String setChannel = scan.nextLine();
				cTivi.Switch(setChannel);
				break;
			case 3:
				cTivi.On();
				break;
			case 4:
				cTivi.Off();
				break;
			case 5:
				cTivi.nextChannel();
				break;
			case 6:
				cTivi.previousChannel();
				break;
			case 7:
				cTivi.show();
				break;
			case 8:
				System.out.println("--------------GOODBYE ---------------");
				break;
			default:
				System.err.println("Wrong input!");
				break;
			}
			
		} while (choose!=8);
		
		
		
	}
	
	static void showMenu() {
		System.out.println("====================== MENU ==================");
		System.out.println("1. Switch the status(on/off)");
		System.out.println("2. Switch the status with channel (when tivi is on)");
		System.out.println("3. Turn On tivi");
		System.out.println("4. Turn Off tivi");
		System.out.println("5. Move to the next channel");
		System.out.println("6. Move back to the previous channel");
		System.out.println("7. Show the status of tivi");
		System.out.println("8. Exit");
		System.out.print("Choose: ");
	}

}
