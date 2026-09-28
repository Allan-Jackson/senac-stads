use northwind;

/*
	CURSOR: guarda o result set na memória em uma variável multidimensional
    
    Funciona como um ponteiro, não é possível usar ele para fazer as operações de valores, é preciso
    navegar pelo cursor e utilizá-lo para setar as variáveis para cada coluna da query, na ordem.alter
    
    É preciso ABRIR o cursor para alocá-lo na memória.
    
    Usamos o FETCH para navegar no cursor. Precisamos utilizar um loop para poder fazer essa navegação.
    
    É preciso usar CLOSE para fechar o cursor e desalocar a memória.
    
    Para saber se não tem mais registros para ler, usamos um HANDLER para setar a variável de controle

*/
delimiter //
CREATE OR REPLACE PROCEDURE sp_listaProdutosCursor() 
BEGIN
	DECLARE varNomeProd varchar(100);
    DECLARE varPrecoProd decimal(10, 4);
    DECLARE sairCursor boolean DEFAULT false;
    DECLARE varCursor CURSOR FOR 
		SELECT productName, unitPrice FROM products;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET sairCursor = TRUE;
    
	OPEN varCursor;
    
    lacoCursor: LOOP
		FETCH varCursor INTO varNomeProd, varPrecoProd;
        
        IF(sairCursor) THEN
			LEAVE lacoCursor;
        END IF;
        
        -- impressão dos resultados das variáveis
        SELECT varNomeProd as `Nome do Produto`, varPrecoProd as `Preço do Produto`;
        
    END LOOP;
    
    CLOSE varCursor;
END//
delimiter ;

CALL sp_listaProdutosCursor();


delimiter //
CREATE OR REPLACE PROCEDURE sp_buscaPedidoCursor()
BEGIN
	DECLARE varIdCliente char(5);
    DECLARE varNomeCliente varchar(100);
    DECLARE varIdPedido int;
    DECLARE varDataPedido datetime;
    DECLARE sairCursor boolean DEFAULT false;
    
    DECLARE varCursor CURSOR FOR 
		SELECT customers.customerId,
				customers.contactname,
				orders.orderId,
				orders.orderDate
		FROM customers JOIN orders 
			ON (customers.customerId = orders.customerId);
	
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET sairCursor = true;
    
    OPEN varCursor;
    
    printar: LOOP
		-- Lê o cursor e verifica se não tem mais nada
		FETCH varCursor INTO varIdCliente, varNomeCliente, varIdPedido, varDataPedido;
        
        -- faz o controle do ciclo
        IF (sairCursor) THEN
			LEAVE printar;
        END IF;
		
        SELECT varIdCliente, varNomeCliente, varIdPedido, varDataPedido;
    END LOOP;
    
    CLOSE varCursor;
END//

CALL sp_buscaPedidoCursor();