package services;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.io.Closeable;
import java.io.IOException;
import java.util.Map;

public class LogService implements Closeable {
    private final MongoClient client;
    private final MongoCollection<Document> logcollection;

    public LogService() {
        client = MongoClients.create();
        var database = client.getDatabase("somedb");
        logcollection = database.getCollection("Logs");
    }

    public void add(Map<String, Object> data) {
        logcollection.insertOne(new Document(data));
    }

    @Override
    public void close() throws IOException {
        client.close();
    }
}
