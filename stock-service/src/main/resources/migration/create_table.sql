CREATE TABLE product (
  product_id varchar(100) NOT NULL,
  product_name varchar(100) NOT NULL,
  available_stock int NOT NULL,
  amount decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (product_id)
);