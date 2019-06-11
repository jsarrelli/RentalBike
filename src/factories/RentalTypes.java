package factories;

public enum RentalTypes {

	WEEKLY(1,"Week"), HOURLY(2,"Hour"), DAILY(3,"Day"), FAMILY(4,"Family");
	String value;
	int id;

	private RentalTypes(int id,String value) {
		this.value = value;
		this.id =id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
}
