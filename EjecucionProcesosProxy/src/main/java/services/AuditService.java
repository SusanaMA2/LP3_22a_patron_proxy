

package services;

import java.text.SimpleDateFormat;//formato tipo date
import java.util.Date;

/**
 *
 * @author Naturaleza
 */
public class AuditService {
     public void auditServiceUsed(String usuario, String servicio){
         SimpleDateFormat formatear= new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
         System.out.println(usuario + " utilizo el servicio > " + servicio + ", a las " +formatear.format(new Date())); 
     }
}
