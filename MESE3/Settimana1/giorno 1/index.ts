interface Smartphone {
    credito: number;
    numeroChiamate: number;
    ricarica(ricarica: number): void;
    chiamata(minuti: number): void;
    chiamata404(): number;
    getNumeroChiamata(): number;
    azzeraChiamata(): void;
}


class User implements Smartphone {
    nome: string;
    cognome: string;
    credito: number;
    numeroChiamate: number;
    protected costoChiamata: 0.20;
    constructor(_nome: string, _cognome: string) {
        this.nome = _nome;
        this.cognome = _cognome;
        this.credito = 0;
        this.numeroChiamate = 0;
        this.costoChiamata = 0.20

    }

    ricarica(ricarica: number): void {
        this.credito += ricarica;
    }
    chiamata(minuti: number): void {
        this.numeroChiamate += minuti;
        this.credito -= (minuti * this.costoChiamata)
    }
    chiamata404(): number {
        return this.credito
    }
    getNumeroChiamata(): number {
        return this.numeroChiamate
    }
    azzeraChiamata(): void {
        this.numeroChiamate = 0
    }
}

const cliente = new User('Francesco', 'Naccari')
console.log('Utente creato:' + cliente.nome + '' + cliente.cognome)
console.log('Credito iniziale:' + cliente.chiamata404())
console.log('Minuti iniziali consumati:' + cliente.getNumeroChiamata())
cliente.ricarica(10);
console.log('Ricarica di 10 euro effettuata');
console.log('Nuovo saldo:' + cliente.chiamata404());
cliente.chiamata(3);
console.log('Chiamata effettuata. Minuti consumati: ' + cliente.getNumeroChiamata());
console.log('Nuovo credito: ' + cliente.chiamata404());