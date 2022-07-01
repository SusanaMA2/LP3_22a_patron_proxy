import IProcessEjecutor;
import ServiceFactory;

public class MainProxy {

    public static void main(String[] args) {
        
        String usuario = "otro";
        String contraseña = "1236";
        int proceso = 1;
        IProcessEjecutor processEjecutor = ServiceFactory.createProcessEjecutor();
        //llamo al servicio factory de instanciar el proxy
        try {
        //controlar para que se ejecute el proceso
            processEjecutor.ejecuteProcess(proceso, usuario, contraseña);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    
    }
    
}
