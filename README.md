# Guardian Back End Server
This repository is the backend part of Guardian, a personnal project for situational awareness System inspired in SINESP CAD (Brazilian Ministry of Justice C2 Tool for Public Safety), Pacificador (Brazilian Army C2 Tool for Law Enforcement Operations) and ATAK (NATO C2 & Situational Awareness Tool).

## What is Situational Awareness?
Precise perception of the factors and conditions that affect the execution of the task during a determined period of time, allowing or providing the decision maker to be aware of what is going on around him and thus to be able to focus his thinking ahead of the objective. It is the perfect harmony between the perceived situation and the real situation.

## Web Application Architecture
![Project Architecture](https://github.com/valmojr/guardian-backend/blob/main/Software%20Modelling/guardianarchtecture.png?raw=true)

## BackEnd Software Modelling
This works in a MVC kind project concept: Models (actors interactions), View(console printed) and Controllers (Data Acess Objects) with the following agents and data base:

![UML](https://github.com/valmojr/guardian-backend/blob/main/Software%20Modelling/UML.png?raw=true)
https://drive.google.com/file/d/1NlrH3ogTpDS-Gp3H7A_T7PYyu8u-PC9P/view?usp=sharing

#### First Responder Types
- 1: Police Trooper
- 2: Firefighter
- 3: Life Saver

#### First Responder Privilege Levels
1. Level 1 - Trooper
- Receive Acts and Patrols orders.
- See current incidents and Areas Of Interest in 10 km.
- Register Incidents.
- Register After-Action reports.
2. Level 2 - Comms Operator
- Giver Patrol and Action orders to level 1 FRs
- See all incidents and areas of interest.
- Register Level 1 FRs.
- See order-givened reports.
- Ask for Area of Interest
3. Level 3 - Administrator
- Promote Level 1 to Level 2.
- See all reports
- Confirm Area of Interest