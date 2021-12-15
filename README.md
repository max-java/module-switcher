# module-switcher
A proof of concept for jar injections to switch dao version or controllers on build/fly.
With an example of retrieving Person entity from database to a client you can focus on different 
approaches and technologies interacting between architectural layers, don't be bothered with business detailes.
Start from monolith project, then see how packages moves to separate modules.

### The monolith project 
is a common multilayer architecture.

### The modular project
is a multilayer architecture extracted from monolith. 
It is possible to switch and test components on it using maven profiles.

## initdb
you have a docker-compose.yml with setup of two databases: Oracle and MariaDb </br>
./initdb folder has an initial scripts for every one of that, 
inserting Person entity with id=1 and name `PostgreSQL` for postgre and `maria` for MariaDB.