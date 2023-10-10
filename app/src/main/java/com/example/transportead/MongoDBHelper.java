package com.example.transportead;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBHelper {

    private static final String DATABASE_NAME = "TrainBookingDB";
    private static final String COLLECTION_NAME = "travelers";

    public static MongoCollection<Document> connectToMongoDB() {
        // Replace "your_server_ip" and "your_port" with your MongoDB server's IP address and port
        String connectionString = "mongodb+srv://admin:admin123@clusteread.t3p549y.mongodb.net/?retryWrites=true&w=majority";

        try {
            MongoClient mongoClient = MongoClients.create(connectionString);
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            return database.getCollection(COLLECTION_NAME);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
