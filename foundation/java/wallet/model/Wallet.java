package wallet.model;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
public class Wallet {
	private final int walletId;
	private final User owner;
	private BigDecimal balance;
	private final List<Transaction> transactions;

	public Wallet(int walletId, User owner){
		this.walletId=walletId;
		this.owner=owner;
		this.balance=BigDecimal.ZERO;
		this.transactions= new ArrayList<>();
		}

	public void deposit(BigDecimal amount){
		if(amount.compareTo(BigDecimal.ZERO) <= 0) {
		throw new IllegalArgumentException("Deposit amount must be greater than zero");
		}
		balance=balance.add(amount);
		transactions.add(new Transaction(transactions.size() + 1,Transaction.Type.DEPOSIT, amount, "Wallet deposit") );
	}

	public void withdraw(BigDecimal amount){
		if(amount.compareTo(BigDecimal.ZERO) <= 0) {
		 throw new IllegalArgumentException("Withdrawl amount must be greater than zero");
		}if(amount.compareTo(balance) > 0) {
		  throw new IllegalArgumentException("Insufficient balance");
		}
		balance=balance.subtract(amount);
		transactions.add(new Transaction(transactions.size() + 1,Transaction.Type.WITHDRAW, amount, "Wallet withdrawl") );
	}

	public int getWalletId(){
		return walletId;
	}
	 public User getOwner(){
                return owner;
        }
	 public BigDecimal getBalance(){
                return balance;
        }
	public List<Transaction> getTransactions(){
		return List.copyOf(transactions);
	}
}
