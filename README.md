#### Description

- The project this weekend was called Film Query.

- The base skills we learned and tested were the use of a Database and how to incorporate the data
    within the data base to the back end using java, and display that information to the user.
    In this case we are still using a scanner to take input from the user and not a front end.

### Structure

- While in class, we setup a lot of the core items needed to complete this project.
- Many downloads included Maven, BootStrap, Apache and MySQL that would help assist in completing this task.

- We started we a database that we accessed through MYSQL, in our terminal that was specifically logged into MYSQL.
    While in this DB, we could access the tables and data within to finish the user stories that were presented to us.

### Directions

      -  Overview
          - You will create a command-line application that retrieves and displays film data. It will be menu-based, allowing the user to choose actions and submit query data.

          - All JDBC code will be encapsulated in methods of the com.skilldistillery.filmquery.database.DatabaseAccessorObject class. As you need new database access methods, declare them first in the DatabaseAccessor interface, then implement them in DatabaseAccessorObject. Methods should return objects like Film, Actor, and List<Actor>, not String or List<String>.

          - All user input and display output will be in methods of com.skilldistillery.filmquery.app.FilmQueryApp (or additional application classes in that package, if you choose to create them.) Comment out app.test(); and uncomment app.launch() as a starting point.

          ## User Stories
          - User Story 1
          - The user is presented with a menu in which they can choose to:

          - Look up a film by its id.
          - Look up a film by a search keyword.
          - Exit the application.

          - User Story 2
          - If the user looks up a film by id, they are prompted to enter the film id. If the film is not found, they see a message saying so. If the film is - found, its title, year, rating, and description are displayed.

          - User Story 3
          - If the user looks up a film by search keyword, they are prompted to enter it. If no matching films are found, they see a message saying so. Otherwise, they see a list of films for which the search term was found anywhere in the title or description, with each film displayed exactly as it is for User Story 2.

          - User Story 4
          - When a film is displayed, its language (English,Japanese, etc.) is also displayed.

          - User Story 5
          - When a film is displayed, the list of actors in its cast is displayed along with the title, year, rating, and description.


### How its done
    - This project consisted of us having to use the MYSQL sdvid database to access and display the information we needed, within java.
    - Creating a menu needed within Story 1 was simple and a Switch statement came in handy for that.
    - In class we setup pretty much the base code we would need to complete everything. I used the search by film id method to help me in
        build my other method, search by key word. Essentially it was the same method but with some minor tweaks to it.

    - Using Connections along with the Driver Manager, our user name and password and our URL, was how we accessed our database.
    - We created objects and lists to store the information about the films and actors and then used those to display it to the user.




### Technology I used

    - A Pom file
    - While loops
    - For each loops
    - If/else statements
    - Connections and Driver Managers
    - Prepared Statements
    - Results Sets
    - Try/catches
    - Try with resources and without
    - Base Java programming skills
    - Array List
    - Select statements
    - MYSQL tied with the Terminal


### What I learned
  - This project helped me solidify my use of the select statements and finding my way through the MYSQL tables and database to find
      the information and items I needed to complete it.
  - It also was great to use Java again, and dive back into it. I was worried I would feel rusty, but as I started to write code,
      my core skills I learned in the first 6 weeks came back and helped me complete the task at hand.

  - I learned how to do a try/catch with resources, which is unusual looking but really fun, as I like to do things in many different ways
      to help me see the variances there are in JAVA.
