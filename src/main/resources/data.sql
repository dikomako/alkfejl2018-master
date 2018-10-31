INSERT INTO USER (ID, NAME, PASSWORD, USER_NAME, ROLE) values (1, 'Móger Tibor', '$2a$10$LplxaCfU8JFYxu9k2kRhWuAoc8Q.viSlUtxsZBs8gIfoSDqwbUZq2', 'tibor', 'ROLE_USER');
INSERT INTO USER (ID, NAME, PASSWORD, USER_NAME, ROLE) values (2, 'Gipsz Jakab', '$2a$10$LplxaCfU8JFYxu9k2kRhWuAoc8Q.viSlUtxsZBs8gIfoSDqwbUZq2', 'jakab', 'ROLE_USER');
INSERT INTO USER (ID, NAME, PASSWORD, USER_NAME, ROLE) values (3, 'Gipsz Jakabné', '$2a$10$LplxaCfU8JFYxu9k2kRhWuAoc8Q.viSlUtxsZBs8gIfoSDqwbUZq2', 'jakabne', 'ROLE_ADMIN');

INSERT INTO PRODUCT (ID, NAME, QUANTITY_IN_STOCK) values (1, 'Lámpa', 10);
INSERT INTO PRODUCT (ID, NAME, QUANTITY_IN_STOCK) values (2, 'Égő', 100);
INSERT INTO PRODUCT (ID, NAME, QUANTITY_IN_STOCK) values (3, 'Ágy', 3);
INSERT INTO PRODUCT (ID, NAME, QUANTITY_IN_STOCK) values (4, 'Asztal', 10);
INSERT INTO PRODUCT (ID, NAME, QUANTITY_IN_STOCK) values (5, 'Szék', 10);

INSERT INTO SUPPLIER (ID, NAME, CONTACT) values (1, 'Möbelix', 'mobelix@info.hu');
INSERT INTO SUPPLIER (ID, NAME, CONTACT) values (2, 'Praktiker', 'praktiker@info.hu');
INSERT INTO SUPPLIER (ID, NAME, CONTACT) values (3, 'OBI', 'obi@info.hu');

-- INSERT INTO  SUPPLIER_PRODUCTS (SUPPLIER_ID, PRODUCT_ID) values (2, 1);
-- INSERT INTO  SUPPLIER_PRODUCTS (SUPPLIER_ID, PRODUCT_ID) values (2, 2);
-- INSERT INTO  SUPPLIER_PRODUCTS (SUPPLIER_ID, PRODUCT_ID) values (1, 3);
-- INSERT INTO  SUPPLIER_PRODUCTS (SUPPLIER_ID, PRODUCT_ID) values (1, 4);
-- INSERT INTO  SUPPLIER_PRODUCTS (SUPPLIER_ID, PRODUCT_ID) values (3, 5);