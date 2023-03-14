package Lab3.Homework;

import java.util.HashMap;
import java.util.Map;

/**
 * The  type Company that implements Comparable and Node interfaces.
 * @author Apricopoai Andrei
 * @version 1.0.
 */
public class Company implements Node, Comparable<Company>{

    private String name;
    private int numberOfDepartments;
    private Map<Person,String> employees;

    /**
     * Instantiates a new Company object.
     *
     * @param name                the name
     * @param numberOfDepartments the number of departments
     */
    public Company(String name, int numberOfDepartments) {
        this.name = name;
        this.numberOfDepartments = numberOfDepartments;
        this.employees = new HashMap<>();
    }

    /**
     * Instantiates a new Company object.
     *
     * @param name                the name
     * @param numberOfDepartments the number of departments
     * @param relationships       the relationships
     */
    public Company(String name, int numberOfDepartments, HashMap<Person, String> relationships) {
        this.name = name;
        this.numberOfDepartments = numberOfDepartments;
        this.employees = relationships;
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
     * Gets number of departments.
     *
     * @return the number of departments
     */
    public int getNumberOfDepartments() {
        return numberOfDepartments;
    }

    /**
     * Sets number of departments.
     *
     * @param numberOfDepartments the number of departments
     */
    public void setNumberOfDepartments(int numberOfDepartments) {
        this.numberOfDepartments = numberOfDepartments;
    }

    /**
     * Gets employees.
     *
     * @return the employees
     */
    public Map<Person, String> getEmployees() {
        return employees;
    }

    /**
     * Sets employees.
     *
     * @param employees the employees
     */
    public void setEmployees(HashMap<Person, String> employees) {
        this.employees = employees;
    }


    /**
     * Add employee company.
     * @param person  the person
     * @param context the context
     * @return the company
     */
    public Company addEmployee(Person person, String context){

        // Aici adaugam conexiunea companie -> person.
        this.employees.put(person,context);

        // Aici adaugam conexiunea persoana -> companie.
        person.getRelationships().put(this,context);
        return this;
    }


    /**
     * This method is the implementation of the Node interface.
     * @return the name of the current Person object.
     */
    @Override
    public String getNodeName() {
        return this.getName();
    }


    /**
     * This method is the implementation of the Comparable interface.
     * @param o the Person object that the current object compares itself to.
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
                ", numberOfDepartments=" + numberOfDepartments +
                ", employees=" + employees +
                '}';
    }
}
