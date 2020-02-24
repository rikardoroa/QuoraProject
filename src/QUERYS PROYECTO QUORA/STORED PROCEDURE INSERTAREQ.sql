USE [QUORA]
GO

/****** Object:  StoredProcedure [dbo].[INSERTAREQ]    Script Date: 05/12/2019 18:28:49 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[INSERTAREQ]
@DETALLEREQ VARCHAR(30),
@IDREQ INT

AS


DECLARE 
@SOLICITANTE VARCHAR(30),
@AREA VARCHAR(30),
@CARGO VARCHAR(30),
@CEDULA VARCHAR(30),
@FECHA_SOLICITUD DATETIME,
@FIRMA_REVISION VARBINARY (MAX)


DECLARE  ACTUALIZADATAREQ CURSOR
FOR

SELECT CNSREQ,ID, SOLICITANTE,AREA,CARGO,FECHA_SOLICITUD, CEDULA, FIRMA_REVISION
FROM REQUISICIONES
WHERE CNSREQ=@DETALLEREQ AND ID=@IDREQ

OPEN ACTUALIZADATAREQ
      
     FETCH NEXT FROM ACTUALIZADATAREQ INTO @DETALLEREQ, @IDREQ,@SOLICITANTE,@AREA,@CARGO,@FECHA_SOLICITUD, @CEDULA,@FIRMA_REVISION 
	  WHILE @@FETCH_STATUS=0
          BEGIN
		    BEGIN

			INSERT INTO REQUISICIONESDT ( SOLICITANTE, CEDULA, AREA, CARGO, FECHA_SOLICITUD, CNSREQ, IDREQ, FIRMA_REVISION) VALUES (@SOLICITANTE,@CEDULA,@AREA,@CARGO,@FECHA_SOLICITUD, @DETALLEREQ, @IDREQ, @FIRMA_REVISION)
			
			UPDATE REQUISICIONES SET REQUISICIONES.CNSRQDT=REQUISICIONESDT.CNSRQDT, REQUISICIONES.IDRQDT=REQUISICIONESDT.ID FROM
			 REQUISICIONESDT INNER JOIN REQUISICIONES ON
			   REQUISICIONES.ID = REQUISICIONESDT.IDREQ  AND REQUISICIONES.CNSREQ = REQUISICIONESDT.CNSREQ 
			   WHERE  REQUISICIONES.ID=@IDREQ AND REQUISICIONES.CNSREQ=@DETALLEREQ


			    UPDATE ITEMSREQ SET ITEMSREQ.IDREQ=@IDREQ, ITEMSREQ.CNSREQ=@DETALLEREQ FROM ITEMSREQ 
                    INNER JOIN REQUISICIONES  ON ITEMSREQ.CEDULA = REQUISICIONES.CEDULA 
                  AND CONVERT(VARCHAR(30),REQUISICIONES.FECHA_SOLICITUD,20) = CONVERT(VARCHAR(30),ITEMSREQ.FECHA_SOLICITUD,20)
                     WHERE ITEMSREQ.CEDULA = REQUISICIONES.CEDULA 
                        AND REQUISICIONES.CARGO = ITEMSREQ.CARGO AND  ITEMSREQ.IDREQ IS NULL  AND ITEMSREQ.CNSREQ IS NULL 
                     AND REQUISICIONES.CNSREQ=@DETALLEREQ AND REQUISICIONES.ID=@IDREQ 
                   

		     END
		  FETCH NEXT FROM ACTUALIZADATAREQ 
             INTO @DETALLEREQ, @IDREQ,@SOLICITANTE,@AREA,@CARGO,@FECHA_SOLICITUD, @CEDULA,@FIRMA_REVISION 
               END
	             CLOSE ACTUALIZADATAREQ;  
                    DEALLOCATE ACTUALIZADATAREQ



GO


