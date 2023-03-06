package Lab2.Homework;

import java.util.Objects;

public class Restaurant extends Location{

    private int rating;
    private int numberOfTables;

    public Restaurant(){ // default
        super();
        this.numberOfTables = -1;
        this.rating = -1;
    }

    public Restaurant(int rating, int numberOfTables) {
        super();
        this.rating = rating;
        this.numberOfTables = numberOfTables;
    }

    public Restaurant(String locationName, int xPosition, int yPosition, int rating, int numberOfTables) {
        super(locationName, xPosition, yPosition);
        this.rating = rating;
        this.numberOfTables = numberOfTables;
    }




    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getNumberOfTables() {
        return numberOfTables;
    }

    public void setNumberOfTables(int numberOfTables) {
        this.numberOfTables = numberOfTables;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Restaurant that = (Restaurant) o;
        return rating == that.rating && numberOfTables == that.numberOfTables;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rating, numberOfTables);
    }


    @Override
    public String toString() {
        return "Restaurant{" +
                "rating=" + rating +
                ", numberOfTables=" + numberOfTables +
                ", locationName='" + locationName + '\'' +
                ", xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                '}';
    }
}
