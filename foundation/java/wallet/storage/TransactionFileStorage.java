package wallet.storage;

import wallet.model.Transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
public class TransactionFileStorage{
	private final Path file;

	public TransactionFileStorage(Path file){
	this.file=file;
	}
	public void save(Transaction transaction) throws IOException {
		String line = transaction.getId() + " | " + transaction.getAmount() + " | "
		 + transaction.getDescription() + " | " + transaction.getType() + System.lineSeparator();
	  Files.writeString(file,line, StandardOpenOption.CREATE , StandardOpenOption.APPEND);
}
	public List<String> readAll() throws IOException {
		return Files.readAllLines(file);
	}
}
