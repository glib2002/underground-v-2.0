import java.util.HashSet;

public class Track {

	private String name;
	private HashSet<Passenger> pass;
	public static final String BACK = "back";
	public static final String FORWARD = "forward";
	private Train train;

	public Track(String name) {
		this.name = name;
	}

	public void setPassengers(HashSet<Passenger> pass) {
		this.pass = pass;
	}

	public HashSet<Passenger> getPassengers() {
		return pass;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public Train getTrain() {
		return train;
	}
	
	@Override
	public String toString() {
		return "Track [name=" + name + ", pass=" + pass + ", train=" + train + "]";
	}
}
