CREATE PROCEDURE CALCULOTIEMPO
AS


UPDATE RINCIDENTES 

SET TIEMPO_RESPUESTA= CONVERT(VARCHAR(50),CONCAT(SUBSTRING(CAST 
(ROUND((CAST(DATEDIFF(MINUTE,FECHA_SOLICITUD, CONVERT(VARCHAR(50),
CONCAT (FECHA_EJECUTADA,' ',HORA_SOLUCION),101))AS DECIMAL)/60),2)
AS VARCHAR(50)),1,3),' ','HORAS') ) 

FROM RINCIDENTES
INNER JOIN INCIDENTES ON
INCIDENTES.CNSRID = RINCIDENTES.ID AND INCIDENTES.CNSRINC = RINCIDENTES.CNSRINC

GO