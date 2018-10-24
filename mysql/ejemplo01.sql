-- ejemplo base de datos semantica
create schema ejemplo_semantica;
use ejemplo_semantica;


create table tipo_documento(
	sigla varchar(10) primary key,
    nombre_documento varchar(40) not null
);

create table cliente(
	sigla varchar(40) not null,
    numero_documento varchar(40) not null,
	nombres varchar(100) not null,
    direccion varchar(100) not null,
    constraint fk_tipo_documento foreign key (sigla) references tipo_documento(sigla) on update cascade,
    primary key (sigla, numero_documento)
);

select * from ejemplo_semantica.tipo_documento td inner join ejemplo_semantica.cliente c on(td.sigla = c.sigla)
where td.sigla = 'CC'and c.numero_documento='80013833'; 

-- ejemplo la misma pero tecnica

create schema ejemplo_tecnica;
use ejemplo_tecnica;


create table tipo_documento(
	id int auto_increment primary key,
	sigla varchar(10) not null unique,
    nombre_documento varchar(40) not null
);

create table cliente(
	id int auto_increment,
	id_tipo_documento int not null,
	numero_documento varchar(40) not null,
	nombres varchar(100) not null,
    direccion varchar(100) not null,
    foreign key (id_tipo_documento) references tipo_documento(id),
    primary key (id)
);

select * from ejemplo_tecnica.tipo_documento t inner join ejemplo_tecnica.cliente c 
on t.id= c.id_tipo_documento
where t.sigla='CC' and c.numero_documento='80013833';

