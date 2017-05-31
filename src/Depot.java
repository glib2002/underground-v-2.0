import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Depot extends TrainBuilder {

	public Depot() {

	}

	public ArrayList<Carriage> getCarriages() {
		ArrayList<Carriage> data = new ArrayList<Carriage>();
		for (int x = 0; x < (int) (Math.random() * 14); x++) {
			data.add(new Carriage(generateHeight(), generateSerialNumber()));
		}
		return data;
	}

	public String generateTrainNumber(){
		SimpleDateFormat sdf = new SimpleDateFormat();
		return sdf.format(new Date());
	
	}
	private String generateSerialNumber() {
		String name = null;
		String number = null;
		String abc = "A B C D E F G H I K L M N O P Q R S T V X Y Z";
		String numbers = "1 2 3 4 5 6 7 8 9 0";
		String[] data = abc.split(" ");
		String[] numdata = numbers.split(" ");

		for (int x = 0; x < 8; x++) {
			name = name + data[(int) (Math.random() * 22)];
		}
		for (int x = 0; x < 4; x++) {
			numbers = numbers + numdata[(int) (Math.random() * 10)];
		}
		return name + number;
	}

	private int generateHeight() {
		return (int) (Math.random() * 50);
	}

}
