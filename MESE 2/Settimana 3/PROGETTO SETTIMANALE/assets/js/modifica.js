const nome = document.getElementById('inputName');
const brand = document.getElementById('inputBrand');
const prezzo = document.getElementById('inputPrezzo');
const url = document.getElementById('inputUrl');
const descrizione = document.getElementById('inputDescrizione');
const elimina = document.getElementById('elimina');

const dataUrl = "https://striveschool-api.herokuapp.com/api/product/"
let articoli = [];
const token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZWFjZTJkN2IxMTAwMTkwZTZmZmYiLCJpYXQiOjE3MDk4OTQzNTAsImV4cCI6MTcxMTEwMzk1MH0.-LYhNItgTaLVM8XEyzpt9FXTfDp-bf_-2wPP2VF5s6A"



window.addEventListener('load', init)

const caricaApi = async () => {
    try {
        const carica = await fetch(dataUrl, {
            headers: {
                "Authorization": token
            }
        })
        const risposta = await carica.json();
        articoli = risposta;
        console.log(articoli);
        card();
    }

    catch (error) {
        console.log(error);
    }
}
function cancellArticolo(){
    
}


elimina.addEventListener('click', (e)=>{
    e.preventDefault()
    let conferma=confirm('Sei sicura di voler eliminare l\'articolo?')
    if (conferma){
        cancellArticolo()
    }

})

function recuperoDati(dataString) {
    articoli.forEach((element) => {
        if (element._id == dataString) 
        {
            nome.value = element.name
            brand.value = element.brand
            prezzo.value = element.price
            url.value = element.imageUrl
            descrizione.value = element.description

        }
    })
}



async function init() {
    await caricaApi()
    const urlParamas = new URLSearchParams(window.location.search)
    const dataString = urlParamas.get('id')
    if (dataString) {
        recuperoDati(dataString)
    }
}

