package bankSys;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginPage {
	
	@FXML
	TextField username;
	@FXML
	PasswordField password;
	
	public static String uname;
	
	public void Login(){
		uname = username.getText();
		try {
			String query1="Select username,password from bank.users where username='"+uname+"';";
			Statement st=SQLcon.con.createStatement();
			ResultSet rs=st.executeQuery(query1);
			rs.next();
			String dbpassword=rs.getString(2);
			
			if(dbpassword.contentEquals(password.getText())) {
				System.out.println("Login successful");
				new Main().changeScene("CheckBalance.fxml", "Main", 400, 400);
			}
			}
			catch(SQLException sqlException) {
				System.out.println("Wrong account data");
			}
	}
	
	public void toRegister() {
		new Main().changeScene("SignUp.fxml", "Sign up", 400, 400);
	}
	
	static public User getUser(String uname) throws SQLException{
		String query2="Select * from bank.userdata where username='"+uname+"';";
		Statement st=SQLcon.con.createStatement();
		st.executeQuery(query2);
		ResultSet rs=st.executeQuery(query2);
		rs.next();
		String username=rs.getString(1);
		String fname=rs.getString(2);
		String lname=rs.getString(3);
		String gender=rs.getString(4);
		Double balance=rs.getDouble(5);
		User user=new User(username, fname, lname, gender, balance);
		return user;
	}

}
