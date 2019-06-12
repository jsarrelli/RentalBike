package rentals;
import java.time.LocalDateTime;

import platform.Bike;
import platform.Client;

public abstract class SingleRental implements Rental {
	protected int rate;
	protected LocalDateTime startDate;
	protected Client client;
	protected Bike bike;
	protected int id;
	
	
	public SingleRental(int id,int rate, Client client, Bike bike) {
		super();
		this.startDate = LocalDateTime.now();
		this.rate = rate;
		this.client = client;
		this.bike = bike;
		this.id= id;
	}


	public float getActualCharge() {
		return getEstimatedCharge(LocalDateTime.now());
	}
	
	
	public float getEstimatedCharge(LocalDateTime estimatedDate) {
		return rate*getPeriod(estimatedDate);
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


	public abstract int getPeriod(LocalDateTime finishDate);
}
