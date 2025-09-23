let suma = 0;
let numero = 0;
alert("Vamos a sumar")
if (confirm("¿Quieres sumar?")) {
  for (let i = 1; i <= 4; i++) {
    do {
      numero = Number(prompt(`(${i}/4) Inserta un número:`));
    } while (numero === null || isNaN(numero));
    suma += numero;
  }
  document.body.innerHTML = `<h1>El resultado es: ${suma}</h1>`;
} else {
  document.body.innerHTML = "<h1>No se realizó ninguna suma.</h1>";
}
