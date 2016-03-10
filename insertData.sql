INSERT INTO Movie VALUES ('Saw', 2004, 104.00, 'R', 'http://ia.media-imdb.com/images/M/MV5BMjAyNTcxNzYwMV5BMl5BanBnXkFtZTgwMzQzNzM5MjE@._V1_SX214_AL_.jpg');

INSERT INTO Person VALUES (4, 'James Wan', TO_DATE('1977-02-26','yyyy-mm-dd'), 'M');
INSERT INTO Person VALUES (5, 'Leigh Whannell', TO_DATE('1977-01-17','yyyy-mm-dd'), 'M');
INSERT INTO Person VALUES (6, 'Cary Elwes', TO_DATE('1962-10-26','yyyy-mm-dd'), 'M');
INSERT INTO Person VALUES (7, 'Tobin Bell', TO_DATE('1942-08-07','yyyy-mm-dd'), 'M');

INSERT INTO Director VALUES (4, 'http://ia.media-imdb.com/images/M/MV5BMTY5NzExMTQ5N15BMl5BanBnXkFtZTcwNjY1NDQzOQ@@._V1_SY317_CR58,0,214,317_AL_.jpg');

INSERT INTO Writer VALUES (4);
INSERT INTO Writer VALUES (5);

INSERT INTO Actor VALUES (6, 'http://ia.media-imdb.com/images/M/MV5BMTUwNjQ3NzY2Nl5BMl5BanBnXkFtZTcwNzQ0NjIzNA@@._V1_SX214_CR0,0,214,317_AL_.jpg');
INSERT INTO Actor VALUES (7, 'http://ia.media-imdb.com/images/M/MV5BNjM5OTE1MjA3Nl5BMl5BanBnXkFtZTgwOTAxNjk4MDE@._V1_SY317_CR7,0,214,317_AL_.jpg');

INSERT INTO Direct VALUES (4, 'Saw');

INSERT INTO Write VALUES (4, 'Saw');
INSERT INTO Write VALUES (5, 'Saw');

INSERT INTO Role VALUES ('Dr. Lawrence Gordon', 6, 'Saw');
INSERT INTO Role VALUES ('Jigsaw', 7, 'Saw');

INSERT INTO Genre VALUES ('Saw', 'Horror');
INSERT INTO Genre VALUES ('Saw', 'Mystery');

INSERT INTO Room VALUES (1001, 300);
INSERT INTO Room VALUES (1002, 300);

INSERT INTO Showing VALUES (TO_DATE('2015-12-15 18:10:00','yyyy-mm-dd hh24:mi:ss'), 1001, 'Saw');
INSERT INTO Showing VALUES (TO_DATE('2015-12-15 19:30:00','yyyy-mm-dd hh24:mi:ss'), 1002, 'Saw');

INSERT INTO CinemaUser VALUES (1, 'Carrie Song');
INSERT INTO CinemaUser VALUES (2, 'Chris Qiu');
INSERT INTO CinemaUser VALUES (3, 'Tonghe Zhan');

INSERT INTO Member VALUES (2, 'yqiu', 'qiu123');
INSERT INTO Member VALUES (3, 'tzhan', 'zhan111');

INSERT INTO PayMethod VALUES (2, '1234123412341234');
INSERT INTO PayMethod VALUES (3, '1111222233334444');

INSERT INTO Staff VALUES (1, 4574, 'ysong1991');

INSERT INTO Ticket VALUES (TO_DATE('2015-12-15 19:30:00','yyyy-mm-dd hh24:mi:ss'), 1002, 2, 12);
INSERT INTO Ticket VALUES (TO_DATE('2015-12-15 18:10:00','yyyy-mm-dd hh24:mi:ss'), 1001, 3, 12);

INSERT INTO RateMovie VALUES (2, 'Saw', 10);
INSERT INTO RateMovie VALUES (3, 'Saw', 9);

INSERT INTO RateActor VALUES (2, 6, 9);
INSERT INTO RateActor VALUES (3, 7, 8);
