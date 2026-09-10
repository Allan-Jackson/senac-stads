## FLUXO DE PAGAMENTO DO PEDIDO (JORNADA DO DINHEIRO)

TABELA PAGAMENTO:

Representa uma transação de pagamento, cada nova tentativa de pagamento vai gerar um novo registro na tabela. Se o usuário alterar a opção de pagamento, ou se tiver que tentar outra vez após o cartão dar recusado pelo banco. Assim, o pagamento atual vai ser aquele que tiver a data mais recente (ORDER BY DATA DESC).

Por exemplo, na hora de atualizar o pedido que foi estornado, vai ser preciso buscar o pagamento que tenha o status APROVADO e então modificá-lo.

Status_Pagamento:

- PENDENTE: gerou boleto e ainda não pagou; cartão sendo processado;

- EXPIRADO: o prazo para o pagamento venceu e o cliente não pagou, resultando no cancelamento do pedido e, claro, não recebimento do valor. (FINAL)

- APROVADO: o banco deu "ok", o pagamento aconteceu

- RECUSADO: o cartão não tinha limite; estava vencido ou algum outro problema. (FINAL)

- ESTORNADO: o dinheiro foi devolvido para o cliente (FINAL)

- ABORTADO: o cliente cancelou por vontade própria o pedido, não realizando o pagamento. (FINAL)

Resumo do fluxo do status_pagamento:

> PENDENTE:
> 
> - EXPIRADO (FINAL);
> 
> - RECUSADO (FINAL);
> 
> - ABORTADO (FINAL).
> 
> APROVADO:
> 
> - ESTORNADO (FINAL);

As datas são importantes para manter a auditoria, isto é, saber exatamente o que aconteceu com o dinheiro.

**Data_criacao**: guarda o momento em que o cliente clicou em 'pagar', ou seja, quando um pagamento foi criado.

**Data_confirmacao**: guarda o momento em que o dinheiro caiu na conta, isto é, que o banco deu o "OK" e o pagamento foi APROVADO. É necessário para saber quanto tempo levou entre o pagamento e um pedido de estorno ou quanto tempo o cliente demorou para pagar o pedido (calcular tempo médio e propor melhorias para o negócio).

**Data_ultimo_status**: guarda o momento em que o status do pagamento foi alterado, inclui quando o pagamento é criado e quando é mudado para algum status final ou para aprovado.

**Data_expiracao**: guarda o momento em que aquele pagamento deve expirar, ou seja, o tempo limite que o cliente tem para realizar o pagamento daquele pedido antes que ele EXPIRE. Esse tempo vai variar de acordo com o metodo de pagamento, se for cartão pode expirar em 2 horas, por exemplo, o tempo que o usuário teria para realizar um pagamento com sucesso, se for pix, tem 30 minutos para pagar o qrcode, se for boleto, vence em 3 dias, e etc.

**Metodo_de_pagamento**: guarda, por meio de string ou números associativos, o método de pagamento escolhido, facilitando assim consultas de meios mais utilizados de pagamento e coisas do tipo, facilita a análise de dados.

**Valor_pago**: refere-se ao valor total que o cliente efetivamente pagou, ou seja, o valor com todos os descontos e taxas já aplicados.

**Id_transacao_externo**: armazena o identificador da transacao no gateway





**METODOS DE PAGAMENTO:**

TBL PIX:

Representa uma transacao por PIX e possui alguns dados próprios desse meio de pagamento, tais como:

- **QR_code**: guarda o código relacionado ao qr_code (pix copia e cola)



TBL BOLETO:

Representa uma transacao por BOLETO e possui alguns dados próprios do meio de pagamento, como:

- **Linha_digitavel**: é a representação do código de barras para digitação manual em apps de banco e parecido

- **Codigo_de_barras**: é a representação do código de barras para a leitura de scanners.

- **Data_pagamento_real**: guarda a data em que o cliente, DE FATO, realizou o pagamento do boleto no caixa eletrônico ou no app do banco.
  
  > Pode diferir da Data_confirmacao do pagamento, pois o boleto pode levar até 48h para ser compensado, o que acontece quando cai em sábado e domingo (o sistema pode verificar se a data_expiracao cai em final de semana e adicionar +2 dias para essa carência e não gerar problema no pedido do cliente), essa data é necessária guardar para auditorias
  
  

TBL CARTAO:

Representa uma transação por CARTAO e possui alguns dados próprios e comuns a CREDITO e DEBITO:

- **NOME_TITULAR**: o nome do titular do cartão

- **VALIDADE**: a validade do cartão

- **BANDEIRA**: a bandeira do cartão

- **QUATRO_ULTIMO_DIGITOS**: não guarda o número do cartão real, apenas os 4 últimos dígitos para verificação



TBL DEBITO:

Possui apenas o campo identificador e a chave FK para a tabela de pagamento cartão para identificar o tipo de pagamento como débito.



TBL CREDITO:

Possui alguns campos específicos para o pagamento no crédito:

- **NUMERO_PARCELAS**: guarda a quantidade de parcelas do pagamento

- **VALOR_TOTAL_JUROS**: guarda o valor total de juros que serão pagos, caso haja juros nas parcelas

- **VALOR_PARCELA**: guarda o valor de cada parcela



## FLUXO DE LOGISTICA DO PEDIDO

TB_PEDIDO

status_pedido:

- AGUARDANDO_PAGAMENTO: o pedido foi criado, mas ainda não foi pago
  
  > Mantém esse status enquanto o pagamento for PENDENTE ou RECUSADO (ou diferente de APROVADO)

- EM SEPARAÇÃO: o pedido foi pago e o produto está sendo separado pela equipe de logística
  
  > Só vai receber esse status quando o pagamento retornar com APROVADO;

- ENVIADO: o produto já foi entregue para a transportadora

- ENTREGUE: o produto chegou para o cliente

- CANCELADO: o pedido não vai mais acontecer
  
  > Vai para esse status quando sai direto de AGUARDANDO_PAGAMENTO, pode significar que o cliente esqueceu de pagar a compra ou desistiu e somente não pagou (assim o pagamento expirou, status_pagamento = EXPIRADO) ou que o cliente definitivamente desistiu da compra, cancelando manualmente o pedido na plataforma (status_pagamento = ABORTADO)

- DEVOLVIDO: o cliente devolveu o produto
