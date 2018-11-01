var a;
console.log('El valor de a es ' + a); // El valor de a es undefined

console.log('El valor de b es ' + b); // El valor de b es undefined
var b;// hoisting declara despues usarse

//console.log('El valor de c es ' + c); // Uncaught ReferenceError: c no está definida

let x;
console.log('El valor de x es ' + x); // El valor de x es undefined

//console.log('El valor de y es ' + y); // Uncaught ReferenceError: y no está definida
//let y

var input = 10;
if (input === undefined) {
    document.write("es verdadero");
} else {
    document.write("falso");
}
