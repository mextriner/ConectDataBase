/*
 * Programa de testeo conexión base de datos MySql
 */
package com.ceep.introjdbc;

import Dominio.Persona;
import Dominio.PersonaDao;
//import java.sql.Statement;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public class TestMySql {
    
    
    public static PersonaDao personaDao = new PersonaDao();
    
    public static List <Persona> personas(){
        
        List <Persona> pers = null;
        try{
            List <Persona> persona = personaDao.seleccionar();
            pers = persona;
//            personas.forEach(persona->{
//                System.out.println("persona = "+persona); 
//            });
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
        return pers;
        
    }
        
    
    
    
    public static void main(String[] args) {
        
        
        
        
        Persona persona = new Persona("Nicolás","Correa","nicolasN@Gmail.com","654654654");
        
//        personaDao.insertar(persona);

        Persona persona2 = persAct(1);
        persona2.setPersonaTelefono("666666666");
        
        
        System.out.println(persona2.getPersonaTelefono()); 
//        System.out.println(persAct(1));
        personaDao.actualizar(persona2);
        
        
       
    }
    
    public static Persona persAct(int id){
        Persona actualizable = null;
        List <Persona> lista = personas();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getPersonaID() == id){
                actualizable = lista.get(i);
            }
        }
            
        return actualizable;
    }
       
}


 //Definimos la url de conexiójn a nuestra base de datos y sus parámetros
//        String url = "jdbc:mysql://localhost:3306/primer_test?useSSL=false"
//                +"&useTimezone=true&serverTimezone=UTC"
//                +"&allowPublicKeyRetrieval=true&";
//        //Ahora tratamos de establecer la conexión con nuestra base de datos
//        try{
//            Connection conexion = DriverManager.getConnection(url,"root","1234");
//            Statement instruccion = conexion.createStatement();
//            String sql = "SELECT * FROM TPersona";
//            ResultSet resultado = instruccion.executeQuery(sql);
//            while(resultado.next()){
//                System.out.println("IdPersona:"+resultado.getInt("PersonaId"));
//                System.out.println("Nombre: "+resultado.getString("personaNmae"));
//                System.out.println("Apellidos: "+resultado.getString("personaApellidos"));
//                System.out.println("Email: "+resultado.getString("personaEmail"));
//                System.out.println("Correo: "+resultado.getString("personaTelefono"));
//            }
//            resultado.close();
//            instruccion.close();
//            
//        }catch(SQLException ex){
//            ex.printStackTrace(System.out);
//        }
//        
//    }