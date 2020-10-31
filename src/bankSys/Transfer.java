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

public class Transfer implements Initializable{
	
	@FXML
	Button balanceBtn, depositBtn, dataBtn, transferBtn;
	
	@FXML
	Label statusLabel;
	
	@FXML
	TextField recipent, amountField;
	
	User currentUser;
	
	public void transferBalance() throws SQLException {
		String recipentName=recipent.getText();
		String amountString = amountField.getText();
		double amount=Double.parseDouble(amountString);
		String query1="UPDATE `bank`.`userdata` SET `balance` = balance-"+(amount)+" WHERE (`username` = '"+LoginPage.uname+"');";
		String query2="UPDATE `bank`.`userdata` SET `balance` = balance+"+amount+" WHERE (`username` = '"+recipentName+"');";
		Statement st=SQLcon.con.createStatement();
		st.addBatch(query1);
		st.addBatch(query2);
		int[] i=st.executeBatch();
		if(i[1]==1) {
			System.out.println("Payment done");
			statusLabel.setVisible(true);
			statusLabel.setText("Payment succesful");
			recipent.setText("");
			amountField.setText("");
			String getBalance="SELECT Balance FROM bank.userdata where username='"+LoginPage.uname+"';";
			ResultSet rs=st.executeQuery(getBalance);
			rs.next();
			double dbBalance=rs.getDouble(1);
			System.out.println("New balance: "+dbBalance);
		}
		else {
			System.out.println("Payment not done");
			statusLabel.setVisible(true);
			statusLabel.setText("Payment unsuccesful");
		}
		
	}

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

}
