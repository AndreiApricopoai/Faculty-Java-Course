package Lab2.Homework;

import java.util.Objects;

/**
 * The type Gas station.
 * This class extends Location abstract class.
 * @author Apricopoai Andrei
 * @version 1.0
 */
public class GasStation extends Location{

    private int gallonPrice;
    private int numberOfPumps;

    /**
     * Instantiates a new default Gas station object.
     */
    public GasStation() { // default
        super();
        this.gallonPrice = -1;
        this.numberOfPumps = -1;
    }

    /**
     * Instantiates a new Gas station object.
     *
     * @param gallonPrice   the gallon price
     * @param numberOfPumps the number of pumps
     */
    public GasStation(int gallonPrice, int numberOfPumps) {
        super();
        this.gallonPrice = gallonPrice;
        this.numberOfPumps = numberOfPumps;
    }

    /**
     * Instantiates a new Gas station.
     *
     * @param locationName  the location name
     * @param xPosition     the x position
     * @param yPosition     the y position
     * @param gallonPrice   the gallon price
     * @param numberOfPumps the number of pumps
     */
    public GasStation(String locationName, int xPosition, int yPosition, int gallonPrice, int numberOfPumps) {
        super(locationName, xPosition, yPosition);
        this.gallonPrice = gallonPrice;
        this.numberOfPumps = numberOfPumps;
    }

    /**
     * Gets gallon price.
     *
     * @return the gallon price
     */
    public int getGallonPrice() {
        return gallonPrice;
    }

    /**
     * Sets gallon price.
     *
     * @param gallonPrice the gallon price
     */
    public void setGallonPrice(int gallonPrice) {
        this.gallonPrice = gallonPrice;
    }

    /**
     * Gets number of pumps.
     *
     * @return the number of pumps
     */
    public int getNumberOfPumps() {
        return numberOfPumps;
    }

    /**
     * Sets number of pumps.
     *
     * @param numberOfPumps the number of pumps
     */
    public void setNumberOfPumps(int numberOfPumps) {
        this.numberOfPumps = numberOfPumps;
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
        GasStation that = (GasStation) o;
        return gallonPrice == that.gallonPrice && numberOfPumps == that.numberOfPumps;
    }



    /**
     * This is a hashing function.
     * @return an int representing the hash-ed value of the members.
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gallonPrice, numberOfPumps);
    }



    /**
     * Constructs a String object which contains the details of the current GasStation object.
     * @return a nice textual representation of the GasStation object as a String object.
     */
    @Override
    public String toString() {
        return "GasStation{" +
                "gallonPrice=" + gallonPrice +
                ", numberOfPumps=" + numberOfPumps +
                ", locationName='" + locationName + '\'' +
                ", xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                '}';
    }
}
