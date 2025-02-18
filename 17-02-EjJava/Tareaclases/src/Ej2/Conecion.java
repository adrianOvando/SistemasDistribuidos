/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej2;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
/**
 *
 * @author Adrian
 */
public class Conecion {
    private static final String URI = "mongodb://localhost:27017";
    private static final String DATABASE = "Biblioteca";
    private static MongoClient cliente;
    private static MongoDatabase db;

    public static MongoDatabase getConexion() {
        if (cliente == null) {
            cliente = MongoClients.create(URI);
            db = cliente.getDatabase(DATABASE);
        }
        return db;
    }
}
