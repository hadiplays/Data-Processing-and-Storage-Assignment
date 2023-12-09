import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    void getReturnNull() throws Exception {
        Transaction transaction = new Transaction();
        assertNull(transaction.get("A"));
    }

    @Test
    void putTransactionNotInProgress() throws Exception {
        Transaction transaction = new Transaction();
        assertThrows(Exception.class, () -> {
            transaction.put("A", 5);
        });
    }

    @Test
    void putWithoutCommit() throws Exception {
        Transaction transaction = new Transaction();
        transaction.begin_transaction();
        transaction.put("A", 5);
        assertNull(transaction.get("A"));
    }

    @Test
    void putWithCommit() throws Exception {
        Transaction transaction = new Transaction();
        transaction.begin_transaction();
        transaction.put("A", 6);
        transaction.commit();
        assertEquals(6, transaction.get("A"));
    }

    @Test
    void commitWithoutOpeningTransaction() throws Exception {
        Transaction transaction = new Transaction();
        assertThrows(Exception.class, transaction::commit);
    }

    @Test
    void rollbackWithoutOngoingTransaction() throws Exception {
        Transaction transaction = new Transaction();
        assertThrows(Exception.class, transaction::rollback);
    }

    @Test
    void rollbackWithOngoingTransaction() throws Exception {
        Transaction transaction = new Transaction();
        transaction.begin_transaction();
        transaction.put("B", 10);
        transaction.rollback();
        assertNull(transaction.get("B"));
    }

    /*
     *So to add junit go to File -> Project Structure -> Modules. Then click the plus below module sdk. Then click library and then from maven. In the box that appears type junit.jupiter and hit enter. Once a list appears select the one with version 5.5 or if that isn’t there any version >= 5.0. Then click ok and then apply.
     *
     */
}