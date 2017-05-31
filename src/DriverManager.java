import java.util.Iterator;

public class DriverManager {

	private String name;
	private Line line;

	public DriverManager(String name, Line line) {
		this.name = name;
		this.line = line;
	}

	private int calculationDriversExpirience(Train train) {
		int pupilsExamination = 0;

		for (int x = 0; x < train.getCarriages().size(); x++) {
			Iterator<Passenger> iter = train.getCarriages().peek().getPassengers().iterator();
			while (iter.hasNext()) {
				pupilsExamination = pupilsExamination + iter.next().getDriversExamination();
				iter.remove();
			}

		}
		int driverExp = pupilsExamination * train.getDriver().getDriversExp();

		return driverExp;
	}

}
