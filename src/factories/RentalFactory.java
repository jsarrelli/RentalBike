package factories;

import platform.Bike;
import platform.Client;
import rentals.DayRental;
import rentals.Rental;
import rentals.WeekRental;

public class RentalFactory implements AbstractFactory {

	@Override
	public Rental newRent(RentalTypes rentalType,Client client, Bike bike) {
		switch (rentalType) {
		case WEEKLY:
			return new WeekRental(client, bike);
		case DAILY:
			return new DayRental(client, bike);
		case HOURLY:
			return new WeekRental(client,bike);
		default:
			break;
		}
		return null;
	}

	
	

}
