
public class PassengerTabloid implements Tabloid {

	public PassengerTabloid() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getDistanceBetweenStations(Station s1, Station s2) {
		int distance = 0;
		if (!s1.equals(s2) && !s1.getLine().equals(s2.getLine())) {
			if (s1.getLocation() > s2.getLocation()) {
				distance = s1.getLocation() - s2.getLocation();
			}
			if (s2.getLocation() > s1.getLocation()) {
				distance = s2.getLocation() - s1.getLocation();
			}
		}
		return distance;
	}

}
