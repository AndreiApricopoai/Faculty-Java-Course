package Lab2.Homework;

import java.util.Objects;

/**
 * The type Road.
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
     * Instantiates a new Road.
     */
//Constructors
    public Road() { // default
        this.speedLimit = -1;
        this.length = -1;
    }

    /**
     * Instantiates a new Road.
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return speedLimit == road.speedLimit && length == road.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(speedLimit, length);
    }

    @Override
    public String toString() {
        return "Road{" +
                "speedLimit=" + speedLimit +
                ", length=" + length +
                '}';
    }
}