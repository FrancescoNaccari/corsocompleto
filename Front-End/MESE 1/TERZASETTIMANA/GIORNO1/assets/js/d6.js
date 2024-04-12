/* ESERCIZIO 1
      Scrivi una funzione per cambiare il titolo della pagina in qualcos'altro
   */

const changeTitle = function () {
    document.getElementsByTagName('h1')[0].innerText = 'Esercizio 1'
}
changeTitle();
/* ESERCIZIO 2
 Scrivi una funzione per aggiungere al titolo della pagina una classe "myHeading"
*/

const addClassToTitle = function () {
    document.getElementsByTagName('h1')[0].setAttribute('class', 'myHeading')
};
addClassToTitle()
/* ESERCIZIO 3
 Scrivi una funzione che cambi il testo dei p figli di un div
*/

const changePcontent = function () {
    let selletore = document.querySelectorAll('div p')
    for (i = 0; i < selletore.length; i++) {
        selletore[i].innerText = 'ciao'
    }

}

changePcontent()
/* ESERCIZIO 4
 Scrivi una funzione che cambi la proprietà href di ogni link (tranne quello nel footer) con il valore https://www.google.com
*/

const changeUrls = function () {
    let links = document.querySelectorAll('a');
    for (let i = 0; i < links.length; i++) {
        const footer = links[i].closest('footer');
    
    if (!footer) {
        links[i].href = 'https://www.google.com/'

    }
}
}

changeUrls()

/* ESERCIZIO 5
 Scrivi una funzione che aggiunga un nuovo elemento lista alla seconda lista non ordinata
*/

const addToTheSecond = function () {
    let li= document.createElement('li');
    li.innerHTML ='<li> nuovo testo </li>';
document.getElementById('secondList').appendChild(li);
};

/* const addToTheSecond = function () {
    let secondList = document.getElementById('secondList')
    secondList.nnerHTML +='<li> nuovo testo </li>'
}  */
addToTheSecond()
/* ESERCIZIO 6
 Scrivi una funzione che aggiunga un paragrafo al primo div
*/

const addParagraph = function () { 
    const div=document.querySelectorall('div')[0];
    const p=document.createElement('p');
    p.innerText='Questo è un paragrafo';
    div.appendChild(p);
}
addParagraph()
/* ESERCIZIO 7
 Scrivi una funzione che faccia scomparire la prima lista non ordinata
*/

//const hideFirstUl = function () { 
//document.getElementById('firstList').setAttribute('style','display:none')
//document.getElementById('firstList').remove();
//}

//hideFirstUl()
/* ESERCIZIO 8 
 Scrivi una funzione che renda verde il background di ogni lista non ordinata
*/

const paintItGreen = function () { 
    const ul=document.querySelectorAll('ul')
for (let i=0; i<ul.length ;i++){
    ul[i].setAttribute('style','background-color: green;')
}

}
paintItGreen()
/* ESERCIZIO 9
 Scrivi una funzione che rimuova l'ultima lettera dall'h1 ogni volta che l'utente lo clicca
*/


    const makeItClickable = function () {
        let h1 = document.querySelector('h1');
  
        h1.addEventListener('click', () => {
          h1.textContent = h1.textContent.slice(0, -1);
        });
      }
  
      makeItClickable();

/* ESERCIZIO 10
 Crea una funzione che, al click sul footer, riveli l'URL del link interno come contenuto di un alert()
*/

const revealFooterLink = function () { }

/* ESERCIZIO 11
 Crea una funzione che crei una tabella nell'elemento con id "tableArea". 
 La tabella avrà 5 elementi e questa struttura: immagine, nome prodotto, quantità, prezzo
*/

const generateTable = function () { }

/* ESERCIZIO 12
 Crea una funzione che aggiunga una riga alla tabella precedentemente creata e fornisca i dati necessari come parametri
*/

const addRow = function () { }

/* ESERCIZIO 14
Crea una funzione che nasconda le immagini della tabella quando eseguita
*/

const hideAllImages = function () { }

/* EXTRA ESERCIZIO 15
Crea una funzione che cambi il colore del h2 con id "changeMyColor" con un colore random ad ogni click ricevuto
*/

const changeColorWithRandom = function () { }