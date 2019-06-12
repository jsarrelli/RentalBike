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
		log.info("Period from "+formatDate(startDate)+"to "+ this.formatDate(finishDate) +"at 12:00 is: " + period+" hours");
		return period;

	}

}
