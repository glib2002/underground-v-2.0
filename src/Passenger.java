
public class Passenger {

	public static final String MOVE_TOWARDS = null;
	public static final String MOVE_BACK = null;
	public static final String CAME = null;
	private String stationTo;
	private String stationFrom;
	private String name;
	private int direction = 0;

	public Passenger(String name, String stationTo, String stationFrom) {
		this.stationFrom = stationFrom;
		this.stationTo = stationTo;
		this.name = name;
	}

	public String getStationTo() {
		return stationTo;
	}

	public String getName() {
		return name;
	}

	public String getStationFrom() {
		return stationFrom;
	}

	public int getDriversExamination() {
		return (int) (Math.random() * 20);
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(String moveTowards) {
		if (moveTowards == MOVE_BACK) {
			direction = -1;
		}
		if (moveTowards == MOVE_TOWARDS) {
			direction = 1;
		}

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Passenger other = (Passenger) obj;
		if (this.getName().equals(other.getName())) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = (int) (Math.random() * getName().length());
		result = prime * result + direction;
		return result;
	}

	@Override
	public String toString() {
		return "Passenger [stationTo=" + stationTo + ", stationFrom=" + stationFrom + ", name=" + name + "]";
	}

}
