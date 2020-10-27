package bankSys;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	static Stage pstage;

	@Override
	public void start(Stage main)  {
	    
		pstage=main;
		changeScene("LoginPage.fxml","Login page",400,400);
		
	}
	
	public void changeScene(String gui,String title,int width,int height) {
		try {
			Parent root=FXMLLoader.load(getClass().getResource(gui));//loading FXML
			Scene scene = new Scene(root,width,height);  //setting size of the window 
			pstage.setScene(scene);  // setting scene
			pstage.setTitle(title); //Title of the window
			pstage.setResizable(false); //Making window non resizable
			pstage.show();  //Showing window
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		SQLcon.connectDB("jdbc:mysql://localhost:3306/?user=root","root",""); //connectDB(url,user,password);
		launch();
    }

}	
