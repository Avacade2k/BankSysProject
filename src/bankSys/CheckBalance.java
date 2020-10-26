package bankSys;

public class CheckBalance {
	
	public void checkBalance() {
		
	}
	
	public void signOut() {
		System.out.println("Signing out");
		new Main().changeScene("LoginPage.fxml", "Login page", 400, 400);
	}

}
