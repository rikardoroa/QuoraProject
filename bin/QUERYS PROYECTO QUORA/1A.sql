
DECLARE 
@SOLICITANTE VARCHAR(30),
@CONSECUTIVO VARCHAR(30),
@AREA VARCHAR(30) , 
@CARGO VARCHAR(30) ,
@FECHA_SOLICITUD DATETIME,
@CANTIDAD INT, 
@ITEM VARCHAR(30),
@INID INT


DECLARE INSERTTEMPORALDATA CURSOR
FOR


SELECT  REQUISICIONES.SOLICITANTE AS SOLICITANTE, REQUISICIONES.CNSREQ AS CONSECUTIVO, REQUISICIONES.AREA AS AREA, 
 REQUISICIONES.CARGO AS CARGO,REQUISICIONES.FECHA_SOLICITUD  AS FECHA_SOLICITUD,
 ITEMSREQ.CANTIDAD AS CANTIDAD,  ITEMSREQ.ITEM AS ITEM  FROM REQUISICIONES   
       INNER JOIN ITEMSREQ ON ITEMSREQ.CEDULA = REQUISICIONES.CEDULA AND ITEMSREQ.CARGO = REQUISICIONES.CARGO   
           WHERE REQUISICIONES.REVISION IS NULL AND REQUISICIONES.APROBACION IS NULL AND REQUISICIONES.FIRMA_REVISION IS NULL    
                         GROUP BY REQUISICIONES.CARGO,    
                       REQUISICIONES.CEDULA,    
                     ITEMSREQ.CANTIDAD,    
                  ITEMSREQ.ITEM ,   
          REQUISICIONES.CNSREQ,   
          REQUISICIONES.SOLICITANTE,   
         REQUISICIONES.FECHA_SOLICITUD,   
         ITEMSREQ.FECHA_SOLICITUD,   
         REQUISICIONES.AREA   
        HAVING CONVERT(VARCHAR(30),ITEMSREQ.FECHA_SOLICITUD,20) = CONVERT(VARCHAR(30),REQUISICIONES.FECHA_SOLICITUD,20)   
        ORDER BY 2 ASC

		OPEN INSERTTEMPORALDATA

      FETCH NEXT FROM INSERTTEMPORALDATA INTO @SOLICITANTE,@CONSECUTIVO,@AREA, @CARGO,@FECHA_SOLICITUD, @CANTIDAD, @ITEM
	  WHILE @@FETCH_STATUS=0
	  BEGIN



	  	INSERT INTO RQITEMSTEMPORAL( SOLICITANTE,CONSECUTIVO,AREA, CARGO,FECHA_SOLICITUD, CANTIDAD, ITEM) VALUES ( @SOLICITANTE,@CONSECUTIVO,@AREA, @CARGO,@FECHA_SOLICITUD, @CANTIDAD, @ITEM)

	
		  FETCH NEXT FROM INSERTTEMPORALDATA INTO @SOLICITANTE,@CONSECUTIVO,@AREA, @CARGO,@FECHA_SOLICITUD, @CANTIDAD, @ITEM
               END
	             CLOSE INSERTTEMPORALDATA;  
                    DEALLOCATE INSERTTEMPORALDATA


				


