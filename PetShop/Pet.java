/**
 * abstract pet class that extends the thing class.
 */
public abstract class Pet extends Thing {
    protected String kind;
    protected float price;
    protected float foodPerDay;

    /**
     * constructor for the pet.
     * 
     * @param kind       breed/type of the pet
     * @param price      price of the pet
     * @param foodPerDay amount of food pet eats per day
     */
    public Pet(String kind, float price, float foodPerDay) {
        this.kind = kind;
        this.price = price;
        this.foodPerDay = foodPerDay;

    }

    /**
     * getter method for the price of the food.
     */
    public float getPrice() {
        return this.price;

    }

    /**
     * getter method for the food the pet eats per day.
     * 
     * @return
     */
    public float getFoodPerDay() {
        return this.foodPerDay;
    }

    /**
     * method to determine if the two objects are equal.
     */
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Pet)) {
            return false;

        }

        Pet other = (Pet) obj;

        return (this.kind.equals(other.kind));
    }

}
