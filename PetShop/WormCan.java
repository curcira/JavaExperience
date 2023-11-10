/**
 * simple wormcan class that extend the pet class.
 */
public class WormCan extends Food {
    /**
     * constructor method for the wormcan class. calls the constructor method
     * from the food class.
     * 
     * @param price price of the food 
     * @param weight weight of the food
     */
    public WormCan(float price, float weight) {
        super(price, weight);
    }

    /**
     * Getter method the returns the kind of food as wormcan.
     */
    public String getKind() {
        return "WormCan";
    }

    /**
     * method that determines that the food is for an aquatic pet.
     */
    public boolean isAquatic() {
        return true;
    }

    /**
     * method to print the details of the wormcan as a string.
     */
    public String toString() {
        return String.format("%s\t%.2f\t%.2f", "WormCan", this.price,
                this.weight);
    }

}
