import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Εισάγετε την προθεματική παράσταση: ");
        String expression = scanner.nextLine();

        // Καλούμε τη συνάρτηση για μετατροπή
        String result = PrefixToInfix.convertPrefixToInfix(expression);  // Χρήση ονόματος κλάσης για πρόσβαση στη στατική μέθοδο.

        // Εκτυπώνουμε το αποτέλεσμα
        System.out.println("Η ενθεματική παράσταση είναι: " + result);

        scanner.close();
    }

}