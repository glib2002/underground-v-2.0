import java.util.Queue;

public class Train {

	private String type;
	private String number;
	private int height;
	private Queue<Carriage> car;
	private Driver driver;
	
	public Train(String type, String number, int height, Queue<Carriage> car, Driver driver) {
		this.type = type;
		this.number = number;
		this.height = height;
		this.car = car;
		this.driver = driver;
	}

	public String getType() {
		return type;
	}

	public Driver getDriver() {
		return driver;
	}

	public String getNumber() {
		return number;
	}

	public int getHeight() {
		return height;
	}

	public Queue<Carriage> getCarriages() {
		return car;
	}
	
}
