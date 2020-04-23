use mygames;

START TRANSACTION;

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

insert into games
(id, title,year_published,price,rated)
values
(1,"TemTem",2020,25.00,"FSK0"),
(2,"Halo",2001,10.00,"FSK12"),
(3,"Amnesia: The Dark Descent", 2010, 20.00, "FSK18"),
(4,"The Last of Us", 2013, 60.00, "FSK18"),
(5,"Dark Souls", 2011, 30.00, "FSK16"),
(6,"World of Warcraft",2007,25.00,"FSK12"),
(7,"Warcraft 3",2002,30.00,"FSK0"),
(8,"The Sims 4", 2014, 50.00, "FSK6"),
(9,"The Elder Scrolls V: Skyrim", 2011, 49.99, "FSK12"),
(10,"Uncharted: Drakes Schicksal", 2007, 60.00, "FSK16"),
(11,"Super Mario Bros WII Edition",2008,59.99,"FSK0"),
(12,"Madden 20", 2020, 59.99, "FSK0"),
(13,"Tekken 7", 2015,59.99,"FSK12"),
(14,"Pac-Man", 1980, 19.99, "FSK0"),
(15,"GTA San Andreas",2002,59.99,"FSK18");

insert into platforms
(title)
values
("ps1"),("ps2"),("ps3"),("ps4"),("Nintendo Switch"),
("PC"),("xbox360"),("Nintendo 64"),("Neo Geo"),("Super Nintendo"),
("xbox"),("xbocOne"),("MacOS"),("Nintendo Wii");

insert into games_developers (game_id,developer_id)
values (1,3),(13,10);
insert into games_genres (game_id,genre_id)
values (1,7),(13,2),(11,7);
insert into games_platforms (game_id,platform_id)
values (1,6),(13,4),(13,6),(13,13),(11,14);

insert into games_developers (game_id, developer_id) values (9,7);
insert into games_genres (game_id, genre_id) values (9,9);
insert into games_platforms (game_id, platform_id) values (9,4),(9,6),(9,12),
(9,13);

COMMIT;