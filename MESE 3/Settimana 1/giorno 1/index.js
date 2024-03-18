"use strict";
class User {
    constructor(_nome, _cognome) {
        this.nome = _nome;
        this.cognome = _cognome;
        this.credito = 0;
        this.numeroChiamate = 0;
        this.costoChiamata = 0.20;
    }
    ricarica(ricarica) {
        this.credito += ricarica;
    }
    chiamata(minuti) {
        this.numeroChiamate += minuti;
        this.credito -= (minuti * this.costoChiamata);
    }
    chiamata404() {
        return this.credito;
    }
    getNumeroChiamata() {
        return this.numeroChiamate;
    }
    azzeraChiamata() {
        this.numeroChiamate = 0;
    }
}
const cliente = new User('Francesco', 'Naccari');
console.log('Utente creato:' + cliente.nome + '' + cliente.cognome);
console.log('Credito iniziale:' + cliente.chiamata404());
console.log('Minuti iniziali consumati:' + cliente.getNumeroChiamata());
cliente.ricarica(10);
console.log('Ricarica di 10 euro effettuata');
console.log('Nuovo saldo:' + cliente.chiamata404());
cliente.chiamata(3);
console.log('Chiamata effettuata. Minuti consumati: ' + cliente.getNumeroChiamata());
console.log('Nuovo credito: ' + cliente.chiamata404());
