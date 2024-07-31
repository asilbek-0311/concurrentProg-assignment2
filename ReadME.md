Readme

# Cinema Online Seat Reservation System

## Project Overview

This project implements a simulation of an online seat reservation system for a cinema with three theatres. It demonstrates concurrent programming in Java, handling multiple customer threads attempting to reserve seats simultaneously while ensuring no double-booking occurs.

## Project Structure
```
assignment2
│  ├─ pom.xml
│  ├─ src
│  │  ├─ main
│  │  │  ├─ java
│  │  │  │  ├─ CinemaReservationSystem.java
│  │  │  │  ├─ Customer.java
│  │  │  │  └─ Theatre.java
│  │  │  └─ resources
│  │  └─ test
│  │     └─ java
│  └─ target
│     ├─ classes
│     │  ├─ CinemaReservationSystem.class
│     │  ├─ Customer.class
│     │  └─ Theatre.class
│     └─ test-classes

```

## Prerequisites

- Java JDK 8 or higher
- Maven

## Building the Project

To build the project, navigate to the project root directory and run:

``` bash 
java -cp target/classes CinemaReservationSystem 
```
## Key Features

1. Simulates 100 concurrent customers attempting to reserve seats.
2. Three theatres with 20 seats each.
3. Customers randomly select 1-3 seats in a chosen theatre.
4. Thread-safe seat reservation to prevent double-booking.
5. Simulated delay (500-1000ms) for payment process after seat selection.

## Class Descriptions

- `CinemaReservationSystem.java`: Main class that sets up and runs the simulation.
- `Customer.java`: Represents a customer thread that selects and attempts to reserve seats.
- `Theatre.java`: Represents a theatre with its seats and handles the seat reservation logic.

## Output

The program will output:
1. Reservation attempts by each customer.
2. Final seat allocations for each theatre.

## Notes

- This project is created using Maven, but it doesn't have any external dependencies.
- The simulation uses Java's built-in concurrency utilities to manage multiple threads.


