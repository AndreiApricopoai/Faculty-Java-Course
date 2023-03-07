package Lab2.Homework;

import java.util.Objects;

/**
 * The type Airport. This class extends the Location abstract class.
 * @author Apricopoai Andrei
 * @version 1.0
 */
public class Airport extends Location{

    private int numberOfTerminals;
    private int maxCapacity;

    /**
     * Instantiates a new default Airport object.
     */
    public Airport() { // default
        super();
        this.numberOfTerminals = -1;
        this.maxCapacity = -1;
    }

    /**
     * Instantiates a new Airport object.
     *
     * @param numberOfTerminals the number of terminals
     * @param maxCapacity       the max capacity
     */
    public Airport(int numberOfTerminals, int maxCapacity) {
        super();
        this.numberOfTerminals = numberOfTerminals;
        this.maxCapacity = maxCapacity;
    }

    /**
     * Instantiates a new Airport.
     *
     * @param locationName      the location name
     * @param xPosition         the x position
     * @param yPosition         the y position
     * @param numberOfTerminals the number of terminals
     * @param maxCapacity       the max capacity
     */
    public Airport(String locationName, int xPosition, int yPosition, int numberOfTerminals, int maxCapacity) {
        super(locationName, xPosition, yPosition);
        this.numberOfTerminals = numberOfTerminals;
        this.maxCapacity = maxCapacity;
    }


    /**
     * Gets number of terminals.
     *
     * @return the number of terminals
     */
    public int getNumberOfTerminals() {
        return numberOfTerminals;
    }

    /**
     * Sets number of terminals.
     *
     * @param numberOfTerminals the number of terminals
     */
    public void setNumberOfTerminals(int numberOfTerminals) {
        this.numberOfTerminals = numberOfTerminals;
    }

    /**
     * Gets max capacity.
     *
     * @return the max capacity
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * Sets max capacity.
     *
     * @param maxCapacity the max capacity
     */
    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
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
        Airport airport = (Airport) o;
        return numberOfTerminals == airport.numberOfTerminals && maxCapacity == airport.maxCapacity;
    }


    /**
     * This is a hashing function.
     * @return an int representing the hash-ed value of the members.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfTerminals, maxCapacity);
    }


    /**
     * This constructs a String object representing the object info.
     * @return a String object representing the object info.
     */
    @Override
    public String toString() {
        return "Airport{" +
                "numberOfTerminals=" + numberOfTerminals +
                ", maxCapacity=" + maxCapacity +
                ", locationName='" + locationName + '\'' +
                ", xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                '}';
    }
}
