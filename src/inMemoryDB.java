// In-memory key-value database
public interface inMemoryDB {
    Object get (String key);

    void put (String key, int val) throws Exception;

    void begin_transaction () throws Exception;

    void commit () throws Exception;

    void rollback () throws Exception;
}
