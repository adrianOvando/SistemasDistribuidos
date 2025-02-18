package crudmongo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
    private final MongoCollection<Document> coleccion;
    private final MongoCollection<Document> counters;

    public PersonaDAO() {
        this.coleccion = ConexionMongo.getConexion().getCollection("personas");
        this.counters = ConexionMongo.getConexion().getCollection("counters");
    }

    
    private int obtenerNuevoId() {
        Document query = new Document("_id", "personaId");
        Document update = new Document("$inc", new Document("seq", 1));

        
        counters.updateOne(query, update, new UpdateOptions().upsert(true));

        
        Document result = counters.find(Filters.eq("_id", "personaId")).first();

       
        if (result == null || result.getInteger("seq") == null) {
            counters.insertOne(new Document("_id", "personaId").append("seq", 1));
            return 1; 
        }

       
        return result.getInteger("seq");
    }

   
    public void crear(Persona persona) {
        int nuevoId = obtenerNuevoId();
        persona.setId(nuevoId);

        Document doc = new Document("id", persona.getId())
                .append("nombre", persona.getNombre())
                .append("apellido", persona.getApellido())
                .append("edad", persona.getEdad());

        coleccion.insertOne(doc);
        System.out.println("Persona creada con éxito con ID: " + persona.getId());
    }

    
    public List<Persona> listar() {
        List<Persona> lista = new ArrayList<>();
        MongoCursor<Document> cursor = coleccion.find().iterator();
        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                Persona p = new Persona();
                p.setId(doc.getInteger("id"));
                p.setNombre(doc.getString("nombre"));
                p.setApellido(doc.getString("apellido"));
                p.setEdad(doc.getInteger("edad"));
                lista.add(p);
            }
        } finally {
            cursor.close();
        }
        return lista;
    }

   
    public void actualizar(int id, Persona persona) {
        Document doc = new Document("nombre", persona.getNombre())
                .append("apellido", persona.getApellido())
                .append("edad", persona.getEdad());
        coleccion.updateOne(Filters.eq("id", id), new Document("$set", doc));
        System.out.println("Persona actualizada con éxito");
    }

    
    public void eliminar(int id) {
        coleccion.deleteOne(Filters.eq("id", id));
        System.out.println("Persona eliminada con éxito");
    }
}