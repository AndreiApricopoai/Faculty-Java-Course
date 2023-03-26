package Lab4.Homework;

import java.util.*;

/**
 * The type Solve allocation.
 */
public class SolveAllocation {

    private Map<Student, Project> allocations;
    private Problem problem;


    /**
     * Instantiates a new Solve allocation.
     *
     * @param problem the problem
     */
    public SolveAllocation(Problem problem) {
        this.problem = problem;
        this.allocations = new HashMap<>();
    }


    /**
     * Solve allocation.
     *
     * @return to solve allocation
     */
    public SolveAllocation solve(){
        List<Student> availableStudents = new ArrayList<>(problem.getStudents());
        Collections.sort(availableStudents);

        List<Project> availableProjects = new ArrayList<>(problem.getProjects());

        for(Student student : availableStudents)
        {
            for(Project project : student.getAdmissibleProjects()){
                if(availableProjects.contains(project)){
                    allocations.put(student, project);
                    availableProjects.remove(project);
                    break;
                }
            }
        }
        return this;
    }

    /**
     * Print allocations.
     */
    public void printAllocations(){
        System.out.println("\nTHE FOLLOWING ALLOCATIONS WERE MADE : \n");
        allocations.forEach((k,v) -> System.out.println("Student: " + k.getName() + " -> Project: " + v.getName()));
    }

}
