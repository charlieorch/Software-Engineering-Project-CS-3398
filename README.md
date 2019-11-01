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
* Erik -
* Charlie -
* Sam - My next step is to refine the GPA algorithm to work with all cases and fully implement the save local data functions.  
* Mesut -

## Accomplishments

Sprint 1
* Erik - I was able to create a system for changing a saving the users desired settings for the application. This system will allow for more future settings to be easily added, implemented, and changed from the options page that can effect the application as a whole. This commit shows the new file OptionsPageController that contains the code. https://github.com/CS3398-Enclave-Boys/CS3398-Enclave-F2019/commit/809c7369da7b0c9e36b15bd0ef89a0de52815041
* Logan - I created packages for student accounts, courses, and began creating a database to store potential courses locally. This will allow users to search for classes and apply actively open courses to their student account. This commit shows the files I added for these packages: https://github.com/CS3398-Enclave-Boys/CS3398-Enclave-F2019/commit/a9ecf18df03fa707d6553f7ad72bee89d6e71ca4
* Charlie - For Sprint 1, I created the login page interface, created and linked the Dining interface, made a meal swipe counter, and added exit buttons. The login page is crucial for students to fully utilize our application as many of the features include personal information such as meal swipes, dining dollars, grades, and so on. Here is the commit that includes the code that makes up the login page:       https://github.com/CS3398-Enclave-Boys/CS3398-Enclave-F2019/commit/1b21d78515005fe58fdba510444c335e5be0773f
For Sprint 2, I created the interface and functionality for the dining dollars counter as well as added an individual student account to be implemented within the database. The dining dollars counter succussfully works and is crucial for the student to add or subtract how many dining dollars they have left on their account. Here is the commit of the code that makes up the functionality of the dining dollars calculation: https://github.com/CS3398-Enclave-Boys/CS3398-Enclave-F2019/commit/c2e139e13da46847ea107fcf9d51b00a32d1b05d
* Sam - I created the homepage, GPA, Student, and Classes interfaces. These will most likely be changed in future sprints once we start implementing more techniques and adding APIs to the Application. The Student and Classes tabs are an idea of what they will look like in the future but need the API for functionality. The GPA calculator interface was created upon a algorithm I came up with. The idea is commented out but has not been translated to code yet. Here is a commit for an update of the GPA interface: https://github.com/CS3398-Enclave-Boys/CS3398-Enclave-F2019/commit/16506383137156fe4611664144ce02d96e1f7f14
* Mesut - I did the grade calculator interface and swipe calculator graph . Grade calculator is under the grade file in src. Swipe graph is under dining file in src. Grade calculator serves a purpose to calculate what the students grade will be in a certain graph. Swipe graph is the burn down chart of how many swipes are left as well as daily consumption.

Sprint 2
* Erik -
* Charlie - I created the interface and functionality for the dining dollars counter as well as added an individual student account to be implemented within the database. The dining dollars counter successfully works and is crucial for the student to add or subtract how many dining dollars they have left on their account. Here is the commit of the code that makes up the functionality of the dining dollars calculation: https://github.com/CS3398-Enclave-Boys/CS3398-Enclave-F2019/commit/c2e139e13da46847ea107fcf9d51b00a32d1b05d
* Sam - I  created the account interface that should implemented with the student page. This could change on collaboration for the next sprint as the account interface could be transferred to another page. I created a template for saving the data locally for the app and is in each class but has not been fully implemented due to talk about moving things around and which data should be stored and what do not needs to be pulled locally. The GPA calculator algorithm was implemented but needs some tuning so that the calculator works for all cases. This refactoring will most likely take place in the next sprint to make sure this code is working correctly for all cases. Here is a commit for the GPA algorithm: https://github.com/CS3398-Enclave-Boys/CS3398-Enclave-F2019/commit/b23ed2428b75d2c12d8cf364f169ce58b1e13363
* Mesut -

## Inspiration
Add here credits. Project inspired by..., based on...

## Contact
Created by [@flynerdpl](https://www.flynerd.pl/) - feel free to contact me!
