package com.self.sample.model;

import java.util.Arrays;
import java.util.List;

/**
 * Created by smehta on 9/18/16.
 */
public class Student extends User {

    public Student(String firstName, String lastName, SEX sexType, int age) {
        super(firstName, lastName, sexType, age, Arrays.asList(Roles.STUDENT));
    }

}
