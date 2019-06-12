package tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import rentals.DayRental;
import rentals.FamilyRental;
import rentals.HourRental;
import rentals.Rental;
import rentals.WeekRental;

class testFamilyRental {

	@Test
	void testAddMoreThan5Rentals() throws Exception {
		FamilyRental familyRental = new FamilyRental(0);
		ArrayList<Rental> associateRentals = new ArrayList<Rental>();
		associateRentals.add(new HourRental(0, null, null));
		associateRentals.add(new DayRental(0, null, null));
		associateRentals.add(new WeekRental(0, null, null));
		associateRentals.add(new WeekRental(0, null, null));
		associateRentals.add(new WeekRental(0, null, null));
		associateRentals.add(new WeekRental(0, null, null));
		associateRentals.add(new WeekRental(0, null, null));

		assertThrows(Exception.class, () -> familyRental.addRentals(associateRentals));
	}

	@Test
	void testAddLThan3Rentals() throws Exception {
		FamilyRental familyRental = new FamilyRental(0);
		ArrayList<Rental> associateRentals = new ArrayList<Rental>();
		associateRentals.add(new HourRental(0, null, null));

		assertThrows(Exception.class, () -> familyRental.addRentals(associateRentals));
	}

	@Test
	void testAddIncompatibleRentalType() throws Exception {
		FamilyRental familyRental = new FamilyRental(0);
		ArrayList<Rental> associateRentals = new ArrayList<Rental>();
		associateRentals.add(new FamilyRental(0));
		associateRentals.add(new WeekRental(0, null, null));
		associateRentals.add(new WeekRental(0, null, null));

		assertThrows(Exception.class, () -> familyRental.addRentals(associateRentals));
	}

}
