package org.example.andrei;

import java.util.Objects;

/**
 * The type Project.
 * @author Apricopoai Andrei
 * @version 1.0
 */
public class Project implements Comparable<Project> {

    private String name;
    private String presentationDate;


    /**
     * Instantiates a new Project.
     *
     * @param name             the name
     * @param presentationDate the presentation date
     */
    public Project(String name, String presentationDate) {
        this.name = name;
        this.presentationDate = presentationDate;
    }


    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets presentation date.
     *
     * @return the presentation date
     */
    public String getPresentationDate() {
        return presentationDate;
    }

    /**
     * Sets presentation date.
     *
     * @param presentationDate the presentation date
     */
    public void setPresentationDate(String presentationDate) {
        this.presentationDate = presentationDate;
    }


    /**
     * This method is the implementation of the Comparable interface.
     * @param o the Company object that the current object compares itself to.
     * @return an int (-1,0,1) representing whether the first object has lower priority, equal or higher than the second object.
     */
    @Override
    public int compareTo(Project o) {
        return (this.getName().compareTo(o.getName()));
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
        Project p = (Project) o;
        return Objects.equals(name, p.name) && Objects.equals(presentationDate, p.presentationDate);
    }

    /**
     * This is a hashing function.
     * @return an int representing the hash-ed value of the members.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, presentationDate);
    }




    /**
     * This constructs a String object representing the object info.
     * @return a String object representing the object info.
     */
    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", presentationDate='" + presentationDate + '\'' +
                '}';
    }
}
