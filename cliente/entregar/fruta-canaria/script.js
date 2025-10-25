

function Fruta() {}

function Fruta(id,fruta,codigoIslaProcedencia,precioKiloEuros,kilos) {
  this.id = id
  this.fruta = fruta
  this.codigoIslaProcedencia = codigoIslaProcedencia
  this.precioKiloEuros = precioKiloEuros
  this.kilos = kilos
}
const frutas = [ new Fruta(1, "Aguacate", "GO", 5.50, 10), new Fruta(2,"Plátano", "LP", 2.30, 15)]
const idiomas = [{codigo: "es", idioma: "Español"},{codigo: "en", idioma: "Inglés"}];
const islas = [ {codigo: "GO", isla: "La Gomera"}, 
                {codigo: "LP", isla: "La Palma"},
                {codigo: "TF", isla: "Tenerife"},
                {codigo: "HI", isla: "El Hierro"},
                {codigo: "GC", isla: "Gran Canaria"},
                {codigo: "FU", isla: "Fuerteventura"},
                {codigo: "LZ", isla: "Lanzarote"},
                {codigo: "LG", isla: "La Graciosa"}
              ]
function insertar(){
  let fruta =document.getElementById("fruta").value;
  let codigoIsla =document.getElementById("islas").value;
  let precio =document.getElementById("precio").value;
  let kilos =document.getElementById("kilos").value;
  let idInsertarDespues =document.getElementById("id-insertar-despues").value;
  let nuevaFruta= new Fruta();
  if (validarDatos(fruta,codigoIsla,precio,kilos,idInsertarDespues)){
    nuevaFruta.id = siguienteId()
    nuevaFruta.fruta = fruta;
    nuevaFruta.codigoIslaProcedencia = codigoIsla;
    nuevaFruta.precioKiloEuros = precio;
    nuevaFruta.kilos = kilos;
    if(idInsertarDespues == "") {
      frutas.push(nuevaFruta)
      mostrarFrutas();
      almacenarSet();
    } else {
      frutas.splice(idInsertarDespues,0,nuevaFruta)
      mostrarFrutas();
      almacenarSet();      
    } 

  }
}
function validarDatos(fruta,codigoIsla,precio,kilos,idInsertarDespues){
  try {
    if (!fruta || fruta.trim() === "") {
      throw new Error("Debe introducir un nombre de fruta");
    }

    if (!codigoIsla) {
      throw new Error("Debe introducir un código de isla válido");
    }

    if (isNaN(precio) || precio <= 0) {
      throw new Error("El precio debe ser un número mayor que 0");
    }

    if (isNaN(kilos) || kilos <= 0) {
      throw new Error("Los kilos deben ser un número mayor que 0");
    }

    if (idInsertarDespues !== null && idInsertarDespues !== undefined && isNaN(idInsertarDespues)) {
      throw new Error("El ID debe ser un número válido");
    }
    return true;

  } catch (e) {
    mostrarError(e.message);
    return false;
  }
}
function mostrarError(msgError){
   let error = document.getElementById("error");
   error.innerHTML = `<span>${msgError}</span>`
}
function mostrarFrutas(){
  let idioma = document.getElementById("select-idiomas").value;
  let divFrutas = document.getElementById("tabla-frutas");
  let html = "<table>";
  html = html + "<tr>"+"<th>Id"+"</th>"+"<th>Fruta"+"</th>"+"<th>Isla"+"</th>"+"<th>Precio/kilo"+"</th>"+"<th>Kilos"+"</th>"+"<th>Importe"+"</th>"+"</tr>"
  frutas.forEach(fruta => {
    html = html + "<tr>"+
                  "<td>"+fruta.id +"</td>" + 
                  "<td>"+fruta.fruta +"</td>" + 
                  "<td>"+obtenerIsla(fruta.codigoIslaProcedencia)+"</td>" + 
                  "<td>"+fruta.precioKiloEuros + "</td>" +
                  "<td>"+fruta.kilos + "</td>" +
                  "<td>"+formatearImporte(calcularImporte(fruta.precioKiloEuros, fruta.kilos),idioma) + "</td>" +
                  "</tr>"
  })
  html = html + "</table>"
  divFrutas.innerHTML = html;
}
function almacenarSet(){
  let txtFrutas = JSON.stringify(frutas);
  localStorage.setItem("frutas", txtFrutas)
}
function cargarIdiomas(){
  let selectIdiomas = document.getElementById("select-idiomas");
  let opciones = "";
  idiomas.forEach(idioma => {
    opciones += `<option value="${idioma.codigo}">${idioma.idioma}</option>`;
  });
  selectIdiomas.innerHTML = opciones;
}
function cargarIslas(){
  let selectIslas = document.getElementById("islas");
  let opciones = "";
  islas.forEach(isla => opciones +=`<option value='${isla.codigo}'>${isla.isla}</option>`);
  selectIslas.innerHTML = opciones;
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
  let islaCorrecta =""
  islas.forEach(isla => {
    if (isla.codigo === codigoIsla)
      islaCorrecta = isla.isla
  })
  return islaCorrecta;
}
function calcularImporte(precioKilo, kilos){
  return precioKilo*kilos
}
function actualizar(){
  let fruta =document.getElementById("fruta").value;
  let codigoIsla =document.getElementById("islas").value;
  let precio =document.getElementById("precio").value;
  let kilos =document.getElementById("kilos").value;
  let idActualizar =parseInt(document.getElementById("id-actualizar").value) ;
  let frutaAActualizar;
  frutas.forEach(fruta => {
    if (fruta.id === Number(idActualizar))
      frutaAActualizar = fruta
  })
    if (!frutaAActualizar) {
    alert(`No se encontró ninguna fruta con id ${idActualizar}`);
    mostrarFrutas();
    return;
  }
  if (validarDatos(fruta,codigoIsla,precio,kilos,idActualizar)){
    frutaAActualizar.fruta = fruta;
    frutaAActualizar.codigoIslaProcedencia = codigoIsla;
    frutaAActualizar.precioKiloEuros = precio;
    frutaAActualizar.kilos = kilos;
    mostrarFrutas();
    almacenarSet();
  }
}
function borrar(){
  let idBorrar = Number(document.getElementById("id-borrar").value);
  let indiceAEliminar = -1;

  frutas.forEach((fruta, i) => {
    if (fruta.id === idBorrar) {
      indiceAEliminar = i;
    }
  });
  if (indiceAEliminar === -1) {
    alert(`No se encontró ninguna fruta con id ${idBorrar}`);
    return;
  }
  frutas.splice(indiceAEliminar, 1); 
  mostrarFrutas();
  almacenarSet();
}
function cambioIdioma(){
  let idioma = document.getElementById("select-idiomas").value;
  alert(idioma);
  mostrarFechaHora(idioma);
  mostrarFrutas();
}
function mostrarFechaHora(idioma) {
  const inputFecha = document.getElementById("fecha-hora-ahora");

  inputFecha.value = new Intl.DateTimeFormat(idioma, {
  weekday: "narrow",
  day: "2-digit",
  month: "short",
  year: "numeric",
  hour: "2-digit",
  minute: "2-digit",
  second: "2-digit"
  }).format(new Date());
  
}

function formatearImporte(importe, idioma) {

  return new Intl.NumberFormat(idioma, {
    style: "currency",
    currency: idioma === "en" ? "GBP" : "EUR"
  }).format(importe);
}

function cargarFrutas() {
  const frutasStorage = localStorage.getItem("frutas");

  if (frutasStorage) {
    const frutasRecuperadas = JSON.parse(frutasStorage);
    frutas.length = 0; 
    frutas.push(...frutasRecuperadas); 
  } else {
    almacenarSet();
  }
}

(function () {
  cargarIdiomas()
  mostrarFrutas()
  cargarIslas()
  cargarFrutas()
  mostrarFechaHora("es")
})(); 