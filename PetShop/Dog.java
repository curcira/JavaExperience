/**
 * Simple dog class that extends the pet class.
 */
public class Dog extends Pet {

    /**
     * Constructor method for the dog class. Calls the constructor method from
     * the pet class.
     * 
     * @param kind       breed of dog
     * @param price      price of dog
     * @param foodPerDay amount of food dog eats per day
     */
    public Dog(String kind, float price, float foodPerDay) {
        super(kind, price, foodPerDay);
    }

    /**
     * Getter method to get and print the breed of the dog.
     */
    @Override
    public String getKind() {
        return ("Dog: " + this.kind);
    }

    /**
     * method that determines that the dog is not aquatic.
     */
    public boolean isAquatic() {
        return false;
    }

    /**
     * method to print the details of the dog as a string.
     */
    public String toString() {
        return String.format("%s\t%s\t%.2f\t%.2f", "Dog", this.kind, this.price,
                this.foodPerDay);
    }
}
