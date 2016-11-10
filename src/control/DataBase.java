/***  Objetivo:
 ***@version    v1.0 09/11/2016
 *@author    Ariel Troncoso/Enzo Troncoso
 */

package control;
import java.sql.*;
import javax.swing.*;
 

public class DataBase {
    private Connection con = null;
    private String user, pass, url;
   
    public DataBase(){}
    public Connection conectar(String dataBase) throws Exception{
        try {
            user = "root";
            pass = "";
            url = "jdbc:mysql://localhost:3306/"+dataBase;
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url,user,pass); 
        }
        catch (SQLException e) { JOptionPane.showMessageDialog(null, e.getMessage(), "Error, no hay conexión con la base de datos.", JOptionPane.ERROR_MESSAGE); }
        if ( con != null ) JOptionPane.showMessageDialog(null, "Conexión establecida con la base de datos.");
        return con;
    }

    public void cerrarConexion()
    {
        try {
            if(con != null) con.close();
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Problemas con la conexión", JOptionPane.ERROR_MESSAGE);
        }
    }
}
