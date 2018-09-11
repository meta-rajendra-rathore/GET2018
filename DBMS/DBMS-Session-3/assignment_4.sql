# Create appropriate tables and relationships for the same and write a SQL
# query for that returns a Resultset containing Zip Code, City Names and
# States ordered by State Name and City Name

CREATE TABLE Zipcode (
    zipcode INT NOT NULL,
    area VARCHAR(20) NOT NULL,
    city VARCHAR(20) NOT NULL,
    state VARCHAR(20) NOT NULL,
    PRIMARY KEY (zipcode)
);

INSERT INTO zipcode (zipcode, area, city, state) VALUES
(311001, 'Bhilwara City', 'Bhilwara', 'Rajasthan'),
(305001, 'Ajmer City', 'Ajmer', 'Rajasthan'),
(302020, 'Jaipur City', 'Jaipur', 'Rajasthan'), 
(313001, 'Udaipur City', 'Udaipur', 'Rajasthan'),
(302033, 'Pratapnagar', 'Jaipur', 'Rajasthan'),
(302018, 'Malviya Nagar', 'Jaipur', 'Rajasthan'), 
(305030, 'Badliya Village', 'Ajmer', 'Rajasthan');

SELECT 
    zipcode, area, city, state
FROM
    zipcode
ORDER BY state, city;
