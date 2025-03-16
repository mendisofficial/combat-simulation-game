# Combat Simulation Game

## Overview

This project is a text-based combat simulation that demonstrates core Object-Oriented Programming principles through a weapon management system. A soldier can carry multiple types of guns, each with unique behaviors, and engage in simulated combat activities.

## Assignment Information

This project was developed as an assignment for the **Object Oriented Programming Concepts 1** module at **Java Institute for Advanced Technology**.

## Features

- Multiple gun types with different behaviors (AK47, Pistol, Sniper)
- Soldier class that can manage multiple weapons
- Weapon switching, dropping and picking mechanics
- Ammunition management with reload functionality
- Text-based simulation output

## OOP Concepts Demonstrated

### Abstraction

- Created an abstract `Gun` class with abstract `shoot()` method
- Each gun type implements its own shooting behavior
- Common behaviors like reload are defined in the abstract parent class

### Inheritance

- `AK47`, `Pistol`, and `Sniper` classes extend the abstract `Gun` class
- They inherit properties and methods but override the shooting behavior
- Specialized classes benefit from reusing code from the parent class

### Encapsulation

- Private attributes in all classes with getters/setters
- Implementation details hidden from outside the classes
- Data integrity maintained through controlled access

### Polymorphism

- Different gun types behave differently when the `shoot()` method is called
- The `Soldier` class can work with any type of gun without knowing its specific type
- Runtime behavior determined by the actual object type

## How to Run

1. Clone the repository
2. Open the project in NetBeans IDE or any Java IDE
3. Run the `CombatSimulation.java` file to see the simulation in action

## Project Structure

- `Abstract` package: Contains the abstract `Gun` class
- `Concrete` package: Contains concrete implementations (`AK47`, `Pistol`, `Sniper`, `Soldier`)
- `CombatSimulation` package: Contains the main simulation logic
