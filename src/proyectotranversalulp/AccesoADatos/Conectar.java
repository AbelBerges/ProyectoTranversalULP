/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectotranversalulp.AccesoADatos;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Configuration;
import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.Driver;

/**
 *
 * @author kalema
 */
public class Conectar {
    
    private static final String URL="jdbc:mariadb://localhost:3306/";
    private static final String DB="proyectoTransversal";
    private static final String USUARIO="administrador";
    private static final String CLAVE="Sc@pl#BmDB";
    
    private static Connection conexion;
    
    public Conectar(){}
    
    public static Connection getConectar(){
        if(conexion==null){
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                //Coneccion mia. Abel por connection de mariadb
                String cadena="jdbc:mariadb://localhost:3306/obrador01?user=administrador&password=Sc@pL#BmDB";
                conexion=Driver.connect(Configuration.parse(cadena));
                //Conección a base por java SQL
                //conexion=DriverManager.getConnection(URL+DB,USUARIO,CLAVE);
                JOptionPane.showMessageDialog(null, "Se conectó");
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Problemas accediendo a la clase "+e.getMessage());
            } catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos "+ex.getMessage());
            }
        }
        return conexion;
    }
    
    
}
