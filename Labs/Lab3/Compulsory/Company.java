package Lab3.Compulsory;

/**
 * A class representing a Company which implements the Node interface and the Comparable interface.
 * As members, it only has a name object of type String representing the name of the company.
 * @see java.lang.Comparable
 * @see Node
 * @author Apricopoai Andrei
 * @version 1.0
 */
public class Company implements Node, Comparable<Company> {

    private String name;

    /**
     * Constructs a new Company object with the specified name.
     *
     * @param name the name node of the Company object.
     */
    public Company(String name) {
        this.name = name;
    }

    /**
     * This method is the implementation of the Node interface.
     * @return the name of the current Company object.
     */
    @Override
    public String getNodeName() {
        return this.name;
    }

    /**
     * This method is the implementation of the Comparable interface.
     * @param o the Company object that the current object compares itself to.
     * @return an int (-1,0,1) representing whether the first object has lower priority, equal or higher than the second object.
     */
    @Override
    public int compareTo(Company o) {
        return (this.getNodeName().compareTo(o.getNodeName()));
    }


    /**
     * This function generates a nice textual representation of the Company object created.
     *
     * @return a nice textual representation of the Company object created as a String object.
     */
    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }
}
