START TRANSACTION;

DROP TABLE IF EXISTS students;

CREATE TABLE students (  
id INT  NOT NULL AUTO_INCREMENT,  
`first_name` VARCHAR (20) NOT NULL,  
`last_name` VARCHAR (20) NOT NULL,  
isMale BOOL NOT NULL,
birthdate DATE NOT NULL, 
address CHAR (25),  
city_id INT,  
phone VARCHAR(12) NOT NULL,  
PRIMARY KEY (ID),  
FOREIGN KEY (city_id) REFERENCES city(id)
);  

SET @cityID = (SELECT id FROM city WHERE `name` = 'Delhi');
INSERT INTO students (first_name, last_name, isMale, birthdate, address, city_id, phone)
VALUES ('Jeff', 'Spicoli', true, '1982-7-04', '5150 Green Valley', @cityId, '658-777-8541');

SET @cityID = (SELECT id FROM city WHERE `name` = 'Merrut');
INSERT INTO students (first_name, last_name, isMale, birthdate, address, city_id, phone)
VALUES ('Stacy', 'Hamilton', false, '1984-8-11', '1400 Knoll Maple', @cityId, '894-822-7354');

SET @cityID = (SELECT id FROM city WHERE `name` = 'Agra');
INSERT INTO students (first_name, last_name, isMale, birthdate, address, city_id, phone)
VALUES ('Arnold', 'Hand', true, '1941-3-24', '5150 Green Valley', @cityId, '658-777-8541');

COMMIT;
