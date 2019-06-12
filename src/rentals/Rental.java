package rentals;

import java.time.LocalDateTime;

public interface Rental {

	public float getEstimatedCharge(LocalDateTime estimatedDate);

	public float getActualCharge();

	public int getId();

}
