package bankSys;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Login {
	
	@FXML
	TextField username;
	@FXML
	TextField password;
	
	public void Login(){
		
	}
	
	static public User getUser(){
		String username="Sample";
		String password="";
		String fname="Ex";
		String lname="Ample";
		String gender="Male";
		Double balance = 0.00;
		User user=new User(username, password, fname, lname, gender, balance);
		return user;
	}

}
