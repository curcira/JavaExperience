/**
 * abstract food class that extend the thing class.
 */
public abstract class Food extends Thing {
    protected float price;
    protected float weight;

    /**
     * constructor for the food for the pet.
     * 
     * @param price  price of the food
     * @param weight weight of the food
     */
    public Food(float price, float weight) {
        this.price = price;
        this.weight = weight;
    }

    /**
     * getter method for the price of the food.
     */
    public float getPrice() {
        return this.price;
    }

    /**
     * getter method for the weight of the food.
     * 
     * @return returns the weight of the food
     */
    public float getWeight() {
        return this.weight;
    }

    /**
     * method to determine if the two objects are equal.
     */
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Food)) {
            return false;

        }

        Food other = (Food) obj;

        return (getPrice() == other.getPrice() 
                && getWeight() == other.getWeight());
    }

}
