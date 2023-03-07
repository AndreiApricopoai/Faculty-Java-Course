package Lab2.Homework;

import java.util.Objects;

/**
 * The type Restaurant.
 * @author Apricopoai Andrei
 * @version 1.0
 *
 */
public class Restaurant extends Location{

    private int rating;
    private int numberOfTables;

    /**
     * Instantiates a new default Restaurant object.
     */
    public Restaurant(){ // default
        super();
        this.numberOfTables = -1;
        this.rating = -1;
    }

    /**
     * Instantiates a new Restaurant object.
     *
     * @param rating         the rating
     * @param numberOfTables the number of tables
     */
    public Restaurant(int rating, int numberOfTables) {
        super();
        this.rating = rating;
        this.numberOfTables = numberOfTables;
    }

    /**
     * Instantiates a new Restaurant.
     *
     * @param locationName   the location name
     * @param xPosition      the x position
     * @param yPosition      the y position
     * @param rating         the rating
     * @param numberOfTables the number of tables
     */
    public Restaurant(String locationName, int xPosition, int yPosition, int rating, int numberOfTables) {
        super(locationName, xPosition, yPosition);
        this.rating = rating;
        this.numberOfTables = numberOfTables;
    }


    /**
     * Gets rating.
     *
     * @return the rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * Sets rating.
     *
     * @param rating the rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Gets number of tables.
     *
     * @return the number of tables
     */
    public int getNumberOfTables() {
        return numberOfTables;
    }

    /**
     * Sets number of tables.
     *
     * @param numberOfTables the number of tables
     */
    public void setNumberOfTables(int numberOfTables) {
        this.numberOfTables = numberOfTables;
    }


    /**
     * This is the implementation of the method equals() from the Object class.
     * @param o the second object that we compare the current one to.
     * @return a boolean value representing whether the two objects are equal or not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Restaurant that = (Restaurant) o;
        return rating == that.rating && numberOfTables == that.numberOfTables;
    }

    /**
     * This is a hashing function.
     * @return an int representing the hash-ed value of the members.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rating, numberOfTables);
    }



    /**
     * This constructs a String object representing the object info.
     * @return a String object representing the object info.
     */
    @Override
    public String toString() {
        return "Restaurant{" +
                "rating=" + rating +
                ", numberOfTables=" + numberOfTables +
                ", locationName='" + locationName + '\'' +
                ", xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                '}';
    }
}
