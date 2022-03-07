INSERT INTO clientes(nombre,apellidos,sexo,telefono,ventas) VALUES ("Andrés","González Fernández","Hombre",657899900,1);
INSERT INTO clientes(nombre,apellidos,sexo,telefono,ventas) VALUES ("Rafa","García Irazusta","Hombre",656129901,2);
INSERT INTO clientes(nombre,apellidos,sexo,telefono,ventas) VALUES ("Rainiero","Fresno Duval","Hombre",668945020,3);
INSERT INTO clientes(nombre,apellidos,sexo,telefono,ventas) VALUES ("Pablo","Sariego Alonso","Hombre",601945310,4);

INSERT INTO productos(nombre,descripcion,precio_unitario,existencias,ventas) VALUES ("Leche","Leche entera marca Pascual",5.20,100,1);
INSERT INTO productos(nombre,descripcion,precio_unitario,existencias,ventas) VALUES ("Pan","Barra de pan larga",5.20,150,2);
INSERT INTO productos(nombre,descripcion,precio_unitario,existencias,ventas) VALUES ("Agua","Agua mineral natural Fuensanta",5.70,50,3);

INSERT INTO ventas(numeroCliente,claveProducto,cantidad,subtotal,iva,total) VALUES (1,1,2,10.40,21,12.58);
INSERT INTO ventas(numeroCliente,claveProducto,cantidad,subtotal,iva,total) VALUES (2,2,3,15.60,10,17,16);
INSERT INTO ventas(numeroCliente,claveProducto,cantidad,subtotal,iva,total) VALUES (3,2,2,10.40,10,11,44);
INSERT INTO ventas(numeroCliente,claveProducto,cantidad,subtotal,iva,total) VALUES (4,3,4,22.80,4,23.71);