CREATE TYPE USER_ROLE_ENUM AS ENUM ('USER', 'ADMINISTRATOR');
CREATE TYPE ITEM_STATE_ENUM AS ENUM ('ACTIVE', 'DISCONTINUED');

CREATE TABLE User_table
(id_user BIGINT PRIMARY KEY,
name VARCHAR NOT NULL,
password  VARCHAR NOT NULL,
user_role USER_ROLE_ENUM DEFAULT 'USER');

CREATE TABLE Item
(id_item BIGINT PRIMARY KEY,
item_code BIGINT NOT NULL UNIQUE,
description VARCHAR NOT NULL,
price  DOUBLE DEFAULT 0,
state ITEM_STATE_ENUM DEFAULT 'ACTIVE',
creation_date DATE,
user_id BIGINT NOT NULL,
CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES User_table(id_user));

CREATE TABLE Price_reduction
(id_price_reduction BIGINT PRIMARY KEY,
reduced_price INTEGER NOT NULL,
start_date DATE,
end_date DATE,
item_id BIGINT NOT NULL,
CONSTRAINT fk_item FOREIGN KEY(item_id) REFERENCES Item(id_item));

CREATE TABLE Item_supplier
(id_item_supplier BIGINT PRIMARY KEY,
name VARCHAR,
country VARCHAR);

CREATE TABLE Item_supplier_item
(item_id BIGINT,
item_supplier_id BIGINT,
PRIMARY KEY (item_id, item_supplier_id),
CONSTRAINT fk_item_m2m FOREIGN KEY(item_id) REFERENCES Item(id_item),
CONSTRAINT fk_item_supplier_id_m2m FOREIGN KEY(item_supplier_id) REFERENCES Item_supplier(id_item_supplier));

INSERT INTO User_table (id_user, name, password, user_role) VALUES (101, 'admin1', 'admin1', 'ADMINISTRATOR');
INSERT INTO User_table (id_user, name, password, user_role) VALUES (102, 'admin2', 'admin2', 'ADMINISTRATOR');
INSERT INTO User_table (id_user, name, password, user_role) VALUES (103, 'usuario1', 'usuario1', 'USER');
INSERT INTO User_table (id_user, name, password, user_role) VALUES (104, 'usuario2', 'usuario2', 'USER');

INSERT INTO Item (id_item, item_code, description, price, state, creation_date, user_id) VALUES (101, 1, 'item1', 10.50, 'ACTIVE', '2022-04-25', 101);
INSERT INTO Item (id_item, item_code, description, price, state, creation_date, user_id) VALUES (102, 2, 'item2', 12.00, 'DISCONTINUED', '2022-05-02', 101);
INSERT INTO Item (id_item, item_code, description, price, state, creation_date, user_id) VALUES (103, 3, 'item3', 5.75, 'ACTIVE', '2022-04-23', 102);

INSERT INTO Price_reduction (id_price_reduction, reduced_price, start_date, end_date, item_id) VALUES (101, 20, '2022-05-01', '2022-05-15', 103);
INSERT INTO Price_reduction (id_price_reduction, reduced_price, start_date, end_date, item_id) VALUES (102, 15, '2022-06-01', '2022-06-15', 103);

INSERT INTO Item_supplier (id_item_supplier, name, country) VALUES (101, 'item_supplier1', 'country1');
INSERT INTO Item_supplier (id_item_supplier, name, country) VALUES (102, 'item_supplier2', 'country2');

INSERT INTO Item_supplier_item (item_id, item_supplier_id) VALUES (101, 101);
INSERT INTO Item_supplier_item (item_id, item_supplier_id) VALUES (102, 101);
INSERT INTO Item_supplier_item (item_id, item_supplier_id) VALUES (103, 101);
