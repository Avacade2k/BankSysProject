package bankSys;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUp implements Initializable{
	
	@FXML
	TextField fname, lname, username;
	
	@FXML
	PasswordField password;
	
	@FXML
	ComboBox<String> gender;
	
	public void signUp() throws SQLException {
		User user = new User(username.getText(), fname.getText(), lname.getText(), gender.getSelectionModel().getSelectedItem(), 0.00);
		registerUser(user, password.getText());
		new Main().changeScene("LoginPage.fxml", "Login page", 400, 400);
	}
	
	public void back() {
		new Main().changeScene("LoginPage.fxml", "Login page", 400, 400);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		gender.setItems(FXCollections.observableArrayList("Male","Female"));
		
	}
	
	public void registerUser(User user, String pass) throws SQLException {
		String query1 = " INSERT INTO `bank`.`userdata` VALUES ('"+user.getUsername()+"','"+user.getFname()+"','"+user.getLname()+"','"+user.getGender()+"',"+0.00+");";
		PreparedStatement ps=SQLcon.con.prepareStatement(query1);
		int i=ps.executeUpdate();
			if(i==1)System.out.println("Registered in userdata");
			else System.out.println("Failed to register in userdata");
		String query2=" INSERT INTO `bank`.`users` VALUES ('"+user.getUsername()+"','"+password.getText()+"');";
		ps=SQLcon.con.prepareStatement(query2);
		int j=ps.executeUpdate();
			if(j==1)System.out.println("Registered in users");
			else System.out.println("Failed to register in users");
	}

}
