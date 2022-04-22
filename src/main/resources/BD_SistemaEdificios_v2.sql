-- drop database BD_SistemaEdificios;
create database BD_SistemaEdificios;
use BD_SistemaEdificios;


create table tb_administrador
(
cod_admin int primary key auto_increment,
nom_admin varchar(25),
login varchar(40),
clave varchar(200),
dni_admin char(8),
telf_admin varchar(15)
);

create table tb_edificio
(
cod_edificio int primary key auto_increment,
nom_edificio varchar(50),
numero_edificio int,
nombre_condominio varchar(50),
cod_usuario int
);


create table tb_departamento
(
cod_departamento int primary key auto_increment,
num_departamento int,
piso_departamento int,
estado int,
condiciones_departamento varchar(200),
metros_cuadrados int,
tipo_departamento int,
cod_edificio int,
cod_propietario int,
cod_admin int
);


create table tb_propietario
(
cod_propietario int primary key auto_increment,
nom_propietario varchar(25),
dni_propietario char(8),
edad_propietario int,
correo_propietario varchar(60),
fecha_incio_contrato datetime,
fecha_fin_contrato datetime,
cod_usuario int
);

create table tb_usuario
(
cod_usuario int primary key auto_increment,
nom_usuario varchar(25),
dni_usuario char(8),
login varchar(40),
clave varchar(200),
fecha_registro_usuario datetime,
estado smallint,
cod_departamento int,
cod_mascota int
);

create table tb_mascota
(
cod_mascota int primary key auto_increment,
nom_mascota varchar(25),
sexo_mascota varchar(25),
raza_mascota varchar(25)
);

create table tb_tipo_indicente
(
cod_tipoinc int primary key auto_increment,
desc_tipoinc varchar(100),
estado smallint
);

create table tb_incidente
(
cod_inc int primary key auto_increment,
desc_inc varchar(100),
fecha_reg_inc datetime,
estado_inc smallint,
cod_tipoinc int
);

create table tb_historial_incidente
(
cod_historial int primary key auto_increment,
estado_historial smallint,
fecha_reg_historial datetime,
cod_usuario int,
cod_inc int
);

create table tb_visitante
(
cod_visitante int primary key auto_increment,
nom_visitante varchar(25)
);

create table tb_visita
(
cod_visita int primary key auto_increment,
fecha_reg_visita datetime,
fecha_llegada_visita datetime,
fecha_salida_visita datetime,
cod_visitante int,
cod_propietario int
);

create table tb_boleta
(
cod_boleta int primary key auto_increment,
servicio_boleta varchar(25),
monto_boleta decimal(15,2),
mes_boleta decimal,
fecha_reg_boleta datetime,
fecha_venc_boleta datetime,
cod_usuario int
);

create table tb_pago
(
cod_pago int primary key auto_increment,
fecha_pago datetime,
cod_boleta int
);

CREATE TABLE tb_rol (
  idRol int,
  nombre varchar(45),
  estado smallint,
  PRIMARY KEY (idRol)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;


CREATE TABLE tb_opcion (
  idOpcion int,
  nombre varchar(45),
  ruta varchar(45),
  estado varchar(45),
  tipo smallint,
  PRIMARY KEY auto_increment(idOpcion)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4;

CREATE TABLE tb_rol_has_opcion (
  idRol int,
  idOpcion int,
  PRIMARY KEY (idRol,idOpcion),
  KEY fk_tb_rol_has_opcion_tb_opcion1_idx (idOpcion),
  KEY fk_tb_rol_has_opcion_tb_rol1_idx (idRol),
  CONSTRAINT fk_tb_rol_has_opcion_tb_opcion1 FOREIGN KEY (idOpcion) REFERENCES tb_opcion (idOpcion),
  CONSTRAINT fk_tb_rol_has_opcion_tb_rol1 FOREIGN KEY (idRol) REFERENCES tb_rol (idRol)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE tb_usuario_has_rol (
  cod_usuario int,
  idRol int,
  PRIMARY KEY (cod_usuario,idRol),
  KEY fk_tb_usuario_has_rol_rol1_idx (idRol),
  CONSTRAINT fk_tb_usuario_has_rol_tb_rol FOREIGN KEY (idRol) REFERENCES tb_rol (idRol),
  
  KEY fk_tb_usuario_has_rol_usuario1_idx (cod_usuario),
  CONSTRAINT fk_tb_usuario_has_rol_tb_usuario FOREIGN KEY (cod_usuario) REFERENCES tb_usuario (cod_usuario)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


alter table tb_edificio add constraint FK01 foreign key(cod_usuario) references tb_usuario(cod_usuario);
alter table tb_departamento add constraint FK02 foreign key(cod_edificio) references tb_edificio(cod_edificio);
alter table tb_departamento add constraint FK03 foreign key(cod_propietario) references tb_propietario(cod_propietario);
alter table tb_departamento add constraint FK04 foreign key(cod_admin) references tb_administrador(cod_admin);
alter table tb_usuario add constraint FK05 foreign key(cod_departamento) references tb_departamento(cod_departamento);
alter table tb_usuario add constraint FK06 foreign key(cod_mascota) references tb_mascota(cod_mascota);
alter table tb_propietario add constraint FK07 foreign key(cod_usuario) references tb_usuario(cod_usuario);
alter table tb_incidente add constraint FK08 foreign key(cod_tipoinc) references tb_tipo_indicente(cod_tipoinc);
alter table tb_historial_incidente add constraint FK09 foreign key(cod_usuario) references tb_usuario(cod_usuario);
alter table tb_historial_incidente add constraint FK10 foreign key(cod_inc) references tb_incidente(cod_inc);
alter table tb_visita add constraint FK11 foreign key(cod_visitante) references tb_visitante(cod_visitante);
alter table tb_boleta add constraint FK12 foreign key(cod_usuario) references tb_usuario(cod_usuario);
alter table tb_pago add constraint FK13 foreign key(cod_boleta) references tb_boleta(cod_boleta);
alter table tb_visita add constraint FK14 foreign key(cod_propietario) references tb_propietario(cod_propietario);

SET FOREIGN_KEY_CHECKS=0;

-- PROCEDIMIENTOS

DELIMITER $$
CREATE PROCEDURE `SP_registrar_departamento`(numero int, piso int, estado int, condiciones varchar(200), metros int, tipo int, cod_es int, cod_pro int, cod_ad int)
BEGIN
	insert into tb_departamento values(null,numero, piso, estado, condiciones, metros, tipo, cod_es, cod_pro, cod_ad);
END $$

DELIMITER $$
CREATE PROCEDURE `SP_registrar_propietario`(nombre varchar(25), dni char(8), edad int, correo varchar(60), f_inicio datetime, f_fin datetime, cod_us int)
BEGIN
	insert into tb_propietario values(null, nombre, dni, edad, correo, f_inicio, f_fin, cod_us);
END $$

DELIMITER $$
CREATE PROCEDURE `SP_registrar_usuario`(nombre varchar(25), dni char(8), login varchar(40), clave varchar(200), f_reg datetime, estado int, cod_dep int, cod_mas int)
BEGIN
	insert into tb_usuario values(null, nombre, dni, login, clave, f_reg, estado, cod_dep, cod_mas);
END $$

DELIMITER $$
CREATE PROCEDURE `SP_registrar_mascota`(nombre varchar(25), sexo varchar(25), raza varchar(25))
BEGIN
	insert into tb_mascota values(null, nombre, sexo, raza);
END $$

DELIMITER $$
CREATE PROCEDURE `SP_registrar_visitante`(nombre varchar(25))
BEGIN
	insert into tb_visitante values(null, nombre);
END $$

DELIMITER $$
CREATE PROCEDURE `SP_listar_departamento`()
BEGIN
	select * from tb_departamento;
END $$

DELIMITER $$
CREATE PROCEDURE `SP_listar_propietario`()
BEGIN
	select * from tb_propietario;
END $$

DELIMITER $$
CREATE PROCEDURE `SP_listar_usuario`()
BEGIN
	select * from tb_usuario;
END $$

DELIMITER $$
CREATE PROCEDURE `SP_listar_mascota`()
BEGIN
	select * from tb_mascota;
END $$

DELIMITER $$
CREATE PROCEDURE `SP_listar_visitante`()
BEGIN
	select * from tb_visitante;
END $$
 
call SP_registrar_usuario('David', '12312312', 'david', 'david', '2000-05-05', 0, 1, 1);
select * from tb_usuario;
-- call SP_registrar_visitante('Fsfbpisf');
-- select * from tb_visitante