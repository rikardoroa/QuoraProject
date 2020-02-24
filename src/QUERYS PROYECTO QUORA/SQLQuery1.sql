


CREATE PROCEDURE FIRMAREQUISICION
@CNSREQ VARCHAR(30)
AS

UPDATE REQUISICIONESDT SET REQUISICIONESDT.FECHA_DE_FIRMA=GETDATE(), 
REQUISICIONESDT.APROBACION=1, REQUISICIONESDT.FIRMA_APROBACION=ITEMSREQ.FIRMA_APROBACION
FROM REQUISICIONESDT INNER JOIN ITEMSREQ
ON REQUISICIONESDT.CNSREQ = ITEMSREQ.CNSREQ
WHERE REQUISICIONESDT.CNSREQ=@CNSREQ AND ITEMSREQ.CNSREQ=@CNSREQ


UPDATE REQUISICIONES SET APROBACION=1 
FROM REQUISICIONESDT INNER JOIN REQUISICIONES
ON REQUISICIONESDT.CNSREQ = REQUISICIONES.CNSREQ WHERE REQUISICIONES.CNSREQ = @CNSREQ
AND REQUISICIONESDT.CNSREQ=@CNSREQ

GO

EXEC FIRMAREQUISICION 'CNSREQ2'