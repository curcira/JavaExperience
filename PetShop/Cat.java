/**
 * Simple cat class that extends the pet class.
 */
public class Cat extends Pet {

    /**
     * Constructor method for the cat class. Calls the constructor method from
     * the pet class.
     * 
     * @param kind       breed of cat
     * @param price      price of cat
     * @param foodPerDay amount of food cat eats per day
     */
    public Cat(String kind, float price, float foodPerDay) {
        super(kind, price, foodPerDay);
    }

    /**
     * Getter method to get and print the breed of the cat.
     */
    @Override
    public String getKind() {
        return ("Cat: " + this.kind);
    }

    /**
     * method that determines the cat is not aquatic.
     */
    public boolean isAquatic() {
        return false;
    }

    /**
     * method to print the details of the cat as a string.
     */
    public String toString() {
        return String.format("%s\t%s\t%.2f\t%.2f", "Cat", this.kind, this.price,
                this.foodPerDay);
    }

}
