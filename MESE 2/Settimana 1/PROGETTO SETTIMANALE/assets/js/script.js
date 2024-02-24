document.addEventListener("DOMContentLoaded", function() {
    const nav = document.getElementById("Navbar");
    const btnVerde = document.getElementById("verde");
    window.onscroll = function() { scrollFunction(); };
  
    function scrollFunction() {
      if (document.body.scrollTop > 50 || document.documentElement.scrollTop > 50) {
        nav.style.backgroundColor = "#ffffff"; // Cambia il colore quando la pagina è scrollata
        btnVerde.style.backgroundColor = "#538724";

      } else {
        nav.style.backgroundColor = "#ffc017"; // Ripristina il colore originale
        btnVerde.style.backgroundColor = "#000000";  
    }
    }
  });