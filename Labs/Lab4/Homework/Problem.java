package Lab4.Homework;

import java.util.*;

/**
 * The type Problem.
 */
public class Problem {

    private Set<Student> students;
    private Set<Project> projects;
    private Map<Student, Set<Project>> preferences;


    /**
     * Instantiates a new Problem.
     */
    public Problem() {
        this.students = new HashSet<Student>();
        this.projects = new HashSet<Project>();
        preferences = new HashMap<>();
    }

    /**
     * Instantiates a new Problem.
     *
     * @param students the students
     * @param projects the projects
     */
    public Problem(Set<Student> students, Set<Project> projects) {
        this.students = students;
        this.projects = projects;
        preferences = new HashMap<>();

        for (Student student: students) {
            preferences.put(student,student.getAdmissibleProjects());
        }
    }

    /**
     * Instantiates a new Problem.
     *
     * @param students    the students
     * @param projects    the projects
     * @param preferences the preferences
     */
    public Problem(Set<Student> students, Set<Project> projects, Map<Student,Set<Project>> preferences) {
        this.students = students;
        this.projects = projects;
        this.preferences = preferences;
    }

    /**
     * Add student problem.
     *
     * @param student the student
     * @return the problem
     */
    public Problem addStudent(Student student){
        this.students.add(student);
        this.preferences.put(student,student.getAdmissibleProjects());
        return this;
    }

    /**
     * Add project problem.
     *
     * @param project the project
     * @return the problem
     */
    public Problem addProject(Project project){
        this.projects.add(project);
        return this;
    }

    /**
     * Add preferences problem.
     *
     * @param student  the student
     * @param projects the projects
     * @return the problem
     */
    public Problem addPreferences(Student student, Set<Project> projects){

        this.preferences.put(student,projects);
        return this;
    }

    /**
     * Display below average.
     */
    public void displayBelowAverage(){

        // Aici vom avea o colectie de multimi de proiecte.
        Collection<Set<Project>> projectSets = preferences.values();
        double average = projectSets.stream().mapToInt(Set::size).average().getAsDouble();

        System.out.println("\nSTUDENTS THAT HAVE THE NUMBER OF PREFERENCES LOWER THAN THE AVERAGE NUMBER OF PREFERENCES OF "+ average + " : \n");
        students.stream().filter(s -> preferences.get(s).size() < average).forEach(System.out::println);
    }


    /**
     * Gets students.
     *
     * @return the students
     */
    public Set<Student> getStudents() {
        return students;
    }

    /**
     * Sets students.
     *
     * @param students the students
     */
    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    /**
     * Gets projects.
     *
     * @return the projects
     */
    public Set<Project> getProjects() {
        return projects;
    }

    /**
     * Sets projects.
     *
     * @param projects the projects
     */
    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    /**
     * Gets preferences.
     *
     * @return the preferences
     */
    public Map<Student, Set<Project>> getPreferences() {
        return preferences;
    }

    /**
     * Sets preferences.
     *
     * @param preferences the preferences
     */
    public void setPreferences(Map<Student, Set<Project>> preferences) {
        this.preferences = preferences;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "students=" + students +
                ", projects=" + projects +
                '}';
    }
}
