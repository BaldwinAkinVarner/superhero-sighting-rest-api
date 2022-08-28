DROP DATABASE IF EXISTS SuperSightingDB;
CREATE DATABASE SuperSightingDB;
USE SuperSightingDB;

CREATE TABLE location(
	location_id INT PRIMARY KEY AUTO_INCREMENT,
    location_name varchar(90) NOT NULL,
    location_description varchar(750),
    address varchar(28),
    longitude DOUBLE,
    latitude DOUBLE);

CREATE TABLE superperson(
	super_id INT PRIMARY KEY AUTO_INCREMENT,
    super_name varchar(40) NOT NULL,
    super_description varchar(750),
    power varchar(50),
    isevil BOOLEAN);

CREATE TABLE org(
	org_id INT PRIMARY KEY AUTO_INCREMENT,
    org_name varchar(40) NOT NULL,
    org_description varchar(750),
    org_address varchar(28),
    contact_info varchar(40));

CREATE TABLE sighting(
	sighting_id INT PRIMARY KEY AUTO_INCREMENT,
    location_id INT NOT NULL,
    sighting_date DATE,
    super_id INT NOT NULL,
    FOREIGN KEY fk_location_id (location_id) REFERENCES location(location_id),
    FOREIGN KEY fk_super_id (super_id) REFERENCES superperson(super_id));

CREATE TABLE affiliation(
	affiliation_id INT PRIMARY KEY AUTO_INCREMENT,
    super_id INT NOT NULL,
    org_id INT NOT NULL,
    FOREIGN KEY fk_super_id (super_id) REFERENCES superperson(super_id),
    FOREIGN KEY fk_org_id (org_id) REFERENCES org(org_id));

INSERT INTO location(location_id, location_name, location_description, address, longitude, latitude) VALUES
	(1, "Gotham City", "Where Batman Be", "721 Malberry Lane", 162.84943, -38.29029),
    (2, "GCPD Headwuarters", "Where Gordon Be", "756 Malberry Lane", 165.84943, -38.29029);

INSERT INTO superperson(super_id, super_name, super_description, power, isEvil) VALUES
	(1, "Batman", "No parents = spite", "Privelege", false),
    (2, "Killer Croc", "Scaley Bot", "He's a crocodile", true);

INSERT INTO org(org_id, org_name, org_description, org_address, contact_info) VALUES
	(1, "League of Villains", "they real villainous", "723 address way", "757-555-5234");
    
INSERT INTO sighting(sighting_id, location_id, sighting_date, super_id) VALUES
	(1, 2, "2020-06-09", 2),
    (2, 1, "2022-06-09", 2),
    (3, 2, "2020-06-09", 2);
    
INSERT INTO affiliation(super_id, org_id) VALUES
	(2, 1);

SELECT * from location;
SELECT * from superperson;
SELECT * from org;
SELECT * from sighting;
SELECT * from affiliation;