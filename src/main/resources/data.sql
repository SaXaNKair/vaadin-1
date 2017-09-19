CREATE TABLE IF NOT EXISTS Todo(id IDENTITY PRIMARY KEY, done BOOLEAN, text VARCHAR(100));
DELETE FROM Todo;
INSERT INTO Todo VALUES (1, TRUE, 'Preparing to work');
INSERT INTO Todo VALUES (2, TRUE, 'Starting to work');
INSERT INTO Todo VALUES (3, FALSE , 'Finish working');

DROP TABLE IF EXISTS Company;
CREATE TABLE IF NOT EXISTS Company(id IDENTITY PRIMARY KEY, name VARCHAR(100), address VARCHAR(100), frozen BOOLEAN, veggies BOOLEAN, seafood BOOLEAN, phone VARCHAR(100), email VARCHAR(100));
INSERT INTO Company VALUES (1, 'Google', 'Palo Alto', TRUE, FALSE, FALSE, '+1 (512) 5556655', 'google@gmail.com');
INSERT INTO Company VALUES (2, 'Unilever', 'London', FALSE, FALSE, TRUE, '+11 (812) 4545444', 'unilever@hotmail.com');
INSERT INTO Company VALUES (3, 'Yandex' , 'Moscow', TRUE, FALSE, TRUE, '+7 (800) 1333 8888', 'yan@yandex.ru');
INSERT INTO Company VALUES (4, 'Agama' , 'Moscow', TRUE, TRUE, TRUE, '+7 (800) 7575 5555', 'agama@mail.ru');
INSERT INTO Company VALUES (5, 'BSQ' , 'Moscow', TRUE, FALSE, TRUE, '+7 (800) 454 1212', 'bsq@yandex.ru');
INSERT INTO Company VALUES (6, 'Frozen' , 'Saint-Petersburg', TRUE, TRUE, TRUE, '+7 (800) 565 8484', 'yan@mail.ru');