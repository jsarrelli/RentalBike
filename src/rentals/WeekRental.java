package rentals;

import java.time.Duration;
import java.time.LocalDateTime;

import platform.Bike;
import platform.Client;

public class WeekRental extends SingleRental{

	public WeekRental(Client client, Bike bike) {
		super(60, client, bike);
	}

	@Override
	public int getPeriod(LocalDateTime finishDate) {
		return (int) Math.ceil(Duration.between(startDate, finishDate).toDays()/7);

	}

	
	
}
