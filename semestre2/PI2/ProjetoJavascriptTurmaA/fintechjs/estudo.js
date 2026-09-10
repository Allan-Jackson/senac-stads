class Exemplo {
    atributoClasse1;

    metodo1() {
        console.log('metodo 1');
    }

    metodoArrow = () => {
        console.log('metodo arrow');
    }
}

const e = new Exemplo();

const proto = Object.getPrototypeOf(e);
Object.getOwnPropertyNames(proto).forEach(item => {
    console.log(item);
})