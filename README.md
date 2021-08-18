# Wildlife-Tracker
An application that allows Rangers to track wildlife sightings in the area.
#### By  Clare Limo

## Setup/Installation Requirements
* You need to have Java, IntelliJ, Postgres, gradle, Junit, Jdk and sdk installed.
* Clone the repository
* Build (gradle build)
* For Psql:
```
CREATE DATABASE wildlife_tracker;
CREATE TABLE sightings (id serial PRIMARY KEY, animalid,location varchar,rangername,lastseen timestamp);
CREATE TABLE animals (id serial PRIMARY KEY, name varchar,health varchar,age varchar, type varchar);
CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;
```
* Run the App (gradle run))
* Navigate to localhost:4567 on your browser
## Known Bugs
There are no known bugs.
## Technologies Used
* Java
* Postgres
* Spark
* Handlebars
* CSS
* Bootstrap
* Junit
## Support and contact details
Email : clare.limo@student.moringaschool.com
### License
[MIT License](./LICENSE)

Copyright (c) [2021] [Clare Limo]