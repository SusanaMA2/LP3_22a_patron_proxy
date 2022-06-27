

package services;

/**
 *
 * @author Naturaleza
 */
public class SecurityService {
     public boolean authorization(String usuario,String contraseña){
         if(usuario.equals("susana") && contraseña.equals("1234")){//equals igual
             System.out.println("Usuario " + usuario + " autorizado");
             return true;
         }else{
             System.out.println("Usuario " + usuario + " No autorizado");
             return false;
             
         }
     }
}
