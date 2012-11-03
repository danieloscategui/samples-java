insert into almacen(almacenid, descripcion) values (1,'ALMACEN CENTRAL');

insert into unidadmedida(unidadmedidaid, descripcion, acronimo) values(1,'PLIEGO', 'PLG');
insert into unidadmedida(unidadmedidaid, descripcion, acronimo) values(2,'UNIDAD', 'UND');
insert into unidadmedida(unidadmedidaid, descripcion, acronimo) values(3,'METRO', 'MET');


insert into grupo(grupoid, grupocodigo, descripcion) values(1,'01','ABRASIVOS FLEXIBLES');
insert into grupo(grupoid, grupocodigo, descripcion) values(2,'02','CONDUCTORES ELECTRICOS');
insert into grupo(grupoid, grupocodigo, descripcion) values(3,'03','PEGAMENTOS Y ADHESIVOS');

insert into familia(familiaid, grupoid, familiacodigo, descripcion) values(1,1,'0101','PAPEL GRANATE');
insert into familia(familiaid, grupoid, familiacodigo, descripcion) values(2,1,'0102','TELA ESMERIL');
insert into familia(familiaid, grupoid, familiacodigo, descripcion) values(3,2,'0201','CABLES Y ALAMBRES THW');
insert into familia(familiaid, grupoid, familiacodigo, descripcion) values(4,2,'0202','CABLES Y ALAMBRES TW');

insert into item(itemid, familiaid, itemcodigo, descripcion, unidadmedidaid, preciolista, costounitario) values(1,1,'0101001','PAPEL GRANATE ASA Nº 60', 1, 2.5, 2.0);
insert into item(itemid, familiaid, itemcodigo, descripcion, unidadmedidaid, preciolista, costounitario) values(2,1,'0101002','TELA ESMERIL ASA Nº 60', 1, 3.5, 3.0);
insert into item(itemid, familiaid, itemcodigo, descripcion, unidadmedidaid, preciolista, costounitario) values(3,3,'0201001','CABLE THW 12 AWG', 3, 5.5, 2.75);


insert into sequence values('pedidonum',2);
insert into sequence values('movimientonum', 2);
insert into sequence values('gruponum', 4);
insert into sequence values('familianum', 5);
insert into sequence values('itemnum', 4);
insert into sequence values('almacennum', 2);
insert into sequence values('unidadmedidanum', 4);
insert into sequence values('inventarionum', 1);

insert into inventario(almacenid, itemid, cantidad) values(1,1,5);
insert into inventario(almacenid, itemid, cantidad) values(1,2,10);
insert into inventario(almacenid, itemid, cantidad) values(1,3,15);

insert into movimientoalmacen (movimientoid, almacenid, fechamovimiento, indmovimiento, correlativo) values(1,1,'20121024', 1, 1);
insert into movimientoalmacenitem(movimientoid, itemid, unidadmedidaid, cantidadmovimiento, costounitario) values(1,1,1,5.0,2.0);
insert into movimientoalmacenitem(movimientoid, itemid, unidadmedidaid, cantidadmovimiento, costounitario) values(1,2,1,10.0,3.0);
insert into movimientoalmacenitem(movimientoid, itemid, unidadmedidaid, cantidadmovimiento, costounitario) values(1,2,1,15.0,2.75);

insert into movimientoalmacenitem(movimientoid, itemid, unidadmedidaid, cantidadmovimiento, costounitario)
values(1,1,1,5.0,2.0);

insert into movimientoalmacenitem(movimientoid, itemid, unidadmedidaid, cantidadmovimiento, costounitario)
values(1,2,1,10.0,3.0);
insert into movimientoalmacenitem(movimientoid, itemid, unidadmedidaid, cantidadmovimiento, costounitario) 
values(1,2,1,15.0,2.75);

insert into pedidoalmacen(pedidoid, fechapedido, solicitadopor, estado) values(1,'20121021', 'daniel', 'PENDIENTE');
insert into pedidoalmacenitem(pedidoid, itemid, unidadmedidaid, cantidadsolicitada) values(1,1,1,3);
insert into pedidoalmacenitem(pedidoid, itemid, unidadmedidaid, cantidadsolicitada) values(1,2,1,5);


