package com.self.sample;

import com.self.sample.model.Instructor;
import com.self.sample.model.Student;
import com.self.sample.model.User;
import com.self.sample.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * This app sorts the given list of students and instructors.
 */
public class App 
{
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    private UserService userService = new UserService();

    public static void main( String[] args )
    {
        LOGGER.info("Initializing app");

        App app = new App();
        app.runSort();
    }

    /**
     * Demo the usage of sorting algorithm based on the given
     * list of criteria
     */
    public void runSort() {

        final List<User> combinedList = new ArrayList<User>();
        combinedList.addAll(generateRandomStudents(2));
        combinedList.addAll(generateRandomInstructors(2));

        LOGGER.info("Run sorting algorithms");

        userService.sort(combinedList);

        LOGGER.info("Display sorted list of students and instructors: ");

        for (User eachSortedUser : combinedList) {
            LOGGER.info(eachSortedUser.toString());
        }
    }

    private List<Student> generateRandomStudents(int numberOfStudents) {

        LOGGER.info("Generating {} random students", numberOfStudents);

        List<Student> studentList = new ArrayList<Student>();

        for(int i = 0; i < numberOfStudents; i++) {

            String fullName = getRandomName();
            String firstName = fullName.split(" ")[0];
            String lastName = fullName.split(" ")[1];
            User.SEX type = new Random().nextBoolean() == true ? User.SEX.FEMALE : User.SEX.MALE;
            int age = new Random().nextInt(75);

            studentList.add(new Student(firstName, lastName, type, age));
        }

        return studentList;
    }

    private List<Instructor> generateRandomInstructors(int numberOfInstructors) {

        LOGGER.info("Generating {} random instructors", numberOfInstructors);

        List<Instructor> instructorList = new ArrayList<Instructor>();

        for(int i = 0; i < numberOfInstructors; i++) {

            String fullName = getRandomName();
            String firstName = fullName.split(" ")[0];
            String lastName = fullName.split(" ")[1];
            User.SEX type = new Random().nextBoolean() == true ? User.SEX.FEMALE : User.SEX.MALE;
            int age = new Random().nextInt(75);

            instructorList.add(new Instructor(firstName, lastName, type, age));
        }

        return instructorList;
    }

    private String getRandomName() {

         List<String> nameList = Arrays.asList(
                 "Adina Awad",
                 "Letisha Longwell",
                 "Remona Richer",
                 "Conchita Culbreth",
                 "Era Eutsey",
                 "Brigette Bothe",
                 "Mallie Matias",
                 "Hattie Henthorn",
                 "Jeniffer Jungers",
                 "Kerri Keyes",
                 "Thelma Toombs",
                 "Rosaura Raynor",
                 "Gaston Gassner",
                 "Donnette Drury",
                 "Celsa Chu",
                 "Chantell Curran",
                 "Phil Piro",
                 "Vickey Victor",
                 "Elin Eckel",
                 "Kizzy Kisner",
                 "Edith Evans",
                 "Marty Mount",
                 "Enda Englert",
                 "Jacinto Jeffress",
                 "Joe Jaques",
                 "Diane Dubuisson",
                 "Jenell Jamison",
                 "Jarred Juergens",
                 "Melodie Marshell",
                 "Blanche Batten",
                 "Karl Kiley",
                 "Ludie Love",
                 "Camellia Calender",
                 "Octavio Ours",
                 "Annabel Auton",
                 "Sanjuana Speir",
                 "Shira Swilley",
                 "Katelynn Knerr",
                 "Tova Toth",
                 "Myriam Meyers",
                 "Osvaldo Odem",
                 "Zaida Zepeda",
                 "Stacia Shain",
                 "Carlee Chesney",
                 "Kenton Krob",
                 "Kiara Kinkead",
                 "Connie Crandall",
                 "Sally Spurling",
                 "Mistie Medved",
                 "Matha Maddock"
         );

        Random r = new Random();
        int index = r.nextInt(nameList.size());

        return nameList.get(index);
    }
}
