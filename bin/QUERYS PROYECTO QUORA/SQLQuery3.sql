SELECT ITEMSREQ.ITEM AS ITEM, ITEMSREQ.CANTIDAD AS CANTIDAD FROM REQUISICIONES 
INNER JOIN ITEMSREQ  ON ITEMSREQ.CEDULA = REQUISICIONES.CEDULA 
AND CONVERT(VARCHAR(30),REQUISICIONES.FECHA_SOLICITUD,20) = CONVERT(VARCHAR(30),ITEMSREQ.FECHA_SOLICITUD,20)
WHERE ITEMSREQ.CEDULA = REQUISICIONES.CEDULA 
 AND REQUISICIONES.CARGO = ITEMSREQ.CARGO AND  ITEMSREQ.IDREQ IS NULL  AND ITEMSREQ.CNSREQ IS NULL 
 AND REQUISICIONES.CNSREQ='CNSREQ1' AND REQUISICIONES.ID='1' 
 GROUP BY ITEMSREQ.ITEM,ITEMSREQ.CANTIDAD,REQUISICIONES.CEDULA,REQUISICIONES.CARGO,REQUISICIONES.SOLICITANTE 
 HAVING MIN(CONVERT(VARCHAR(30),ITEMSREQ.FECHA_SOLICITUD,20)) = MIN(CONVERT(VARCHAR(30),REQUISICIONES.FECHA_SOLICITUD,20))

UPDATE ITEMSREQ SET ITEMSREQ.IDREQ=1, ITEMSREQ.CNSREQ='CNSREQ1' FROM ITEMSREQ 
INNER JOIN REQUISICIONES  ON ITEMSREQ.CEDULA = REQUISICIONES.CEDULA 
AND CONVERT(VARCHAR(30),REQUISICIONES.FECHA_SOLICITUD,20) = CONVERT(VARCHAR(30),ITEMSREQ.FECHA_SOLICITUD,20)
WHERE ITEMSREQ.CEDULA = REQUISICIONES.CEDULA 
 AND REQUISICIONES.CARGO = ITEMSREQ.CARGO AND  ITEMSREQ.IDREQ IS NULL  AND ITEMSREQ.CNSREQ IS NULL 
 AND REQUISICIONES.CNSREQ='CNSREQ1' AND REQUISICIONES.ID=1 
 /*GROUP BY ITEMSREQ.ITEM,ITEMSREQ.CANTIDAD,REQUISICIONES.CEDULA,REQUISICIONES.CARGO,REQUISICIONES.SOLICITANTE 
 HAVING MIN(CONVERT(VARCHAR(30),ITEMSREQ.FECHA_SOLICITUD,20)) = MIN(CONVERT(VARCHAR(30),REQUISICIONES.FECHA_SOLICITUD,20))*/



SELECT * FROM REQUISICIONESDT



SELECT * FROM REQUISICIONES

SELECT * FROM ITEMSREQ


SELECT ITEMSREQ.CANTIDAD, ITEMSREQ.ITEM , FECHA_SOLICITUD FROM ITEMSREQ 
INNER JOIN REQUISICIONESDT ON 
REQUISICIONESDT.CNSREQ = ITEMSREQ.CNSREQ

WHERE CNSREQ='CNSREQ2'

