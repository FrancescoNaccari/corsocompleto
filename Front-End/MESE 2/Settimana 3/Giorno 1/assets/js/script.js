/*ESERCIZIO 1*/
class User {
    constructor(_firstName, _lastName, _age, _location) {
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.age = _age;
        this.location = _location;
    }
    confronto = function (utente2) {
        if (this.age > utente2.age) {
            console.log(`${this.firstName} è più grande di ${user2.firstName}`)
        } else if (this.age < utente2.age) {
            console.log(`${this.firstName} è più piccolo di ${user2.firstName}`)
        } else
            console.log(`${this.firstName} ha la stesse età di ${user2.firstName}`)

    }
}


const user1 = new User('Francesco', 'Naccari', 31, 'Palermo')
const user2 = new User('Marco', 'Bianchi', 30, 'Roma')

user1.confronto(user2)

/*ESERCIZIO 2*/
let stessoPdrone;
class Pet {
    constructor(_petName, _ownerName, _species, _breed) {
        this.petName = _petName;
        this.ownerName = _ownerName;
        this.species = _species;
        this.breed = _breed;
    }
    condivisione = function (pet2) {
        if (this.ownerName === pet2.ownerName) {
            stessoPdrone = true
            console.log(`${this.petName} e ${pet3.petName} hanno lo stesso padrone`)
        } else {
            stessoPdrone = false
            console.log(`${this.petName} e ${pet3.petName} non hanno lo stesso padrone`)
        }
    }
}

const pet1 = new Pet('ciccio', 'Michele', 'cane', 'beagle ')
const pet2 = new Pet('mia', 'Fabiana', 'gatto', 'Maine Coon ')
const pet3 = new Pet('cloe', 'Fabiana', 'gatto', 'Maine Coon ')

bntAggiungi = document.getElementById('aggiungi')
pet2.condivisione(pet3)
const animal = [];

bntAggiungi.addEventListener('click', e => {
    e.preventDefault();
 
    let petName = document.getElementById('petName');
    let ownerName = document.getElementById('ownerName');
    let species = document.getElementById('species');
    let breed = document.getElementById('breed');

    const pet = new Pet(petName.value, ownerName.value, species.value, breed.value);
    animal.push(pet);

  
    petName.value = "";
    ownerName.value = "";
    species.value = "";
    breed.value = "";
    generaLista();


});

function generaLista() {
    let tabella = document.getElementById('tabella');
    tabella.innerHTML = '';
    animal.forEach((element) => {
        

        const riga = document.createElement("tr");
        const petName = document.createElement("th");
        const ownerName = document.createElement("th");
        const species = document.createElement("th");
        const breed = document.createElement("th");
        petName.innerText = element.petName;
        ownerName.innerText = element.ownerName;
        species.innerText = element.species;
        breed.innerText = element.breed;
        riga.append(petName, ownerName, species, breed);
        tabella.appendChild(riga);
    })
}

