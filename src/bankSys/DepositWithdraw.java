package bankSys;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DepositWithdraw implements Initializable{
	
	@FXML
	Button balanceBtn, depositBtn, dataBtn;
	
	@FXML
	TextField deposit, withdraw;
	
	User currentUser;
	
	boolean isDeposit = false;
	boolean isWithdraw = false;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			CheckBalance cb = new CheckBalance();
			cb.setButtons(balanceBtn, depositBtn, dataBtn);
			currentUser = LoginPage.getUser(LoginPage.uname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void depositFinalize() throws SQLException {
		double depositMoney=Double.parseDouble(deposit.getText());
		double total=currentUser.getBalance()+depositMoney;
		String query="UPDATE `bank`.`userdata` SET `balance` = '"+total+"' WHERE (`username` = '"+LoginPage.uname+"');";
		Statement st=SQLcon.con.createStatement();
		int i=st.executeUpdate(query);
		if(i==1)
		{
			String getBalance="SELECT Balance FROM bank.userdata where username="+LoginPage.uname+";";
			ResultSet rs=st.executeQuery(getBalance);
			rs.next();
			double dbBalance=rs.getDouble(1);
			System.out.println("New balance: "+dbBalance);
			currentUser.setBalance(dbBalance);
			deposit.setText("");
		}
		else {
			System.out.println("Error while trying to deposit");
		}
	}
	
	public void withdrawFinalize() throws SQLException {
		double withdrawMoney=Double.parseDouble(withdraw.getText());
		double total=c.getBalance()-withdrawMoney;
		String query="UPDATE `bank`.`userdata` SET `balance` = '"+total+"' WHERE (`username` = '"+LoginPage.uname+"');";
		Statement st=SQLcon.con.createStatement();
		int i=st.executeUpdate(query);
		if(i==1)
		{
			String getBalance="SELECT Balance FROM bank.userdata where username="+LoginPage.uname+";";
			ResultSet rs=st.executeQuery(getBalance);
			rs.next();
			double dbBalance=rs.getDouble(1);
			System.out.println(dbBalance);
			currentUser.setBalance(dbBalance);
			withdraw.setText("");
		}
		else {
			System.out.println("Error while withdrawing");
		}
		
	}

}
