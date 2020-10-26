package bankSys;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginPage {
	
	@FXML
	TextField username;
	@FXML
	TextField password;
	
	public void Login(){
		if(username.getText().equals("Sample") && password.getText().equals("")) {
			System.out.println("Login successful");
			new Main().changeScene("CheckBalance.fxml", "Main", 400, 400);
		}
	}
	
	public void toRegister() {
		new Main().changeScene("SignUp.fxml", "Sign up", 400, 400);
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
