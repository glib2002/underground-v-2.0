import java.sql.SQLException;

public class DepotWorker {

	private Depot depot = new Depot();
	private HandlerDB handlerDB = new HandlerDB(); 
	private static int pos = 0;
	public DepotWorker() {
		// TODO Auto-generated constructor stub
	}
	public Train build() throws SQLException{
		String generatedTN = depot.generateTrainNumber();
		handlerDB.enter("mysql.Driver", "jdbc:mysql", "passengerfactory", "1234");
		//TODO MAKE QUERY TO THE DATABASE!!!
		handlerDB.setValue("", generatedTN, pos);
		pos++;
		return depot.createTrain(generatedTN, depot.getCarriages());
	}
	
}
