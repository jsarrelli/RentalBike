package rentals;

import java.time.Duration;
import java.time.LocalDateTime;

import platform.Bike;
import platform.Client;

public class DayRental extends SingleRental {

	public DayRental(int id, Client client, Bike bike) {
		super(id, 20, client, bike);
	}

	@Override
	public int getPeriod(LocalDateTime finishDate) {
		int period = (int) Duration.between(startDate, finishDate).toDays();
		log.debug("Period from " + formatDate(startDate) + "to " + this.formatDate(finishDate) + " is: " + period
				+ " weeks");
		return period;
	}

}
