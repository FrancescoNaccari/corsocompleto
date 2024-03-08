const cartContainer = document.getElementById('cartContainer');
const btnModifica = document.getElementById('btn-modifica');
const btnScopri = document.getElementById('btn-scopri');

const dataUrl = "https://striveschool-api.herokuapp.com/api/product/"
let articoli = [];
const token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZWFjZTJkN2IxMTAwMTkwZTZmZmYiLCJpYXQiOjE3MDk4OTQzNTAsImV4cCI6MTcxMTEwMzk1MH0.-LYhNItgTaLVM8XEyzpt9FXTfDp-bf_-2wPP2VF5s6A"
const primoProdotto = {
    "name": "Nokia 3310",
    "description": "Indestructible cellphone",
    "brand": "Nokia",
    "imageUrl": "https://upload.wikimedia.org/wikipedia/commons/thumb/7/78/Nokia_3310_Blue_R7309170_%28retouch%29.png/125px-Nokia_3310_Blue_R7309170_%28retouch%29.png",
    "price": 99
}


window.addEventListener('load', init)

async function init() {
   await caricaApi()
    prodotto()
}

const prodotto = async () => {
    console.log(token,primoProdotto)
    let stop=false
    articoli.forEach((element) => {
        if (element.name==primoProdotto.name){
            stop=true
        }

    })
    if (stop){
        return
    }
        try {
        const carica = await fetch(dataUrl, {
            method: "POST",
            headers: {
                "Authorization": token,
                "Content-Type": "application/json"
            },
            body: JSON.stringify(primoProdotto)
        });

        if (carica.ok) {
            console.log("Prodotto aggiunto con successo!");
        } else {
            console.error("Errore durante l'aggiunta del prodotto:", carica.status);
        }

    } catch (error) {
        console.log(error);
    }
}





contenutoCard = (element, col) => {
    col.innerHTML = `<div class="card d-flex align-items-center text-center" >
<img src="${element.imageUrl}" class="card-img-top w-50 " ; alt="...">
<div class="card-body">
  <h5 class="card-title">${element.name}</h5>
  <p class="card-text">${element.description}</p>
</div>

<div class="card-body">
  <a href="modifica.html?id=${element._id}"><button id='btn-modifica' class="btn btn-warning me-2" type="">Modifica</button></a>
  <a href="Details.html?id=${element._id}"><button id='btn-scopri' class="btn bg-info" type="">Scopri di più</button></a>
</div>
</div> `;
   cartContainer.appendChild(col);
} 






const card = () => {
    articoli.forEach((element) => {
        const col = document.createElement('div')
        col.classList.add('col-3', 'my-3')
        contenutoCard(element, col)
    });


}


const caricaApi = async () => {
    try {
        const carica = await fetch(dataUrl, {
            headers: {
                "Authorization": token
            }
        })
        const risposta = await carica.json();
        articoli = risposta;
        card();
        console.log(articoli);

    }

    catch (error) {
        console.log(error);
    }
}
