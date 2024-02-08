const button = document.getElementById('button')
const tombola = document.getElementById('tombola');
const tombolaArrey = [];
const numeriUsciti = [];



const creaTombola = () => {
    for (let i = 0; i < 90; i++) {
        const div = document.createElement('div');
        const span = document.createElement('span');
        span.innerText = i + 1;
        div.setAttribute('id', `numero-${i}`)
        div.classList.add('cella');
        div.appendChild(span);
        tombola.appendChild(div);
        tombolaArrey.push(i);
    }
};

const numeroRandom = () => {
    let numero = Math.floor(Math.random() * tombolaArrey.length) + 1
    let find = numeriUsciti.indexOf(numero)
    if (find === -1) {
        tombolaArrey.push(numero)
        const cella= document.getElementById(`numero-${(numero-1)}`)
        cella.classList.add('usciti');
    } else {
        if( numeriUsciti.length < tombolaArrey.length){
            numeroRandom()
        }
        
    }
}


button.addEventListener('click', function (e) {
    e.preventDefault()
    numeroRandom()
})



window.addEventListener('load', function () {
    creaTombola()

});




