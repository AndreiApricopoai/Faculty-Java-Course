package Lab2.Homework;

import java.util.Objects;

public abstract class Road {

    protected int speedLimit; // (km/h)
    protected int length; // (km)

    //Constructors
    public Road() { // default
        this.speedLimit = -1;
        this.length = -1;
    }

    public Road(int speedLimit, int length) {
        this.speedLimit = speedLimit;
        this.length = length;
    }



    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public int getLength() {
        return length;
    }

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