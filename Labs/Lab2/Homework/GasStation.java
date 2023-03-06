package Lab2.Homework;

import java.util.Objects;

public class GasStation extends Location{

    private int gallonPrice;
    private int numberOfPumps;

    public GasStation() { // default
        super();
        this.gallonPrice = -1;
        this.numberOfPumps = -1;
    }

    public GasStation(int gallonPrice, int numberOfPumps) {
        super();
        this.gallonPrice = gallonPrice;
        this.numberOfPumps = numberOfPumps;
    }

    public GasStation(String locationName, int xPosition, int yPosition, int gallonPrice, int numberOfPumps) {
        super(locationName, xPosition, yPosition);
        this.gallonPrice = gallonPrice;
        this.numberOfPumps = numberOfPumps;
    }

    public int getGallonPrice() {
        return gallonPrice;
    }

    public void setGallonPrice(int gallonPrice) {
        this.gallonPrice = gallonPrice;
    }

    public int getNumberOfPumps() {
        return numberOfPumps;
    }

    public void setNumberOfPumps(int numberOfPumps) {
        this.numberOfPumps = numberOfPumps;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GasStation that = (GasStation) o;
        return gallonPrice == that.gallonPrice && numberOfPumps == that.numberOfPumps;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gallonPrice, numberOfPumps);
    }

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
