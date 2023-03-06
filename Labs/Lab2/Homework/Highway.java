package Lab2.Homework;


import java.util.Objects;

/**
 * The type Highway.
 */
public class Highway extends Road {

    private int numberOfLanes;
    private int getNumberOfExits;

    /**
     * Instantiates a new Highway.
     */
    public Highway() {
        super();
        this.numberOfLanes = -1;
        this.getNumberOfExits = -1;
    }

    /**
     * Instantiates a new Highway.
     *
     * @param numberOfLanes    the number of lanes
     * @param getNumberOfExits the get number of exits
     */
    public Highway(int numberOfLanes, int getNumberOfExits) {
        this.numberOfLanes = numberOfLanes;
        this.getNumberOfExits = getNumberOfExits;
    }

    /**
     * Instantiates a new Highway.
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Highway highway = (Highway) o;
        return numberOfLanes == highway.numberOfLanes && getNumberOfExits == highway.getNumberOfExits;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfLanes, getNumberOfExits);
    }


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
