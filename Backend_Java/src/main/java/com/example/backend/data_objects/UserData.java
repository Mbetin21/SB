/**
 * This file defines the structure of a user in the system.
 * It contains attributes related to a user's personal information,
 * language preferences, skill levels, and interests.
 * 
 * Author: Mariam Betin <mbetine@udistrital.edu.co>
 */
package com.example.backend.data_objects;

/**
 * Represents a user in the system.
 */
public class UserData {
    public int id;
    public String nombre;
    public String correo;
    public String birthday;
    public String idioma_habla;
    public String idioma_aprender;
    public int nivel_escritura;
    public int nivel_lectura;
    public int nivel_habla;
    public int nivel_comprension;
    public String[] intereses;

    /**
     * Generates a description for the user based on their languages and interests.
     * @return A formatted string describing the user.
     */
    public String getDescripcion() {
        return "Speaks " + idioma_habla + ", learning " + idioma_aprender +
                ". Interests: " + String.join(", ", intereses);
    }
}
