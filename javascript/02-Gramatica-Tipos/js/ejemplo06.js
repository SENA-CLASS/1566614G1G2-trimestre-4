foo(); // "bar" //funcion hosting

function foo() {
    console.log("bar");
}


/**
 * cuidado conesto es una funcion hoisting peor al declararla como una variable genera un error


 */

baz(); // TypeError: baz no es una función

var baz = function () {
    console.log("bar2");
};



