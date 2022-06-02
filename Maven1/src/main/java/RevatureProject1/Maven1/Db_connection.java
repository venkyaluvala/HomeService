package RevatureProject1.Maven1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db_connection {
	public Connection getMyConnection() {
		Connection con = null;
		try {
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/HomeserviceAppData","root","Venky@123");
		return con;
		}catch(SQLException e) {
			return con;
		}
	}

}
