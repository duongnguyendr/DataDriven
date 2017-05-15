package com.auvenir.utilities.extentionLibraries;

import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * Created by huy.huynh on 15/05/2017.
 * a tempory mongodb library
 */
public class MongoDB {
    private String serverHost;
    private int portNo;
    private String dBName;
    MongoClient mongoClient;
    DB dB;
    DBCollection table;

    public MongoDB(String serverHost, int portNo, String dB) {
        this.serverHost = serverHost;
        this.portNo = portNo;
        this.dBName = dB;
    }

    public void connectDBServer() throws UnknownHostException {
        mongoClient = new MongoClient(serverHost, portNo);
    }

    public void getDatabase(String dbName) {
        dB = mongoClient.getDB(dbName);
    }

    public void getCollection(String collectionName) {
        table = dB.getCollection(collectionName);
    }

    public DBObject getObject(String dbName, String collectionName, String field, String value) {
        DBObject object = null;
        try {
            MongoClient mongoClient = new MongoClient(serverHost, portNo);
            DB dB = mongoClient.getDB(dbName);
            DBCollection table = dB.getCollection(collectionName);

            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put(field, value);

            DBCursor cursor = table.find(searchQuery);
            object = cursor.next();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return object;
    }

}
