
SELECT * FROM REQUISICIONES

SELECT * FROM ITEMSREQ
SELECT * FROM REQUISICIONESDT


SELECT ITEMSREQ.CANTIDAD, ITEMSREQ.ITEM , ITEMSREQ.FECHA_SOLICITUD FROM ITEMSREQ 
INNER JOIN REQUISICIONESDT ON 
REQUISICIONESDT.CNSREQ = ITEMSREQ.CNSREQ
WHERE ITEMSREQ.CNSREQ='CNSREQ2'


SELECT FIRMA_REVISION, FIRMA_APROBACION FROM REQUISICIONESDT WHERE CNSREQ = ?