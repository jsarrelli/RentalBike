package rentals;
import java.time.Duration;
import java.time.LocalDateTime;

import platform.Bike;
import platform.Client;

public class DayRental extends SingleRental {

	public DayRental(Client client, Bike bike) {
		super(20, client, bike);
	}

	@Override
	public int getPeriod(LocalDateTime finishDate) {
		return (int) Duration.between(startDate, finishDate).toDays();
	}


}
