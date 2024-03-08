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


INSERT INTO MENU (name, date, description, price, restaurant_id)
VALUES ('menu', '2024-03-05', 'Beef steak', 500, 1),
       ('menu', '2024-03-05', 'Margarita', 300, 2),
       ('menu', '2024-03-05', 'Salad', 200, 3),
       ('menu1', '2024-03-05', 'Bread', 150, 1),
       ('menu1', '2024-03-05', 'Soup', 250, 2),
       ('menu1', '2024-03-05', 'Grilled ribs', 250, 3);