package platform;

import java.util.ArrayList;
import java.util.Arrays;

import factories.RentalTypes;

public class Main {
	

	public static void main(String[] args) throws Exception {
		while (true) {
			int option = optionsMenu();
			if (option == 4) {
				System.exit(0);
			}
			processOption(option);
		}

	}

	private static void processOption(int option) throws Exception {
		switch (option) {
		case 1:
			createUser();
			break;
		case 2:
			rent();
		default:
			break;
		}
	}

	private static void rent() throws Exception {
		
		Platform plataform = Platform.getInstance();
		Client client=askForClientName();
		RentalTypes rentType=askForRentalType();
		plataform.rentABike(client, rentType);

	}

	private static RentalTypes askForRentalType() {
		RentalTypes rentType;
		ArrayList<RentalTypes> rentTypes = new ArrayList<RentalTypes>(Arrays.asList(RentalTypes.values()));
		System.out.println("Select which rental type you prefer" );
		int index = 0;
		for (RentalTypes rentalType : rentTypes) {
			System.out.println(index+1+"."+rentalType.getValue()+"/n");
		}
		Integer rentTypeIndex = new Integer(System.console().readLine())-1;
		rentType=rentTypes.get(rentTypeIndex);
		if(rentType==null) {
			System.out.println("Wrong type");
			askForRentalType();
		}
		return rentType;
	}

	private static Client askForClientName() {
		Platform plataform = Platform.getInstance();
		Client client;
		
			System.out.println("Please insert your name" );
			String name = System.console().readLine();
			client = plataform.getClientByName(name);
			if(client==null) {
				System.out.println("Client does not exist");
				askForClientName();
			}
		
		return client;
	}

	private static void createUser() {
		System.out.println("Insert your name");
		String name= System.console().readLine();
		Platform.getInstance().addClient(name);
	}

	private static int optionsMenu() {
		int option = 4;
		System.out.println("Welcome to our Rental System /n" + "Please select an option:/n" + "1.Create User/n"
				+ "2.Rent a bike/n" + "3.Calculate charge/n" + "4.Exit/n");
		try {
			option = new Integer(System.console().readLine());

		} catch (Exception e) {
			System.out.println("Please select one option/n");
			optionsMenu();
		}
		return option;
	}

}
