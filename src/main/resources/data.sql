-- INSERT INTO USERS (NAME, EMAIL, PASSWORD)
-- VALUES ('User', 'user@yandex.ru', '{noop}password'),
--        ('Admin', 'admin@gmail.com', '{noop}admin'),
--        ('Guest', 'guest@gmail.com', '{noop}guest');
--
-- INSERT INTO USER_ROLE (ROLE, USER_ID)
-- VALUES ('USER', 1),
--        ('ADMIN', 2),
--        ('USER', 2);
--
-- INSERT INTO RESTAURANT (NAME)
-- VALUES ('Piatsa Gourounaki'),
--        ('Ladi and Rigani'),
--        ('The Hill View restaurant'),
--        ('Sage Restaurant');
--
-- INSERT INTO MENU (restaurant_id, name, date, description, price)
-- VALUES (1,'Piatsa Gourounaki', '2024-03-08', 'Meze', 20),
--        (1, 'Piatsa Gourounaki', '2024-03-08', 'Mahalembi', 40),
--        (1, 'Piatsa Gourounaki', '2024-03-08', 'Soup', 10),
--        (2, 'Ladi and Rigani', '2024-03-09', 'Сhicken gyro', 20),
--        (2, 'Ladi and Rigani', '2024-03-09', 'Sheftalyu', 50),
--        (2, 'Ladi and Rigani', '2024-03-09', 'Souvlaki', 35),
--        (2, 'Ladi and Rigani', '2024-03-09', 'Souvlaki', 35);


INSERT INTO USERS (NAME, EMAIL, PASSWORD)
VALUES ('User', 'user@yandex.ru', '{noop}password'),
       ('Admin', 'admin@gmail.com', '{noop}admin'),
       ('Guest', 'guest@gmail.com', '{noop}guest');

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 2);

INSERT INTO RESTAURANT (name)
VALUES ('Muse'),
       ('Porto Bello'),
       ('Oniro');

INSERT INTO DISH (name, date, price, restaurant_id)
VALUES ('Beef steak', current_date, 500, 1),
       ('Margarita', current_date, 300, 2),
       ('Salad', current_date, 200, 3),
       ('Bread', current_date, 150, 1),
       ('Soup', current_date, 250, 2),
       ('Grilled ribs', current_date, 250, 3);

INSERT INTO VOTE (user_id, restaurant_id, date_time)
VALUES (1, 1, '2024-03-09 11:00'),
       (2, 2, '2024-03-09 10:00'),
       (2, 1,'2024-03-09 15:00'),
       (1, 3, '2024-03-09 16:00');