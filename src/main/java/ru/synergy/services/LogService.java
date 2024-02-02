package ru.synergy.services;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import lombok.Getter;
import org.bson.Document;

import java.io.Closeable;
import java.util.Map;

public class LogService implements Closeable {
    private final MongoClient mongoClient;
    @Getter
    private final MongoCollection<Document> logCollection;

    public LogService() {
        mongoClient = MongoClients.create();
        var database = mongoClient.getDatabase("syn");
        logCollection = database.getCollection("logs");
    }

    public void add(Map<String, Object> data) {
        logCollection.insertOne(new Document(data));
    }

    @Override
    public void close() {
        mongoClient.close();
    }

}