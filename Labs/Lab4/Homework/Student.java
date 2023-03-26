package Lab4.Homework;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * The type Student.
 * @author Apricopoai Andrei
 * @version 1.0
 */

public class Student implements Comparable<Student>{

    private String name;
    private int age;
    private Set<Project> admissibleProjects;

    /**
     * Instantiates a new Student.
     *
     * @param name the name
     * @param age  the age
     */
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.admissibleProjects = new TreeSet<>();
    }


    /**
     * Instantiates a new Student.
     *
     * @param name               the name
     * @param age                the age
     * @param admissibleProjects the admissible projects
     */
    public Student(String name, int age, Set<Project> admissibleProjects) {
        this.name = name;
        this.age = age;
        this.admissibleProjects = admissibleProjects;
    }

    /**
     * Add admissible project student.
     *
     * @param project the project
     * @return the student
     */
    public Student addAdmissibleProject(Project project){
        this.admissibleProjects.add(project);
        return this;

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
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Gets admissible projects.
     *
     * @return the admissible projects
     */
    public Set<Project> getAdmissibleProjects() {
        return admissibleProjects;
    }

    /**
     * Sets admissible projects.
     *
     * @param admissibleProjects the admissible projects
     */
    public void setAdmissibleProjects(Set<Project> admissibleProjects) {
        this.admissibleProjects = admissibleProjects;
    }



    /**
     * This method is the implementation of the Comparable interface.
     * @param o the Company object that the current object compares itself to.
     * @return an int (-1,0,1) representing whether the first object has lower priority, equal or higher than the second object.
     */
    @Override
    public int compareTo(Student o) {

        int numProjects1 = this.admissibleProjects.size();
        int numProjects2 = o.admissibleProjects.size();
        return Integer.compare(numProjects1, numProjects2);
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
        Student s = (Student) o;
        return age == s.age && Objects.equals(name, s.name);
    }


    /**
     * This is a hashing function.
     * @return an int representing the hash-ed value of the members.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    /**
     * This constructs a String object representing the object info.
     * @return a String object representing the object info.
     */
    @Override
    public String toString() {

        String projects = admissibleProjects.stream()
                .map(Project::getName)
                .collect(Collectors.joining(", "));

        int numberOfProjects = admissibleProjects.size();
        return name + ": [" + projects + "] (" + numberOfProjects + ")";

    }
}
