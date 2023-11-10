/**
 * Simple fish class that extends the pet class.
 */
public class Fish extends Pet {

    /**
     * Constructor method for the fish class. Calls the constructor from the
     * pet class.
     * 
     * @param kind       type of fish
     * @param price      price of fish
     * @param foodPerDay amount of food fish eats per day
     */
    public Fish(String kind, float price, float foodPerDay) {
        super(kind, price, foodPerDay);
    }

    /**
     * Getter method to get and print the type of the fish.
     */
    @Override
    public String getKind() {
        return ("Fish: " + this.kind);
    }

    /**
     * method that determines the fish is aquatic.
     */
    public boolean isAquatic() {
        return true;
    }

    /**
     * method that prints the attributes of the fish as a string.
     */
    public String toString() {
        return String.format("%s\t%s\t%.2f\t%.2f", "Fish", this.kind,
                this.price, this.foodPerDay);
    }

}
