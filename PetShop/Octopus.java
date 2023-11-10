/**
 * Simple cat class that extends the pet class.
 */
public class Octopus extends Pet {
    /**
     * Constructor method for the octopus class. Calls the constructor method
     * the pet class.
     * 
     * @param kind       type of octopus
     * @param price      price of octopus
     * @param foodPerDay amount of food octopus eats per day
     */
    public Octopus(String kind, float price, float foodPerDay) {
        super(kind, price, foodPerDay);
    }

    /**
     * Getter method to get and print the breed of the cat.
     */
    @Override
    public String getKind() {
        return ("Octopus: " + this.kind);
    }

    /**
     * method that determines the octopus is aquatic.
     */
    public boolean isAquatic() {
        return true;
    }

    /**
     * method to print the attributes of the octopus as a string.
     */
    public String toString() {
        return String.format("%s\t%s\t%.2f\t%.2f", "Octopus", this.kind,
                this.price, this.foodPerDay);
    }
}
