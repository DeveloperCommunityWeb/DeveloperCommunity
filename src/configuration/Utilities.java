package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utilities {
	private Connection cnn=null;
	private final String USERNAME="haminho";
	private final String PASSWORD="123456";
	private final String URL="jdbc:postgresql://1.246.219.159:5432/db_developer_community";
	public Connection dbConnect(){
		try {
			Class.forName("org.postgresql.Driver");
			cnn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return cnn;
	}
}
