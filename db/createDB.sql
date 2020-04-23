drop database if exists furious_games;
CREATE DATABASE furious_games;
use furious_games;

create table publishers (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100)
);

CREATE TABLE games (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100),
    year_published YEAR,
    suggested_price DECIMAL(5,2),
    rated VARCHAR(10),
    viewed INT,
    publisher_id INT NOT NULL,
    FOREIGN KEY (publisher_id) REFERENCES publishers(id) ON DELETE CASCADE
);

create table platforms (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100)
);

create table games_platforms (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    game_id INT NOT NULL,
    platform_id INT NOT NULL,
    FOREIGN KEY (game_id) REFERENCES games(id) ON DELETE CASCADE,
    FOREIGN KEY (platform_id) REFERENCES platforms(id) ON DELETE CASCADE
);

create table developers (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100), 
    year_founded YEAR
);

create table games_developers (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    game_id INT NOT NULL,
    developer_id INT NOT NULL,
    FOREIGN KEY (game_id) REFERENCES games(id) ON DELETE CASCADE,
    FOREIGN KEY (developer_id) REFERENCES developers(id) ON DELETE CASCADE
);

create table genres (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100)
);

create table games_genres (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    game_id INT NOT NULL,
    genre_id INT NOT NULL,
    FOREIGN KEY (game_id) REFERENCES games(id) ON DELETE CASCADE,
    FOREIGN KEY (genre_id) REFERENCES genres(id) ON DELETE CASCADE
);

create table reviewers (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(100), 
    email VARCHAR(100)
);

create table reviews (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    game_id INT NOT NULL,
    reviewer_id INT NOT NULL,
    review VARCHAR(140),
    score DECIMAL(2,1),
	FOREIGN KEY (reviewer_id) REFERENCES reviewers(id) ON DELETE CASCADE,
    FOREIGN KEY (game_id) REFERENCES games(id) ON DELETE CASCADE
);

create table games_reviewers (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    game_id INT NOT NULL,
    reviewer_id INT NOT NULL,
    FOREIGN KEY (game_id) REFERENCES games(id) ON DELETE CASCADE,
    FOREIGN KEY (reviewer_id) REFERENCES reviewers(id) ON DELETE CASCADE
);

create table games_reviews (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    game_id INT NOT NULL,
    review_id INT NOT NULL,
    FOREIGN KEY (game_id) REFERENCES games(id) ON DELETE CASCADE,
    FOREIGN KEY (review_id) REFERENCES reviews(id) ON DELETE CASCADE
);
