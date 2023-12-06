public class Main {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello world!");

        Transaction transaction = null;

// should return null, because A doesn’t exist in the DB yet
        transaction.get("A");

// should throw an error because a transaction is not in progress
        transaction.put("A", 5);

// starts a new transaction
        transaction.begin_transaction();

// set’s value of A to 5, but its not committed yet
        transaction.put("A", 5);

// should return null, because updates to A are not committed yet
        transaction.get("A");

// update A’s value to 6 within the transaction
        transaction.put("A", 6);

// commits the open transaction
        transaction.commit();

// should return 6, that was the last value of A to be committed
        transaction.get("A");

// throws an error, because there is no open transaction
        transaction.commit();

// throws an error because there is no ongoing transaction
        transaction.rollback();

// should return null because B does not exist in the database
        transaction.get("B");

// starts a new transaction
        transaction.begin_transaction();

// Set key B’s value to 10 within the transaction
        transaction.put("B", 10);

// Rollback the transaction - revert any changes made to B
        transaction.rollback();

// Should return null because changes to B were rolled back
        transaction.get("B");

    }
}