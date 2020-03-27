

-----------------------DESPUES DE CREAR LA BASE DE DATOS Y LAS TABLAS CORRER LOS PROCEDIMIENTOS ALMACENADOS----
-----------------------DESPUES SE DEBE DESHABILITAR LA LINEA DE CODIGO  DESDE LA 190 A LA 200 EN LOGIN CONTROLLER PARA ACCEDER Y ACTUALIZAR LA FIRMA----------
CREATE DATABASE QUORA

CREATE TABLE RINCIDENTES
(
ID INT IDENTITY (1,1) NOT NULL,
CNSRINC AS RIGHT ('CNSRINC' + CAST (ID AS VARCHAR(20)), 20) PERSISTED NOT NULL,
FECHA_PROGRAMADA DATE  NOT NULL,
TIEMPO_ESTIMADO VARCHAR(50) NOT NULL,
FECHA_EJECUTADA DATE NOT NULL,
HORA_SOLUCION VARCHAR(50) NOT NULL,
TIEMPO_RESPUESTA VARCHAR(50),
TAREA_EJECUTADA VARCHAR(50) NOT NULL,
NOVEDADES VARCHAR(100) NOT NULL,
PRIORIDAD VARCHAR(50) NOT NULL,
VERIFICACION VARCHAR(50) NOT NULL,
CNSINC VARCHAR(20),
CNSID INT
CONSTRAINT PK_RINCEDENTEID PRIMARY KEY  CLUSTERED (ID,CNSRINC)
)


CREATE TABLE INCIDENTES
(
ID INT IDENTITY (1,1) NOT NULL,
CNSINC AS RIGHT ('CNSINC' + CAST (ID AS VARCHAR(20)), 20) PERSISTED NOT NULL,
FECHA_SOLICITUD DATETIME NOT NULL,
SOLICITUD VARCHAR (50) NOT NULL,
SOLICITANTE VARCHAR (50) NOT NULL,
AREA VARCHAR(80) NOT NULL,
COMENTARIOS VARCHAR(100) NOT NULL,
CNSRINC VARCHAR(20),
CNSRID INT,
FECHA_TEMPORAL_S DATE NULL,
CONSTRAINT PK_INCEDENTEID PRIMARY KEY CLUSTERED(ID,CNSINC)
)


ALTER TABLE RINCIDENTES WITH CHECK ADD CONSTRAINT  FK_CNRINC FOREIGN KEY (CNSID,CNSINC) REFERENCES  INCIDENTES(ID, CNSINC)
ALTER TABLE INCIDENTES WITH CHECK ADD CONSTRAINT  FK_CNSRINC FOREIGN KEY (CNSRID,CNSRINC) REFERENCES RINCIDENTES(ID,CNSRINC)


CREATE TABLE USUARIOS
(
ID INT IDENTITY (1,1) NOT NULL,
USERID AS RIGHT ('CNSUSER' + CAST(ID AS VARCHAR(20)), 20) PERSISTED NOT NULL,
NOMBREUSUARIO  VARCHAR(80) NOT NULL,
FECHA_REGISTRO DATETIME NOT NULL,
NOMBRE VARCHAR (80) NOT NULL,
CEDULA VARCHAR(30) NOT  NULL,
CARGO VARCHAR(50) NOT NULL,
AREA VARCHAR(50) NOT NULL,
CENTRO_OPERACION VARCHAR(50)	NOT NULL,
ROL VARCHAR(80) NOT NULL,
PERMISOS bit  NULL,
PASS VARBINARY (8000) NOT NULL,
FIRMA_DIGITAL IMAGE  NULL,
CONSTRAINT PK_USERID PRIMARY KEY CLUSTERED(ID,USERID)
)

INSERT INTO USUARIOS (NOMBREUSUARIO,FECHA_REGISTRO,NOMBRE,CEDULA,CARGO,CENTRO_OPERACION, AREA,ROL,PERMISOS, PASS, FIRMA_DIGITAL)VALUES('rikardoroa' ,GETDATE(),'Ricardo Roa',1067858108,'Coordinador De Sistemas','Oficina Principal','Sistemas','ADMINISTRADORREV', 1, ENCRYPTBYPASSPHRASE('*xc/6789o�---+y','123'),NULL)

/*---------SE DEBE ESCANEAR LA FIRMA DIGITAL Y COLOCARLA EN LA RUTA QUE APARECE EN EL SCRIPT--------*/
UPDATE USUARIOS SET FIRMA_DIGITAL= (SELECT * FROM OPENROWSET(BULK N'C:\IMG\ricardoroa.jpg', SINGLE_BLOB) as T1) WHERE ID=1


CREATE TABLE AREA(
ID INT IDENTITY (1,1) NOT NULL,
CNSAREA AS RIGHT ('CNSAREA' + CAST (ID AS VARCHAR(20)),20) PERSISTED NOT NULL,
NOMBRE VARCHAR(50) NOT NULL,
CONSTRAINT PK_AREA PRIMARY KEY CLUSTERED (ID,CNSAREA)
)


CREATE TABLE INCIDENTEAREA(
ID INT IDENTITY (1,1) NOT NULL,
CNSINACS AS RIGHT ('CNSINAC' + CAST (ID AS VARCHAR(20)),20) PERSISTED,
IDAREA INT,
CNSAREA  VARCHAR(20) NOT NULL,
IDINCIDENTE INT,
CNSINC  VARCHAR(20) NOT NULL,
CONSTRAINT PK_INCIDENTEAREA PRIMARY KEY CLUSTERED(ID, CNSINACS)
)

ALTER TABLE INCIDENTEAREA WITH CHECK ADD CONSTRAINT FK_CNSAREA FOREIGN KEY(IDAREA,CNSAREA) REFERENCES AREA (ID,CNSAREA)
ALTER TABLE INCIDENTEAREA WITH CHECK ADD CONSTRAINT FK_INCIDENTE FOREIGN KEY(IDINCIDENTE,CNSINC) REFERENCES INCIDENTES (ID,CNSINC)


INSERT INTO AREA (NOMBRE) VALUES ('ADMINISTRATIVO'),
                                 ('GERENCIA'),
							     ('BODEGA'),
							     ('COMERCIAL'),
								 ('FARMACIA')


CREATE TABLE REQUISICIONES(
ID INT IDENTITY(1,1) NOT NULL,
CNSREQ AS RIGHT ('CNSREQ' + CAST (ID AS VARCHAR(20)),20) PERSISTED NOT NULL,
SOLICITANTE VARCHAR(30) NOT NULL,
CEDULA VARCHAR(30) NOT NULL,
AREA VARCHAR(30) NOT NULL,
CARGO VARCHAR(50) NOT NULL,
CENTRO_OPERACION VARCHAR(50) NOT NULL,
FECHA_SOLICITUD DATETIME NOT NULL,
REVISION INT NULL,
APROBACION BIT NULL,
FIRMA_REVISION IMAGE NULL,
CNSRQDT VARCHAR(20) NULL,
IDRQDT INT NULL,
ESTADO_REQUISICION BIT NULL,
FECHA_ENTREGA VARCHAR(40) NULL,
ESTADO_ITEMS INT NULL,
CONSTRAINT PK_REQUISICIONES PRIMARY KEY CLUSTERED(ID,CNSREQ)
)


CREATE TABLE REQUISICIONESDT
(
ID INT IDENTITY(1,1) NOT NULL,
CNSRQDT AS RIGHT ('CNSRQDT' + CAST (ID AS VARCHAR(20)),20) PERSISTED NOT NULL,
SOLICITANTE VARCHAR(30)  NULL,
CEDULA VARCHAR(30)  NULL,
AREA VARCHAR(30) NULL,
CARGO VARCHAR(50) NULL,
CENTRO_OPERACION VARCHAR(50)  NULL,
FECHA_SOLICITUD DATETIME  NULL,
CNSREQ VARCHAR(20)NULL,
IDREQ INT NULL,
FECHA_DE_FIRMA DATETIME  NULL,
APROBACION BIT NULL,
FIRMA_APROBACION IMAGE NULL,
FIRMA_REVISION IMAGE NULL,
CONSTRAINT PK_REQUISICIONESDT PRIMARY KEY CLUSTERED(ID,CNSRQDT)
)

ALTER TABLE REQUISICIONES WITH CHECK ADD CONSTRAINT FK_CNSRQDT FOREIGN KEY(IDRQDT,CNSRQDT) REFERENCES REQUISICIONESDT (ID,CNSRQDT)
ALTER TABLE REQUISICIONESDT WITH CHECK ADD CONSTRAINT FK_CNSREQ FOREIGN KEY(IDREQ,CNSREQ) REFERENCES REQUISICIONES (ID,CNSREQ)



CREATE TABLE ITEMSREQ
(
ID INT IDENTITY(1,1) NOT NULL,
CNSITEMREQ AS RIGHT ('CNSITEMREQ' + CAST (ID AS VARCHAR(20)),20) PERSISTED NOT NULL,
CANTIDAD INT NULL,
ITEM VARCHAR(30) NOT NULL,
FIRMA_APROBACION IMAGE NULL,
CARGO VARCHAR(50) NULL,
CENTRO_OPERACION VARCHAR(50) NULL,
CEDULA VARCHAR(30) NULL,
FECHA_SOLICITUD DATETIME NULL,
IDREQ INT NULL,
CNSREQ VARCHAR(20)  NULL,
ITEMAPROBADO BIT NULL,
RECIBIDO BIT NULL,
CONSTRAINT PK_ITEMSREQUISICIONESDT PRIMARY KEY CLUSTERED(ID,CNSITEMREQ)
)




ALTER TABLE ITEMSREQ WITH CHECK ADD CONSTRAINT FK_CNSREQDT FOREIGN KEY(IDREQ,CNSREQ) REFERENCES REQUISICIONES (ID,CNSREQ)



SELECT *,  NOMBREUSUARIO, CONVERT (VARCHAR(50), (DecryptByPassPhrase('*xc/6789o�---+y',PASS))) as PASS from USUARIOS
SELECT  NOMBREUSUARIO, CONVERT (VARCHAR(50), (DecryptByPassPhrase('*xc/6789o�---+y',PASS))) as PASS from USUARIOS where  CONVERT (VARCHAR(50), (DecryptByPassPhrase('*xc/6789o�---+y',PASS)))='123'
				


CREATE TABLE RQITEMSTEMPORAL
(
SOLICITANTE VARCHAR(30) NULL,
CONSECUTIVO VARCHAR(30) NULL,
AREA VARCHAR(30) NULL,
CARGO VARCHAR(50) NULL,
CENTRO_OPERACION VARCHAR(50) NULL,
FECHA_SOLICITUD DATETIME NULL,
CANTIDAD INT NULL,
ITEM VARCHAR(30) NULL

)

CREATE TABLE FESTIVOS
(
ID INT IDENTITY(1,1) NOT NULL,
CNSDATE AS RIGHT ('CNSDATE' + CAST (ID AS VARCHAR(20)),20) PERSISTED NOT NULL,
FECHAFESTIVO VARCHAR(30) NULL,
CONSTRAINT PK_FECHAFESTIVOS PRIMARY KEY CLUSTERED(ID,CNSDATE)
)


CREATE TABLE ENERO
(
ID INT IDENTITY(1,1) NOT NULL,
CNSJAN AS RIGHT ('CNSJAN' + CAST (ID AS VARCHAR(20)),20) PERSISTED NOT NULL,
DIAENERO VARCHAR(30) NULL,
CONSTRAINT PK_ENEROD PRIMARY KEY CLUSTERED(ID,CNSJAN)
)

CREATE TABLE MARZO
(
ID INT IDENTITY(1,1) NOT NULL,
CNSMAR AS RIGHT ('CNSMAR' + CAST (ID AS VARCHAR(20)),20) PERSISTED NOT NULL,
DIAMARZO VARCHAR(30) NULL,
CONSTRAINT PK_MARD PRIMARY KEY CLUSTERED(ID,CNSMAR)
)

CREATE TABLE ABRIL
(
ID INT IDENTITY(1,1) NOT NULL,
CNSABR AS RIGHT ('CNSABR' + CAST (ID AS VARCHAR(20)),20) PERSISTED NOT NULL,
DIAABRIL VARCHAR(30) NULL,
CONSTRAINT PK_ABRILD PRIMARY KEY CLUSTERED(ID,CNSABR)
)

/*DBCC CHECKIDENT ('INCIDENTES', RESEED, 40000)



DROP TABLE INCIDENTES
DROP TABLE RINCIDENTES
DROP TABLE USUARIOS
DROP TABLE AREA
DROP TABLE INCIDENTEAREA
DROP TABLE REQUISICIONES
DROP TABLE REQUISICIONESDT/*





