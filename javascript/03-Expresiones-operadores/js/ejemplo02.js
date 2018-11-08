var arreglo = new Array(1, 2, 3, 4, 5, 6, 7, 8, 9);
delete arreglo[3];

for (let a of arreglo) {
    document.write(a + "</br>");
    console.log(a);
}


var miFuncion = new Function("5 + 2");
var forma = "redonda";
var largo = 1;
var hoy = new Date();

document.write("</br>");
document.write(typeof miFuncion + "</br>"); // devuelve "function"
document.write(typeof forma + "</br>"); // devuelve "function"
document.write(typeof largo + "</br>"); // devuelve "function"
document.write(typeof hoy + "</br>"); // devuelve "function"
document.write(typeof noExiste + "</br>"); // devuelve "function"

var arboles = new Array(undefined, undefined, "cedro", "roble", "arce");
delete arboles[0];
document.write((0 in arboles) + "</br>");

let valor = new Date();
document.write(valor instanceof Date);

let a = {sexo: "masculino"};

class Animal {

}

class Perro extends Animal {
    constructor(raza, nombre) {
        super();
        this._raza = raza;
        this._nombre = nombre;
    }

    get raza() {
        return this._raza;
    }

    set raza(value) {
        this._raza = value;
    }

    get nombre() {
        return this._nombre;
    }

    set nombre(value) {
        this._nombre = value;
    }
}

var perrito = new Perro("chiguagua", "rin tin itn");

