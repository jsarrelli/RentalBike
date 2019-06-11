package factories;

import platform.Bike;
import platform.Client;
import rentals.Rental;

public interface AbstractFactory{
	 public Rental newRent(RentalTypes rentalType,Client client, Bike bikes);
}
