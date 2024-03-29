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
VALUES (1, 1, current_timestamp(0)),
       (2, 2, current_timestamp(0)),
       (2, 1, current_timestamp(0)),
       (1, 3, current_timestamp(0));