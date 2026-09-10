use northwind;

-- Procedure simples
-- o delimiter pode ser qualquer caractere para usar como delimitador
delimiter $$ 
-- create or replace funciona no MariaDB para procedure, no MYSQL apenas para VIEWS
CREATE OR REPLACE PROCEDURE sp_listaClientes()
BEGIN
	SELECT customerId, contactName, phone, address
    FROM customers;
END$$

-- é necessário restaura o delimiter para o padrão do ponto e vírgula
delimiter ; 

-- chamada da procedure
CALL sp_listaClientes();

delimiter $$
CREATE OR REPLACE PROCEDURE sp_listaClientesFiltro(in varNomeContato varchar(30))
BEGIN
	SELECT customerId, contactName, phone, address
    FROM customers
    WHERE contactName = varNomeContato;
END$$
delimiter ; 

call sp_listaClientesFiltro('Maria Anders')

delimiter $$
CREATE OR REPLACE PROCEDURE sp_listaPedidosFiltro(IN varCodPedido int, IN varDataPedido dateTime)
BEGIN
	IF varCodPedido is null and varDataPedido is null then
		SELECT orderId, customerId, orderDate, shipVia
		FROM orders;
	ELSE
		SELECT orderId, customerId, orderDate, shipVia
		FROM orders
		WHERE orderId = varCodPedido OR orderDate = varDataPedido;
	END IF;
END$$
delimiter ;

call sp_listaPedidosFiltro(10248, '1996-07-08 00:00:00');
call sp_listaPedidosFiltro(null, null);
call sp_listaPedidosFiltro(10260, null);
