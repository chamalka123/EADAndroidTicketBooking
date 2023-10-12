package com.example.transportead;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
public class MongoDBUtil {


    private static final String DATABASE_NAME = "TrainBookingDB";
    private static final String CONNECTION_STRING = "mongodb+srv://admin:admin123@clusteread.t3p549y.mongodb.net/?retryWrites=true&w=majority";

    public static MongoClient createMongoClient() {
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(CONNECTION_STRING))
                .build();

        return MongoClients.create(settings);
    }

    public static MongoDatabase getDatabase() {
        MongoClient mongoClient = createMongoClient();
        return mongoClient.getDatabase(DATABASE_NAME);
    }

}
