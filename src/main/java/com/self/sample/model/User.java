package com.self.sample.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Created by smehta on 9/18/16.
 */
public class User {

    private String id; // not being used as of now
    private String firstName;
    private String lastName;
    private SEX sexType;
    private int age;
    private List<Roles> rolesList;

    public User(String firstName, String lastName, SEX sexType, int age, List<Roles> rolesList) {

        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setSexType(sexType);
        this.setAge(age);
        this.setRolesList(rolesList);
    }

    public static Comparator<User> nameComparator = new Comparator<User>() {

        @Override
        public int compare(User o1, User o2) {
            int result = o1.getLastName().toLowerCase()
                    .compareTo(o2.getLastName().toLowerCase());

            if (result == 0) {
                return o1.getFirstName().toLowerCase()
                        .compareTo(o2.getFirstName().toLowerCase());
            }

            return result;
        }
    };

    public static Comparator<User> rolesComparator = new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {

            if(o1.isStudent() && o2.isStudent() ||
                    o1.isInstructor() && o2.isInstructor()) {
                return 0;
            }
            if (o1.isInstructor()) {
                return -1;
            }

            return 1;
        }
    };

    public static Comparator<User> ageComparator = new Comparator<User>() {

        @Override
        public int compare(User o1, User o2) {

            int result = o1.getAge() - o2.getAge();
            return result;
        }
    };

    public static Comparator<User> sexComparator = new Comparator<User>() {

        @Override
        public int compare(User o1, User o2) {

            int result = o2.getSexType().compareTo(o1.getSexType());
            return result;
        }
    };

    public enum SEX {MALE, FEMALE};

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public SEX getSexType() {
        return sexType;
    }

    public void setSexType(SEX sexType) {
        this.sexType = sexType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Roles> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<Roles> rolesList) {
        this.rolesList = rolesList;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o instanceof User) {
            User user = (User) o;
            return new EqualsBuilder()
                    .append(id, user.id)
                    .append(age, user.age)
                    .append(firstName, user.firstName)
                    .append(lastName, user.lastName)
                    .append(sexType, user.sexType)
                    .build();
        }

        return false;
    }

    @Override
    public int hashCode() {

        return new HashCodeBuilder()
                .append(id)
                .append(firstName)
                .append(lastName)
                .append(sexType)
                .append(age)
                .build();
    }

    @Override
    public String toString() {
        return "User{" +
                "  lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                "  rolesList=" + rolesList +
                ", age=" + age +
                ", sexType=" + sexType +
                ", id='" + id + '\'' +
                '}';
    }

    private boolean isStudent() {
        return this.rolesList.contains(Roles.STUDENT);
    }

    private boolean isInstructor() {
        return this.rolesList.contains(Roles.INSTRUCTOR);
    }
}
