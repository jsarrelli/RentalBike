package platform;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import factories.RentalTypes;
import rentals.FamilyRental;
import rentals.Promotion;
import rentals.Rental;

public class Menu {
	public Scanner scanner;
	public Platform platform;
	private static Menu instance;

	private Menu() {
		this.scanner = new Scanner(System.in);
		this.platform = Platform.getInstance();
	}

	public static Menu getInstance() {
		if (instance == null) {
			instance = new Menu();
		}
		return instance;
	}

	private void processOption(int option) throws Exception {
		switch (option) {
		case 1:
			createUser();
			break;
		case 2:
			rent();
			break;
		case 3:
			actualChargeMenu();
			break;
		case 4:
			estimateCharge();
			break;
		case 5:
			System.exit(0);
		default:
			break;
		}
	}

	private void estimateCharge() {
		Rental rental = askForRentalId();
		LocalDateTime estimatedDate = askForDate();
		float charge = rental.getEstimatedCharge(estimatedDate);
		System.out.println("Your estimate charge is " + charge);
	}

	private LocalDateTime askForDate() {
		System.out.print("Insert estimated date (YYYY-mm-dd): ");
		String stringDate = scanner.nextLine();
		String[] data = stringDate.split("-");
		LocalDateTime estimatedDate = LocalDateTime.of(Integer.valueOf(data[0]), Integer.valueOf(data[1]),
				Integer.valueOf(data[2]), 12, 00);
		return estimatedDate;
	}

	private void actualChargeMenu() {
		Rental rental = askForRentalId();
		float charge = rental.getActualCharge();
		System.out.println("Your actual charge is " + charge);
	}

	private Rental askForRentalId() {
		System.out.print("Search rental by id: ");
		int id = 0;
		try {
			id = Integer.valueOf(scanner.nextLine());
		} catch (Exception e) {
			askForRentalId();
		}
		Rental rental = platform.getRentals().get(id);
		return rental;
	}

	private void rent() throws Exception {

		Rental rental = askForRental();
		if (rental.getClass().getSimpleName().equals(FamilyRental.class.getSimpleName())) {
			addRentalsToPromotion((FamilyRental) rental);
		}
		platform.getRentals().put(rental.getId(), rental);
		System.out.println("Success! Your rental Id: " + rental.getId());

	}

	private void addRentalsToPromotion(FamilyRental familyRental) throws Exception {

		ArrayList<Rental> associateRentals = new ArrayList<Rental>();
		System.out.println("Load from 3 to 5 rentals.");
		do {

			Rental associateRental = askForRental();
			if (Promotion.class.isAssignableFrom(associateRental.getClass())) {
				System.out.println("Invalid type");
			}else {
				associateRentals.add(associateRental);
			}
			
			System.out.println("Do you wish to continue? yes or no :");
			String input = scanner.nextLine();
			if (input.equalsIgnoreCase("no")) {
				break;
			}

		} while (familyRental.getRentals().size() <= 5);
		familyRental.addRentals(associateRentals);

	}

	private Rental askForRental() throws Exception {
		RentalTypes rentType = askForRentalType();
		Client client = askForClientName();
		return platform.newRent(client, rentType);
	}

	private RentalTypes askForRentalType() {
		RentalTypes rentType;
		ArrayList<RentalTypes> rentTypes = new ArrayList<RentalTypes>(Arrays.asList(RentalTypes.values()));
		System.out.println("Select which rental type you prefer");
		int index = 0;
		for (RentalTypes rentalType : rentTypes) {
			System.out.println(index + 1 + "." + rentalType.getValue());
			index++;
		}
		Integer rentTypeIndex = Integer.parseInt(scanner.nextLine()) - 1;
		rentType = rentTypes.get(rentTypeIndex);
		if (rentType == null) {
			System.out.println("Wrong type");
			askForRentalType();
		}
		return rentType;
	}

	private Client askForClientName() throws Exception {
		Platform plataform = Platform.getInstance();
		Client client;

		System.out.print("Please insert your name:");
		String name = scanner.nextLine();
		client = plataform.getClientByName(name);
		if (client == null) {
			System.out.println("Client does not exist\n");
			optionsMenu();
		}

		return client;
	}

	private void createUser() {
		System.out.print("Insert your name: ");
		String name = scanner.nextLine();
		platform.addClient(name);
	}

	public void optionsMenu() throws Exception {
		int option = 5;
		System.out.println("\nWelcome to our Rental System \n" + "Please select an option:\n" + "1.Create User\n"
				+ "2.Rent a bike\n" + "3.Calculate actual charge\n" + "4.Estimate charges \n" + "5.Exit\n");

		try {
			option = Integer.parseInt(scanner.nextLine());

		} catch (Exception e) {
			System.out.println("Please select one option\n");
			optionsMenu();
		}
		processOption(option);
	}
}
