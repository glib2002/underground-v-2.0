import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Tourniquet {

	private String name;
	private int seed;
	private HashSet<Passenger> passengers = new HashSet<Passenger>();
	private PassengerFactory passfactory = new PassengerFactory();
	private Line line;
	private Tourniquet tourniquet;

	public Tourniquet(String name, int seed, Line line) {
		this.name = name;
		this.seed = seed;
		this.line = line;
	}

	public HashSet<Passenger> getPassengers() {
		for (int x = 0; x < (int) (Math.random() * seed); x++) {
			try {
				Thread.sleep((int) (Math.random() * 4000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			passengers.add(passfactory.createPassenger());
			Iterator<Passenger> iter = passengers.iterator();
			setDirection(iter.next());
			iter.remove();
		}
		return passengers;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	private void setDirection(Passenger passenger) {
		Station to = null;
		Station from = null;
		int direction = 0;
		ArrayList<Station> stationsData = line.getStations();
		Iterator<Station> iter = stationsData.iterator();
		while (iter.hasNext()) {

			if (passenger.getStationFrom() == iter.next().getName()) {
				from = iter.next();
			}
			while (iter.hasNext()) {
				if (passenger.getStationTo() == iter.next().getName()) {
					to = iter.next();
				}
				iter.remove();

			}
			iter.remove();

		}
		direction = to.getLocation() - from.getLocation();
		if (direction < 0) {
			passenger.setDirection(Passenger.MOVE_BACK);
		}
		if (direction > 0) {
			passenger.setDirection(Passenger.MOVE_TOWARDS);
		}
	}

	public void clear() {
		passengers.clear();
	}

	public String getName() {
		return name;
	}
}
