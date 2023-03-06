package Lab2.Homework;


import java.util.Objects;

/**
 * The type Express.
 */
public class Express extends Road {
    private boolean hasIntersection;
    private boolean trucksAllowed;


    /**
     * Instantiates a new Express.
     */
    public Express() { // default
        super();
        this.hasIntersection = false;
        this.trucksAllowed = false;
    }

    /**
     * Instantiates a new Express.
     *
     * @param hasIntersection the has intersection
     * @param trucksAllowed   the trucks allowed
     */
    public Express(boolean hasIntersection, boolean trucksAllowed) {
        super();
        this.hasIntersection = hasIntersection;
        this.trucksAllowed = trucksAllowed;
    }

    /**
     * Instantiates a new Express.
     *
     * @param speedLimit      the speed limit
     * @param length          the length
     * @param hasIntersection the has intersection
     * @param trucksAllowed   the trucks allowed
     */
    public Express(int speedLimit, int length, boolean hasIntersection, boolean trucksAllowed) {
        super(speedLimit, length);
        this.hasIntersection = hasIntersection;
        this.trucksAllowed = trucksAllowed;
    }


    /**
     * Is has intersection boolean.
     *
     * @return the boolean
     */
    public boolean isHasIntersection() {
        return hasIntersection;
    }

    /**
     * Sets has intersection.
     *
     * @param hasIntersection the has intersection
     */
    public void setHasIntersection(boolean hasIntersection) {
        this.hasIntersection = hasIntersection;
    }

    /**
     * Is trucks allowed boolean.
     *
     * @return the boolean
     */
    public boolean isTrucksAllowed() {
        return trucksAllowed;
    }

    /**
     * Sets trucks allowed.
     *
     * @param trucksAllowed the trucks allowed
     */
    public void setTrucksAllowed(boolean trucksAllowed) {
        this.trucksAllowed = trucksAllowed;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Express express = (Express) o;
        return hasIntersection == express.hasIntersection && trucksAllowed == express.trucksAllowed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hasIntersection, trucksAllowed);
    }


    @Override
    public String toString() {
        return "Express{" +
                "hasIntersection=" + hasIntersection +
                ", trucksAllowed=" + trucksAllowed +
                ", speedLimit=" + speedLimit +
                ", length=" + length +
                '}';
    }
}
