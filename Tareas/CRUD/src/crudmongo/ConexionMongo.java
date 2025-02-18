package crudmongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class ConexionMongo {
    private static final String URI = "mongodb://localhost:27017";
    private static final String DATABASE = "crud_personas";
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