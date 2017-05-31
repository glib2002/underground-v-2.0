import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HandlerDB {
	private Connection dbh;

	public void enter(String driver, String url, String user, String password) throws SQLException {
		dbh = DriverManager.getConnection(url, user, password);
	}


	public ArrayList<String> createQuery(String query) throws SQLException {
		ArrayList<String> data = new ArrayList<String>();
		Statement statement = dbh.createStatement();

		ResultSet rs = statement.executeQuery(query);

		while (rs.next()) {
			data.add(rs.getString(1));
			System.out.println(rs.getString(1));
		}
		rs.close();
		statement.close();
		return data;

	}

	public void setValue(String prepare, String data, int pos) throws SQLException {
		PreparedStatement ps = dbh.prepareStatement(prepare);
		ps.setString(pos, data);
	}
}
