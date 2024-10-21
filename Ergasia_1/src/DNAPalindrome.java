public class DNAPalindrome {

    // Ελέγχει αν το DNA είναι συμπληρωματικό παλίνδρομο
    public boolean check(String dna) {
        StringBuilder complementedString = new StringBuilder();

        StringDoubleEndedQueueImpl queue = new StringDoubleEndedQueueImpl();

        // Διατρέχουμε το DNA από το τέλος προς την αρχή και χτίζουμε το συμπληρωματικό
        for (int i = dna.length() - 1; i >= 0; i--) {
            queue.addLast(String.valueOf(dna.charAt(i)));
            String base = queue.getLast();
            complementedString.append(complement(base));
        }

        // Έλεγχος αν το DNA είναι παλίνδρομο συμπληρωματικό
        System.out.println(dna + " " + complementedString.toString());
        return dna.contentEquals(complementedString);
    }

    // Επιστρέφει το συμπλήρωμα μιας βάσης DNA
    public String complement(String base) {
        switch (base) {
            case "A": return "T";
            case "T": return "A";
            case "C": return "G";
            case "G": return "C";
            default: throw new IllegalArgumentException("Μη έγκυρη βάση DNA: " + base);
        }
    }
}
