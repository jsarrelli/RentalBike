package factories;

public enum RentalTypes {

	WEEKLY("Week"), HOURLY("Hour"), DAILY("Day"), FAMILY("Family");
	String value;

	private RentalTypes(String value) {
		this.value = value;

	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
