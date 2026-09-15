USE northwind;

delimiter $$
CREATE OR REPLACE PROCEDURE sp_listaPedidosRepeat() 
BEGIN
	DECLARE varQtdPedidos int DEFAULT 0;
    DECLARE varContador int DEFAULT 0;
    
    -- busca na tabela orders a quantidade de pedidos e seta na variável
    SELECT count(*) INTO varQtdPedidos from orders;
    
    REPEAT 
		SELECT * FROM orders LIMIT varContador, 10; -- limit index, length
        SET varContador = varContador + 10;
		UNTIL varContador > varQtdPedidos
    END REPEAT;
END$$
delimiter ;

CALL sp_listaPedidosRepeat();

SELECT COUNT(*) FROM ORDERS

delimiter //
CREATE OR REPLACE PROCEDURE sp_listaPedidosLoop() 
BEGIN
	DECLARE varQtdPedidos int DEFAULT 0;
    DECLARE varContador int DEFAULT 0;
    
    SELECT count(*) INTO varQtdPedidos FROM orders;
    
    laco: LOOP
		IF(varContador > varQtdPedidos) THEN
			LEAVE laco;
        END IF;
        
        SELECT * FROM orders LIMIT varContador, 10;
        
        SET varContador = varContador + 10;
        
    END LOOP;
END//
delimiter ;

CALL sp_listaPedidosLoop();

/* TIPOS DE PARÂMETROS
 *
 * IN: ENTRADA DE DADOS
 * OUT: RETORNA DADOS
 * INOUT: RECEBE E RETORNA DADOS
 *
 * PARÂMETRO DE SAÍDA LIMITA A PROCEDURE A RETORNAR UM ÚNICO VALOR
 * ENQUANTO ELA PODERIA DEVOLVER VÁRIOS COM UM RESULT SET
 */
 
delimiter &&
CREATE PROCEDURE sp_listaProdutoIn(IN varCodProd INT)
BEGIN
	SELECT productName, unitPrice, unitsInStock
	FROM products
	WHERE ProductID = varCodProd;
END&&
delimiter ;

CALL sp_listaProdutoIn(2);

delimiter //
CREATE OR REPLACE PROCEDURE sp_listaQtdProdutosOut(IN varCodCat int, OUT varQtdProdutos int)
BEGIN
	SELECT COUNT(*) INTO varQtdProdutos 
    FROM products
    WHERE categoryId = varCodCat;
END//
delimiter ;

SELECT * FROM PRODUCTS
WHERE CATEGORYiD IS NOT NULL
LIMIT 10;

SET @totalProdutos = 0; -- variável temporária para pegar algum valor, por isso não tem tipo
CAll sp_listaQtdProdutosOut(2, @totalProdutos);
SELECT @totalProdutos;

delimiter //
CREATE OR REPLACE PROCEDURE sp_atualizaEstoqueInOut(INOUT varCodProd int, IN varQtdAdicional int)
BEGIN
	-- atualizar o estoque adicional
	UPDATE products
    SET unitsInStock = unitsInStock + varQtdAdicional
    WHERE productId = varCodProd;
    
    -- retornar a quantidade de estoque atualizada
    SELECT unitsInStock INTO varCodProd
    FROM products
    WHERE productId = varCodProd;
END//
delimiter ;

select productId, unitsInStock from products where productId = 1;

SET @id = 1; -- cria uma variável que vai passar a entrada e também vai receber a saída
CALL sp_atualizaEstoqueInOut(@id, 11);
SELECT @id -- printa a saída que é um dado diferente da entrada


delimiter @
CREATE OR REPLACE PROCEDURE sp_resumoPedido(
	IN varCodPedido int,
    OUT varTotalItens int,
    INOUT varValorTotal decimal(10,2)
)
BEGIN
	-- busca quantos itens existem para um determinado pedido 
	SELECT count(*) INTO varTotalItens
    FROM `order details`
    WHERE orderId = varCodPedido;
    
    -- busca o valor total do pedido somando o total de todos os produtos do pedido
    SELECT SUM(unitPrice * quantity)  INTO varValorTotal
    FROM `order details`
    WHERE orderId = varCodPedido;
END@
delimiter ;

select * from `order details` where orderId = 10248;

-- TODO: VER COMO PEGAR DE FORMA DISTINTA AS ORDENS QUE TEM PELO MENOS 3 OU MAIS PRODUTOS ASSOCIADOS
SELECT distinct orderId FROM `order details` having count(orderId) >= 3;

SET @itensTotais = 0;
SET @total = 0;
CALL sp_resumoPedido(10248, @itensTotais, @total);
SELECT @itensTotais, @total;
