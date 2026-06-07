# Java CLI Task Tracker

A command-line Task Tracker application built in Java that allows users to manage tasks efficiently through terminal commands.

## Features

* Add new tasks
* Update existing tasks
* Delete tasks
* Mark tasks as completed
* Mark tasks as in progress
* View all tasks
* Filter tasks by status:

  * Todo
  * In Progress
  * Done
* Automatic task persistence using local file storage
* Created and updated timestamps for every task

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* ArrayList
* File Handling
* Exception Handling
* LocalDateTime API

## Project Structure

```text
Main.java         -> Handles command-line arguments
Task.java         -> Task model class
TaskManager.java  -> Business logic and task management
```

## How to Compile

```bash
javac Main.java Task.java TaskManager.java
```

## How to Run

### Add a Task

```bash
java Main add "Learn Java"
```

### Update a Task

```bash
java Main update 1 "Learn Advanced Java"
```

### Delete a Task

```bash
java Main delete 1
```

### Mark Task as Done

```bash
java Main mark-done 1
```

### Mark Task as In Progress

```bash
java Main mark-in-progress 1
```

### List All Tasks

```bash
java Main list
```

### List Completed Tasks

```bash
java Main list done
```

### List Todo Tasks

```bash
java Main list todo
```

### List In Progress Tasks

```bash
java Main list in-progress
```

## Concepts Practiced

* Classes and Objects
* Encapsulation
* Constructors
* Getters and Setters
* ArrayLists
* CRUD Operations
* File Reading and Writing
* Exception Handling
* Command-Line Arguments
* Data Persistence

## Future Improvements

* JSON-based storage
* Search functionality
* Task priorities
* Due dates
* Sorting and filtering options
