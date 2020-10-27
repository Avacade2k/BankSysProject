package bankSys;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class CheckBalance implements Initializable {
	
	@FXML
	Label balanceStatus;
	
	@FXML
	Label userData;
	
	User currentUser;
	
	public void checkBalance() throws SQLException {
		currentUser = LoginPage.getUser(LoginPage.uname);
		balanceStatus.setText(currentUser.getBalance().toString());
		userData.setText(capitalize(currentUser.getFname()) + " " + capitalize(currentUser.getLname()));
	}
	
	public void signOut() {
		System.out.println("Signing out");
		new Main().changeScene("LoginPage.fxml", "Login page", 400, 400);
	}
	
	public void depositWithdraw() {
		System.out.println("Went to deposit");
		new Main().changeScene("DepositWithdraw.fxml", "Deposit/Withdraw", 400, 400);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			checkBalance();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String capitalize(String str)
	{
	    if(str == null) return str;
	    return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

}
