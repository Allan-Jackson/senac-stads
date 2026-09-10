export class Abelha {
    nome: String;
    especie: String;
    possuiFerrao: Boolean;

    constructor(nome: String, especie: String, possuiFerrao: Boolean = false) {
        this.nome = nome;
        this.especie = especie;
        this.possuiFerrao = possuiFerrao;
    }

    coletarNectar() {
        console.log("Abelha coletou nectar.");
    }

    voar() {
        console.log("A abelha voou!");
    }
}