/***  Objetivo:  El objetivo de esta clase es almacenar todos los metodos para hacer efectivo
 * el CRUD.
 ***@version    V1.0 2/11/2016
 *@author    Ariel Troncoso/Enzo Troncoso
 */

package auto;
import model.Auto;
import java.util.ArrayList;

public class Datos {
    private static ArrayList<Auto> losAutos=new ArrayList<>();
    public static boolean agregar(Auto auto)
    {
        boolean estado=false;
        losAutos.add(auto);
        estado=true;
        
        return estado;
    }
    
    public static ArrayList<Auto> obtenerAuto()
    {
         return losAutos;
    }
    
    public static Auto buscar(int id) 
    {
        Auto obj=null;
        for(Auto xx: losAutos)
        {
           if(xx.getId() == id)
           {
                obj=xx;
                break;
           }
        }
       return obj;
    }
    
    public static boolean modificar(Auto auto)
    {
        boolean estado = false;    
        int p = 0; 
        for(Auto xx:losAutos)
        {
            if(xx.getId() == auto.getId())
            {
                losAutos.set(p,auto);
                estado=true;
                break;
            }       
            p++;  
       }             
       return estado;
    }
    public static boolean eliminar(int id)
    {
       boolean estado = false;    
       int p=0;
       for(Auto xx:losAutos)
       {
            if(xx.getId() == id)
            {
                losAutos.remove(p);
                estado=true;
                break;
            }       
            p++;  
       }             
       return estado;
    }
}
