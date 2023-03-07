package Lab2.Homework;

import java.util.Objects;

/**
 * The type Road.
 * @author Apricopoai Andrei
 * @version 1.0
 */
public abstract class Road {

    /**
     * The Speed limit.
     */
    protected int speedLimit; // (km/h)
    /**
     * The Length.
     */
    protected int length; // (km)

    /**
     * Instantiates a new default Road object.
     */
    public Road() { // default
        this.speedLimit = -1;
        this.length = -1;
    }

    /**
     * Instantiates a new Road object.
     *
     * @param speedLimit the speed limit
     * @param length     the length
     */
    public Road(int speedLimit, int length) {
        this.speedLimit = speedLimit;
        this.length = length;
    }


    /**
     * Gets speed limit.
     *
     * @return the speed limit
     */
    public int getSpeedLimit() {
        return speedLimit;
    }

    /**
     * Sets speed limit.
     *
     * @param speedLimit the speed limit
     */
    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    /**
     * Gets length.
     *
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets length.
     *
     * @param length the length
     */
    public void setLength(int length) {
        this.length = length;
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
        Road road = (Road) o;
        return speedLimit == road.speedLimit && length == road.length;
    }

    /**
     * This is a hashing function.
     * @return an int representing the hash-ed value of the members.
     */
    @Override
    public int hashCode() {
        return Objects.hash(speedLimit, length);
    }

    /**
     * This constructs a String object representing the object info.
     * @return a String object representing the object info.
     */
    @Override
    public String toString() {
        return "Road{" +
                "speedLimit=" + speedLimit +
                ", length=" + length +
                '}';
    }
}