package Lab2.Homework;


import java.util.Objects;

public class Highway extends Road {

    private int numberOfLanes;
    private int getNumberOfExits;

    public Highway() {
        super();
        this.numberOfLanes = -1;
        this.getNumberOfExits = -1;
    }

    public Highway(int numberOfLanes, int getNumberOfExits) {
        this.numberOfLanes = numberOfLanes;
        this.getNumberOfExits = getNumberOfExits;
    }

    public Highway(int speedLimit, int length, int numberOfLanes, int getNumberOfExits) {
        super(speedLimit, length);
        this.numberOfLanes = numberOfLanes;
        this.getNumberOfExits = getNumberOfExits;
    }

    public int getNumberOfLanes() {
        return numberOfLanes;
    }

    public void setNumberOfLanes(int numberOfLanes) {
        this.numberOfLanes = numberOfLanes;
    }

    public int getGetNumberOfExits() {
        return getNumberOfExits;
    }

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
