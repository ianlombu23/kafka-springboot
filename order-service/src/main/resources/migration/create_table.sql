CREATE TABLE order (
  order_id varchar(100) NOT NULL,
  customer_id varchar(100) NOT NULL,
  product_id varchar(100) NOT NULL,
  count int DEFAULT NULL,
  status varchar(100) DEFAULT NULL,
  PRIMARY KEY (order_id)
);