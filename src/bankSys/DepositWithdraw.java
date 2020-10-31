package bankSys;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DepositWithdraw implements Initializable{
	
	@FXML
	Button balanceBtn, depositBtn, dataBtn, transferBtn;
	
	@FXML
	Button chooseDeposit, chooseWithdraw, submitBtn;
	
	@FXML
	TextField amountField;
	
	@FXML
	Label mainLabel, amountLabel;
	
	User currentUser;
	
	boolean isDepositing = false;
	boolean isWithdrawing = false;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			CheckBalance cb = new CheckBalance();
			cb.setButtons(balanceBtn, depositBtn, dataBtn, transferBtn);
			currentUser = LoginPage.getUser(LoginPage.uname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void submit() throws SQLException {
		if(isDepositing) depositFinalize();
		if(isWithdrawing) withdrawFinalize();
		
	}
	
	public void showHidden() {
		amountLabel.setVisible(true);
		amountField.setVisible(true);
		submitBtn.setVisible(true);
		mainLabel.setVisible(false);
		chooseDeposit.setVisible(false);
		chooseWithdraw.setVisible(false);
		if(isDepositing) amountLabel.setText("Depositing");
		if(isWithdrawing) amountLabel.setText("Withdrawing");
	}
	
	public void depositClick() {
		isDepositing = true;
		showHidden();
	}
	
	public void withdrawClick() {
		isWithdrawing = true;
		showHidden();
	}
	
	public void depositFinalize() throws SQLException {
		double depositMoney=Double.parseDouble(amountField.getText());
		double total=currentUser.getBalance()+depositMoney;
		String query="UPDATE `bank`.`userdata` SET `balance` = '"+total+"' WHERE (`username` = '"+LoginPage.uname+"');";
		Statement st=SQLcon.con.createStatement();
		int i=st.executeUpdate(query);
		if(i==1)
		{
			String getBalance="SELECT balance FROM bank.userdata where username= '"+LoginPage.uname+"';";
			ResultSet rs=st.executeQuery(getBalance);
			rs.next();
			double dbBalance=rs.getDouble(1);
			System.out.println("New balance: "+dbBalance);
			currentUser.setBalance(dbBalance);
			amountField.setText("");
			mainLabel.setText("Deposit succesful");
			mainLabel.setVisible(true);
		}
		else {
			System.out.println("Error while trying to deposit");
			mainLabel.setText("Deposit unsuccesful");
			mainLabel.setVisible(true);
		}
	}
	
	public void withdrawFinalize() throws SQLException {
		double withdrawMoney=Double.parseDouble(amountField.getText());
		if(currentUser.getBalance() > withdrawMoney) {
			double total=currentUser.getBalance()-withdrawMoney;
			String query="UPDATE `bank`.`userdata` SET `balance` = '"+total+"' WHERE (`username` = '"+LoginPage.uname+"');";
			Statement st=SQLcon.con.createStatement();
			int i=st.executeUpdate(query);
			if(i==1)
			{
				String getBalance="SELECT balance FROM bank.userdata where username= '"+LoginPage.uname+"';";
				ResultSet rs=st.executeQuery(getBalance);
				rs.next();
				double dbBalance=rs.getDouble(1);
				System.out.println(dbBalance);
				currentUser.setBalance(dbBalance);
				amountField.setText("");
				mainLabel.setText("Withdraw succesful");
				mainLabel.setVisible(true);
			}
			else {
				System.out.println("Error while withdrawing");
				mainLabel.setText("Withdraw unsuccesful");
				mainLabel.setVisible(true);
			}
		}else {
			mainLabel.setText("Your balance is too low");
			mainLabel.setVisible(true);
		}
		
	}

}
