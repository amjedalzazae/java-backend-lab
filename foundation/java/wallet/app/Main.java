package wallet.app;
import java.math.BigDecimal;
import wallet.model.Transaction;
import wallet.model.User;
import wallet.model.Wallet;
public class Main {
	public static void main(String args[]){
	User user = new User(11,"Amjed","amjed@gmail.com");
	Wallet wallet =new Wallet(1000,user);
	wallet.deposit(new BigDecimal("500.00"));
	wallet.withdraw(new BigDecimal("150.00"));
	System.out.println("Owner: "+wallet.getOwner().getName());
	System.out.println("Balance: "+wallet.getBalance());
	System.out.println("\nTransaction");
	for(Transaction transaction : wallet.getTransactions()){
	System.out.println(transaction.getId() + " | " + transaction.getType() + " | " + transaction.getAmount() + " | " + transaction.getDescription());
	}
}}
