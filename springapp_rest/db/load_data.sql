INSERT INTO products (id, description, long_description, price) values(NULL, 'NewProduct1', 'This item is NewProduct1', 103.00);
INSERT INTO products (id, description, long_description, price) values(NULL, 'NewProduct2', 'This item is NewProduct2', 5.78);
INSERT INTO products (id, description, long_description, price) values(NULL, 'NewProduct3', 'This item is NewProduct3', 105.00);
INSERT INTO products (id, description, long_description, price) values(NULL, 'NewProduct4', 'This item is NewProduct4', 106.00);
INSERT INTO products (id, description, long_description, price) values(NULL, 'NewProduct5', 'This item is NewProduct5', 75.29);
INSERT INTO products (id, description, long_description, price) values(NULL, 'NewProduct6', 'This item is NewProduct6', 22.81);
INSERT INTO products (id, description, long_description, price) values(NULL, 'NewProduct7', 'This item is NewProduct7', 102.51);
INSERT INTO products (id, description, long_description, price) values(NULL, 'NewProduct8', 'This item is NewProduct8', 104.00);




INSERT INTO components (id, description, long_description)
select NULL, 'Component 1', 'Component 1';
INSERT INTO components (id, description, long_description)
select NULL, 'Component 2', 'Component 2';
INSERT INTO components (id, description, long_description)
select NULL, 'Component 3', 'Component 3';
INSERT INTO components (id, description, long_description)
select NULL, 'Component 4', 'Component 4';
INSERT INTO components (id, description, long_description)
select NULL, 'Component 5', 'Component 5';
INSERT INTO components (id, description, long_description)
select NULL, 'Component 6', 'Component 6';
INSERT INTO components (id, description, long_description)
select NULL, 'Component 7', 'Component 7';
INSERT INTO components (id, description, long_description)
select NULL, 'Component 8', 'Component 8';
INSERT INTO components (id, description, long_description)
select NULL, 'Component 9', 'Component 9';
INSERT INTO components (id, description, long_description)
select NULL, 'Component 10', 'Component 10';
INSERT INTO components (id, description, long_description)
select NULL, 'Component 11', 'Component 11';
INSERT INTO components (id, description, long_description)
select NULL, 'Component 12', 'Component 12';
INSERT INTO components (id, description, long_description)
select NULL, 'Component 13', 'Component 13';
INSERT INTO components (id, description, long_description)
select NULL, 'Component 14', 'Component 14';
INSERT INTO components (id, description, long_description)
select NULL, 'Component 15', 'Component 15';
INSERT INTO components (id, description, long_description)
select NULL, 'Component 16', 'Component 16';
INSERT INTO components (id, description, long_description)
select NULL, 'Component 17', 'Component 17';


INSERT INTO products_components (product_id, component_id)
select id from products where description = 'NewProduct1',
select id from components where description = 'Component1';

INSERT INTO products_components (product_id, component_id)
select id from products where description = 'NewProduct1',
select id from components where description = 'Component17';

INSERT INTO products_components (product_id, component_id)
select id from products where description = 'NewProduct1',
select id from components where description = 'Component11';

