# Texas State Desktop Application
> A team consisting of Charlie Orch, Sam Swanson, Erik Sager, Logan Schmidt, and Mesut Apil.
Our team is creating a desktop application for our fellow Texas State students that allows them to see Texas State University services such as buses, food, academic work, and so on.
We are creating this application to help ease the burden for Texas State students that find it hard to balance school work and everyday life.

## Table of contents
* [General info](#general-info)
* [Screenshots](#screenshots)
* [Technologies](#technologies)
* [Setup](#setup)
* [Features](#features)
* [Status](#status)
* [Inspiration](#inspiration)
* [Contact](#contact)

## General info
The purpose of this project is to help future Texas State students succeed academically and socially.

## Screenshots
![Example screenshot](https://i.imgur.com/fuOoJle.png)

## Technologies
* Jaunt - Java Web Scraping & JSON Querying
* Texas State University API

## Setup
Describe how to install / setup your local environement / add link to demo version.

## Code Examples
Show examples of usage:
`put-your-code-here`

## Features
List of features ready and TODOs for future development
* GPA Calculator: Calculates GPA from homework, exams, quizzes, etc; Erik's user story
* Academic Calender: Shows the students personal academic calender; Sam's user story
* Meal Swipe Counter: Shows the student's current available meal swipes for dining halls; Mesut's user story

To-do list:
* Wow improvement to be done 1
* Wow improvement to be done 2

## Status
Project is: in progress

Sprint 1
* Erik - My next step is to work on connecting our login page to the web connection functionality.
* Logan - My next step will be to add courses to the course database and add more functionality for it.
* Charlie - My next step is to polish up the dining interface and implement more functionality for users.
* Sam - My next step is to implement the GPA algorithm to work with the GUI so it is functioning properly.  
* Mesut - My next step is to implement code on the interface so it actually works.

Sprint 2
* Erik -  My next step is to make a create account and login page that will implement the HTML parser that I wrote for this sprint.
* Charlie - My next step is to refine and/or fix the Dining interface to work with the implemented database.
* Sam - My next step is to refine the GPA algorithm to work with all cases and fully implement the save local data functions.  
* Mesut - My next step is to fix my calculator algorithm and allow users to calculate grades according to their choice instead of having to calculate 10 grades all the time.

Sprint 3
* Erik -
* Logan -
* Charlie - My next step is to fix and clean up the dining page so that it can be more efficient for the user.
* Sam - My next step is to further fix and tamper with the GPA Calculator by using a different and more efficient method that works better in our app. 
* Mesut - My next step is to add more functionality to line chart in Dining interface and make it more useful for the user.

## Accomplishments

Sprint 1
* Erik - I was able to create a system for changing a saving the users desired settings for the application. This system will allow for more future settings to be easily added, implemented, and changed from the options page that can effect the application as a whole. This commit shows the new file OptionsPageController that contains the code. https://github.com/CS3398-Enclave-Boys/CS3398-Enclave-F2019/commit/809c7369da7b0c9e36b15bd0ef89a0de52815041
* Logan - I created packages for student accounts, courses, and began creating a database to store potential courses locally. This will allow users to search for classes and apply actively open courses to their student account. This commit shows the files I added for these packages: https://github.com/CS3398-Enclave-Boys/CS3398-Enclave-F2019/commit/a9ecf18df03fa707d6553f7ad72bee89d6e71ca4
* Charlie - For Sprint 1, I created the login page interface, created and linked the Dining interface, made a meal swipe counter, and added exit buttons. The login page is crucial for students to fully utilize our application as many of the features include personal information such as meal swipes, dining dollars, grades, and so on. Here is the commit that includes the code that makes up the login page:       https://github.com/CS3398-Enclave-Boys/CS3398-Enclave-F2019/commit/1b21d78515005fe58fdba510444c335e5be0773f
* Sam - I created the homepage, GPA, Student, and Classes interfaces. These will most likely be changed in future sprints once we start implementing more techniques and adding APIs to the Application. The Student and Classes tabs are an idea of what they will look like in the future but need the API for functionality. The GPA calculator interface was created upon a algorithm I came up with. The idea is commented out but has not been translated to code yet. Here is a commit for an update of the GPA interface: https://github.com/CS3398-Enclave-Boys/CS3398-Enclave-F2019/commit/16506383137156fe4611664144ce02d96e1f7f14
* Mesut - I did the grade calculator interface and swipe calculator graph . Grade calculator is under the grade file in src. Swipe graph is under dining file in src. Grade calculator serves a purpose to calculate what the students grade will be in a certain graph. Swipe graph is the burn down chart of how many swipes are left as well as daily consumption.

Sprint 2
* Erik - I created an interface that allows the user to upload their class schedule to the application allowing them to see all their classes information as well as giving them the option to recieve notifications on their desktop that alert them when a class in about to begin or end. This interface will later be used once a user has created an account and logged into the application. This commit has all the code pertaining to the interface that displays the users schedule: https://github.com/CS3398-Enclave-Boys/CS3398-Enclave-F2019/commit/8e8cec27b9dfa095b98f7042c78e2f82a3cdd280
* Charlie - I created the interface and functionality for the dining dollars counter as well as added an individual student account to be implemented within the database. The dining dollars counter successfully works and is crucial for the student to add or subtract how many dining dollars they have left on their account. Here is the commit of the code that makes up the functionality of the dining dollars calculation: https://github.com/CS3398-Enclave-Boys/CS3398-Enclave-F2019/commit/c2e139e13da46847ea107fcf9d51b00a32d1b05d
* Sam - I  created the account interface that should implemented with the student page. This could change on collaboration for the next sprint as the account interface could be transferred to another page. I created a template for saving the data locally for the app and is in each class but has not been fully implemented due to talk about moving things around and which data should be stored and what do not needs to be pulled locally. The GPA calculator algorithm was implemented but needs some tuning so that the calculator works for all cases. This refactoring will most likely take place in the next sprint to make sure this code is working correctly for all cases. Here is a commit for the GPA algorithm: https://github.com/CS3398-Enclave-Boys/CS3398-Enclave-F2019/commit/b23ed2428b75d2c12d8cf364f169ce58b1e13363
* Mesut - I created the grade calculator interface and implemented functionality where the user can calculate their current grade in the class by typing what they had recieved on the assignment and the percentage the assignment is worth. It allows them to calculate as much to 10 assignments in one time. I also made changes in the swipe calculator and the graph which will show how many swipes the user has left from the beginning of the semester and the graph will show an illustration of how much they are spending. The functionality for swipe calculator will be done in the next sprint as well as improving the grade calculator. Here is the commit for the grade calculator: https://github.com/CS3398-Enclave-Boys/CS3398-Enclave-F2019/blob/master/Test2/src/Grade/GradeController.java

Sprint 3
* Erik - I created an interface for creating new user accounts. This allows the user to create a username and password as well as upload their student schedule to make a new account within the application. These accounts allow for easy access to a students schedule and allows them to recieve notifications for when their class is about to begin and end depending on their settings. This is a commit that shows the new implementation for the new account interface: https://github.com/CS3398-Enclave-Boys/CS3398-Enclave-F2019/commit/468c7e82ed123c2b0bdbc67da4ce17c1825c81bc
* Charlie - I created the clubs page for all clubs on campus that are available for students to choose from. This gives the user more user out of the application as well as have a better chance to get more integrated into Texas State life. I also gave this interface functionality as well. This is the commit for the implementation for the clubs interface: https://github.com/CS3398-Enclave-Boys/CS3398-Enclave-F2019/commit/457bf0211241f02431359aa99c1eeb7963056518
* Sam - I created the save features for the Grade calculator as well as the GPA and Dining calculator. This allows the user to leave the window that they were in and come back to it with the same values that they were previously using to complete their task. Each individual text box is saved in a text document that is created when you enter your first input as either GPA, Grade, or Dining. I had trouble getting some of these to work but Erik helped me figure out and then update those commits to work correctly. Here is one of those commits: https://github.com/CS3398-Enclave-Boys/CS3398-Enclave-F2019/commit/68b0087c5bebdd74758124d9a132a6bd8ea1739d
* Mesut - I improved the bugs i had in grade calculator and the graph for dining calculator. Improvements I had done in grade calculator is that the user doesn't have to fill up every box so that lets them to compute as much as they want to, and there was a improvement to the algorithm to compute the total grade because the previous algorithm was not giving accurate results. I added a graph to dining calculator that will show a burndown of their spendings of dining dollars. Here is one of those commits: https://github.com/CS3398-Enclave-Boys/CS3398-Enclave-F2019/commit/5d6f15de1fe0f1113481d7cdedd0d6ece03f2887
* Logan - I created pages for a campus map and a list of on campus resources including phone numbers and locations. The map will help students find their way around campus. The school resources page will aid students in accessing helpful resources on campus. This commit shows the addition of the school resource page: https://github.com/CS3398-Enclave-Boys/CS3398-Enclave-F2019/commit/57324b98676944281d03475cb9f533307f024424

## Inspiration
Add here credits. Project inspired by..., based on...

## Contact
Created by [@flynerdpl](https://www.flynerd.pl/) - feel free to contact me!
