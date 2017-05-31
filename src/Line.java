import java.util.ArrayList;

public class Line {

	
	private static final String YELLOW = "yellow";
	private static final String RED = "red";
	private static final String BLUE = "blue";
	private static final String GREEN = "green";
	private String name;
	private static final String undergroundFilePath = "";
	private HandlerDB db = new HandlerDB(); 
	private FileHandler fh = new FileHandler();
	public Line(String name) {
		this.name = name;
	}
	public void init(){
		//db.enter(driver, url, user, password);
		
		//Read file of stations.
		//Load in database.
		//Read file of stations.
		//Load in database.
		//Registration of depot. 		
	}
	public ArrayList<Station> getStations() {
	
		return null;
	}
}
