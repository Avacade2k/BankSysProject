package bankSys;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class AccountData implements Initializable{
	
	@FXML
	Button balanceBtn, depositBtn, dataBtn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		CheckBalance cb = new CheckBalance();
		cb.setButtons(balanceBtn, depositBtn, dataBtn);
	}

}
