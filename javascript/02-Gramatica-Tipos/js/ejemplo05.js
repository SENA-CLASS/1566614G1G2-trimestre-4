// relgas del undefined

(function () {
    /**
     * El valor undefined se comporta como un false cuando se utiliza en un contexto booleano.
     */
    var t
    if (t && true)
        document.write("verdadero </br>");
    else
        document.write("falso </br>");

    /**
     * El valor undefined se convierte en NaN, no numérico, cuando se usa en una operación aritmética
     */

    document.write((t + 3) + "</br>");

    /**
     * Cuando se evalúa una variable nula, el valor null se comporta como el 0 en operaciones aritméticas y como false en operaciones lógicas
     */
    var y = null;
    if (y && true)
        document.write("verdadero </br>");
    else
        document.write("falso </br>");

    document.write(y + 3);

})();
