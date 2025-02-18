/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej2;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;

public class Mongod {

    
    public void crear(Armario a) {
        MongoDatabase db = Conecion.getConexion();  
        MongoCollection<Document> collection = db.getCollection("armarios");  
        
       
        Document doc = new Document("codigo", a.getCodigo())
            .append("material", a.getMaterial().toString());
        
        
        collection.insertOne(doc);
    }

    
    public Armario obtenerArmarioPorCodigo(String codigo) {
        MongoDatabase db = Conecion.getConexion();  
        MongoCollection<Document> collection = db.getCollection("armarios");  
        
        
        Document doc = collection.find(new Document("codigo", codigo)).first();
        
        if (doc != null) {
          
            String materialString = doc.getString("material");
            Material material = Material.valueOf(materialString.toUpperCase());
            return new Armario(codigo, material);  
        }
        return null;  
    }

    
    public void actualizar(Armario a) {
        MongoDatabase db = Conecion.getConexion();  
        MongoCollection<Document> collection = db.getCollection("armarios");  
        
        
        Document doc = new Document("codigo", a.getCodigo())
            .append("material", a.getMaterial().toString());
        
        
        collection.replaceOne(new Document("codigo", a.getCodigo()), doc);
    }

    
    public List<Armario> obtenerTodosArmarios() {
        MongoDatabase db = Conecion.getConexion();  
        MongoCollection<Document> collection = db.getCollection("armarios");  
        
        List<Armario> armarios = new ArrayList<>();  
        for (Document doc : collection.find()) {
            String codigo = doc.getString("codigo");
            String materialString = doc.getString("material");
            Material material = Material.valueOf(materialString.toUpperCase());
            Armario armario = new Armario(codigo, material);
            armarios.add(armario);  
        }
        
        return armarios;  
    }
}
