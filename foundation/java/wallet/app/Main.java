package wallet.app;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.io.IOException;
import wallet.storage.TransactionFileStorage;
import wallet.model.Transaction;
import wallet.model.User;
import wallet.model.Wallet;
public class Main {
	public static void main(String args[]){
	User user = new User(11,"Amjed","amjed@gmail.com");
	Wallet wallet =new Wallet(1000,user);
	wallet.deposit(new BigDecimal("500.00"));
	wallet.withdraw(new BigDecimal("150.00"));
	Path filePath = Path.of("storage/transactions.txt");
	TransactionFileStorage storage = new TransactionFileStorage(filePath);
	try{
		storage.save(new Transaction(1,Transaction.Type.DEPOSIT,new BigDecimal("500.00"),"wallet deposit"));
		storage.save(new Transaction(2,Transaction.Type.WITHDRAW,new BigDecimal("150.00"),"wallet withdraw"));
		System.out.println("Transactions saved ");
	}catch(IOException e ){
	System.out.println("failed to save Transaction");
	e.printStackTrace();
	}

	System.out.println("\nSaved Transactions: ");
	try{
		for(String line: storage.readAll()){
			System.out.println(line);
		}
         }catch(IOException e){
	     System.out.println("failed to read  Transactions");
             e.printStackTrace();
        }

	System.out.println("Owner: "+wallet.getOwner().getName());
	System.out.println("Balance: "+wallet.getBalance());
	System.out.println("\nTransaction");
	for(Transaction transaction : wallet.getTransactions()){
	System.out.println(transaction.getId() + " | " + transaction.getType() + " | " + transaction.getAmount() + " | " + transaction.getDescription());
	}
}}
