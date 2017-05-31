import java.util.HashSet;
import java.util.Set;

public class Carriage {

	private String serialNumber;
	private int height;
	public static final int MAX_NUMBER_OF_PASSENGERS = 240;
	private HashSet<Passenger> passengers;
	public Carriage(int height, String serialNumber) {
		this.height = height;
		this.serialNumber = serialNumber;
	}

	public int getHeight() {
		return height;
	}
	public void setPassengers(HashSet<Passenger> passengers){
		this.passengers = passengers;
	}
	public Set<Passenger> getPassengers(){
		return passengers;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
}
