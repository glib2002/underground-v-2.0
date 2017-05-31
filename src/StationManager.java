import java.util.ArrayList;

public abstract class StationManager {

	private DataManager dataManager = new DataManager();
	private ArrayList<Tourniquet> tourniquets;
	private int location;
	private Line line;
	private Station next;
	private Station back;
	private boolean endedStation = false;
	private int numOfTourniquets;

	public StationManager(int location, Line line, Station next, boolean endedStation, int numOfTourniquets) {
		this.location = location;
		this.line = line;
		this.next = next;
		this.endedStation = endedStation;
		this.numOfTourniquets = numOfTourniquets;
		tourniquets = new ArrayList<Tourniquet>(numOfTourniquets);

		for (int x = 0; x < numOfTourniquets; x++) {
			tourniquets.add(new Tourniquet(dataManager.generateStringWithNumber(true), numOfTourniquets, getLine()));

		}

	}

	public Line getLine() {
		return line;
	}

	public int getLocation() {
		return location;
	}

	public Station getNext() {
		return next;
	}

	public boolean getEndedStation() {
		return endedStation;
	}

	public Station getBackStation() {
		return back;
	}

	protected ArrayList<Tourniquet> getTourniquets() {
		return tourniquets;
	}

	protected int getNumOfPassengers() {
		return numOfTourniquets;
	}

	protected void remove(ArrayList<Passenger> data) {
		data.clear();
	}
}
