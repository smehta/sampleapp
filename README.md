Student App
---------------
Demonstrates the capabilities of sorting given list of students and instructors
based on the chains of sorting criteria.

This is a maven based project.
It demonstrates the usage of 3rd party libraries like
apache-commons-collections, apache-commons-lang, logback, jacoco.

Pre-requisites
---------
1. System with Java 8 is required
2. Maven is required

To run the application:
-------------------
- Download this project. If required, unzip it.
- Run App.java class to see the demonstration of sorting capabilities

REST API Details :
--------------
REST URI for the following use cases:

###Student/Instructor API

CRUD Operations on the Students and Instructors can be performed using Users API. Student and Instructors
can be differentiated based on the roles["STUDENT", "INSTRUCTOR"] attributes.  User can actually have multiple
roles. i.e. User can be student or instructor.

Create Student/Instructor
----
Description: New Student/Instructor can be created using user API.
URI: /users/
RequestType: POST
Body: `{firstName: "Joe", lastName: "Bill", "email": "joe@bill.com", "sex": "MALE", "age": 25, roles:["student"]}`
ResponseStatus:
 - 201 : Returned on successful student creation
     - LocationHeader : `/users/{userId}`
 - 409 : Conflict, if user already exists with the same information
 - 400 : Bad Request, if invalid roles or any other attributes have been passed into request

Update Student/Instructor
----
Description: Updates user(Student/Instructor) information for the given userId.
URI: /users/{userId}
RequestType: PUT
Body: `{firstName: "Joe", lastName: "Bill", "email": "joe@bill.com",
        "sex": "MALE", "age": 25, roles:["student","instructor"]}`
ResponseStatus:
 - 200 : On Successful update
 - 400 : Bad Request, if invalid roles or any other attributes have been passed into request

Get All Students/Instructors
----
Description: Gets a list of all students or Instructors. Optional Roles query param can be passed
to filter the list of students or instructors

URI: /users?roles=student
RequestType: GET
ResponseBody:  List of all students
ResponseStatus:
 - 200 : On Successful Request
 - 400 : Bad Request, if invalid roles or any other attributes have been passed into request


Delete Student/Instructor with a given id
----
Description: Updates user(Student/Instructor) information for the given userId.
URI: /users/{userId}
RequestType: DELETE
ResponseStatus:
 - 202 : Accepted, if for some reason user cannot be deleted immediately.
 - 204 : No Content, i.e. Request has successfully been processed and there is no content to return.


###Courses API
Courses API can be used to perform CRUD operation on the courses

Create Course
----
Description: Creates the new course
URI: /courses/
RequestType: POST
Body: `{"courseName" : "501", "courseDescription": "Algorithms & Design"}`
ResponseStatus:
 - 201 : Returned on successful course creation
     - LocationHeader : `/courses/{courseId}`
 - 409 : Conflict, if course already exists with the same information
 - 400 : Bad Request, if invalid attributes have been passed into request

Update Course
----
Description: Allows users to update the course information.
URI: /courses/{courseId}
RequestType: PUT
Body: `{"courseName" : "501", "courseDescription": "Algorithms & Design( New Courses)"}`
ResponseStatus:
 - 200 : On Successful update
 - 400 : Bad Request, if invalid attributes have been passed into request

Get all the courses
----
Description: Gets a list of all courses that are available

URI: /courses
RequestType: GET
ResponseBody:  List of all Courses
ResponseStatus:
 - 200 : On Successful Request

Delete Course by Id
----
Description: Deletes the course record of given a course Id
URI: /courses/{courseId}
RequestType: DELETE
ResponseStatus:
 - 202 : Accepted, if for some reason courses cannot be deleted immediately.
 - 204 : No Content, i.e. Request has successfully been processed and there is no content to return.

###Enrollments API
Enrollments API is a sub resource of courses API.  This endpoint allows endpoint users to enroll
student or instructors in the courses. Based on the roles attributes it will add user as an
instructor or student to the course

Enroll a user to a Course
----
Description: Enrolls the users for a particular course
URI: /courses/{courseId}/enrollments
RequestType: POST
Body: `{"userId": "idOftheUserToBeEnrolled", "role" : "student", "enrollmentState": "active" }`
ResponseStatus:
 - 201 : Returned on successful enrollments of a user
     - LocationHeader : `/courses/{courseId}/enrollments/{enrollmentsId}`
 - 409 : Conflict, if user is already enrolled in the course
 - 400 : Bad Request, if invalid attributes have been passed into request

Update Enrollments information of a user for a Course
----
Description: Enrolls the users for a particular course
URI: /courses/{courseId}/enrollments/{enrollmentsId}
RequestType: PUT
Body: `{"userId": "idOftheUserToBeEnrolled", "role" : "student", "enrollmentState": "inactive"}`
ResponseStatus:
 - 201 : Returned on successful update of enrollments information of a user
 - 400 : Bad Request, if invalid attributes have been passed into request


Delete enrollments by Id
----
Description: Deletes the course record of given a course Id
URI: /courses/{courseId}/enrollments/{enrollmentsId}
RequestType: DELETE
ResponseStatus:
 - 202 : Accepted, if for some reason courses cannot be deleted immediately.
 - 204 : No Content, i.e. Request has successfully been processed and there is no content to return.

Get all enrollments for the course
----
Description: Gets a list of all enrollments information

URI: /courses/{courseId}/enrollments
RequestType: GET
ResponseBody:  List of all enrollments
ResponseStatus:
 - 200 : On Successful Request

Get all enrollments of a given user
---
Description: Lists all the enrollments of a given user
URI: /users/{userId}/enrollments/
RequestType: GET
ResponseBody:  List of all enrollments
ResponseStatus:
 - 200 : On Successful Request
