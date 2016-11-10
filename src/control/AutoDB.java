/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.*;
import java.util.*;

public class AutoDB {
    private static Auto auto;
    private static Connection con = null;
    private static Statement stament;
    private static String query;
    private static ResultSet rs;
    private static int id;
    private static int fEliminadas;
    private static boolean estado;
    private static ArrayList<Auto> losAutos=new ArrayList<Auto>();

    public static void agregar(Auto auto)throws Exception{
        con = new DataBase().conectar("Autos");
        try {
            stament = con.createStatement();
            query = "INSERT INTO Autos VALUES ('"+auto.getId()+
                                     "','"+auto.getModelo()+
                                     "','"+auto.getAnio()+
                                     "','"+auto.getFoto()+
                                     "','"+auto.getPapeles()+
                                     "','"+auto.getPuertas()+
                                     "','"+auto.getLlantas()+"')";
            
            int i  = stament.executeUpdate(query);

            if ( i != 1 ) JOptionPane.showMessageDialog(null, "Error, no se agrego el auto.");
            else JOptionPane.showMessageDialog(null, "Los datos se han agregado correctamente...");
        }
        catch (SQLException log) { JOptionPane.showMessageDialog(null, "Error, El registro ya existe."); }
        con.close();
    }
    

    public static ArrayList<Auto> listar()throws Exception {
        int i;
        con = new DataBase().conectar("Autos");

        try {
            stament = con.createStatement();
            query = "SELECT * FROM Autos";
            rs = stament.executeQuery(query);

            int    id;
            String modelo, anio, foto;
            byte   papeles, puertas, llantas;
               
            while(rs.next())
            {
                id=rs.getInt("id");
                modelo=rs.getString("modelo");
                anio=rs.getString("anio");
                foto=rs.getString("foto");
                papeles=rs.getByte("papeles");
                puertas=rs.getByte("puertas");
                llantas=rs.getByte("llantas");
                losAutos.add(new Auto(id,modelo,anio,foto,papeles,puertas,llantas));
            }
        } catch(SQLException log) { JOptionPane.showMessageDialog(null, "Error, problema con la base de datos..."+log); }
        con.close();
       
        return losAutos;
    }      

    public static Auto buscar(int id) throws Exception {
        con = new DataBase().conectar("Autos");

        try {
            stament = con.createStatement();
            query="SELECT * FROM Autos WHERE id = '"+id+"';";
            rs = stament.executeQuery(query);

            rs.last();
            System.out.println("Paso RS... "+rs.getRow());
                      
            rs.first();
            if(rs.getRow()==0)
            {
                JOptionPane.showMessageDialog(null,"Error, este ID no existe, por favor agregarlo.");
                auto = new Auto();
            }
            else
            {
                rs.beforeFirst();
                while(rs.next()) {
                    auto = new Auto( rs.getInt("id"), rs.getString("modelo"), rs.getString("anio"), rs.getString("foto"), rs.getByte("papeles"), rs.getByte("puertas"), rs.getByte("llantas") );
                }
            }
             
        } catch(SQLException sqle) { System.out.println("Error SQL....." +sqle); }
        con.close();
     
        return auto;
    }
    public static boolean eliminar(String rut) throws Exception {
        estado = false;
        con = new DataBase().conectar("Autos");
        try {
            stament = con.createStatement();
            query = "DELETE FROM Autos WHERE id = ('"+id+"')";
            fEliminadas = stament.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"La fila eliminada fue "+fEliminadas);

            if(fEliminadas != 1) JOptionPane.showMessageDialog(null, "Se ha producido un error inesperado.");
            else
            {
                JOptionPane.showMessageDialog(null, "Los datos se han eliminado corectamente");
                //limpiar();
                estado = true;
            }
        }
        catch (SQLException log) { JOptionPane.showMessageDialog(null,"Error, hubo un problema con la base de datos, registro: " +log); }
        if ( con == null ) JOptionPane.showMessageDialog(null,"Error, No se pudo eliminar el auto.");
        else if ( con != null )
        {
            try { con.close(); }
            catch( Exception log ) { JOptionPane.showMessageDialog(null, log.getMessage()); }
        }
                      
        return estado;        
    }
    
    public static void modificar(Auto auto)throws Exception{
         
        con = new DataBase().conectar("Autos");
        try {
            stament = con.createStatement();
            query = "UPDATE Autos SET modelo='"+auto.getModelo()+
                                   "',anio='"+auto.getAnio()+
                                   "',foto='"+auto.getFoto()+
                                   "',papeles='"+auto.getPapeles()+
                                   "',puertas='"+auto.getPuertas()+
                                   "',llantas='"+auto.getLlantas()+
                                   "' WHERE id = '"+auto.getId()+"'";
            int mFila  = stament.executeUpdate(query);

            if(mFila!=1) JOptionPane.showMessageDialog(null,"Error, Primero debes agregar este auto, luego puedes modificarlo.");
            else JOptionPane.showMessageDialog(null, "Los datos se han modificado correctamente.");
          }
          catch (SQLException sqle)
                { System.out.println("Error SQL....." +sqle); }

        con.close();
    }
    
}
