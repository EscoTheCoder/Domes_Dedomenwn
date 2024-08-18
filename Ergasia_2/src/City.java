class City implements CityInterface, Comparable<City> {

    int id;
    String Name;
    int Population;
    int InfluenzaCases;

    @Override
    public int getID() {
        return id;
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public void setName(String name) {
        this.Name = name;
    }

    @Override
    public int getPopulation() {
        return Population;
    }

    @Override
    public void setPopulation(int population) {
        this.Population = population;
    }

    @Override
    public int getInfluenzaCases() {
        return InfluenzaCases;
    }

    @Override
    public void setInfluenzaCases(int influenzaCases) {
        this.InfluenzaCases = influenzaCases;
    }

    public double calculateDensity() {
        return (double) InfluenzaCases / Population * 50000;
    }

    @Override
    public int compareTo(City other) {
        double thisDensity = this.calculateDensity();
        double otherDensity = other.calculateDensity();

        if (thisDensity < otherDensity) {
            return -1;
        } else if (thisDensity > otherDensity) {
            return 1;
        } else {
            // Σε περίπτωση ισοβαθμίας, πρώτα γίνεται αλφαβητική σύγκριση
            int nameComparison = this.Name.compareTo(other.Name);
            if (nameComparison != 0) {
                return nameComparison;
            } else {
                // Σε περίπτωση που έχουν και ίδιο όνομα, σύγκριση ID
                return Integer.compare(this.id, other.id);
            }
        }
    }
}