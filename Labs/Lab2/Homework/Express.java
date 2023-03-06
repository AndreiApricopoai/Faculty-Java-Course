package Lab2.Homework;


import java.util.Objects;

public class Express extends Road {
    private boolean hasIntersection;
    private boolean trucksAllowed;


    public Express() { // default
        super();
        this.hasIntersection = false;
        this.trucksAllowed = false;
    }

    public Express(boolean hasIntersection, boolean trucksAllowed) {
        super();
        this.hasIntersection = hasIntersection;
        this.trucksAllowed = trucksAllowed;
    }

    public Express(int speedLimit, int length, boolean hasIntersection, boolean trucksAllowed) {
        super(speedLimit, length);
        this.hasIntersection = hasIntersection;
        this.trucksAllowed = trucksAllowed;
    }



    public boolean isHasIntersection() {
        return hasIntersection;
    }

    public void setHasIntersection(boolean hasIntersection) {
        this.hasIntersection = hasIntersection;
    }

    public boolean isTrucksAllowed() {
        return trucksAllowed;
    }

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
