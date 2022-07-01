public class ProcessEjecutorProxy implements IProcessEjecutor{
//se implemeta a traves de la interfaz
    //se coloca la clase abstracta,se controla la excepcion y controlamos de manera directa
    //se simula la ejcucion 
    //La clase implementa el método ejecuteProcess el cual simula realizar una tarea.
    @Override
    public void ejecuteProcess(int idProceso, String usuario, String contraseña) throws Exception {
        //
        SecurityService securityService = new SecurityService();//instancio securityservice,crear la autorizacion al cliente
        if(!securityService.authorization(usuario, contraseña)){//si es diferente de true captura la excepcion,es falso
            throw new Exception("El usuario '"+usuario +"' no tiene privilegios para ejecutar el proceso");//capture y crear excepcion y se personalice la excepcion y muestra mensaje
            
        }//desde security es la preaccion valida al usuario
        
        DefaultProcessEjecutor ejecutorProcesos = new DefaultProcessEjecutor();//llamamamos al bojeto que ejeucte el proceso
        ejecutorProcesos.ejecuteProcess(idProceso, usuario, contraseña); 
        //default y ejecutor accion--ejecucion del proceso
        
        AuditService audit = new AuditService();//llamamos al paquete
        audit.auditServiceUsed(usuario, DefaultProcessEjecutor.class.getName());//usuario y servici ejecutar el proceso auditoria()
        //pos accion auditoria
    }

}

