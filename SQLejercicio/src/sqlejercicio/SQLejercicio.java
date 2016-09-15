/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlejercicio;

import java.util.Scanner;

/**
 *
 * @author Alumno
 */
public class SQLejercicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("ingrese una opcion");
// TODO code application logic here
        Clases ver = new Clases();
        Scanner leer = new Scanner(System.in);
        int a = leer.nextInt();
        
        //para hacer lo demas tienes que cambiar de metodos
        //como lo son crearBDatos o CrearTabla
        
        
        
      
    
        switch(a)
        {
            case 1:
                ver.CrearTabla();
                break;
                
            case 2:
                ver.InsertarDatos();
                break;
                
            case 3:
                ver.borrartabla();
                break;
                
            case 4:
                ver.mostrartabla();
                break;
            default :
                System.out.println("error");
                        
                
            
            
        }
        
        
    }

    }

