package wallet.model;
import java.math.BigDecimal;
public class Transaction {
 	public enum Type {
		DEPOSIT,
		WITHDRAW
	}

	private final int id;
	private final Type type;
	private final BigDecimal amount;
	private final String description;

	public Transaction(int id, Type type, BigDecimal amount, String description){
		this.id=id;
		this.type=type;
		this.amount=amount;
		this.description=description;
	}
	public int getId(){
		return id;
	}
	public Type getType(){
		return type;
	}
	public BigDecimal getAmount(){
		return amount;
	}
	public String getDescription(){
		return description;
	}
}
