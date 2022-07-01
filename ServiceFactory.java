public class ServiceFactory {
    //metodo estatico 
    public static IProcessEjecutor createProcessEjecutor(){
        return new ProcessEjecutorProxy();//devuelve y trabaja con el proxy
        
    }
}
