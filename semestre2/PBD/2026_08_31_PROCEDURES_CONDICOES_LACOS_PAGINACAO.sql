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

delimiter //
CREATE OR REPLACE PROCEDURE sp_atualizaPrecoProduto(IN varCodProduto int,  IN varPrecoUnitario decimal(10,4))
BEGIN
	IF varCodProduto is not null and varPrecoUnitario is not null THEN
		UPDATE products SET unitPrice = varPrecoUnitario
		WHERE productId = varCodProduto;
	ELSE
		SELECT 'Os parâmetros: Codigo produto e/ou Preco Unitario estão nulos!' as RESULTADO;
    END IF;
END//
delimiter ;

select * from products where productId = 3;
CALL sp_atualizaPrecoProduto(3, null);
select * from products where productId = 3;

-- Retorna msg com qtd de estoque e qual o status do estoque com ESTRUTURA IF
delimiter $$
CREATE OR REPLACE PROCEDURE sp_estoqueProdutos(IN varCodProduto int)
BEGIN
	 DECLARE varQtdEstoque int;
     DECLARE varMsg varchar(50);
     
     SELECT unitsInStock, CONCAT('O estoque do produto ', varCodProduto) INTO varQtdEstoque, varMsg FROM products
     WHERE productId = varCodProduto; 
     
     IF(varQtdEstoque >= 100) THEN
		SET varMsg = CONCAT(varMsg, ' está alto : ', varQtdEstoque);
     ELSEIF(varQtdEstoque >= 11) THEN
		SET varMsg = CONCAT(varMsg, ' está OK : ', varQtdEstoque);
     ELSE
		SET varMsg = CONCAT(varMsg, ' está baixo : ', varQtdEstoque); 
     END IF;
 
     select varMsg as RESULTADO;
END$$
delimiter ;

call sp_estoqueProdutos(1);
call sp_estoqueProdutos(6);
call sp_estoqueProdutos(8);

-- Retorna msg com qtd de estoque e qual o status do estoque com WHEN CASE
delimiter $$
CREATE OR REPLACE PROCEDURE sp_estoqueProdutosWhenCase(IN varCodProduto int)
BEGIN
	 DECLARE varQtdEstoque int;
     DECLARE varMsg varchar(50);
     
     SELECT unitsInStock, CONCAT('O estoque do produto ', varCodProduto) INTO varQtdEstoque, varMsg FROM products
     WHERE productId = varCodProduto; 
     
     CASE
		WHEN varQtdEstoque >= 100 THEN
			SET varMsg = CONCAT(varMsg, ' está alto : ', varQtdEstoque);
		WHEN varQtdEstoque >= 11 THEN
			SET varMsg = CONCAT(varMsg, ' está OK : ', varQtdEstoque);
		ELSE
			SET varMsg = CONCAT(varMsg, ' está baixo : ', varQtdEstoque); 
     END CASE; 
 
     select varMsg as RESULTADO;
END$$
delimiter ;

call sp_estoqueProdutos(1);
call sp_estoqueProdutos(6);
call sp_estoqueProdutos(8);

select productId, unitsInStock from products where productId


delimiter //
CREATE OR REPLACE PROCEDURE sp_lista_pedidos_paginacao(IN varIndiceInicio int, IN varQtdPorPagina int)  
BEGIN
	/* 
	LIMIT X, Y 
		 X => o índice de onde começar (a partir do zero)
		 Y => a quantidade de registros para retornar 
	*/
	SELECT * FROM orders LIMIT varIndiceInicio, varQtdPorPagina;
END//
delimiter ;

select * from orders limit 20;

CALL sp_lista_pedidos_paginacao(0, 10);

delimiter //
CREATE OR REPLACE PROCEDURE sp_lista_pedidos()  
BEGIN
	DECLARE varTotalPedidos int;
    DECLARE varContador int DEFAULT 0;
    
    SELECT COUNT(*) INTO varTotalPedidos FROM orders;
    
    WHILE(varContador < varTotalPedidos) DO
		SELECT * FROM orders LIMIT varContador, 5;
		SET varContador = varContador + 5;
    END WHILE;
END//
delimiter ;

CALL sp_lista_pedidos();

