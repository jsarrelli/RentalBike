package rentals;

import java.time.Duration;
import java.time.LocalDateTime;

import platform.Bike;
import platform.Client;

public class HourRental extends SingleRental {

	public HourRental(int id, Client client, Bike bike) {
		super(id, 5, client, bike);
	}

	@Override
	public int getPeriod(LocalDateTime finishDate) {
		int period =(int) Duration.between(startDate, finishDate).toHours();
		log.debug("Period from "+formatDate(startDate)+"to "+ this.formatDate(finishDate)+" is: " + period+" hours");
		return period;

	}

}
