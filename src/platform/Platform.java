package platform;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import factories.RentalFactory;
import factories.RentalTypes;
import rentals.DayRental;
import rentals.HourRental;
import rentals.Rental;
import rentals.WeekRental;;

public class Platform {
	private static final Logger logger = Logger.getLogger(Platform.class);

	private static Platform instance;
	private ArrayList<Bike> bikes;
	private ArrayList<Client> clients;
	private HashMap<Integer, Rental> rentals;
	private RentalFactory factory;

	private Platform() {
		this.clients = new ArrayList<Client>();
		this.bikes = new ArrayList<Bike>();
		this.rentals = new HashMap<Integer, Rental>();
		this.factory = new RentalFactory();
	}

	public static Platform getInstance() {
		if (instance == null) {
			instance = new Platform();
		}
		return instance;
	}

	public Rental newRent(Client client, RentalTypes rentType) throws Exception {
		Bike availableBike = getAvailableBike();
		if (availableBike == null) {
			logger.debug("No available bike");
			throw new Exception("There is no available bike");

		}
		Rental rent = factory.newRent(rentals.size(), rentType, client, availableBike);
		return rent;

	}

	public HourRental newHourRental(Client client) throws Exception {
		return (HourRental) newRent(client, RentalTypes.HOURLY);
	}

	public WeekRental newWeekRental(Client client) throws Exception {
		return (WeekRental) newRent(client, RentalTypes.WEEKLY);
	}

	public DayRental newDayRental(Client client) throws Exception {
		return (DayRental) newRent(client, RentalTypes.DAILY);
	}

	private Bike getAvailableBike() {
		return bikes.parallelStream().filter(bike -> !bike.isRented()).findAny().orElse(null);
	}

	public Client getClientByName(String name) {
		return clients.parallelStream().filter(client -> client.getName().equalsIgnoreCase(name)).findAny()
				.orElse(null);
	}

	public List<RentalTypes> getRentalTypes() {

		return Arrays.asList(RentalTypes.values());
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

	public HashMap<Integer, Rental> getRentals() {
		return rentals;
	}

	public void setRentals(HashMap<Integer, Rental> currentRentals) {
		this.rentals = currentRentals;
	}

	public void newBike() {
		bikes.add(new Bike(bikes.size()));
		logger.debug("New bike in system");
	}
}
