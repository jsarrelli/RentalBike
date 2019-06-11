package rentals;

import java.time.Duration;
import java.time.LocalDateTime;

import platform.Bike;
import platform.Client;

public class HourRental extends SingleRental {

	public HourRental( Client client, Bike bike) {
		super(5, client, bike);
	}

	@Override
	public int getPeriod(LocalDateTime finishDate) {
		return (int) Duration.between(startDate, finishDate).toHours();
		
	}

}