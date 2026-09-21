/*
FUNÇÃO é chamada apenas usando seu nome sem necessidade de 'CALL' como a procedure


*/

SELECT productId,
productName,
(unitprice * unitsinstock) AS totalProduto
FROM products;

-- retorna o valor total de itens estocados
SELECTsum((unitprice * unitsinstock)) AS totalEstoque
FROM products;

/*Essas funções são chamadas de função de agregação porque usam várias valores e agregam num só*/
SELECT  min(unitprice) AS menorValor,
		max(unitprice) AS maiorValor,
        avg(unitPrice) AS valorMedio,
        count(unitprice) AS QtdRegistros
        FROM products;


/* PASSO A PASSO PARA FAZER UMA CONSULTA QUE RETORNE:
Nº PEDIDO | DATA_PEDIDO | VALOR_TOTAL_PEDIDO
*/

-- ver todos os produtos X pedido
SELECT * FROM `order details`;

-- seleciona o valor total por produto de cada pedido
SELECT orderId, (unitPrice * quantity) as totalItem
FROM `order details`;

/* seleciona os pedidos com a soma do total de cada produto de cada pedido
	é necessário agrupar pelos pedidos, pois se não entra em conflito, pois
    o primeiro campo pede vários orderId e a função de agregação agrega vários valore
    de coluna, assim é preciso criar grupos para que a função sum se aplique a cada um*/
SELECT orderId, sum((unitPrice * quantity)) as totalItem
FROM `order details`
GROUP BY (orderId);

-- por fim, seleciona tbm a data do pedido, que está na tbl orders
SELECT orders.orderId as N_PEDIDO, orders.orderDate as DATA_PEDIDO, sum((unitPrice * quantity)) as TOTAL_PEDIDO
FROM `order details`
INNER JOIN orders
	ON (orders.orderId = `order details`.orderId)
GROUP BY (orders.orderId);

-- arredonda para 2 casas decimais usando a função ROUND(x,y)
/* ROUND(X, Y)
	X -> VALOR PARA ARREDONDAR
    Y -> NÚMERO DE CASAS DECIMAIS
*/
SELECT  orders.orderId as N_PEDIDO, 
		orders.orderDate as DATA_PEDIDO,
		round(sum((unitPrice * quantity)), 2) as TOTAL_PEDIDO
FROM `order details`
INNER JOIN orders
	ON (orders.orderId = `order details`.orderId)
GROUP BY (orders.orderId);


-- retorna o mesmo que a consulta anterior, mas com a máscara da moeda usando CONCAT
SELECT  orders.orderId as N_PEDIDO, 
		orders.orderDate as DATA_PEDIDO,
		concat('R$ ', round(sum((unitPrice * quantity)), 2)) as TOTAL_PEDIDO
FROM `order details`
INNER JOIN orders
	ON (orders.orderId = `order details`.orderId)
GROUP BY (orders.orderId);


-- retorna o mesmo que a consulta anterior, usando TRUNCATE que corta as casas decimais sem arredondar
SELECT  orders.orderId as N_PEDIDO, 
		orders.orderDate as DATA_PEDIDO,
		concat('R$ ', round(sum((unitPrice * quantity)), 2)) as TOTAL_PEDIDO_ARREDONDADO,
        concat('R$ ', truncate(sum((unitPrice * quantity)), 1)) as TOTAL_PEDIDO_TRUNCADO
FROM `order details`
INNER JOIN orders
	ON (orders.orderId = `order details`.orderId)
GROUP BY (orders.orderId);

-- pega o valor em módulo (valor absoluto)
select abs(-785);

-- pega o seno do valor
select sin(0);

-- pega o cosseno do valor
select cos(0);

/*  pega um valor aleatório de 0 a 1.
	RAND(N) -> pode passar um valor N como semente
    */
select rand(2);

-- função concat para concatenar texto
SELECT concat('Código do cliente: ', customerId, ' Nome do contato: ', contactName)
FROM customers;


-- função para transformar em maiúscula ou minúscula
SELECT  upper(contactName) AS maiusculo,
		lower(contactName) AS minusculo
FROM customers;

-- usa da função LENGTH para pegar o tamanho de uma string
SELECT contactName, length(contactName) AS tamanho FROM customers;

/* função substring(S, I, F)
	S -> string para aplicar
    I -> posição de inicio
    F -> posição final inclusivo
    
    A primeira posição tem valor 1 (não ZERO como de costume)
*/
SELECT contactName, substring(contactName, 1, length(contactName)) FROM customers;

-- pode-se usar o 'FROM' também, mas usando só o parâmetro de início
SELECT contactName, substring(contactName from 1) FROM customers;

-- com números negativos, retorna do final da string para o começo a partir do -1
SELECT contactName, substring(contactName, -1) FROM customers;


SELECT contactName, substring(contactName, 5, 3) from customers;

-- pega todos em minusculo com a ultima em maiusculo
SELECT concat( substring(lower(contactName), 1, length(contactName)-1), upper(substring(contactName, -1)) )
FROM customers;