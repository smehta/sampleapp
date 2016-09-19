package com.self.sample.service;

import com.self.sample.model.Instructor;
import com.self.sample.model.Student;
import com.self.sample.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smehta on 9/18/16.
 */
public class UserServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceTest.class);

    private UserService userService = new UserService();

    @Test
    public void testDefaultSortBehavior() {

        //given
        List<Student> studentList = new ArrayList<Student>();

        studentList.add(new Student("Jill", "Joe", User.SEX.MALE, 18));
        studentList.add(new Student("Jill", "Joe", User.SEX.FEMALE, 18));
        studentList.add(new Student("Abbie", "Joe", User.SEX.MALE, 23));

        List<Instructor> instructorList = new ArrayList<Instructor>();
        instructorList.add(new Instructor("Jill", "Joe", User.SEX.MALE, 80));
        instructorList.add(new Instructor("Jill", "Joe", User.SEX.FEMALE, 80)); //1
        instructorList.add(new Instructor("Tom", "Brady", User.SEX.MALE, 34));

        List<User> userList = new ArrayList<User>();
        userList.addAll(studentList);
        userList.addAll(instructorList);

        //when
        userService.sort(userList);

        //then
        List<User> expectedList = new ArrayList<User>();
        expectedList.add(new Instructor("Tom", "Brady", User.SEX.MALE, 34));
        expectedList.add(new Student("Abbie", "Joe", User.SEX.MALE, 23));
        expectedList.add(new Instructor("Jill", "Joe", User.SEX.FEMALE, 80));
        expectedList.add(new Instructor("Jill", "Joe", User.SEX.MALE, 80));
        expectedList.add(new Student("Jill", "Joe", User.SEX.FEMALE, 18));
        expectedList.add(new Student("Jill", "Joe", User.SEX.MALE, 18));

        Assert.assertEquals(userList, expectedList, "Order list doesn't match to expected list");
    }

    @Test
    public void testSortingBasedOnAge() {

        //given
        List<Student> studentList = new ArrayList<Student>();

        studentList.add(new Student("Jill", "Joe", User.SEX.MALE, 18));
        studentList.add(new Student("Jill", "Joe", User.SEX.FEMALE, 18));
        studentList.add(new Student("Abbie", "Joe", User.SEX.MALE, 23));

        List<Instructor> instructorList = new ArrayList<Instructor>();
        instructorList.add(new Instructor("Jill", "Joe", User.SEX.MALE, 80));
        instructorList.add(new Instructor("Jill", "Joe", User.SEX.FEMALE, 80)); //1
        instructorList.add(new Instructor("Tom", "Brady", User.SEX.MALE, 34));

        List<User> userList = new ArrayList<User>();
        userList.addAll(studentList);
        userList.addAll(instructorList);

        //when
        userService.sort(userList, User.ageComparator);

        //then
        //expected List
        List<User> expectedList = new ArrayList<User>();

        expectedList.add(new Student("Jill", "Joe", User.SEX.MALE, 18));
        expectedList.add(new Student("Jill", "Joe", User.SEX.FEMALE, 18));
        expectedList.add(new Student("Abbie", "Joe", User.SEX.MALE, 23));
        expectedList.add(new Instructor("Tom", "Brady", User.SEX.MALE, 34));
        expectedList.add(new Instructor("Jill", "Joe", User.SEX.MALE, 80));
        expectedList.add(new Instructor("Jill", "Joe", User.SEX.FEMALE, 80));

        Assert.assertEquals(userList, expectedList, "user list is not sorted correctly based on age");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSortingWhenListIsNull() {

        //when
        userService.sort(null, User.sexComparator, User.rolesComparator);
    }

}
