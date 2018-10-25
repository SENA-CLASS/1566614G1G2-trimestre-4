console.log("hola mundo en javascript");

for (let i = 1; i <= 10; i++) {
    console.log(i);
}

console.log(location.hostname);

let perro = {
    color: "negro",
    sexo: "machito"
}

console.log(perro.color);
console.log(perro.sexo);

class Carro {
    constructor(marca, color) {
        this._marca = marca;
        this._color = color;
    }

    get marca() {
        return this._marca;
    }

    set marca(value) {
        this._marca = value;
    }

    get color() {
        return this._color;
    }

    set color(value) {
        this._color = value;
    }
}


let carrito = new Carro("mazda","rojo");

console.log(carrito.color);
