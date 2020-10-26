package bankSys;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUp {
	
	@FXML
	TextField fname;
	
	@FXML
	TextField lname;
	
	@FXML
	PasswordField password;
	
	@FXML
	TextField username;
	
	public void signUp() {
		
	}
	
	public void back() {
		new Main().changeScene("LoginPage.fxml", "Login page", 400, 400);
	}

}
