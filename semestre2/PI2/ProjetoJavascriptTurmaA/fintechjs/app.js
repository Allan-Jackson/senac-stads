import { ContaCorrente } from "./conta-corrente.js";

let conta1 = new ContaCorrente(1, 'Luiz', 1000);
let conta2 = new ContaCorrente(2, 'Ana', 5000);

console.log(conta1.consultarSaldo());
console.log(conta2.consultarSaldo());

conta1.depositar(500);
conta1.sacar(1500);
console.log(conta1.consultarSaldo());

conta2.depositar(6000);
console.log(conta2.consultarSaldo())
conta2.pagar(3000)
console.log(conta2.consultarSaldo())
conta2.pagar(300, 'conta de água')
console.log(conta2.consultarSaldo())

console.log("\n\n\n")
console.log(conta1.consultarSaldo())
console.log(conta2.consultarSaldo())
conta2.transferir(100, conta1);
console.log(conta1.consultarSaldo())
console.log(conta2.consultarSaldo())

//teste do método pagar com argumentos diferentes
console.log("\n\nSaldo inicial da conta 1:")
conta1.depositar(1000)
console.log(conta1.consultarSaldo())
conta1.pagar2('texto')
conta1.pagar2('texto', 'descrição')
conta1.pagar2(100, 200)
conta1.pagar2(100, 'conta luz', 'algo mais')
conta1.pagar2(100, 'conta luz')
conta1.pagar2(300)
console.log(conta1.consultarSaldo())





