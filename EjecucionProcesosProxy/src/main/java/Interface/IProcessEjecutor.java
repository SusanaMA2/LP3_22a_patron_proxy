

package Interface;

/**
 *
 * @author Naturaleza
 */
public interface IProcessEjecutor {
    public void ejecuteProcess(int idProceso, String usuario, String contraseña)//metodo public
        throws Exception; //si algo ocurre con el metodo me lance o capture(throws) una excepcion 
                            //cuando no se genera el metodo,tambien para controlar la ejcucion de los procesos
}
