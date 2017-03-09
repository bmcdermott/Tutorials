
CREATE TABLE products (
  id INTEGER IDENTITY PRIMARY KEY,
  description varchar(255),
  long_description varchar(255),
  price decimal(15,2)
);

CREATE TABLE components (
  id INTEGER IDENTITY PRIMARY KEY,
  description varchar(255),
  long_description varchar(255),
  product_id integer,
  CONSTRAINT fk_product FOREIGN KEY (product_id)
  REFERENCES products(id)
);


