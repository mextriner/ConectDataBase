/*
 * Programa de testeo conexión base de datos MySql
 */
package com.ceep.introjdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alumno Mañana
 */
public class TestMySql {
    public static void main(String[] args) {
        //Definimos la url de conexiójn a nuestra base de datos y sus parámetros
        String url = "jdbc:mysql://localhost:3306/primer_test?useSSL=false"
                +"&useTimezone=true&serverTimezone=UTC"
                +"&allowPublicKeyRetrieval=true&";
        //Ahora tratamos de establecer la conexión con nuestra base de datos
        try{
            Connection conexion = DriverManager.getConnection(url,"root","1234");
            Statement instruccion = conexion.createStatement();
            String sql = "SELECT * FROM TPersona";
            ResultSet resultado = instruccion.executeQuery(sql);
            while(resultado.next()){
                System.out.println("IdPersona:"+resultado.getInt("PersonaId"));
                System.out.println("Nombre: "+resultado.getString("personaNmae"));
                System.out.println("Apellidos: "+resultado.getString("personaApellidos"));
                System.out.println("Email: "+resultado.getString("personaEmail"));
                System.out.println("Correo: "+resultado.getString("personaTelefono"));
            }
            resultado.close();
            instruccion.close();
            
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
        
    }
}
