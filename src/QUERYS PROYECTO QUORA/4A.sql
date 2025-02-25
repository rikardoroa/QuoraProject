		  SELECT DISTINCT  MIN(T.CONSECUTIVO)  FROM (SELECT MAX(REQUISICIONES.CNSREQ) AS CONSECUTIVO ,MAX(CONVERT(VARCHAR(16),ITEMSREQ.FECHA_SOLICITUD,20) )AS MAXFSA ,MAX(CONVERT(VARCHAR(16),REQUISICIONES.FECHA_SOLICITUD,20)) MAXFSAA1
              FROM REQUISICIONES  INNER JOIN ITEMSREQ ON ITEMSREQ.CEDULA = REQUISICIONES.CEDULA AND 
			    ITEMSREQ.CARGO = REQUISICIONES.CARGO   
             WHERE REQUISICIONES.REVISION IS NULL AND REQUISICIONES.APROBACION IS NULL
			  AND REQUISICIONES.FIRMA_REVISION IS NULL AND  REQUISICIONES.CNSREQ NOT IN 
      (SELECT CONSECUTIVO  FROM RQITEMSTEMPORAL) GROUP BY
	 REQUISICIONES.CNSREQ,  REQUISICIONES.FECHA_SOLICITUD,ITEMSREQ.FECHA_SOLICITUD
HAVING CONVERT(VARCHAR(16),ITEMSREQ.FECHA_SOLICITUD,20) = CONVERT(VARCHAR(16),REQUISICIONES.FECHA_SOLICITUD,20) )  AS T

    INNER JOIN 

	 (SELECT MAX(REQUISICIONES.CNSREQ) AS CONSECUTIVO ,MAX(CONVERT(VARCHAR(16),ITEMSREQ.FECHA_SOLICITUD,20) ) AS MAXFSB,MAX(CONVERT(VARCHAR(16),REQUISICIONES.FECHA_SOLICITUD,20)) AS MAXFSAA2
              FROM REQUISICIONES  INNER JOIN ITEMSREQ ON ITEMSREQ.CEDULA = REQUISICIONES.CEDULA AND 
			    ITEMSREQ.CARGO = REQUISICIONES.CARGO   
             WHERE REQUISICIONES.REVISION IS NULL AND REQUISICIONES.APROBACION IS NULL
			  AND REQUISICIONES.FIRMA_REVISION IS NULL AND  REQUISICIONES.CNSREQ NOT IN 
      (SELECT CONSECUTIVO  FROM RQITEMSTEMPORAL) GROUP BY
	 REQUISICIONES.CNSREQ,  REQUISICIONES.FECHA_SOLICITUD,ITEMSREQ.FECHA_SOLICITUD
HAVING CONVERT(VARCHAR(16),ITEMSREQ.FECHA_SOLICITUD,20) = CONVERT(VARCHAR(16),REQUISICIONES.FECHA_SOLICITUD,20) ) AS H

ON T.CONSECUTIVO = H.CONSECUTIVO