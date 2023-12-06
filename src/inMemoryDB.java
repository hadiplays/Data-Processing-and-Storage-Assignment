import java.util.HashMap;

// In-memory key-value database
public interface inMemoryDB {
    int get (String key);

    void put (String key, int val) throws Exception;

    void begin_transaction () throws Exception;

    void commit () throws Exception;

    void rollback () throws Exception;
}
