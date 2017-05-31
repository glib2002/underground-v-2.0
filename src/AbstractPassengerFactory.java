import java.sql.SQLException;
import java.util.ArrayList;

public abstract class AbstractPassengerFactory implements PassengerCreator {

	private HandlerDB hand = new HandlerDB();

	@Override
	public Passenger createPassenger() {
		try {
			hand.enter("mysql.Driver", "jdbc:mysql", "passengerfactory", "1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Passenger(generateName(), generateStation(), generateStation());
	}

	protected String generateName() {
		String name = null;
		String surname = null;
		String abc = "A B C D E F G H I K L M N O P Q R S T V X Y Z";
		String[] data = abc.split(" ");
		int ranNumOfLetterOfName = (int) (Math.random() * 22);
		for (int x = 0; x < ranNumOfLetterOfName; x++) {
			name = name + data[(int) (Math.random() * 22)];
		}
		int ranNumOfLetterOfSurname = (int) (Math.random() * 22);

		for (int x = 0; x < ranNumOfLetterOfSurname; x++) {
			surname = surname + data[(int) (Math.random() * 22)];
		}

		return name + surname;
	}

	protected String generateStation() {
		ArrayList<String> data = null;
		try {
			data = hand.createQuery("SELECT name FROM STATIONS");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data.get((int) (Math.random() * 46));
	}

}
