package factories;

import platform.Bike;
import platform.Client;
import rentals.DayRental;
import rentals.FamilyRental;
import rentals.HourRental;
import rentals.Rental;
import rentals.WeekRental;

public class RentalFactory implements AbstractFactory {

	@Override
	public Rental newRent(int id, RentalTypes rentalType,Client client, Bike bike) {
		switch (rentalType) {
		case WEEKLY:
			return new WeekRental(id,client, bike);
		case DAILY:
			return new DayRental(id,client, bike);
		case HOURLY:
			return new HourRental(id,client,bike);
		case FAMILY:
			return new FamilyRental(id);
		default:
			break;
		}
		return null;
	}

	
	

}
