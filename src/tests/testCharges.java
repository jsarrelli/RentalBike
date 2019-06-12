package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import rentals.DayRental;
import rentals.FamilyRental;
import rentals.HourRental;
import rentals.Rental;
import rentals.WeekRental;

class testCharges {

	@Test
	void testGetEstimatedlChargeWeekRental() {
		WeekRental weekRental = new WeekRental(0, null, null);
		LocalDateTime estimatedDate = LocalDateTime.now().plusWeeks(4);
		assertEquals(60 * 4, weekRental.getEstimatedCharge(estimatedDate));
	}

	@Test
	void testGetActualChargeWeekRental() {
		WeekRental weekRental = new WeekRental(0, null, null);
		assertEquals(60 * 1, weekRental.getEstimatedCharge(LocalDateTime.now()));
	}

	@Test
	void testGetEstimatedlChargeDayRental() {
		DayRental rental = new DayRental(0, null, null);
		LocalDateTime estimatedDate = LocalDateTime.now().plusDays(9);
		assertEquals(20 * 9, rental.getEstimatedCharge(estimatedDate));
	}

	@Test
	void testGetActualChargeDayRental() {
		DayRental rental = new DayRental(0, null, null);
		assertEquals(20 * 1, rental.getEstimatedCharge(LocalDateTime.now()));
	}

	@Test
	void testGetEstimatedlChargeHourRental() {
		HourRental rental = new HourRental(0, null, null);
		LocalDateTime estimatedDate = LocalDateTime.now().plusHours(35);
		assertEquals(5 * 35, rental.getEstimatedCharge(estimatedDate));
	}

	@Test
	void testGetActualChargeHourRental() {
		HourRental rental = new HourRental(0, null, null);
		assertEquals(5 * 1, rental.getEstimatedCharge(LocalDateTime.now()));
	}

	@Test
	void testGetEstimatedlChargeFamilyRental() throws Exception {
		FamilyRental familyRental = new FamilyRental(0);
		ArrayList<Rental> associateRentals = new ArrayList<Rental>();
		associateRentals.add(new HourRental(0, null, null));
		associateRentals.add(new DayRental(0, null, null));
		associateRentals.add(new WeekRental(0, null, null));
		familyRental.addRentals(associateRentals);

		LocalDateTime estimatedDate = LocalDateTime.now().plusDays(93);
		int expectedResult = (int) ((93 * 24) * 5 + Math.ceil(93 / 7) * 60 + 93 * 20);
		assertEquals(expectedResult, familyRental.getEstimatedCharge(estimatedDate));
	}

	@Test
	void testGetActualChargeFamilyRental() throws Exception {
		FamilyRental familyRental = new FamilyRental(0);
		ArrayList<Rental> associateRentals = new ArrayList<Rental>();
		associateRentals.add(new HourRental(0, null, null));
		associateRentals.add(new DayRental(0, null, null));
		associateRentals.add(new WeekRental(0, null, null));
		familyRental.addRentals(associateRentals);

		LocalDateTime estimatedDate = LocalDateTime.now();
		assertEquals(5 + 20 + 60, familyRental.getEstimatedCharge(estimatedDate));
	}

}
