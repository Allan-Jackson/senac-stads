let nome = "Cezar"; //Escopo global ou de função
var idade = 18;
const pais = "Brasil"; //Valor constante. Impede reatribuição

if(true) {
    var idade = 20;
    let nome = "Ana";
    //console.log(nome, idade);
    console.log(`nome: ${nome} - idade: ${idade}`)
}

console.log(idade);
console.log(nome)
