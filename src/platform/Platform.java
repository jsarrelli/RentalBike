package platform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import factories.RentalFactory;
import factories.RentalTypes;
import rentals.DayRental;
import rentals.HourRental;
import rentals.Rental;
import rentals.WeekRental;;

public class Platform {
	private static Platform instance;
	private ArrayList<Bike> bikes;
	private ArrayList<Client> clients;
	private ArrayList<Rental> currentRentals;
	private RentalFactory factory;

	private Platform() {
		Platform.instance = new Platform();
		this.factory = new RentalFactory();
	}

	public static Platform getInstance() {
		if (instance == null) {
			return new Platform();
		}
		return instance;
	}

	public Rental rentABike(Client client, RentalTypes rentType) throws Exception {
		Bike availableBike = getAvailableBike();
		if (availableBike == null) {
			throw new Exception("There is no available bike");
		}
		return factory.newRent(rentType, client, availableBike);

	}

	public HourRental newHourRental(Client client) throws Exception {
		return (HourRental) rentABike(client, RentalTypes.HOURLY);
	}

	public WeekRental newWeekRental(Client client) throws Exception {
		return (WeekRental) rentABike(client, RentalTypes.WEEKLY);
	}

	public DayRental newDayRental(Client client) throws Exception {
		return (DayRental) rentABike(client, RentalTypes.DAILY);
	}

	private Bike getAvailableBike() {
		return bikes.parallelStream().filter(bike -> !bike.isRented()).findAny().orElse(null);
	}

	public Client getClientByName(String name) {
		return clients.parallelStream().filter(client -> client.getName().equalsIgnoreCase(name)).findAny()
				.orElse(null);
	}
	
	public List<RentalTypes> getRentalTypes(){
	
		return  Arrays.asList(RentalTypes.values());
	}

	public void addClient(String name) {
		clients.add(new Client(name));
	}

	public ArrayList<Bike> getBikes() {
		return bikes;
	}

	public void setBikes(ArrayList<Bike> bikes) {
		this.bikes = bikes;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	public ArrayList<Rental> getCurrentRentals() {
		return currentRentals;
	}

	public void setCurrentRentals(ArrayList<Rental> currentRentals) {
		this.currentRentals = currentRentals;
	}

}
