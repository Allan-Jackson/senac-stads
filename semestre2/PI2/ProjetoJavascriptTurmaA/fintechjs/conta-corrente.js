export class ContaCorrente {
    //attributes
    numero
    nomeCliente
    saldo

    constructor(pNum, pNome, pSaldo) {
        this.nomeCliente = pNome;
        this.numero = pNum;
        this.saldo = pSaldo;
    }

    //usar arrow functions evita que a referência para o 'this' se perca se a função for passada como callback em algum ponto do projeto
    consultarSaldo = () => {
        return `Conta de ${this.nomeCliente}\nSaldo: R$ ${this.saldo.toFixed(2)}`;
    }

    depositar = (valor) => {
        this.saldo += valor;
    }

    sacar = (valor) => {
        if(valor <= this.saldo) {
            this.saldo -= valor;
        }else {
            console.log('A conta não possui saldo suficiente para sacar!');
        }
    }

    pagar = (...args) => {
        if(args.length == 1 && typeof(args[0]) == 'number') {
            let valor = args[0];
            if(valor <= this.saldo) {
                this.saldo -= valor;
                console.log(`Pagamento de R$ ${valor.toFixed(2)} foi realizado com sucesso.`);
            }else {
                console.log('A conta não possui saldo suficiente para realizar o pagamento!');
            }
        }else if(args.length == 2 && typeof(args[0]) == 'number' && typeof(args[1]) == 'string') {
            let valor = args[0];
            let descricao = args[1];

            if(valor <= this.saldo) {
                this.saldo -= valor;
                console.log(`Pagamento de R$ ${valor.toFixed(2)} referente a '${descricao}' foi realizado com sucesso.`);
            }else {
                console.log('A conta não possui saldo suficiente para realizar o pagamento!');
            }
        }else {
            console.log("Argumentos inválidos!");
        }
    }

    pagar2 = (...args) => {
        //extrai os valores do array para duas variáveis
        const [arg0, arg1] = args;

        if(!(args.length == 1 && typeof(arg0) == 'number') && !(args.length == 2 && typeof(arg0) == 'number' && typeof(arg1) == 'string')) {
            console.log("Argumentos inválidos!");
            return;
        }

        let valor = arg0;
        let descricao;
        let msg;

        if(valor > this.saldo) {
            console.log('A conta não possui saldo suficiente para realizar o pagamento!');
            return;
        }

        this.saldo -= valor;

        if(arg1 != undefined) {
            descricao = arg1;
            msg = `Pagamento de R$ ${valor.toFixed(2)} referente a '${descricao}' foi realizado com sucesso.`;
        }else {
            msg = `Pagamento de R$ ${valor.toFixed(2)} foi realizado com sucesso.`;
        }

        console.log(msg);
       
    }

    transferir = (valor, contaDestino) => {
        if(valor <= this.saldo) {
            this.saldo -= valor;
            contaDestino.saldo += valor;
        }else {
            console.log('A conta não possui saldo suficiente para realizar a transferência!');
        }
    }
}