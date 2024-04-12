function divi(n1, n2) {
    const divisione = n1 * n2

    document.querySelector('h1').innerText = divisione

}
divi(2, 5)



const persona = {
    nome: 'france',
    cognome: 'nacca',
    eta: '31'
}
console.log(persona)
const { nome, cognome, eta } = persona
console.log(persona)


const numeri = [4585, 5689, 9969]
const [cordi1, cordi2, cordi3] = numeri

console.log(cordi1)
console.log(cordi2)
console.log(cordi3)


