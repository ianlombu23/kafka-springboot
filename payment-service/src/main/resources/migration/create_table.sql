CREATE TABLE payment (
  payment_id varchar(100) NOT NULL,
  order_id varchar(100) NOT NULL,
  customer_id varchar(100) NOT NULL,
  payment_method varchar(100) DEFAULT NULL,
  PRIMARY KEY (payment_id)
);