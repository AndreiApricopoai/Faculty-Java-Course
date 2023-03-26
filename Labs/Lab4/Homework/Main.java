package Lab4.Homework;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static int randomInt(){
        Random random = new Random();
        return random.nextInt(30 - 20) + 20;
    }
    public static String randomDate(){
        Random random = new Random();
        int day = random.nextInt(31-1)+1;
        int month = random.nextInt(12-1)+1;
        int year = random.nextInt(2030-2014)+2014;
        String dateString = String.format("%02d/%02d/%04d", day, month, year);
        return dateString;

    }



    public static void main(String[] args) {

        Faker faker = new Faker();  //Aici se creeaza obiectul pentru nume random generate.

        // Aici se creeaza 10 proiecte random.
        var projects = IntStream.rangeClosed(0, 9)
                .mapToObj(i -> new Project(faker.app().name(), randomDate())).collect(Collectors.toSet());

        System.out.println("LISTA DE PROIECTE GENERATA ARE (" + projects.size() + ") ELEMENTE : \n");
        projects.forEach(System.out::println); // Aici afisam pe ecran proiectele create.


        // Aici se creeaza 10 students random.
        var students = IntStream.rangeClosed(0, 9)
                .mapToObj(i -> new Student(faker.leagueOfLegends().champion(),randomInt(),projects.stream().limit(i+1).collect(Collectors.toSet())))
                .collect(Collectors.toSet());


        // Aici afisam pe ecran studentii creati.
        System.out.println("\nLISTA DE STUDENTI GENERATA ARE (" + students.size() + ") STUDENTI : \n");

        List<Student> list = new ArrayList<>(students); // convert set to list
        Collections.sort(list); // sortam lista
        list.forEach(System.out::println);
        //students.forEach(System.out::println); // Aici afisam pe ecran studentii creati.


        Problem problem = new Problem(students,projects);
        problem.displayBelowAverage();


        SolveAllocation solver = new SolveAllocation(problem);
        solver.solve().printAllocations();


    }
}