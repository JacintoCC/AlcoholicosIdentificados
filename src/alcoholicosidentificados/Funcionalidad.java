/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alcoholicosidentificados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;


/**
 *
 * @authors
 *          Anabel Gómez Ríos
 *          Gustavo Rivas Gervilla
 *          Luis Suárez Lloréns
 *          Jacinto Carrasco Castillo
 */
public class Funcionalidad {
    private Connection conexion;
    
    public Connection getConexion(){
        return conexion;
    }
    
    public void setConexion(Connection conexion){
        this.conexion=conexion;
    }
    
    public Funcionalidad conectar(){
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            String base_de_datos="jdbc:oracle:thin:@localhost:1521:XE";

            conexion=DriverManager.getConnection(base_de_datos,"system","112358");

            if(conexion!=null){
                System.out.println("Conexión exitosa");
            }
            else{
                System.out.println("Conexión fallida");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return this;
    }
    
    public boolean escribir(String sql) {
        try {

            Statement sentencia;

            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

            sentencia.executeUpdate(sql);

            getConexion().commit();

            sentencia.close();

            System.out.println("Consulta Realizada");

        } catch (SQLException e) {

            e.printStackTrace();

            System.out.print("ERROR SQL");

            return false;

        }        

        return true;

    }
    
    public ResultSet consultar(String sql) {

        ResultSet resultado = null;

        try {

            Statement sentencia;

            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

            resultado = sentencia.executeQuery(sql);

            System.out.println("Consulta Realizada");

        } catch (SQLException e) {

            e.printStackTrace();

            return null;

        } 
        
        return resultado;

    }
}
        
