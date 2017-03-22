INSERT INTO products (id, description, long_description, price) values(NULL, 'Lamp', 'This item is a LAMP', 5.78);
INSERT INTO products (id, description, long_description, price) values(NULL, 'Table', 'This item is a TABLE', 75.29);
INSERT INTO products (id, description, long_description, price) values(NULL, 'Chair', 'This item is a CHAIR', 22.81);
INSERT INTO products (id, description, long_description, price) values(NULL, 'Super Fancy Chair', 'This item is a Super Fancy CHAIR', 102.51);
INSERT INTO products (id, description, long_description, price) values(NULL, 'NewProduct3', 'This item is NewProduct3', 103.00);
INSERT INTO products (id, description, long_description, price) values(NULL, 'NewProduct3', 'This item is NewProduct4', 104.00);
INSERT INTO products (id, description, long_description, price) values(NULL, 'NewProduct3', 'This item is NewProduct5', 105.00);


INSERT INTO components (id, description, long_description, product_id)
select NULL, 'AWood', 'The wood the chair is made from',  id from products
where description = 'Chair';
INSERT INTO components (id, description, long_description, product_id)
select NULL, 'AScrews', 'The screws that hold the chair together',  id from products
where description = 'Chair';
INSERT INTO components (id, description, long_description, product_id)
select NULL, 'AGlue', 'The glue that holds the chair together',  id from products
where description = 'Chair';

INSERT INTO components (id, description, long_description, product_id)
select NULL, 'BBulb', 'The lightbulb',  id from products
where description = 'Lamp';
INSERT INTO components (id, description, long_description, product_id)
select NULL, 'BShade', 'The lamp shade',  id from products
where description = 'Lamp';
INSERT INTO components (id, description, long_description, product_id)
select NULL, 'BWood', 'The wood the lamp is made from',  id from products
where description = 'Lamp';

INSERT INTO components (id, description, long_description, product_id)
select NULL, 'CWood', 'The wood the table is made from',  id from products
where description = 'Table';
INSERT INTO components (id, description, long_description, product_id)
select NULL, 'CLaminate Top', 'The top of the table',  id from products
where description = 'Table';
INSERT INTO components (id, description, long_description, product_id)
select NULL, 'CMetal Brackets', 'The brackets that hold the table leaves together',  id from products
where description = 'Table';

INSERT INTO components (id, description, long_description, product_id)
select NULL, 'Super Wood', 'The super wood the Super Chair is made from',  id from products
where description = 'Super Fancy Chair';
INSERT INTO components (id, description, long_description, product_id)
select NULL, 'Super Laminate Top', 'The top of the Super Chair',  id from products
where description = 'Super Fancy Chair';
INSERT INTO components (id, description, long_description, product_id)
select NULL, 'Super Metal Brackets', 'The Super brackets that hold the super chair together',  id from products
where description = 'Super Fancy Chair';

INSERT INTO components (id, description, long_description, product_id)
select NULL, 'New Component 3A', 'New Component 3A',  id from products
where description = 'NewProduct3';
INSERT INTO components (id, description, long_description, product_id)
select NULL, 'New Component 3B', 'New Component 3B',  id from products
where description = 'NewProduct3';
INSERT INTO components (id, description, long_description, product_id)
select NULL, 'New Component 3C', 'New Component 3C',  id from products
where description = 'NewProduct3';
INSERT INTO components (id, description, long_description, product_id)
select NULL, 'New Component 3D', 'New Component 3D',  id from products
where description = 'NewProduct3';

INSERT INTO components (id, description, long_description, product_id)
select NULL, 'New Component 4A', 'New Component 4A',  id from products
where description = 'NewProduct4';
INSERT INTO components (id, description, long_description, product_id)
select NULL, 'New Component 4B', 'New Component 4B',  id from products
where description = 'NewProduct4';
INSERT INTO components (id, description, long_description, product_id)
select NULL, 'New Component 4C', 'New Component 4C',  id from products
where description = 'NewProduct4';
INSERT INTO components (id, description, long_description, product_id)
select NULL, 'New Component 4D', 'New Component 4D',  id from products
where description = 'NewProduct4';

INSERT INTO components (id, description, long_description, product_id)
select NULL, 'New Component 5A', 'New Component 5A',  id from products
where description = 'NewProduct5';
INSERT INTO components (id, description, long_description, product_id)
select NULL, 'New Component 5B', 'New Component 5B',  id from products
where description = 'NewProduct5';
INSERT INTO components (id, description, long_description, product_id)
select NULL, 'New Component 5C', 'New Component 5C',  id from products
where description = 'NewProduct5';
INSERT INTO components (id, description, long_description, product_id)
select NULL, 'New Component 5D', 'New Component 5D',  id from products
where description = 'NewProduct5';