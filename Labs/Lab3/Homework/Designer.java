package Lab3.Homework;

import java.util.HashMap;

/**
 * The type Designer, a child of Person who contains
 * In addition we have a String favouriteWork member and a boolean usesPhotoshop variable.
 * @author Apricopoai Andrei
 * @version 1.0.
 */
public class Designer extends Person{

    private String favouriteArtWork;
    private boolean usesPhotoshop;


    /**
     * Instantiates a new Designer object.
     * @param name             the name
     * @param birthDate        the birthdate
     * @param favouriteArtWork the favourite art work
     * @param usesPhotoshop    the uses photoshop
     */
    public Designer(String name, String birthDate, String favouriteArtWork, boolean usesPhotoshop) {
        super(name, birthDate);
        this.favouriteArtWork = favouriteArtWork;
        this.usesPhotoshop = usesPhotoshop;
    }

    /**
     * Instantiates a new Designer object.
     *
     * @param name             the name
     * @param birthDate        the birthdate
     * @param favouriteArtWork the favourite art work
     * @param usesPhotoshop    the uses photoshop
     * @param realtionships    the realtionships hashmap list
     */
    public Designer(String name, String birthDate,String favouriteArtWork, boolean usesPhotoshop, HashMap<Node, String> realtionships) {
        super(name, birthDate, realtionships);
        this.usesPhotoshop = usesPhotoshop;
        this.favouriteArtWork = favouriteArtWork;
    }


    /**
     * Gets favourite art work.
     *
     * @return the favourite art work
     */
    public String getFavouriteArtWork() {
        return favouriteArtWork;
    }

    /**
     * Sets favourite art work.
     *
     * @param favouriteArtWork the favourite art work
     */
    public void setFavouriteArtWork(String favouriteArtWork) {
        this.favouriteArtWork = favouriteArtWork;
    }

    /**
     * Is uses photoshop boolean.
     *
     * @return the boolean
     */
    public boolean isUsesPhotoshop() {
        return usesPhotoshop;
    }

    /**
     * Sets uses photoshop.
     *
     * @param usesPhotoshop the usesPhotoshop boolean value
     */
    public void setUsesPhotoshop(boolean usesPhotoshop) {
        this.usesPhotoshop = usesPhotoshop;
    }

    /**
     * This function generates a nice textual representation of the Designer object created.
     *
     * @return a nice textual representation of the Designer object created as a String object.
     */
    @Override
    public String toString() {
        return "Designer{" +
                "favouriteArtWork='" + favouriteArtWork + '\'' +
                ", usesPhotoshop=" + usesPhotoshop +
                '}';
    }
}
