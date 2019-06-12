package rentals;

import java.time.LocalDateTime;
import java.util.ArrayList;

import platform.Client;

public class FamilyRental implements Rental {
	private int id;
	private ArrayList<Rental> rentals;

	public FamilyRental(int id) {
		super();
		this.id = id;
	

	}

	@Override
	public float getEstimatedCharge(LocalDateTime estimatedDate) {
		return (float) rentals.parallelStream().mapToDouble(rental -> rental.getEstimatedCharge(estimatedDate)).sum();
		
	}

	@Override
	public float getActualCharge() {
		return (float) rentals.parallelStream().mapToDouble(rental -> rental.getActualCharge()).sum();
	}

	@Override
	public int getId() {
		return this.id;
	}

	public ArrayList<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(ArrayList<Rental> rentals) {
		this.rentals = rentals;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void addRental(Rental rental) throws Exception {
		if (rentals.size() <= 5 && rentals.size() >= 3) {
			this.rentals.add(rental);
		} else {
			throw new Exception("Error! Family Rental accepts 3 to 5 rentals");
		}
	}

}
