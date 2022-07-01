import java.util.Date;
import java.text.SimpleDateFormat;


public class AuditService {
     public void auditServiceUsed(String usuario, String servicio){
         SimpleDateFormat formatear= new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
         System.out.println(usuario + " utilizo el servicio > " + servicio + ", a las " +formatear.format(new Date()));
     }
}
