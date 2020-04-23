drop database if exists mygames;
create database mygames;
use mygames;

create table games (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title varchar(100),
    year_published YEAR,
    price decimal(5,2),
    rated varchar(10),
    viewed int
);

create table genres (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title varchar(100)
);

create table games_genres (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    game_id int NOT NULL,
    genre_id int NOT NULL,
    FOREIGN KEY (game_id) REFERENCES games(id) ON DELETE CASCADE,
    FOREIGN KEY (genre_id) REFERENCES genres(id) ON DELETE CASCADE
);

create table developers (
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title varchar(100),
    year_founded YEAR
);

create table games_developers (
    id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    game_id int NOT NULL,
    developer_id int NOT NULL,
    FOREIGN KEY (game_id) REFERENCES games(id) ON DELETE CASCADE,
    FOREIGN KEY (developer_id) REFERENCES developers(id) ON DELETE CASCADE
);

create table platforms (
    id int not null auto_increment PRIMARY KEY,
    title varchar(100)
);

create table games_platforms (
    id int not null auto_increment PRIMARY KEY,
    game_id int NOT NULL,
    platform_id int NOT NULL,
    FOREIGN KEY (game_id) REFERENCES games(id) ON DELETE CASCADE,
    FOREIGN KEY (platform_id) REFERENCES platforms(id) ON DELETE CASCADE
);