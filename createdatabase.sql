CREATE DATABASE mlbplayoffs;
USE mlbplayoffs;

DROP TABLE IF EXISTS team;

CREATE TABLE team (
	  id VARCHAR(3) PRIMARY KEY,
    city VARCHAR(20) ,
    name VARCHAR(20) ,
    wins INT,
    losses INT,
    seed INT,
    league VARCHAR(10)
);

INSERT INTO team VALUES ('BOS', 'Boston', 'Red Sox', 93, 69, 3, 'American');
INSERT INTO team VALUES ('CLE', 'Cleveland', 'Indians', 102, 60, 1, 'American');
INSERT INTO team VALUES ('HOU', 'Houston', 'Astros', 101, 61, 2, 'American');
INSERT INTO team VALUES ('NYY', 'New York', 'Yankees', 91, 71, 4, 'American');
INSERT INTO team VALUES ('MIN', 'Minnesota', 'Twins', 85, 77, 5, 'American');
INSERT INTO team VALUES ('WAS', 'Washington', 'Nationals', 97, 65, 2, 'National');
INSERT INTO team VALUES ('CHI', 'Chicago', 'Cubs', 92, 70, 3, 'National');
INSERT INTO team VALUES ('LAD', 'Los Angeles', 'Dodgers', 104, 58, 1, 'National');
INSERT INTO team VALUES ('ARI', 'Arizona', 'Diamondbacks', 93, 69, 4, 'National');
INSERT INTO team VALUES ('COL', 'Colorado', 'Rockies', 87, 75, 5, 'National');
