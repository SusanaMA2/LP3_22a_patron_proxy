public class DefaultProcessEjecutor implements IProcessEjecutor{
//se implemeta a traves de la interfaz
//se coloca la clase abstracta,se controla la excepcion y controlamos de manera directa
//se simula la ejcucion 
    @Override
    public void ejecuteProcess(int idProceso, String usuario, String contraseña) throws Exception {
        System.out.println("Proceso " + idProceso + " en ejecucion");
        System.out.println("Proceso " + idProceso + " terminado.");
    }
    
}
