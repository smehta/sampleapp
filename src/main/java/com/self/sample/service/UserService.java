package com.self.sample.service;

import com.self.sample.model.User;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.Predicate;

/**
 * Created by smehta on 9/18/16.
 */
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    /**
     * Sorts the given list of users(students &or instructors) based on the given list of comparators.
     * It will iterates over each comparator in sequence until either
     * 1) any single Comparator returns a non-zero results of (and that result is then returned),
     * or 2) the ComparatorChain is exhausted (and zero is returned.
     *
     * If given list of comparators is empty then it will use default comparators. Default comparators
     * sorts the list in the following orders
     * - 1. Alphabetically by last and then first name
     * - 2. If 1 is equal, instructors should come before students
     * - 3. If 1 and 2 are equal, by age: persons with lower age will come before persons with higher age
     * - 4. If 1, 2, and 3 are equal, by gender: persons that are female will come before persons that are male.
     *
     * throws IllegalArgumentException if users list is null
     * @param users
     * @param comparators
     */
    public void sort(final List<User> users, final Comparator<User>... comparators) {

        if (users == null) {

            LOGGER.error("NULL user list is passed as an argument");
            throw  new IllegalArgumentException("Users list cannot be null");
        }

        List<Comparator<User>> comparatorList = null;

        if (comparators == null || comparators.length == 0 ) {

            LOGGER.info("Using Default list of comparators to sort the given user list");

            comparatorList =  Arrays.asList(User.nameComparator,
                User.rolesComparator,
                User.ageComparator,
                User.sexComparator);

        } else {

            LOGGER.info("Using passed in list of comparators to sort the given user list");
            comparatorList = new ArrayList<Comparator<User>>(Arrays.asList(comparators));
        }

        ComparatorChain comparatorChain = new ComparatorChain();

        for (Comparator each : comparatorList) {
            comparatorChain.addComparator(each);
        }

        Collections.sort(users, comparatorChain);
    }
}
