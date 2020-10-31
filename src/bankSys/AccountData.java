package bankSys;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AccountData implements Initializable{
	
	@FXML
	Button balanceBtn, depositBtn, dataBtn, transferBtn;
	
	@FXML
	Label gender, name, user;
	
	User currentUser;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			CheckBalance cb = new CheckBalance();
			cb.setButtons(balanceBtn, depositBtn, dataBtn, transferBtn);
			User currentUser = LoginPage.getUser(LoginPage.uname);
			gender.setText(currentUser.getGender());
			name.setText(currentUser.getFname() + " " + currentUser.getLname());
			user.setText(currentUser.getUsername());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
