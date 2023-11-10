import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A simple pet store that has pets and food things.
 *
 */
public class PetShop {
    /**
     * The items available for sale in this pet shop. The items are added to
     * this list via the addItemsFromFile method.
     */
    private ArrayList<Thing> things;

    /**
     * This is an intermediate summary string that has been used to generate the
     * full summary format below. Don't use this one. Instead, use the
     * SUMMARY_FORMAT string below.
     */
    private static final String SUMMARY_SUB_FORMAT = "    Number of pets      "
            + ": %d%n"
            + "    Total price pets    : $%.2f%n"
            + "    Number of food items: %d%n"
            + "    Total price of food : $%.2f%n";

    /**
     * Format string to print summary of pets and food items in the pet store.
     */
    private static final String SUMMARY_FORMAT = "Summary of items "
            + "in Pet Shop%n"
            + "Aquatic pets & food summary%n"
            + SUMMARY_SUB_FORMAT
            + "Non-aquatic pets & food summary%n"
            + SUMMARY_SUB_FORMAT;

    /**
     * Format string to print food status for the pet store.
     */
    private static final String FOOD_STATUS = "Pet Shop food status:%n"
            + "    Daily aquatic food needed      : %.2f lb%n"
            + "    Daily non-aquatic food needed  : %.2f lb%n"
            + "    Aquatic food stock in store    : %.2f lb%n"
            + "    Non-aquatic food stock in store: %.2f lb%n";
    /**
     * variable to hold the number of non-aquatic pets in the pet shop.
     */
    private int numPets = 0;
    /**
     * variable to hold the number of aquatic pets in the pet shop.
     */
    private int numPetsWater = 0;
    /**
     * variable to hold the amount of aquatic food in the pet shop.
     */
    private int numFoodWater = 0;
    /**
     * variable to hold the amount of non-aquatic food in the pet shop.
     */
    private int numFood = 0;
    /**
     * variable to hold the overall price of the aquatic pets in the pet shop.
     */
    private Float petPriceWater = (float) 0.0;
    /**
     * variable to hold the overall price of non-aquatic pets in the pet shop.
     */
    private Float petPrice = (float) 0.0;
    /**
     * variable to hold the overall price of aquatic food in the pet shop.
     */
    private Float foodPriceWater = (float) 0.0;
    /**
     * variable to hold the overall price of non-aquatic food in the pet shop.
     */
    private Float foodPrice = (float) 0.0;
    /**
     * variable to hold the amount of food needed for non-aquatic pets in the
     * pet shop.
     */
    private Float foodNeeded = (float) 0.0;
    /**
     * variable to hold the amount of food needed for aquatic pets in the pet
     * shop.
     */
    private Float foodNeededWater = (float) 0.0;
    /**
     * variable to hold the amount of food available for the non-aquatic pets in
     * the pet shop.
     */
    private Float foodAmount = (float) 0.0;
    /**
     * variable to hold the amount of food available for the aquatic pets in the
     * pet shop.
     */
    private Float foodAmountWater = (float) 0.0;

    /**
     * Creates an empty shop without any items.
     */
    public PetShop() {
        things = new ArrayList<>();
    }

    /**
     * Returns the number of food objects in the list of things in this pet
     * store.
     * 
     * @return The number of food things currently in the list of things in this
     *         pet store.
     */
    public int getFoodCount() {
        if (things.size() == 0) {
            return 0;
        } else {
            int count = 0;
            for (int i = 0; i < things.size(); i++) {
                if (things.get(i) instanceof Food) {
                    count += 1;
                }
            }
            return count;
        }
    }

    /**
     * Returns the number of pet objects in the list of things in this pet
     * store.
     * 
     * @return The number of pets currently in the list of things in this pet
     *         store.
     */
    public int getPetCount() {
        if (things.size() == 0) {
            return 0;
        } else {
            int count = 0;
            for (int i = 0; i < things.size(); i++) {
                if (things.get(i) instanceof Pet) {
                    count += 1;
                }
            }
            return count;
        }
    }

    /**
     * Adds items loaded from a given text file to the list of items in the
     * store. The items are stored line-by-line in the text file. Each line
     * contains values separated by a tab character. The data in the lines are
     * with: 3-columns for Food: FoodName Price Weight 4-columns for Pet :
     * PetNamme PetKind Price FoodPerDay
     * 
     * @param fileName The text file from where Things are to be added to the
     *                 list of items for sale in the pet store.
     */
    public void addItemsFromFile(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        while (sc.hasNext()) {
            String name = sc.next();
            if (name.equals("Fish")) {
                things.add(new Fish(sc.next(), sc.nextFloat(), sc.nextFloat()));
            } else if (name.equals("Cat")) {
                things.add(new Cat(sc.next(), sc.nextFloat(), sc.nextFloat()));
            } else if (name.equals("Dog")) {
                things.add(new Dog(sc.next(), sc.nextFloat(), sc.nextFloat()));
            } else if (name.equals("Octopus")) {
                things.add(
                        new Octopus(sc.next(), sc.nextFloat(), sc.nextFloat()));
            } else if (name.equals("ChowBag")) {
                things.add(new ChowBag(sc.nextFloat(), sc.nextFloat()));
            } else if (name.equals("WormCan")) {
                things.add(new WormCan(sc.nextFloat(), sc.nextFloat()));
            }
        }

        sc.close();
    }

    /**
     * Interface method to print a summary of the items in the pet store. The
     * summary is computed and printed using the supplied SUMMARY_FORMAT string.
     * 
     * @see SUMMARY_FORMAT
     */
    public void printSummary() {
        for (int i = 0; i < things.size(); i++) {
            if (things.get(i) instanceof Pet) {
                petCount(i);
            } else {
                foodCount(i);
            }
        }
        System.out.printf(SUMMARY_FORMAT, numPetsWater, petPriceWater,
                numFoodWater, foodPriceWater, numPets, petPrice, numFood,
                foodPrice);
    }

    /**
     * Method to calculate the amount and price of the pets (aquatic and
     * non-aquatic) in the pet shop.
     * 
     * @param i integer to get the object from the things array list.
     */
    private void petCount(int i) {
        if (((things.get(i)).isAquatic()) == true) {
            numPetsWater += 1;
            petPriceWater += (things.get(i)).getPrice();
        } else {
            numPets += 1;
            petPrice += (things.get(i)).getPrice();
        }
    }

    /**
     * Method to calculate the amount and price of the food (aquatic and
     * non-aquatic) in the pet shop.
     * 
     * @param i integer to get the object from the things array list.
     */
    private void foodCount(int i) {
        if (((things.get(i)).isAquatic()) == true) {
            numFoodWater += 1;
            foodPriceWater += (things.get(i)).getPrice();
        } else {
            numFood += 1;
            foodPrice += (things.get(i)).getPrice();
        }
    }

    /**
     * A simple method that prints all of the things in the store.
     */
    public void printAllThings() {
        System.out.println("List of all items:");
        for (int i = 0; i < things.size(); i++) {
            System.out.println(things.get(i));
        }
    }

    /**
     * Computes and prints the amount of aquatic and non-aquatic food needed to
     * feed all of the pets in the store along with the amount of food currently
     * available. The food needed by pets is computed by adding the daily food
     * needs of all the pets. The food available is computed by adding the
     * weight of all the food things.
     * 
     * @see FOOD_STATUS
     */
    public void reportFoodStatus() {

        for (int i = 0; i < things.size(); i++) {
            if (things.get(i) instanceof Pet) {
                foodNeeded(i);

            } else {
                foodAmount(i);
            }
        }
        System.out.printf(FOOD_STATUS, foodNeededWater, foodNeeded,
                foodAmountWater, foodAmount);
    }

    /**
     * Method to calculate the amount of food needed for the aquatic and
     * non-aquatic pets in the shop.
     * 
     * @param i integer to get the object from the things array list.
     */
    private void foodNeeded(int i) {
        Pet pet = (Pet) things.get(i);
        if (((things.get(i)).isAquatic()) == true) {
            foodNeededWater += pet.getFoodPerDay();
        } else {
            foodNeeded += pet.getFoodPerDay();
        }
    }

    /**
     * Method to calculate the amount of food available for the aquatic and
     * non-aquatic pets in the shop.
     * 
     * @param i integer to get the object from the things array list.
     */
    private void foodAmount(int i) {
        Food food = (Food) things.get(i);
        if (((things.get(i)).isAquatic()) == true) {
            foodAmountWater += food.getWeight();
        } else {
            foodAmount += food.getWeight();
        }
    }
}
