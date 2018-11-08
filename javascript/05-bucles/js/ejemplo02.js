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
