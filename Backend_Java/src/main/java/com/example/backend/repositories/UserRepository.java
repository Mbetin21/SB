/**
 * This file handles loading and retrieving user data from the `usuarios.json` file.
 * It provides methods to fetch all users and parse their details.
 * 
 * Author: Mariam Betin <mbetine@udistrital.edu.co>
 */
package com.example.backend.repositories;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.backend.data_objects.UserData;

/**
 * Repository class responsible for loading user data from `usuarios.json`.
 */
public class UserRepository {
    private static final String USERS_FILE = "data/usuarios.json";

    /**
     * Retrieves all users from JSON.
     * @return List of UserData objects.
     */
    public List<UserData> getAllUsers() {
        JSONArray jsonArray = loadUsers();
        List<UserData> users = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            UserData user = new UserData();
            user.id = obj.getInt("id");
            user.nombre = obj.getString("nombre");
            user.correo = obj.getString("correo");
            user.birthday = obj.getString("birthday");
            user.idioma_habla = obj.getString("idioma_habla");
            user.idioma_aprender = obj.getString("idioma_aprender");
            user.nivel_escritura = obj.getInt("nivel_escritura");
            user.nivel_lectura = obj.getInt("nivel_lectura");
            user.nivel_habla = obj.getInt("nivel_habla");
            user.nivel_comprension = obj.getInt("nivel_comprension");
            user.intereses = obj.getJSONArray("intereses").toList().toArray(new String[0]);
            users.add(user);
        }
        return users;
    }

    private JSONArray loadUsers() {
        try (FileReader reader = new FileReader(USERS_FILE)) {
            StringBuilder jsonContent = new StringBuilder();
            int ch;
            while ((ch = reader.read()) != -1) {
                jsonContent.append((char) ch);
            }
            return new JSONArray(jsonContent.toString());
        } catch (IOException e) {
            return new JSONArray();
        }
    }
}
