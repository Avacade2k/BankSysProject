package bankSys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLcon {
	
	static Connection con;
	
	public static void connectDB(String url,String user,String pass) throws SQLException{ //Connecting to database
		con=DriverManager.getConnection(url, user, pass);
		System.out.println(con);
	}

}
