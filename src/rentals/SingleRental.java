package rentals;
import java.time.LocalDateTime;

import platform.Bike;
import platform.Client;

public abstract class SingleRental implements Rental {
	protected int rate;
	protected LocalDateTime startDate;
	protected Client client;
	protected Bike bike;
	
	
	
	public SingleRental(int rate, Client client, Bike bike) {
		super();
		this.startDate = LocalDateTime.now();
		this.rate = rate;
		this.client = client;
		this.bike = bike;
	}


	public float getActualCharge() {
		return getEstimatedCharge(LocalDateTime.now());
	}
	
	
	public float getEstimatedCharge(LocalDateTime estimatedDate) {
		return rate*getPeriod(estimatedDate);
	}
	
	public abstract int getPeriod(LocalDateTime finishDate);
}
