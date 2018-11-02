// destructuracion

var foo = ['uno', 'dos', 'tres'];

/ sin destructuración
var uno = foo[0];
var dos = foo[1];
var tres = foo[2];


// con destructuración
var [uno, dos, tres] = foo

document.write(uno);
document.write(dos);
document.write(tres);
