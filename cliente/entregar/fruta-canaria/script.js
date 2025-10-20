const frutas = [{id: 1, fruta: "Aguacate", codigoIslaProcedencia: "GO", precioKiloEuros: 5.50, kilos: 10},
                {id: 2, fruta: "Plátano", codigoIslaProcedencia: "LP", precioKiloEuros: 2.30, kilos: 15},
]
const idiomas = [{codigo: "es", idioma: "Español"},{codigo: "en", idioma: "Inglés"}];
const islas = [ {codigo: "GO", isla: "La Gomera"}, 
                {codigo: "LP", isla: "La Palma"}]

function insertar(){
  let fruta =document.getElementById("fruta").value;
  let codigoIsla =document.getElementById("islas").value;
  let precio =document.getElementById("precio").value;
  let kilos =document.getElementById("kilos").value;
  let idInsertarDespues =document.getElementById("id-insertar-despues").value;
  let nuevaFruta={};
  if (validarDatos(fruta,codigoIsla,precio,kilos,idInsertarDespues)){
    nuevaFruta.id = siguienteId()
    nuevaFruta.fruta = fruta;
    nuevaFruta.codigoIslaProcedencia = codigoIsla;
    nuevaFruta.precioKiloEuros = precio;
    nuevaFruta.kilos = kilos;
    frutas.push(nuevaFruta)
    mostrarFrutas();
    almacenarSet();
  }
}
function validarDatos(fruta,codigoIsla,precio,kilos,idInsertarDespues){
  if (fruta==""){
    mostrarError("Debe introducir un nombre de fruta")
    return false;
  }
  return true
}
function mostrarError(msgError){
   let error = document.getElementById("error");
   error.innerHTML = `<span>${msgError}</span>`
}
function iniciar(){
  cargarIdiomas()
  mostrarFrutas()
  cargarIslas()
}
function mostrarFrutas(){
  let divFrutas = document.getElementById("tabla-frutas");
  let html = "<table>";
  html = html + "<tr>"+"<th>Id"+"</th>"+"<th>Fruta"+"</th>"+"<th>Isla"+"</th>"+"<th>Precio/kilo"+"</th>"+"<th>Kilos"+"</th>"+"<th>Importe"+"</th>"+"</tr>"
  for (let i=0;i<frutas.length;i++){
    html = html + "<tr>"+
                  "<td>"+frutas[i].id +"</td>" + 
                  "<td>"+frutas[i].fruta +"</td>" + 
                  "<td>"+obtenerIsla(frutas[i].codigoIslaProcedencia)+"</td>" + 
                  "<td>"+frutas[i].precioKiloEuros + "</td>" +
                  "<td>"+frutas[i].kilos + "</td>" +
                  "<td>"+calcularImporte(frutas[i].precioKiloEuros, frutas[i].kilos) + "</td>" +
                  "</tr>"
  }
  html = html + "</table>"
  divFrutas.innerHTML = html;
}
function almacenarSet(){
  let txtFrutas = JSON.stringify(frutas);
  localStorage.setItem("frutas", txtFrutas)
}
function cargarIdiomas(){
  let selectIdiomas = document.getElementById("select-idiomas");
  let opciones;
  for (let i=0;i<idiomas.length;i++){
    opciones = opciones + '<option value="' + idiomas[i].codigo + '">' + idiomas[i].idioma +'</option>';
  } 
  selectIdiomas.innerHTML = opciones;
}
function cargarIslas(){
  let selectIslas = document.getElementById("islas");
  selectIslas.innerHTML = '<option value="GO">La Gomera</option><option value="LP">La Palma</option>' 
}
function siguienteId() {
  let maxId = 0; 
  frutas.forEach(fruta => {
    if (fruta.id > maxId) {
      maxId = fruta.id;
    }
  });
  return maxId + 1;
}
function obtenerIsla(codigoIsla){
  if (codigoIsla=="LP")
    return "La Palma"
  if (codigoIsla=="GO")
    return "La Gomera"
}
function calcularImporte(precioKilo, kilos){
  return precioKilo*kilos
}
function actualizar(){
  alert("Función actualizar sin programar")
}
function borrar(){
  alert("Función borrar sin programar")
}
function cambioIdioma(){
  let idioma = document.getElementById("select-idiomas").value;
  alert(idioma);
}