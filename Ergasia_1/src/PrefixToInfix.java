public class PrefixToInfix {

    // Έλεγχος αν ο χαρακτήρας είναι τελεστής
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // Μετατροπή προθεματικής παράστασης σε ενθεματική
    public static String convertPrefixToInfix(String expression) {
        StringDoubleEndedQueueImpl queue = new StringDoubleEndedQueueImpl();

        // Διαβάζουμε την παράσταση από το τέλος προς την αρχή
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);

            // Αν είναι τελεστής
            if (isOperator(c)) {
                // Πρέπει να υπάρχουν τουλάχιστον δύο στοιχεία στη στοίβα για να γίνει η μετατροπή
                if (queue.size() < 2) {
                    return "Μη έγκυρη παράσταση!";
                }

                // Ανασύρουμε δύο τελεστέους από τη στοίβα
                String operand1 = queue.removeLast();
                String operand2 = queue.removeLast();

                // Δημιουργούμε την ενθεματική έκφραση και την προσθέτουμε ξανά στη στοίβα
                String infixExpression = "(" + operand1 + " " + c + " " + operand2 + ")";
                queue.addLast(infixExpression);
            }
            // Αν είναι αριθμός, τον προσθέτουμε στη στοίβα
            else if (Character.isDigit(c)) { //ΕΙΣΑΓΩΓΗ ΜΟΝΟ ΑΡΙΘΜΩΝ
                queue.addLast(c + "");
            }
            // Αν βρεθεί κάτι άλλο εκτός από τελεστή ή αριθμό
            else {
                return "Μη έγκυρη παράσταση!";
            }
        }

        // Ελέγχουμε αν υπάρχει μόνο ένα στοιχείο στη στοίβα
        if (queue.size() != 1) {
            return "Μη έγκυρη παράσταση!";
        }

        // Το τελικό αποτέλεσμα είναι το μόνο στοιχείο που έχει απομείνει στη στοίβα
        return queue.removeLast();
    }
}