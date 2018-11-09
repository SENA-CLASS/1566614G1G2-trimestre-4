let heroe = {
    nombre: "superman",
    altura: "1.80",
    sexo: "M"
}

for (let a in heroe) {
    console.log(a);
    console.log(heroe[a]);
}


function volcar_propiedades(obj, obj_nombre) {
    var resultado = "";
    for (var i in obj) {
        resultado += obj_nombre + "." + i + " = " + obj[i] + "<br>";
    }
    resultado += "<hr>";
    return resultado;
}

console.log(volcar_propiedades(heroe, "superman"));



let arr = [3, 5, 7];
arr.foo = "hello";

for (let i in arr) {
    console.log(i); // logs "0", "1", "2", "foo"
}

for (let i of arr) {
    console.log(i); // logs "3", "5", "7"
}
