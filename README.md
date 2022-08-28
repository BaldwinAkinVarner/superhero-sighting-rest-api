
# superhero-sighting-rest-service

This is a REST API for a mock superhero sighting service. The API was built using Spring Boot and Maven. See the Description below for more info on how the API works.

## Description

This project is a REST API built using Spring Boot and Maven for a mock superhero sighting service. The application configurations can be changed using the pom.xml file in the root directory. All data is returned from the API in JSON format. The Entity Relationship Diagram can be found in the root directory as "Super Database ERD.png".

## Objects
**Sighting** : Each Sighting has a unique sighting id as an integer, a location id as an integer, a sighting date as a date, and a super id as an integer.<br>
**Superperson** : Each Superperson has a unique super id as an integer, a name as a string, a description as a string, a power as a string, and an isEvil boolean for whether they are evil or not.<br>
**Location** : Each Location has a unique location id as an integer, location name as a string, location description as a string, address as a string, longitude as a double, and latitude as a double.<br>
**Organization** Each Organization has a unique org id as an integer, org name as a string, org description as a string, org address as a string, and contact info as a string.

## Routes

* http://localhost:3306/api

GET

* http://localhost:3306/api/super/location/locationId : *given a location id, returns a list of supers sighted at a specific location*
* http://localhost:3306/api/location/super/superId : *given a super id, returns a list of locations a super has sightings at*
* http://localhost:3306/api/sighting/sightingDateStr : *given a date in the format "YYYY-MM-DD", returns a list of sightings*
* http://localhost:3306/api/super/org/orgId : *given an organization id, returns a list of supers in that organization*
* http://localhost:3306/api/org/super.superId : *given a super id, returns a list of organizations a super is in*

POST

* http://localhost:3306/api/sighting : *given a sighting object, creates a superhero sighting*

---
Made by Baldwin-Akin Varner

##### This project was done through Wiley Edge Academy as part of a bootcamp