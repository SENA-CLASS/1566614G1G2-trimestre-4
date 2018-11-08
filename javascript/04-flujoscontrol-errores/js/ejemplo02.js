function getMonthName(mo) {
    mo = mo - 1; // Ajusta el indice del arreglo para el arreglo de meses (1=Jan, 12=Dec)
    var months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
        "Aug", "Sep", "Oct", "Nov", "Dec"];
    if (months[mo] != null) {
        console.log(months[mo]);
        return months[mo];

    } else {
        throw "InvalidMonthNo"; //Arroja la palabra "InvalidMonthNo" al ocurrir una excepción
    }
}

function logMyErrors(e) {
    throw e.toString();
}

try { // instrucciones a probar
    var myMonth = 1;
    monthName = getMonthName(myMonth); // La función puede arrojar una excepción
}
catch (e) {
    monthName = "unknown";
    logMyErrors(e); // Pasa el objeto de la excepción a un manejador de errores
}

function f() {
    try {
        throw "bogus";
    } catch (e) {
        console.log('caught inner "bogus"');
        throw e; // Esta sentencia throw es suspendida hasta que
                 // el bloque finally se termine de ejecutar
    } finally {
        return false; // Sobreescribe la sentencia throw anterior
    }
    // "return false" es ejecutado ahora
}

try {
    f();
} catch (e) {
    // Esta nunca es encontrada porque la sentencia throw dentro
    // del bloque catch es sobrescrita por la sentencia return
    // en el bloque finally
    console.log('caught outer "bogus"');
}

// SALIDA
// atrapado dentro de "bogus"
