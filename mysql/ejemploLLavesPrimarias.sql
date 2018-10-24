-- llave primaria simple

create table tablita1(
	campo1 int primary key
);


create table tablita2(
	campo1 int,
    primary key(campo1)
);

-- llave compuesta
create table tablita3(
	campo1 int,
    campo2 int,
    primary key(campo1, campo2)
);

