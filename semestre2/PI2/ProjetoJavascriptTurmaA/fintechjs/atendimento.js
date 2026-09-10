/* const fila = ['Luiz', 'Ana', 'Roberta']
const tamanho = fila.length
console.log('fila inicial: ', fila)

for(let i = 0; i < tamanho; i++){

    console.log('Atendimento de', fila.at(0), 'concluído')
    fila.shift()
    mostrarFila()

}

function mostrarFila(){
    if(fila.length == 0){
        console.log("Fila vazia");
    }else{
        console.log('Fila atual:', fila);
    }
}  */


let fila = []
function adicionarCliente() {
    let nome = prompt('Digite o nome do cliente')
    if(nome) {
        fila.push(nome)
    }else{
        alert('Você não colocou o nome, panaca!')
    }
}



function atenderCliente() {
    if(fila.length > 0) {
        let nome = fila.shift()
        let texto = `Cliente ${nome} atendido`
        alert(texto)
    }
}