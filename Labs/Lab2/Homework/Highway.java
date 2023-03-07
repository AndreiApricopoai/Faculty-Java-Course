package Lab2.Homework;


import java.util.Objects;

/**
 * The type Highway that extends the Road abstract class.
 * @author Apricopoai Andrei
 * @version 1.0
 */
public class Highway extends Road {

    private int numberOfLanes;
    private int getNumberOfExits;

    /**
     * Instantiates a new default Highway object.
     */
    public Highway() {
        super();
        this.numberOfLanes = -1;
        this.getNumberOfExits = -1;
    }

    /**
     * Instantiates a new Highway object.
     *
     * @param numberOfLanes    the number of lanes
     * @param getNumberOfExits the get number of exits
     */
    public Highway(int numberOfLanes, int getNumberOfExits) {
        this.numberOfLanes = numberOfLanes;
        this.getNumberOfExits = getNumberOfExits;
    }

    /**
     * Instantiates a new Highway object.
     *
     * @param speedLimit       the speed limit
     * @param length           the length
     * @param numberOfLanes    the number of lanes
     * @param getNumberOfExits the get number of exits
     */
    public Highway(int speedLimit, int length, int numberOfLanes, int getNumberOfExits) {
        super(speedLimit, length);
        this.numberOfLanes = numberOfLanes;
        this.getNumberOfExits = getNumberOfExits;
    }

    /**
     * Gets number of lanes.
     *
     * @return the number of lanes
     */
    public int getNumberOfLanes() {
        return numberOfLanes;
    }

    /**
     * Sets number of lanes.
     *
     * @param numberOfLanes the number of lanes
     */
    public void setNumberOfLanes(int numberOfLanes) {
        this.numberOfLanes = numberOfLanes;
    }

    /**
     * Gets get number of exits.
     *
     * @return the get number of exits
     */
    public int getGetNumberOfExits() {
        return getNumberOfExits;
    }

    /**
     * Sets get number of exits.
     *
     * @param getNumberOfExits the get number of exits
     */
    public void setGetNumberOfExits(int getNumberOfExits) {
        this.getNumberOfExits = getNumberOfExits;
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
        Highway highway = (Highway) o;
        return numberOfLanes == highway.numberOfLanes && getNumberOfExits == highway.getNumberOfExits;
    }


    /**
     * This is a hashing function.
     * @return an int representing the hash-ed value of the members.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfLanes, getNumberOfExits);
    }




    /**
     * Constructs a String object which contains the details of the current GasStation object.
     * @return a nice textual representation of the GasStation object as a String object.
     */
    @Override
    public String toString() {
        return "Highway{" +
                "numberOfLanes=" + numberOfLanes +
                ", getNumberOfExits=" + getNumberOfExits +
                ", speedLimit=" + speedLimit +
                ", length=" + length +
                '}';
    }
}
