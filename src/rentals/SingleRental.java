package rentals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;

import platform.Bike;
import platform.Client;

public abstract class SingleRental implements Rental {
	protected Logger log;
	protected int rate;
	protected LocalDateTime startDate;
	protected Client client;
	protected Bike bike;
	protected int id;

	public SingleRental(int id, int rate, Client client, Bike bike) {
		super();
		this.startDate = LocalDateTime.now();
		this.rate = rate;
		this.client = client;
		this.bike = bike;
		this.id = id;
		this.log = Logger.getLogger(this.getClass());
	}

	public float getActualCharge() {
		return getEstimatedCharge(LocalDateTime.now());
	}

	public float getEstimatedCharge(LocalDateTime estimatedDate) {
		int period = getPeriod(estimatedDate);
		if (period == 0) {
			period = 1;
		}
		float result = rate * period;
		log.debug("Charge from: " + formatDate(startDate) + " to " + formatDate(estimatedDate)+ " is $" + result);
		return result;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Bike getBike() {
		return bike;
	}

	public void setBike(Bike bike) {
		this.bike = bike;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	protected String formatDate(LocalDateTime date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		return date.format(formatter);
	}

	public abstract int getPeriod(LocalDateTime finishDate);
}
