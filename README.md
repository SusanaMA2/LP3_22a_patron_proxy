<div align="center">
<table>
    <theader>
        <tr>
            <th><img src="https://github.com/rescobedoulasalle/git_github/blob/main/ulasalle.png?raw=true" alt="EPIS" style="width:50%; height:auto"/></th>
            <th>
                <span style="font-weight:bold;">UNIVERSIDAD LA SALLE</span><br />
                <span style="font-weight:bold;">FACULTAD DE INGENIERÍAS</span><br />
                <span style="font-weight:bold;">DEPARTAMENTO DE INGENIERÍA Y MATEMÁTICAS</span><br />
                <span style="font-weight:bold;">CARRERA PROFESIONAL DE INGENIERÍA DE SOFTWARE</span>
            </th>            
        </tr>
    </theader>
    
</table>
</div>

<div align="center">
<span style="font-weight:bold;">GUÍA DE LABORATORIO</span><br />
</div>

<table>
    <theader>
        <tr><th colspan="2">INFORMACIÓN BÁSICA</th></tr>
    </theader>
<tbody>

<tr><td>TÍTULO DE LA PRÁCTICA:</td><td>Examen final de lenguaje de programacion III</td></tr>
<tr><td colspan="2">RECURSOS:
    <ul>
        <li><a href="https://git-scm.com/book/es/v2">https://git-scm.com/book/es/v2</a></li>
        <li><a href="https://guides.github.com/">https://guides.github.com/</a></li>        
        <li><a href="https://www.w3schools.com/java/default.asp">https://www.w3schools.com/java/default.asp</a></li>
    </ul>
</td>
</<tr>
<tr><td colspan="2">DOCENTES:
    <ul>
        <li>Richart Smith Escobedo Quispe  - r.escobedo@ulasalle.edu.pe</li>
    </ul>
</td>
</<tr>
</tdbody>
</table>

# Patrón proxy

#

## OBJETIVOS Y TEMAS

### OBJETIVOS
- Conocer mas acerca del patrón proxy.
- Aprender a manejar git e implementar el codigo java.

### TEMAS
- Editor Vim
- Java
- Git
- GitHub

## CONTENIDO DE LA GUÍA

### MARCO CONCEPTUAL

- Editor Vim
    - Vim es un editor de texto muy eficiente para programar en consola que no tiene nada que envidiar a los editores gráficos.
    
- Instalar Vim en:

	- MS Windows
        - Para descarga en sistemas MS Windows https://www.vim.org/download.php

#

- Java
    - Java es un lenguaje de programación orientado a objetos
    - La documentación de Java 11 se encuentra en: https://docs.oracle.com/javase/specs/jls/se11/html/index.html
    - Un curso muy interesante en videos se puede encontrar en: https://www.youtube.com/playlist?list=PLw8RQJQ8K1yQDqPyDRzt-h8YlBj96OwMP
    
    - Instalar Java

        - MS Windows
            - Para descarga en sistemas MS Windows https://www.oracle.com/java/technologies/downloads/

#

- Git
    - Git es un sistema de control de versiones creado por Linus Torvalds. Es eficiente, confiable. 

- Instalar Git
      
	- MS Windows
        - Para descarga en sistemas MS Windows https://git-scm.com/download/win
    
#
       
- git init
    - Crea un nuevo proyecto local, se crean archivos en el directorio oculto .git
    -   ```sh
        git init
        ```

- git status
    - Permite verificar el estado de los archivos
    -   ```sh
        git status
        ```
- git add
    - Añade archivos al staging area. El punto "." agrega todos
    -   ```sh
        git add HolaMundo.java
        git add .
        ```

- git commit
    - Sube los archivos al área de staging, en la máquina local. La opción -m permite escribir el mensaje en línea
    -   ```sh
        git commit -m "Probando el Hola Mundo"    
        ```

#

## EJERCICIO RESUELTO 

- Se crea un nuevo proyecto en GitHub

- Crear un repositorio local usando git init
  
  ```sh
        
        \Users\Naturaleza\LP3\git\Pproxy
        git init
        ```
-Se crea una implentacion de patrón proxy
-Se comienza con la creacion de un paquete "EjecucionProcesosProxy".
-dentro del paquete se crea otro paquete "services".
-se crea una nueva clase new>java class llamado "AuditService"
se agrega el codigo.

```sh

  public void auditServiceUsed(String usuario, String servicio){
  
         SimpleDateFormat formatear= new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
         
         System.out.println(usuario + " utilizo el servicio > " + servicio + ", a las " +formatear.format(new Date())); 
     }```


-se crea una nueva clase new>java class llamado "SecurityService"
-se agrega el codigo.

 ```sh
      public boolean authorization(String usuario,String contraseña){

         if(usuario.equals("susana") && contraseña.equals("1234")){
         
             System.out.println("Usuario " + usuario + " autorizado");
             return true;
         }
         else{
         
             System.out.println("Usuario " + usuario + " No autorizado");
             return false;
             
         }
     }```

-Dentro del paquete "EjecucionProcesosProxy" se crea otro paquete "Interface".
-Se crea una nueva interfaz new>java interface llamado "IProcessEjecutor"
-Se agrega el codigo.

 ```sh
  public void ejecuteProcess(int idProceso, String usuario, String contraseña)
  
        throws Exception; ```
        

-Dentro del paquete "EjecucionProcesosProxy" se crea otro paquete "Implementation".
-Se crea una nueva interfaz new>java class llamado "DefaultProcessEjecutor"
-Se agrega el codigo.

 ```sh
public class DefaultProcessEjecutor implements IProcessEjecutor{


    @Override
    
    public void ejecuteProcess(int idProceso, String usuario, String contraseña) throws Exception {
    
        System.out.println("Proceso " + idProceso + " en ejecucion");
        System.out.println("Proceso " + idProceso + " terminado.");
    }
   
}```


-Se crea una nueva interfaz new>java class llamado "ProcessEjecutorProxy"
-Se agrega el codigo.


 ```sh
public class ProcessEjecutorProxy implements IProcessEjecutor{

    @Override
    public void ejecuteProcess(int idProceso, String usuario, String contraseña) throws Exception {
    
        
        SecurityService securityService = new SecurityService();
        if(!securityService.authorization(usuario, contraseña)){
         throw new Exception("El usuario '"+usuario +"' no tiene privilegios para ejecutar el proceso");//capture y crear excepcion y se personalice la excepcion y muestra mensaje
            
        }
        
        
        DefaultProcessEjecutor ejecutorProcesos = new DefaultProcessEjecutor();
        ejecutorProcesos.ejecuteProcess(idProceso, usuario, contraseña); 
        AuditService audit = new AuditService();
        audit.auditServiceUsed(usuario, DefaultProcessEjecutor.class.getName());
        
       
    }
   
}```


-Se crea una nueva interfaz new>java class llamado "ServiceFactory"
-Se agrega el codigo.

 ```sh
 public static IProcessEjecutor createProcessEjecutor(){
        return new ProcessEjecutorProxy();
        
    }```

-Dentro del paquete"EjecucionProcesosProxy" se crea otro paquete "Main".
-Se crea una nueva interfaz new>java main class llamado "MainProxy"
-Se agrega el codigo.

 ```sh
       String usuario = "susana";
 
        String contraseña = "1256";
        
        int proceso = 1;
        
        IProcessEjecutor processEjecutor = ServiceFactory.createProcessEjecutor();
        
        try {
        
            processEjecutor.ejecuteProcess(proceso, usuario, contraseña);
        } 
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }```


- luego se crear un archivo Readme.md con contenido Markup


#

## REFERENCIAS
- https://www.academia.edu/39945137/Introduccion_a_los_patrones_de_dise%C3%B1o
-https://www.youtube.com/watch?v=ORXfXNsrqH0

#

