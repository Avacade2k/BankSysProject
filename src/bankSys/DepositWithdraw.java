package bankSys;

public class DepositWithdraw{
	
	public void checkBalance() {
		System.out.println("Checking balance");
		new Main().changeScene("CheckBalance.fxml", "Main", 400, 400);
	}

}
