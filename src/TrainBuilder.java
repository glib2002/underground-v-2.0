import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public abstract class TrainBuilder implements Builder {

	private Random random = new Random();

	private DataManager dm = new DataManager();

	public TrainBuilder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Train createTrain(String number, ArrayList<Carriage> car) {
		int translateIndex = 0;
		String type = null;
		int height = 0;
		Driver driver = null;

		Comparator<Carriage> comparator = new Comparator<Carriage>() {

			@Override
			public int compare(Carriage o1, Carriage o2) {
				if (o1.getHeight() > o2.getHeight()) {
					return -1;
				}
				if (o1.getHeight() > o2.getHeight()) {
					return 1;
				}
				return 0;
			}
		};

		Queue<Carriage> queue = new PriorityQueue<>(10, comparator);

		for (Carriage c : car) {
			queue.add(car.get(translateIndex));
			translateIndex++;
		}
		if (car.size() <= 5) {
			type = "SMALL";
			driver = new Driver(random.nextInt(2), dm.generateStringWithoutNumbers(true));
		}
		if ((car.size() > 5) && (car.size() <= 10)) {
			type = "MEDIUM";
			driver = new Driver(random.nextInt(6), dm.generateStringWithoutNumbers(true));
		}
		if ((car.size() > 10) && (car.size() <= 15)) {
			driver = new Driver(random.nextInt(10), dm.generateStringWithoutNumbers(true));
			type = "LARGE";
		}
		for (int x = 0; x < car.size(); x++) {
			height = height + car.get(x).getHeight();
		}
		return new Train(type, number, height, queue, driver);

	}
}
