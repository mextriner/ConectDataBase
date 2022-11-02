/*
 * Conjunto de operacions que voy a realizar sobre una persona
 */
package Dominio;

import static AccesoDatos.Conexion.close;
import Dominio.Persona;
import static AccesoDatos.Conexion.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public class PersonaDao {
    
    private static final String SQL_SELECT ="SELECT * FROM TPersona";
    private static final String SQL_INSERT = "INSERT INTO TPersona (personaNmae, personaApellidos,"
            + "personaEmail,personaTelefono) VALUES (?,?,?,?)";
//    private static final String SQL_UPDATE_ID = "UPDATE TPersona SET ? = ? "
//            + "where personaId = ?";
//    private static final String SQL_UPDATE = "UPDATE TPersona SET ? = ? "
//            + "where ? = ?";
    private static final String SQL_UPDATE = "UPDATE TPersona SET "
            + "personaNmae = ?, "
            + "personaApellidos = ?,"
            + "personaEmail = ?,"
            + "personaTelefono = ?"
            + "WHERE personaId = ?";
    
    private static final String SQL_DELETE = "DELETE FROM TPersona WHERE PersonaId = ?";
    
//    Método que nos lista todas las personas de nuestro sistema
    public List<Persona> seleccionar() throws SQLException {
        //INICIALIZAR VARIABLES
        
        Connection conn = null;
        PreparedStatement stmt= null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
        
        conn = getConnection();
        stmt = conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        
        while(rs.next()){
            int idPersona = rs.getInt("PersonaId");
            String nombre = rs.getString("personaNmae");
            String apellido = rs.getString("personaApellidos");
            String email = rs.getString("personaEmail");
            String tel = rs.getString("personaTelefono");
            
            //Instancio un nuevo objeto
            personas.add(new Persona(idPersona, nombre,apellido,email,tel));
            
        }
        
        
        close(rs);
        close(stmt);
        close(conn);
        
        return personas;
    }
    
    //MÉTODO QUE INSERTA UNA PERSONA EN EL SISTEMA
    public int insertar (Persona persona){
        Connection conn =null;
        PreparedStatement stmt=null;
        int registro = 0;
        
        try{
             //1. ESTABLECER CONEXIÓN
        
            conn = getConnection();
            
            //2. PREPARO LA INSTRUCCIÓN EJECUTABLE EN MYSQL
            
            stmt = conn.prepareStatement(SQL_INSERT);
            
            
            //3. ASIGNAR LOS VALORES A LOS INTERROGANTES DE LA CONSULTA
            
            stmt.setString(1, persona.getPersonaName());
            stmt.setString(2,  persona.getPersonaApellido());
            stmt.setString(3,  persona.getPersonaEmail());
            stmt.setString(4,  persona.getPersonaTelefono());
            
            
            //4. EJECUTO LA QUERY
            
            registro = stmt.executeUpdate();
            
            
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            try{
                close(stmt);
                close(conn);
            }catch(SQLException ex){
                ex.printStackTrace(System.out);
            
            }
            
        }
        return registro;
    }
    
    public int actualizar (Persona persona){
        Connection conn =null;
        PreparedStatement stmt=null;
        int registro = 0;
        
        try{
             //1. ESTABLECER CONEXIÓN
        
            conn = getConnection();
            
            //2. PREPARO LA INSTRUCCIÓN EJECUTABLE EN MYSQL
            
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            
            //3. ASIGNAR LOS VALORES A LOS INTERROGANTES DE LA CONSULTA
            
            stmt.setString(1, persona.getPersonaName());
            stmt.setString(2, persona.getPersonaApellido());
            stmt.setString(3, persona.getPersonaEmail());
            stmt.setString(4, persona.getPersonaTelefono());
            stmt.setInt(5, persona.getPersonaID());
            
            
            //4. EJECUTO LA QUERY
            
            registro = stmt.executeUpdate();
            
            
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            try{
                close(stmt);
                close(conn);
            }catch(SQLException ex){
                ex.printStackTrace(System.out);
            
            }
            
        }
        return registro;
    }
    
    public int eliminar (Persona persona){
        Connection conn =null;
        PreparedStatement stmt=null;
        int registro = 0;
        
        try{
             //1. ESTABLECER CONEXIÓN
        
            conn = getConnection();
            
            //2. PREPARO LA INSTRUCCIÓN EJECUTABLE EN MYSQL
            
            stmt = conn.prepareStatement(SQL_UPDATE);
            
            
            //3. ASIGNAR LOS VALORES A LOS INTERROGANTES DE LA CONSULTA
            
            stmt.setInt(1, persona.getPersonaID());
            
            
            //4. EJECUTO LA QUERY
            
            registro = stmt.executeUpdate();
            
            
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }finally{
            try{
                close(stmt);
                close(conn);
            }catch(SQLException ex){
                ex.printStackTrace(System.out);
            
            }
            
        }
        return registro;
    }
    
    

}
