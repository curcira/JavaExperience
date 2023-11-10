/**
 * Simple chowbag class that extends the pet class.
 */
public class ChowBag extends Food {

    /**
     * Constructor method for the chowbag class. calls the constructor method
     * from the food class.
     * 
     * @param price  price of the food
     * @param weight weight of the food
     */
    public ChowBag(float price, float weight) {
        super(price, weight);
    }

    /**
     * Getter method that returns the kind of food.
     */
    public String getKind() {
        return "ChowBag";
    }

    /**
     * Method that determines that the food is not for an aquatic pet.
     */
    public boolean isAquatic() {
        return false;
    }

    /**
     * method to print the details of the chowbag as a string.
     */
    public String toString() {
        return String.format("%s\t%.2f\t%.2f", "ChowBag", this.price,
                this.weight);
    }

}
