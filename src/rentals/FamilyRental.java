package rentals;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class FamilyRental extends Promotion {
	private int id;
	private ArrayList<Rental> rentals;

	public FamilyRental(int id) {
		super();
		this.id = id;
		this.rentals = new ArrayList<Rental>();
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

	public void addRentals(ArrayList<Rental> associateRentals) throws Exception {
		if (validateNumberOfAssociateRentals(associateRentals) && validateTypesOfRentals(associateRentals))  {
			this.rentals.addAll(associateRentals);
		} else {
			throw new Exception("Error! Family Rental accepts 3 to 5 rentals and not inlude another promotions");
		}
	}

	private boolean validateTypesOfRentals(ArrayList<Rental> associateRentals) {
		return !associateRentals.parallelStream().anyMatch(rental-> Promotion.class.isAssignableFrom(rental.getClass()));
	}

	private boolean validateNumberOfAssociateRentals(ArrayList<Rental> associateRentals) {
		return associateRentals.size() <= 5 && associateRentals.size() >= 3;
	}

}
