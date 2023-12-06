import java.util.HashMap;
import java.util.Map;

public class Transaction implements inMemoryDB {
    HashMap<String, Integer> dB = new HashMap<String, Integer>();
    HashMap<String, Integer> temp = new HashMap<String, Integer>();

    Boolean transaction = false;

    // Will return the value associated with the key or null if the key does not exist
    // Can be called anytime even when a transaction is not in progress
    @Override
    public int get(String key) {
        return dB.get(key);
    }

    // Will create a new key with the provided value if a key does not exist.
    // Otherwise, it will update the value of an existing key.
    @Override
    public void put(String key, int val) throws Exception {
        // If transaction has not begun throw exception, else call put method
        if (!transaction) throw new Exception("Transaction is not in progress");
        temp.put(key, val);
    }

    // Starts a new transaction
    // At a time only a single transaction may exist
    // Within a transaction you can make as many changes to as many keys as you like
    // However, they should not be “visible” to get(), until the transaction is committed
    // A transaction ends when either commit() or rollback() is called
    @Override
    public void begin_transaction() throws Exception {
        if (transaction) throw new Exception("Cannot have more than one open transactions");
        transaction = true;
    }

    // Applies changes made within the transaction to the main state.
    // Allowing any future gets() to “see” the changes made within the transaction
    @Override
    public void commit() throws Exception {
        if (!transaction) throw new Exception("No open transaction");
        transaction = false;
        dB.putAll(temp);
    }

    // Should abort all the changes made within the transaction and everything should go back to the way it was before.
    @Override
    public void rollback() throws Exception {
        if (!transaction) throw new Exception("No ongoing transaction");
        transaction = false;
        temp = new HashMap<String, Integer>();
    }
}
