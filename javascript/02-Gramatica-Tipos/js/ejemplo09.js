//literales
(function () {
// literal de arreglo
    var cafes = ["Tostado Frances", , "Colombiano", "Kona", ,];
    for (a of cafes) {
        document.write(a + "</br>");
    }
    // literal booleano

    var b = true;
    document.write(b + "</br>");

    //literales enteros

    var hexadecimal = -0xF1A7;
    document.write(hexadecimal + "</br>");
    var binario = 0b10101010;
    document.write(binario + "</br>");
    var octal = 0o015;
    document.write(octal + "</br>");

    //literales reales

    var real = 3.1415;
    document.write(real + "</br>");

    // literales objetos
    var ventas = "Toyota";

    var carro = {miCarro: "Saturn", getCarro: tiposCarro("mazda"), especial: ventas};

    function tiposCarro(nombre) {
        if (nombre == "Honda") {
            return nombre;
        } else {
            return "Lo siento, nosotros no vendemos " + nombre + ".";
        }
    }

    document.write(carro.miCarro + "</br>");
    document.write(carro.getCarro + "</br>");
    document.write(carro.especial + "</br>");

    var perro = {
        raza: "golden",
        duenio: {
            d1: "pepe",
            d2: "juan",
            d3: "micguel"
        },
        collar: function (a) {
            if (a == "poner")
                return true;
            else
                return false;
        }
    }

    document.write(perro.raza + "</br>");
    document.write(perro.duenio.d1 + "</br>");
    document.write(perro.collar("quitar") + "</br>");

    var arregloObjetos = [{
        direccion: "avenida siempre viva",
        habitaciones: "10"
    }, {
        direccion: "sadfasdf",
        habitaciones: 16
    }]

    // objetos literales conNombres inusuales
    var propiedadesDeNombreInusual = {
        "": "Un string vacio",
        "!": "Bang!",
        "hola": "hola mundo"

    }

    document.write(propiedadesDeNombreInusual[""] + "</br>");
    document.write(propiedadesDeNombreInusual["!"] + "</br>");
    document.write(propiedadesDeNombreInusual.hola + "</br>");


    var foo = {a: "alpha", 2: "two"};
    console.log(foo.a);    // alpha
    console.log(foo[2]);   // two
//console.log(foo.2);  // Error: missing ) after argument list
    console.log(foo[a]); // Error: a is not defined
    console.log(foo["a"]); // alpha
    console.log(foo["2"]); // two

    var asdf1 = "hola uno";
    var asdf2 = 'hola dos';

    document.write("\" \n hola\t mama" + "</br>");

    var str = "this string is broken across multiple\
    lines.";

    var poem =
        "Roses are red,\n\
        Violets are blue.\n\
        I'm schizophrenic,\n\
        And so am I.";

    document.write(poem);
    console.log(poem);


})();
