const salva = document.getElementById('salva')
const elimina = document.getElementById('elimina')
const nome = document.getElementById('name')
const nomeSalvato = document.getElementById('nomeSalvato')


salva.addEventListener('click', function (e) {
    e.preventDefault()
    if (nome.value.trim() == '') {
        return;
    }

    localStorage.setItem('nome', nome.value)
    nomeSalvato.classList.remove('d-none');
    nomeSalvato.innerText = `${nome.value}`;
    nome.value = '';
});



elimina.addEventListener('click', function (e) {
    e.preventDefault()
    if (localStorage.getItem('nome')) {
        localStorage.removeItem('nome')
        nomeSalvato.classList.add('d-none')
    }

    nome.value = '';

});



const init = () => {
    if (localStorage.getItem('nome')) {
        localStorage.removeItem('nome')
        nomeSalvato.innerText = `${localStorage.getItem(nome.value)}`;
    }
    let tempo = sessionStorage.getItem('sessione') || 0;
    const p = document.getElementById('sessione')
    p.innerText = `Tempo della sessione ${tempo} secondi`;
    setInterval(() => {
        p.innerText = `Tempo della sessione${tempo} secondi`;
        tempo++;
        sessionStorage.setItem('sessione', tempo);

    }, 1000);


};
window.addEventListener('load', init);
