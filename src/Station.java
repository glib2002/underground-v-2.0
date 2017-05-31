
//Author GLIB.
//Version 2.0
//This is stabilized system.
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Station extends StationManager implements Runnable {

	private String name;

	private Track trackToward = new Track(Track.FORWARD);
	private Track trackBack = new Track(Track.BACK);

	public Station(String name, int location, Line line, Station next, boolean endedStation, int numOfTourniquets) {
		super(location, line, next, endedStation, numOfTourniquets);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	private HashSet<Passenger> grabPassengers() {
		HashSet<Passenger> grab = new HashSet<Passenger>();
		ArrayList<Tourniquet> tourniquetList = new ArrayList<Tourniquet>();
		Iterator<Tourniquet> iter = tourniquetList.iterator();
		while (iter.hasNext()) {

			HashSet<Passenger> dataP = iter.next().getPassengers();
			Iterator<Passenger> iteration = dataP.iterator();
			while (iteration.hasNext()) {
				grab.add(iteration.next());
				iteration.remove();
			}
			iter.remove();
		}
		return grab;
	}

	public void exitPassengers(Track track) {

		HashSet<Passenger> passengers = track.getPassengers();
		Iterator<Passenger> iter = passengers.iterator();
		while (iter.hasNext()) {
			if (iter.next().getStationTo().equals(name)) {
				iter.remove();
			}
		}
	}

	public int getDistanceBetweenStations() {
		return getNext().getLocation() - getLocation();
	}

	@Override
	public void run() {

		while (true) {
			System.out.println(toString());

			new Thread(new Runnable() {

				@Override
				public void run() {
					HashSet<Passenger> passTo = new HashSet<>();
					if (!(trackToward.getTrain().equals(null))) {
						HashSet<Passenger> pass = grabPassengers();
						Iterator<Passenger> iter = pass.iterator();
						while (iter.hasNext()) {
							if (iter.next().getDirection() > 0) {
								passTo.add(iter.next());
							}
							iter.remove();
						}
						// 1 GRAB.
						trackToward.setPassengers(passTo);
						// 2 GIVE TO THE TRACKS.
						exitPassengers(trackToward);
						// 3 EXIT.

						System.out.println(trackToward.toString());

					}
				}
			});

			new Thread(new Runnable() {

				@Override
				public void run() {

					HashSet<Passenger> passBack = new HashSet<>();
					if (!(trackBack.getTrain().equals(null))) {
						HashSet<Passenger> pass = grabPassengers();
						Iterator<Passenger> iter = pass.iterator();
						while (iter.hasNext()) {
							if (iter.next().getDirection() < 0) {
								passBack.add(iter.next());
							}
							iter.remove();
						}
						// 1 GRAB.

						trackBack.setPassengers(passBack);
						// 2 GIVE TO THE TRACKS.
						exitPassengers(trackBack);
						// 3 EXIT.
						System.out.println(trackToward.toString());

					}
				}

			});

		}

	}

	@Override
	public String toString() {
		return "Station [name=" + name + "]";
	}
}
