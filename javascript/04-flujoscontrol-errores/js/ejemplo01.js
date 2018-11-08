{
    var a = 10;
}

var var1 = new Boolean(true);

if (var1 == true) {
    document.write("son iguales</br>");
} else {
    document.write("son diferentes</br>");
}

document.write(typeof var1);
document.write(typeof true);

//throw "Error2";   // Tipo string
//throw 42;         // Tipo número
//throw true;       // Tipo booleano
//throw {toString: function() { return "¡Soy un objeto!"; } };


class UserException {
    constructor(aviso) {
        this._aviso = aviso;
        this._nombre = "UserException";
    }

    toSring() {
        return this._nombre + ': "' + this._aviso + '"';
    }


}

throw new UserException("hola esta es mi exceptcion personalizada").toSring();
