//para generar excepciones
public interface IProcessEjecutor {
    public void ejecuteProcess(int idProceso, String usuario, String contraseña)
        throws Exception; //si algo ocurre con el metodo me lance o capture(throws)  
                            //cuando no se genera el metodo,tambien para controlar la ejcucion de los procesos
}
