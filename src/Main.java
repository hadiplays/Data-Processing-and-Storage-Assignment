import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Transaction transaction = new Transaction();

        System.out.println("Welcome, this is an in memory database with transaction support!");
        System.out.println("Type \"QUIT\" to leave the database. Type \"HELP\" for all available commands");
        Scanner scanner = new Scanner(System.in);

        boolean cont = true;

        while (cont) {
            System.out.print(">>> ");
            String input = scanner.nextLine();
            switch(input) {
                case "BEGIN TRANSACTION" -> transaction.begin_transaction();
                case "GET" -> {
                    System.out.println("What key do you want to get?");
                    String key = scanner.nextLine();
                    System.out.println(transaction.get(key));
                }
                case "PUT" -> {
                    System.out.println("What key and value do you want to put?");
                    System.out.print("Key: ");
                    String key = scanner.nextLine();
                    System.out.print("Value: ");
                    String value = scanner.nextLine();

                    transaction.put(key, Integer.parseInt(value));
                }
                case "COMMIT" -> transaction.commit();
                case "ROLLBACK" -> transaction.rollback();
                case "HELP" -> {
                    System.out.println("All Commands:");
                    System.out.println("BEGIN TRANSACTION");
                    System.out.println("GET");
                    System.out.println("PUT");
                    System.out.println("COMMIT");
                    System.out.println("ROLLBACK");
                }
                case "QUIT" -> cont = false;
            }
        }
    }
}