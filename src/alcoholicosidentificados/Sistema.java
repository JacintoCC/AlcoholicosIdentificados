/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alcoholicosidentificados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @authors
 *          Anabel Gómez Ríos
 *          Gustavo Rivas Gervilla
 *          Luis Suárez Lloréns
 *          Jacinto Carrasco Castillo
 */

public class Sistema {
    private static final Sistema instance=new Sistema();
    private Vista v;
    private String id_activo;
    private final Funcionalidad f;
    
    private Sistema(){
        f=new Funcionalidad();
        f.conectar();
    }
    public static Sistema getInstance(){
        return instance;
    }
    
    public void setVista(Vista unaVista){
        v=unaVista;
    }
    
    public void buscarProducto(){
        Scanner s=new Scanner(System.in);
        String consulta="SELECT * FROM ProductoOfertadoPor";
        
        boolean param_introducido=false;
        String str;

        System.out.println("Introduzca el nombre del producto");
        str=s.nextLine();

        if(str.length()>0){
            param_introducido=true;
            consulta=consulta.concat(" WHERE NOMBRE='" + str + "'");
        }

        System.out.println("Introduzca el precio del producto");
        str=s.nextLine();
            
        if(str.length()>0){
            if(param_introducido){
                consulta=consulta.concat(" AND ");
            }
            else{
                consulta=consulta.concat(" WHERE ");
                param_introducido=true;
            }
            consulta=consulta.concat(" PRECIO="+str);
        }
            
        System.out.println("Introduzca la categoria del producto");
        str = s.nextLine();

        if(str.length()>0){
            if(param_introducido){
                consulta=consulta.concat(" AND ");
            }
            else{
                consulta=consulta.concat(" WHERE ");
                param_introducido=true;
            }
            consulta=consulta.concat(" CATEGORIA='"+str+"'");
        }

        System.out.println("Introduzca la graduacion del producto");
        str=s.nextLine();
            
        if(str.length()>0){
            if(param_introducido){
                consulta=consulta.concat(" AND ");
            }
            else{
                consulta=consulta.concat(" WHERE ");
                param_introducido=true;
            }
            consulta=consulta.concat(" GRADUACION="+str);
        }

        System.out.println("Introduzca la empresa del producto");
        str=s.nextLine();

        if(str.length()>0){
            if(param_introducido){
                consulta=consulta.concat(" AND ");
            }
            else{
                consulta=consulta.concat(" WHERE ");
                param_introducido=true;
            }
            consulta=consulta.concat(" EMPRESA='"+str+"'");
        }
        
        System.out.println(consulta);
        Funcionalidad f=new Funcionalidad();
        f.conectar();
        ResultSet r=f.consultar(consulta);
            try{
                while(r.next()){
                    Object fila = new Object();
                    fila = r.getObject(2);
                    System.out.println(fila);
                }

                r.close();//cerrar result-set
            } 
            catch (SQLException ex) {
              System.out.println(ex.toString());
            }
    }
    
    public void borrarProducto(){
        Scanner s=new Scanner(System.in);
        String consulta="DELETE FROM ProductoOfertadoPor";
        
        boolean param_introducido=false;
        String str;

        System.out.println("Introduzca el nombre del producto");
        str=s.nextLine();

        if(str.length()>0){
            param_introducido=true;
            consulta=consulta.concat(" WHERE NOMBRE='" + str + "'");
        }

        System.out.println("Introduzca el precio del producto");
        str=s.nextLine();
            
        if(str.length()>0){
            if(param_introducido){
                consulta=consulta.concat(" AND ");
            }
            else{
                consulta=consulta.concat(" WHERE ");
                param_introducido=true;
            }
            consulta=consulta.concat(" PRECIO="+str);
        }
            
        System.out.println("Introduzca la categoria del producto");
        str = s.nextLine();

        if(str.length()>0){
            if(param_introducido){
                consulta=consulta.concat(" AND ");
            }
            else{
                consulta=consulta.concat(" WHERE ");
                param_introducido=true;
            }
            consulta=consulta.concat(" CATEGORIA='"+str+"'");
        }

        System.out.println("Introduzca la graduacion del producto");
        str=s.nextLine();
            
        if(str.length()>0){
            if(param_introducido){
                consulta=consulta.concat(" AND ");
            }
            else{
                consulta=consulta.concat(" WHERE ");
                param_introducido=true;
            }
            consulta=consulta.concat(" GRADUACION="+str);
        }

        System.out.println("Introduzca la empresa del producto");
        str=s.nextLine();

        if(str.length()>0){
            if(param_introducido){
                consulta=consulta.concat(" AND ");
            }
            else{
                consulta=consulta.concat(" WHERE ");
                param_introducido=true;
            }
            consulta=consulta.concat(" EMPRESA='"+str+"'");
        }
        
        System.out.println(consulta);
        Funcionalidad f=new Funcionalidad();
        f.conectar();
        ResultSet r=f.consultar(consulta);
            try{
                while(r.next()){
                    Object fila = new Object();
                    fila = r.getObject(2);
                    System.out.println(fila);
                }

                r.close();//cerrar result-set
            } 
            catch (SQLException ex) {
              System.out.println(ex.toString());
            }
    }
    
    public void introducirProducto(){
        String values=" VALUES(",str;
        Scanner s=new Scanner(System.in);
        String consulta="INSERT INTO PRODUCTOOFERTADOPOR (codProducto";
        
        System.out.println("Introduzca el código del producto\n");
        do{
            str=s.nextLine();
        }while(str.length()==0);
        values=values.concat(str);
        
        System.out.println("Introduzca el nombre del producto\n");
        str=s.nextLine();
        if (str.length() > 0){
            consulta=consulta.concat(",nombre");
            values = values.concat(",'"+str+"'");
        }
        
        System.out.println("Introduzca el precio del producto\n");
        str=s.nextLine();
        if (str.length() > 0){
            consulta=consulta.concat(",precio");
            values = values.concat(","+str);
        }
        
        System.out.println("Introduzca la categoría del producto\n");
        str=s.nextLine();
        if (str.length() > 0){
            consulta=consulta.concat(",categoria");
            values = values.concat(",'"+str+"'");
        }
        
        System.out.println("Introduzca la graduación del producto\n");
        str=s.nextLine();
        if (str.length() > 0){
            consulta=consulta.concat(",graduacion");
            values = values.concat(","+str);
        }
        
        System.out.println("Introduzca los ingredientes del producto\n");
        str=s.nextLine();
        if (str.length() > 0){
            consulta=consulta.concat(",ingredientes");
            values = values.concat(",'"+str+"'");
        }
        
        System.out.println("Introduzca la empresa que fabrica el producto\n");
        str=s.nextLine();
        if (str.length() > 0){
            consulta=consulta.concat(",idUsuario");
            values = values.concat(",'"+str+"'");
        }
        
        consulta=consulta.concat(")"+ values+")");
        System.out.println(consulta);
        Funcionalidad f=new Funcionalidad();
        f.conectar();
        f.consultar(consulta);
    }
    
    public void introducirMovimiento(){
        String values=" VALUES(",str;
        Scanner s=new Scanner(System.in);
        String consulta="INSERT INTO Movimiento";
        
        System.out.println("Introduzca el identificador del movimiento\n");
        do{
            str=s.nextLine();
        }while(str.length()==0);
        values=values.concat(str);
        
        System.out.println("Introduzca el concepto del movimiento\n");
        do{
            str=s.nextLine();
        }while(str.length()==0);
        values = values.concat(",'"+str+"'");
        
        
        System.out.println("Introduzca la cantidad del movimiento\n");
        do{
            str=s.nextLine();
        }while(str.length()==0);
        values = values.concat(","+str);
        
        System.out.println("Introduzca la fecha del movimiento en formato DD/MM/YYYY\n");
        do{
            str=s.nextLine();
        }while(str.length()==0);
        values = values.concat(",TO_DATE('"+str+"'))");
            
            
        consulta=consulta.concat(values);
        System.out.println(consulta);
        Funcionalidad f=new Funcionalidad();
        f.conectar();
        f.consultar(consulta);
    }
    
    public void registrarUsuario(ArrayList<String> argumentos,ArrayList<String> valores){
        String consulta="INSERT INTO Usuario (IdUsuario,Contraseña";
        
        for (String argumento : argumentos) {
            consulta = consulta+"," + argumento;
        }
        consulta=consulta+") VALUES('"+valores.get(0);
        
        for(int i=1;i<valores.size();i++){
            consulta=consulta+"','"+valores.get(i);
        }
        consulta=consulta+"')";
        
        f.escribir(consulta);
    }
    
    public void registrarConsumidor(ArrayList<String> valores){
        String consulta="INSERT INTO Consumidor (IdUsuario,FechaNacimiento";
        
        if(valores.size()==3){
            consulta=consulta+",Apellidos";
        }
        consulta=consulta+") VALUES('"+valores.get(0)+"',TO_DATE('"+valores.get(1)+"')";
        
        if(valores.size()==3){
            consulta=consulta+",'"+valores.get(2)+"'";
        }
        consulta=consulta+"')";
        
        f.escribir(consulta);
    }
    
    public void registrarEmpresa(ArrayList<String> valores){
        String consulta="INSERT INTO Empresa (IdUsuario";
        
        if(valores.size()==2){
            consulta=consulta+",Telefono";
        }
        consulta=consulta+") VALUES('"+valores.get(0)+"'";
        
        if(valores.size()==2){
            consulta=consulta+","+valores.get(2);
        }
        consulta=consulta+")";
        
        f.escribir(consulta);
    }
    
    public void setIdActivo(String idUsuario){
        id_activo=idUsuario;
    }
    
    public void setValoracion(int cod_producto,int valoracion){
        String consulta="SELECT * FROM Valoracion WHERE IdUsuario='"+
                        id_activo+"' AND CodProducto="+cod_producto;
        
        ResultSet r= f.consultar(consulta);
        try {
        if(r.next()){
            consulta="UPDATE Valoracion SET Puntuacion="+valoracion+
                    " WHERE IdUsuario='"+id_activo+
                    "' AND CodProducto="+cod_producto;
            System.out.println(consulta);
            f.escribir(consulta);
        }
        else{
            consulta="INSERT INTO Valoracion VALUES('"+id_activo+"',"+cod_producto+","+valoracion+")";
            System.out.println(consulta);
            f.escribir(consulta);
        }
        } catch (SQLException ex) {
            Logger.getLogger(Sistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}