/*
 * Conjunto de operacions que voy a realizar sobre una persona
 */
package Dominio;

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
            
        }
        
        //Instancio un nuevo objeto
        personas.add(new Persona());
        
        return personas;
    }
}
