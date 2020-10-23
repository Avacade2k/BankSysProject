package bankSys;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
	
	public static Label status = new Label ("Enter account data");

	@Override
	public void start(Stage stage)  {
	    
	    Pane pane = new Pane();
	    
	    TextField usernameInput = new TextField ();
	    usernameInput.setPromptText("Username");
	    TextField passwordInput = new TextField ();
	    passwordInput.setPromptText("Password");
	    
	    Button login = new Button("Login");
	    login.setOnAction((event) -> {
	    	System.out.println("Login");
	    });
	    
	    Button signUp = new Button("Sign up");
	    signUp.setOnAction((event) -> {
	    	System.out.println("Sign up");
	    });
	    
	    pane.getChildren().add(usernameInput);
	    pane.getChildren().add(passwordInput);
	    pane.getChildren().add(login);
	    pane.getChildren().add(status);
	    
	    Scene scene = new Scene (pane,400,400);
	    
	    stage.setScene(scene); 
	    stage.show();
		
	}
	
	public static void main(String[] args) {
		launch();
    }

}
