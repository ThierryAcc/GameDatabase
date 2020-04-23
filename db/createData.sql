use furious_games;
SET FOREIGN_KEY_CHECKS = 0;
truncate developers;
truncate genres;
truncate games;
truncate platforms;
truncate publishers;
truncate reviewers;
truncate reviews;
SET FOREIGN_KEY_CHECKS = 1;

INSERT into developers
(id, title,year_founded)
values
(1, "Team Cherry",1905),
(2, "Activison",1979),
(3, "cremagames",2019),
(4,"naughty dog dog",1986),
(5, "EA",1982),
(6, "FromSoftware",1986),
(7, "bethesda",1986),
(8, "frictional games",2006),
(9, "Blizzard",2008),
(10, "Bandai Namco",2006);



insert into genres
(title)
values
("Horror"),
("Action"),
("Jump&Run"),
("KoopGames"),
("Sport"),
("Shooter"),
("Adventure"),
("Strategie"),
("RPG"),
("Simulation"),
("Fighting Games");

insert into publishers
(id, title)
values
(1, 'Blizzard'),
(2, 'Namco'),
(3, 'Bethesda'),
(5, 'cremagames'),
(4, 'Unknown');

insert into games
(id, title,year_published,suggested_price,rated, publisher_id)
values
(1,"TemTem",2020,25.00,"FSK0", 5),
(2,"Halo",2001,10.00,"FSK12", 4),
(3,"Amnesia: The Dark Descent", 2010, 20.00, "FSK18", 3),
(4,"The Last of Us", 2013, 60.00, "FSK18", 4),
(5,"Dark Souls", 2011, 30.00, "FSK16", 4),
(6,"World of Warcraft",2007,25.00,"FSK12", 1),
(7,"Warcraft 3",2002,30.00,"FSK0", 1),
(8,"The Sims 4", 2014, 50.00, "FSK6", 4),
(9,"The Elder Scrolls V: Skyrim", 2011, 49.99, "FSK12", 4),
(10,"Uncharted: Drakes Schicksal", 2007, 60.00, "FSK16", 4),
(11,"Super Mario Bros WII Edition",2008,59.99,"FSK0", 4),
(12,"Madden 20", 2020, 59.99, "FSK0", 4),
(13,"Tekken 7", 2015,59.99,"FSK12", 2),
(14,"Pac-Man", 1980, 19.99, "FSK0", 2),
(15,"GTA San Andreas",2002,59.99,"FSK18", 4);

insert into platforms
(title)
values
("ps1"),("ps2"),("ps3"),("ps4"),("Nintendo Switch"),
("PC"),("xbox360"),("Nintendo 64"),("Neo Geo"),("Super Nintendo"),
("xbox"),("xbocOne"),("MacOS"),("Nintendo Wii");

insert into games_developers (game_id,developer_id)
values (1,3),(13,10);

insert into reviewers (id, title, email) values
(1, "thierry", "test@gmail.com"),
(2, "steffi", "steffi@gmail.com"),
(3, "allen", "allen@gmx.ch");

insert into reviews (id,game_id,reviewer_id, review, score)
values
(1, 5, 1, "Geiles Game", 3.2),
(2, 6, 1, "Super Game", 4.1),
(3, 7, 2, "Game des Jahres", 2.1),
(4, 8, 3, "BS", 5.0),
(5, 9, 3, "Naja", 1.7);

insert into games_reviewers (game_id, reviewer_id)
values (1,1),(2,2),(3,3),(5,3),(6,3);

insert into games_platforms (game_id, platform_id)
values (1,6),(13,4),(13,6),(13,13),(11,14);

insert into games_genres (game_id, genre_id)
values (1,7),(13,2),(11,7);


