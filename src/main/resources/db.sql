DROP SCHEMA IF EXISTS inform_system;

CREATE SCHEMA inform_system;

CREATE TABLE inform_system.USER (
  id INT AUTO_INCREMENT,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  is_admin boolean DEFAULT FALSE ,
  PRIMARY KEY (id),
  UNIQUE (email)
);

CREATE TABLE inform_system.PRODUCT (
  product_id INT NOT NULL AUTO_INCREMENT,
  name_product VARCHAR(255) NOT NULL,
  price DECIMAL (10, 2) NOT NULL,
  status VARCHAR(255) NOT NULL,
  PRIMARY KEY (product_id)
);

CREATE TABLE inform_system.ORDERS (
  order_id INT NOT NULL AUTO_INCREMENT,
  user_id INT NOT NULL,
  product_id INT NOT NULL,
  primary key (order_id)

);



