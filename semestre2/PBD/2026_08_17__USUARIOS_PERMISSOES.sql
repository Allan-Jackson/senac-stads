use northwind;

#select * from customers;
SELECT  customers.customerId, 
		customers.companyName,
        customers.address,
        orders.orderId,
        orders.orderDate,
        orders.shipVia,
        `order details`.ProductID,
        `order details`.Quantity,
        `order details`.UnitPrice
FROM customers JOIN orders 
	ON customers.customerId = orders.CustomerID
JOIN `order details` 
	ON orders.OrderID = `order details`.OrderID;
CREATE USER 'allan'
IDENTIFIED BY '1234';

SELECT * FROM mysql.user
where is_role = 'Y';

ALTER USER 'allan'@'localhost' IDENTIFIED BY '4321';

DROP USER 'allan'@'localhost';

CREATE USER 'Joao' IDENTIFIED BY '1234';
CREATE USER 'Maria' IDENTIFIED BY '1234';
CREATE USER 'Jose' IDENTIFIED BY '1234';
CREATE USER 'Pedro' IDENTIFIED BY '1234';

select * from mysql.user
where user in ('Joao', 'Maria', 'Jose', 'Pedro');

GRANT SELECT, INSERT ON customers TO 'Maria';
GRANT SELECT, INSERT ON orders TO 'Maria';
GRANT SELECT, INSERT ON products TO 'Maria';

SELECT * FROM mysql.tables_priv where user = 'Maria';

REVOKE SELECT, INSERT ON customers FROM 'Maria';

REVOKE INSERT ON products FROM 'Maria';

CREATE ROLE 'gestor_dados';
CREATE ROLE 'analista_dados';
CREATE ROLE 'visitante_dados';

GRANT SELECT, INSERT, UPDATE, DELETE ON customers TO 'gestor_dados';
GRANT SELECT, INSERT, UPDATE, DELETE ON orders TO 'gestor_dados';
GRANT SELECT, INSERT, UPDATE, DELETE ON products TO 'gestor_dados';


SELECT * FROM mysql.tables_priv WHERE user = 'gestor_dados';

GRANT 'gestor_dados' TO 'Jose';

flush privileges;

SELECT * FROM mysql.roles_mapping where role = 'gestor_dados';

-- dar permissão para o analista e visitante
GRANT SELECT, INSERT, UPDATE ON products TO 'analista_dados';
GRANT SELECT, INSERT, UPDATE ON customers TO 'analista_dados';
GRANT SELECT, INSERT, UPDATE ON orders TO 'analista_dados';

GRANT SELECT ON products TO 'visitante_dados';
GRANT SELECT ON customers TO 'visitante_dados';
GRANT SELECT ON orders TO 'visitante_dados';

-- dar os roles para O Pedro e Maria
GRANT 'analista_dados' TO 'Maria';
GRANT 'visitante_dados' TO 'Pedro';

SELECT * FROM mysql.user;
SELECT * FROM mysql.roles_mapping WHERE role like '%dados' and user <> 'root';
SELECT * FROM mysql.tables_priv WHERE user like '%dados';


