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

INSERT INTO DISH (name, local_date, price, restaurant_id)
VALUES ('Beef steak', '2024-04-20', 500, 1),
       ('Margarita', '2024-04-20', 300, 2),
       ('Salad', '2024-04-20', 200, 3),
       ('Bread', '2024-04-20', 150, 1),
       ('Soup', '2024-04-20', 250, 2),
       ('Grilled ribs', '2024-04-20', 250, 3);

INSERT INTO VOTE (user_id, restaurant_id, created_date_time, updated_date_time)
VALUES (1, 1, '2024-04-20 10:30', '2024-04-20 10:35'),
       (2, 2, '2024-04-20 10:26', '2024-04-20 10:30'),
       (2, 1, '2024-04-20 9:24', '2024-04-20 10:00'),
       (1, 3, '2024-04-20 8:40', '2024-04-20 9:30');