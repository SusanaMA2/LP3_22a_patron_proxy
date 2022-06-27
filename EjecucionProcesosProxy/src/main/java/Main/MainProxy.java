
package Main;

import Implementation.ServiceFactory;
import Interface.IProcessEjecutor;

/**
 *
 * @author Naturaleza
 */
public class MainProxy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String usuario = "susana";
        String contraseña = "1256";
        int proceso = 1;
        IProcessEjecutor processEjecutor = ServiceFactory.createProcessEjecutor();//llamo al servicio factory ,de instanciar el proxy
        try {//controlar para que se ejcute el proceso
            processEjecutor.ejecuteProcess(proceso, usuario, contraseña);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    
    }
    
}
