package com.self.sample.model;

import java.util.Arrays;

/**
 * Created by smehta on 9/18/16.
 */
public class Instructor extends User {


    public Instructor(String firstName, String lastName, SEX sexType, int age) {
        super(firstName, lastName, sexType, age, Arrays.asList(Roles.INSTRUCTOR));
    }

}
