
var variableUno =10;

function uno() {
    var variableDos=12;
    console.log(variableDos);
}
uno();

for (let i = 0; i <10 ; i++) {
    var a=1;
    console.log(a+i);
}


let variableTres =15;
console.log(variableTres);
const variableCuatro=20;
console.log(variableCuatro);

function inicia() {
    var nombre = "Mozilla"; // 'nombre' es una variable local creada por la función 'inicia'
    function muestraNombre() { // 'muestraNombre' es una función interna (un closure)
        alert(nombre); // dentro de esta función usamos una variable declarada en la función padre
    }
    muestraNombre();
}
inicia();

