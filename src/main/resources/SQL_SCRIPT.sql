DROP DATABASE STORE;

CREATE DATABASE STORE;

USE STORE;

CREATE TABLE URLS(
ID INT AUTO_INCREMENT;
ORIGIN_URL VARCHAR(100) NOT NULL,
SHORT_URL VARCHAR(100) NOT NULL,
constraint user_id primary key (ID)
);

ALTER TABLE URLS AUTO_INCREMENT=1001;