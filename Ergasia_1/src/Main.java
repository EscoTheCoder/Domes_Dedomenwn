import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Δωσε ακολουθία DNA: ");
        String akolouthia_dna = scanner.nextLine();

        DNAPalindrome dnaPalindrome = new DNAPalindrome();

        System.out.println(dnaPalindrome.check(akolouthia_dna));
    }
}