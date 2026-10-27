USE northwind;
SHOW INDEX FROM customers;

/* Mostra um resumo dos campos da tabela, o tipo de cada um, se é null e outras coisas */
DESC customers;

CREATE INDEX idx_ContactName ON customers(contactname);

/* usando 'explain' antes do select ele faz o mesmo que o botão de LUPA do workbench, que mostra algumas informações sobre a consulta */
explain
SELECT * 
FROM customers 
WHERE address like 'A%';

explain
SELECT * 
FROM customers 
WHERE contactName like 'A%';

explain
SELECT * 
FROM customers 
WHERE city like 'A%';

/* Cria índice FULLTEXT no campo address */
CREATE FULLTEXT INDEX idx_full ON customers(address, contactName);

-- explain
SELECT * 
FROM customers 
WHERE MATCH(address, contactName) AGAINST('ana');

SELECT * 
FROM customers 
WHERE MATCH(address, contactName) AGAINST('lusadas');