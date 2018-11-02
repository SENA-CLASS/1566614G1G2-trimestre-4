// destructuracion

var foo = ['uno', 'dos', 'tres'];

// sin destructuración
var uno = foo[0];
var dos = foo[1];
var tres = foo[2];


// con destructuración
var [uno, dos, tres] = foo

document.write(uno + "</br>");
document.write(dos + "</br>");
document.write(tres + "</br>");

//iguales

var a = 10;
var b = "10";

document.write((a == b) + "</br>");
document.write((a === b) + "</br>");


document.write((a != b) + "</br>");
document.write((a !== b) + "</br>");


//
x = 42;
var y = 43;
miObj = new Number();
miObj.h = 4;    // crea la propiedad "h"
delete x;       // devuelve true (se puede eliminar si se declaró implícitamente)
delete y;       // devuelve false (no se puede eliminar si se declaró con var)
delete Math.PI; // devuelve false (no se pueden eliminar propiedades predefinidas)
delete miObj.h; // devuelve true (se pueden eliminar propiedades definidas por el usuario)
delete miObj;   // devuelve true (se puede eliminar si se ha declarado implícitamente)

var arboles = new Array("secoya", "laurel", "cedro", "roble", "arce");
delete arboles[3];
for (gg in arboles) {
    document.write(gg + "</br>");
}


// typeof

document.write(typeof arboles + "</br>");

