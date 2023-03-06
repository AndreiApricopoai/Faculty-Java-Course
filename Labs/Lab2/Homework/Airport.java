package Lab2.Homework;

import java.util.Objects;

public class Airport extends Location{

    private int numberOfTerminals;
    private int maxCapacity;

    public Airport() { // default
        super();
        this.numberOfTerminals = -1;
        this.maxCapacity = -1;
    }

    public Airport(int numberOfTerminals, int maxCapacity) {
        super();
        this.numberOfTerminals = numberOfTerminals;
        this.maxCapacity = maxCapacity;
    }

    public Airport(String locationName, int xPosition, int yPosition, int numberOfTerminals, int maxCapacity) {
        super(locationName, xPosition, yPosition);
        this.numberOfTerminals = numberOfTerminals;
        this.maxCapacity = maxCapacity;
    }


    public int getNumberOfTerminals() {
        return numberOfTerminals;
    }

    public void setNumberOfTerminals(int numberOfTerminals) {
        this.numberOfTerminals = numberOfTerminals;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Airport airport = (Airport) o;
        return numberOfTerminals == airport.numberOfTerminals && maxCapacity == airport.maxCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfTerminals, maxCapacity);
    }

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
