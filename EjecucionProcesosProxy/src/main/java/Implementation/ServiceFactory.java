

package Implementation;

import Interface.IProcessEjecutor;

/**
 *
 * @author Naturaleza
 */
public class ServiceFactory {
    //metodo estatico 
    public static IProcessEjecutor createProcessEjecutor(){
        return new ProcessEjecutorProxy();//devuelve y trabaja con el proxy
        
    }
}
