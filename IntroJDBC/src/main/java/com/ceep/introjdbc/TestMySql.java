/*
 * Programa de testeo conexión base de datos MySql
 */
package com.ceep.introjdbc;

import Dominio.Persona;
import Dominio.PersonaDao;
import Dominio.Usuario;
import Dominio.UsuarioDao;
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
    
    public static List <Usuario> usuarios(){
        
        List <Usuario> usurs = null;
        try{
            List <Usuario> usuario = usuarioDao.seleccionar();
            usurs = usuario;
//            personas.forEach(persona->{
//                System.out.println("persona = "+persona); 
//            });
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
        return usurs;
        
    }
    
    public static UsuarioDao usuarioDao = new UsuarioDao();
        
    
    
    
    public static void main(String[] args) {
        
        
        
        
        Persona persona = new Persona("Nicolás","Correa","nicolasN@Gmail.com","654654654");
        
//        personaDao.insertar(persona);

        Persona persona2 = persAct(1);
        persona2.setPersonaTelefono("666666666");
        
        
//        System.out.println(persAct(1));
        personaDao.actualizar(persona2);
        
        Usuario usuario = new Usuario ("mextriner","1234");
        
       usuarioDao.insertar(usuario);
       
       usuario.setId(usurAct(1).getId());
       
        System.out.println(usuario);
       
        usuarioDao.eliminar(usuario);
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
    
    public static Usuario usurAct(int id){
        Usuario actualizable = null;
        List <Usuario> lista = usuarios();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id){
                actualizable = lista.get(i);
            }
        }
            
        return actualizable;
    }
       
}
