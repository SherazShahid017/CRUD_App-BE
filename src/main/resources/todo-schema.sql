DROP TABLE `task` IF EXISTS;

CREATE TABLE `task` (
	
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	description VARCHAR(255) NOT NULL,
	completed BOOLEAN NOT NULL
);