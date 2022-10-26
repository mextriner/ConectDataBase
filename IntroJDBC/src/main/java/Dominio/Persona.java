/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alumno Mañana
 */
public class Persona implements Serializable{
    private int personaID;
    private String personaName;
    private String personaApellido;
    private String personaEmail;
    private String personaTelefono;

    public Persona() {
    }

    public Persona(int personaID, String personaName, String personaApellido, String personaEmail, String personaTelefono) {
        this.personaID = personaID;
        this.personaName = personaName;
        this.personaApellido = personaApellido;
        this.personaEmail = personaEmail;
        this.personaTelefono = personaTelefono;
    }

    public Persona(String personaName, String personaApellido, String personaEmail, String personaTelefono) {
        this.personaName = personaName;
        this.personaApellido = personaApellido;
        this.personaEmail = personaEmail;
        this.personaTelefono = personaTelefono;
    }

    public int getPersonaID() {
        return personaID;
    }

    public void setPersonaID(int personaID) {
        this.personaID = personaID;
    }

    public String getPersonaName() {
        return personaName;
    }

    public void setPersonaName(String personaName) {
        this.personaName = personaName;
    }

    public String getPersonaApellido() {
        return personaApellido;
    }

    public void setPersonaApellido(String personaApellido) {
        this.personaApellido = personaApellido;
    }

    public String getPersonaEmail() {
        return personaEmail;
    }

    public void setPersonaEmail(String personaEmail) {
        this.personaEmail = personaEmail;
    }

    public String getPersonaTelefono() {
        return personaTelefono;
    }

    public void setPersonaTelefono(String personaTelefono) {
        this.personaTelefono = personaTelefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "personaID=" + personaID + ", personaName=" + personaName + ", personaApellido=" + personaApellido + ", personaEmail=" + personaEmail + ", personaTelefono=" + personaTelefono + '}';
    }
    
    
   
    
}
