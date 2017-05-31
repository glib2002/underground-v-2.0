
public class DataManager {

	public DataManager() {
		// TODO Auto-generated constructor stub
	}
	public String generateStringWithoutNumbers(boolean toUpperCase) {
		String string = null;
		String abc = "a b c d e f g h i k l m n o p q r s t v x y z";
		if(toUpperCase == true){
			abc = abc.toUpperCase();
		}
		String[] data = abc.split(" ");
		int ranNumOfString = (int) (Math.random() * 22);
		for (int x = 0; x < ranNumOfString; x++) {
			string = string + data[(int) (Math.random() * 22)];
		}
		return string;
	}
	public String generateStringWithNumber(boolean toUpperCase) {
		String number = null;
		String numbers = "1 2 3 4 5 6 7 8 9 0";
		String[] numdata = numbers.split(" ");

		for (int x = 0; x < 4; x++) {
			numbers = numbers + numdata[(int) (Math.random() * 10)];
		}
		
		return generateStringWithoutNumbers(toUpperCase) + number;
	
	}

	
}
