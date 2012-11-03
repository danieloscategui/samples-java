--drop table item;
--drop table familia;
--drop table grupo;
--drop table unidadmedida;
--drop table pedidoalmacen;
--drop table pedidoalmacendetalle;
--drop table inventario;
--drop table movimientoalmacen;
--drop table movimientoalmacendetalle;
--drop table inventario;
--drop table almacen;

create table grupo(
	grupoid integer not null,
	grupocodigo varchar(2) not null,
	descripcion varchar(30) not null,
	constraint pk_grupo primary key (grupoid)
);

create table familia(
	familiaid integer not null,
	grupoid integer not null,
	familiacodigo varchar(4) not null,
	descripcion varchar(30) not null,
	constraint pk_familia primary key(familiaid),
	constraint fk_familia_grupo foreign key(grupoid)
	references grupo(grupoid)
);

create table unidadmedida(
	unidadmedidaid integer not null,
	descripcion varchar(30)not null,
	acronimo varchar(5) not null,
	constraint pk_unidadmedida primary key(unidadmedidaid)
);

create table item(
	itemid integer not null,
	familiaid integer not null,
	itemcodigo varchar(7) not null,
	descripcion varchar(30)not null,
	unidadmedidaid integer not null,
	preciolista decimal(10,2) null,
	costounitario decimal(10,2) null,
	constraint pk_item primary key(itemid),
	constraint fk_item_familia foreign key(familiaid)
	references familia(familiaid),
	constraint fk_item_unidadmedida foreign key(unidadmedidaid)
	references unidadmedida(unidadmedidaid)
);

create index itemCatalogo on item(itemcodigo);

create table almacen(
	almacenid integer not null,
	descripcion varchar(30) not null,
	constraint pk_almacen primary key (almacenid)
);

create table inventario(
	almacenid integer not null,
	itemid integer not null,
	cantidad decimal(10,2) not null,
	constraint pk_inventario primary key (almacenid, itemid),
	constraint fk_inventario_almacen foreign key(almacenid) 
	references almacen(almacenid),
	constraint fk_inventario_item foreign key(itemid) 
	references item(itemid)
);

create table movimientoalmacen(
	movimientoid bigint not null,
	almacenid integer not null,
	fechamovimiento date not null,
	indmovimiento integer not null,
	correlativo integer not null,
	constraint pk_movimientoalmacen primary key(movimientoid),
	constraint fk_movimientoalmacen_almacen foreign key (almacenid)
	references almacen(almacenid)
);

create table movimientoalmacenitem(
	movimientoid bigint not null,
	itemid integer not null,
	unidadmedidaid integer not null,
	cantidadmovimiento decimal(10,2) not null,
	costounitario decimal(10,2) not null,
	constraint fk_movimientoalmacen_movimiento foreign key(movimientoid)
	references movimientoalmacen(movimientoid)
);

create table pedidoalmacen(
	pedidoid bigint not null,
	fechapedido date not null,
	solicitadopor varchar(30) null,
	fechaautorizacion date null,
	autorizadopor varchar(30) null,
	fechaatencion date null,
	atendidopor varchar(30) null,
	estado varchar(30) not null,
	observacion varchar(30) null,
	nroordenservicio varchar(10) null,
	constraint pk_pedidoalmacen primary key (pedidoid)
);

create table pedidoalmacenitem(
	pedidoid bigint not null,
	itemid integer not null,
	unidadmedidaid integer not null,
	cantidadsolicitada decimal(10,2) null,
	cantidadautorizada decimal(10,2) null,
	cantidadatendida decimal(10,2) null,
	constraint fk_pedidoid foreign key (pedidoid) 
	references pedidoalmacen(pedidoid)
);

create table sequence(
	nombre varchar(30) not null,
	nextid bigint not null,
	constraint pk_sequence primary key (nombre)
);