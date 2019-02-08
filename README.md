# BCCA Nomination
A software solution in Java to support the Base Camp Coding Academy admissions process.

## User Side
1. User starts up user side program
2. User has two options in main menu:
   - Nominate
     - Nominate student to BCCA
   - Apply
     - Apply to BCCA
3. User fills out application or nomination
4. User submits application or nomination
5. When done, user closes program

## Admin Side
1. Admin starts up admin side program
2. Admin has three options in main menu:
   - Show All Students
     - Shows all students
   - Show Ready Students
     - Shows all students with an application and a nomination
   - Search
     - Gives options to search by school or name
3. Admin chooses a student within the list
4. Admin has two options in student menu:
   - Nomination
     - Shows student's nomination
   - Application
     - Shows student's application
5. When done, admin closes program

## Technical Side
The goal for this application was to make two seperate programs that used the same data file. 
This file contains an ArrayList of Student objects that could either be added to by the first
program, or viewed by the second.

  - The first would be the user side that could nominate a student or apply as a student. 
Once the nomination, or application, was submitted a method would search the data file for
any student that had matching information as the new one. If one was found, it would assign
either the nomination, or application, to that student. If one could not be found it would
create a new Student object and still assign the nomintation, or application. The Student
is then serialized to a ser file with other Student objects from that ser file.

  - The second would be the admin side. This would be used for BCCA admins to look through
the data and see all of the students with either an application or nomination, see all of
the students with both, and be able to search through the students by either name or 
school district. Every so often, the program looks at the ser file and pulls Student
objects from it to keep the list of students updated.
