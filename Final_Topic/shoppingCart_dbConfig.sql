CREATE DATABASE  IF NOT EXISTS `shopping-cart`;

USE `shopping-cart`;

CREATE TABLE User(
	first_name VARCHAR(40) NOT NULL,
	last_name VARCHAR(40) NOT NULL,
	username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
	CONSTRAINT Pk_User PRIMARY KEY (username));


CREATE TABLE Product(
	id INTEGER NOT NULL, 
	name VARCHAR(40) NOT NULL,
	category VARCHAR(40) NOT NULL,
    price DECIMAL(5,2) NOT NULL,
    stock INTEGER NOT NULL,
	CONSTRAINT Pk_Product PRIMARY KEY (id));


CREATE TABLE Cart(
	username VARCHAR(100) NOT NULL,
	id_product INTEGER NOT NULL,
	quantity INTEGER NOT NULL,
	CONSTRAINT Pk_Cart PRIMARY KEY (username,id_product),
	CONSTRAINT Fk_Cart_User 
		FOREIGN KEY (username) REFERENCES User (username),
	CONSTRAINT Fk_Cart_Product 
		FOREIGN	KEY (id_product) REFERENCES Product (id));