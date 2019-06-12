package platform;

public class Bike {
	private int idBike;
	private boolean isRented;

	public Bike(int id) {
		this.idBike = id;
		isRented = false;
	}

	public int getIdBike() {
		return idBike;
	}

	public void setIdBike(int idBike) {
		this.idBike = idBike;
	}

	public boolean isRented() {
		return isRented;
	}

	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}

}
