/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlejercicio;



import java.sql.*;

/**
 *
 * @author Alumno
 */

public class Clases {
    
        Connection conexion = null;
        Statement sentencia = null;
    public void crearBDatos(){
    
        
        try
        {
         Class.forName("org.sqlite.JDBC");
         conexion= DriverManager.getConnection("jdbc:sqlite:empresa.sqlite");
         
        }
        catch(ClassNotFoundException |SQLException e)
        {
           System.err.println("Error:" +e.getMessage());
           System.exit(0);
        }
        System.out.println("Se ha creado la base de datos");
        
    }  
    
    public void CrearTabla(){
      
        try
        {
        Class.forName("org.sqlite.JDBC");
         conexion= DriverManager.getConnection("jdbc:sqlite:empresa.sqlite");
         System.out.println("conexion realizada con exito");
         
        sentencia = conexion.createStatement();
        
         String sql = "CREATE TABLE USUARIOS " + 
                 "(NOMBRE TEXT PRIMARY KEY NOT NULL," +
                 "APELLIDO TEXT NOT NULL," + 
                 "EDAD INT,  "+
                 "FECHANACIDO DATE,"
                 + "FONO INT,"
                 + "PUESTO_TRABAJO TEXT)";
         
         sentencia.executeUpdate(sql);
         sentencia.close();
         conexion.close();
        }
        catch(ClassNotFoundException |SQLException e)
        {
            System.err.println("Error:" + e.getMessage());
            System.exit(0);

        }
        
    }
    public void InsertarDatos(){
        try
        {  
        Class.forName("org.sqlite.JDBC");
         conexion= DriverManager.getConnection("jdbc:sqlite:empresa.sqlite");
         conexion.setAutoCommit(false);
         System.out.println("Base de datos abierta satisfactoriamente");
         
         sentencia = conexion.createStatement();
         
         String sql = "INSERT INTO USUARIOS(NOMBRE, APELLIDO, EDAD, FECHANACIDO, FONO, PUESTO_TRABAJO) "+
                 "VALUES('CRISTOBAL', 'VARGAS', 24, 19081996, 94449688, 'GERENTE')";
         
         sentencia.executeUpdate(sql);
         sentencia.close();
         conexion.commit();
         conexion.close();
         
        }
        catch(ClassNotFoundException |SQLException e)
        {
            System.err.println("Error:" + e.getMessage());
            System.exit(0);
        }
        
       
            
        
        
        
    }
    public void mostrartabla(){
        
        try
        {  
        Class.forName("org.sqlite.JDBC");
         conexion= DriverManager.getConnection("jdbc:sqlite:empresa.sqlite");
         conexion.setAutoCommit(false);
         sentencia = conexion.createStatement();
         ResultSet resultado = sentencia.executeQuery("SELECT * FROM USUARIOS");
         
         while(resultado.next())
         {
             String NOMBRE = resultado.getString("NOMBRE");
             String APELLIDO = resultado.getString("APELLIDO");
             int EDAD = resultado.getInt("EDAD");
             int FECHANACIDO = resultado.getInt("FECHANACIDO");
             int FONO = resultado.getInt("FONO");
             String PUESTO_TRABAJO = resultado.getString("PUESTO_TRABAJO");
             
             System.out.println("\nNOMBRE  :" + NOMBRE + "\nAPELLIDO  :" +
                     APELLIDO + "\nEDAD  :" + EDAD + "\nFECHANACIDO  :" + FECHANACIDO +
                     "\nFONO  :" + FONO + "\nPUESTO_TRABAJO  :" + PUESTO_TRABAJO + "\n");
         }
         
        
            
         resultado.close();
         sentencia.close();
         conexion.close();
         
        }
        catch(ClassNotFoundException |SQLException e)
        {
            System.err.println("Error:" + e.getMessage());
            System.exit(0);
        }
            
        
    }
    public void borrartabla(){
        try
        {
        Class.forName("org.sqlite.JDBC");
         conexion= DriverManager.getConnection("jdbc:sqlite:empresa.sqlite");
         System.out.println("conexion realizada con exito");
         
        sentencia = conexion.createStatement();
        
         String sql = "DROP TABLE USUARIOS ";
                 
         
         sentencia.executeUpdate(sql);
         sentencia.close();
         conexion.close();
        }
        catch(ClassNotFoundException |SQLException e)
        {
        
            System.err.println("Error:" + e.getMessage());
            System.exit(0);
        }
        
    }
   
        
    
}      

