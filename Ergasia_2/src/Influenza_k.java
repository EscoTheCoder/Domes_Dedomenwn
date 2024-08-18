import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Influenza_k {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Influenza_k <k> <input_file>");
            return;
        }

        int k = Integer.parseInt(args[0]);
        String fileName = args[1];

        List<City> cities = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int id = Integer.parseInt(parts[0]);
                StringBuilder nameBuilder = new StringBuilder();
                int i = 1;
                // Ανίχνευση του πληθυσμού που είναι ο πρώτος ακέραιος αριθμός μετά το όνομα της πόλης
                while (!parts[i].matches("\\d+")) {
                    if (i > 1) nameBuilder.append(" ");
                    nameBuilder.append(parts[i]);
                    i++;
                }
                String name = nameBuilder.toString();
                int population = Integer.parseInt(parts[i]);
                int influenzaCases = Integer.parseInt(parts[i + 1]);

                City city = new City();
                city.setID(id);
                city.setName(name);
                city.setPopulation(population);
                city.setInfluenzaCases(influenzaCases);

                cities.add(city);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Έλεγχος αν το k είναι μεγαλύτερο από το πλήθος των πόλεων
        if (k > cities.size()) {
            System.out.println("Error: k is larger than the number of cities.");
            return;
        }

        // Ταξινόμηση των πόλεων
        quicksort(cities,0,cities.size()-1);

        // Εκτύπωση των k πόλεων με τη μικρότερη πυκνότητα κρουσμάτων
        System.out.println("The top " + k + " cities are:");
        for (int i = 0; i < k; i++) {
            System.out.println(cities.get(i).getName());
        }
    }

    public static void quicksort(List<City> cities, int start, int finish) {
        int pos;
        if (start < finish) {
            pos = partition(cities, start, finish);
            quicksort(cities, start, pos - 1);
            quicksort(cities, pos + 1, finish);
        }
    }

    public static int partition(List<City> cities, int start, int finish) {
        City pivot = cities.get(start);
        int i = start + 1;
        int j = finish;

        while (true) {
            // Βρίσκουμε την πρώτη πόλη που έχει πυκνότητα μεγαλύτερη από το pivot
            while (i <= finish && cities.get(i).compareTo(pivot) <= 0) {
                i++;
            }
            // Βρίσκουμε την πρώτη πόλη που έχει πυκνότητα μικρότερη ή ίση από το pivot
            while (j >= start && cities.get(j).compareTo(pivot) > 0) {
                j--;
            }
            if (i < j) {
                // Αντικατάσταση του cities[i] με το cities[j]
                City temp = cities.get(i);
                cities.set(i, cities.get(j));
                cities.set(j, temp);
            } else {
                // Τερματισμός ανταλλάσσοντας το pivot με το cities[j]
                cities.set(start, cities.get(j));
                cities.set(j, pivot);
                return j;
            }
        }
    }

}