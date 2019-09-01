
--Заполнение пользователей
INSERT INTO Users (access_type, first_name, last_name, middle_name, login, password) VALUES ('USER','Иванов','Иван','Иван','test1','test');
INSERT INTO Users (access_type, first_name, last_name, middle_name, login, password) VALUES ('USER','Петров','Петр','Петр','test2','test');
INSERT INTO Users (access_type, first_name, last_name, middle_name, login,  password) VALUES ('USER','Сидоров','Ева','Але','test3','test');

--Заполнение отелей
INSERT INTO Hotel (name) VALUES ('Star');
INSERT INTO Hotel (name) VALUES ('Princes');
INSERT INTO Hotel (name) VALUES ('SunRise');

--Заполнение комнат
-- Star
INSERT INTO Room (hotel_id, description) VALUES ('1','standard');
INSERT INTO Room (hotel_id, description) VALUES ('1','double');
INSERT INTO Room (hotel_id, description) VALUES ('1','superior');
-- Princes
INSERT INTO Room (hotel_id, description) VALUES ('2','standard');
INSERT INTO Room (hotel_id, description) VALUES ('2','double');
INSERT INTO Room (hotel_id, description) VALUES ('2','superior');
-- SunRise
INSERT INTO Room (hotel_id, description) VALUES ('3','standard');
INSERT INTO Room (hotel_id, description) VALUES ('3','double');
INSERT INTO Room (hotel_id, description) VALUES ('3','superior');


