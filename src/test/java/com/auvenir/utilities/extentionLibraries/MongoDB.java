package com.auvenir.utilities.extentionLibraries;

import com.mongodb.*;
import com.mongodb.util.JSON;
import org.json.JSONArray;
import org.json.JSONObject;

import java.net.UnknownHostException;

/**
 * Created by huy.huynh on 15/05/2017.
 * a tempory mongodb library
 * move db config to properties file
 */
public class MongoDB {
    private String serverHost;
    private int portNo;

    public MongoDB(String serverHost, int portNo, String dB) {
        this.serverHost = serverHost;
        this.portNo = portNo;
    }

    public MongoClient connectDBServer() throws UnknownHostException {
        return new MongoClient(serverHost, portNo);
    }

    public DB getDatabase(String dbName) throws UnknownHostException {
        MongoClient mongoClient = connectDBServer();
        return mongoClient.getDB(dbName);
    }

    public DBCollection getCollection(String dbName, String collectionName) throws UnknownHostException {
        DB dB = getDatabase(dbName);
        return dB.getCollection(collectionName);
    }

    public DBObject getDBObject(String dbName, String collectionName, String field, String value) {
        DBObject object = null;
        try {
            DBCollection table = getCollection(dbName, collectionName);

            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put(field, value);

            DBCursor cursor = table.find(searchQuery);
            object = cursor.next();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static JSONObject getToDoObjectByName(DBObject dBbject, String name) {
        JSONObject output = new JSONObject(new JSON().serialize(dBbject));
        JSONArray jsonArray = output.getJSONArray("todos");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            if (object.get("name").toString().equals(name)) {
                return object;
            }
        }
        return null;
    }

    public static JSONObject getToDoObject(DBCollection dBCollection, String field, String value, String name) {
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put(field, value);
        DBCursor cursor = dBCollection.find(searchQuery);
        DBObject dBbject = cursor.next();

        JSONObject output = new JSONObject(new JSON().serialize(dBbject));
        JSONArray jsonArray = output.getJSONArray("todos");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            if (object.get("name").toString().equals(name)) {
                return object;
            }
        }
        return null;
    }

    /**
     * add more 18/05/2017
     */

    public static String getUserObjectByFirstNameLastName(DBCollection dBCollection, String value) {
        String[] assignee = value.split(" ");
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("firstName", assignee[0]);
        searchQuery.put("lastName", assignee[1]);
        DBCursor cursor = dBCollection.find(searchQuery);
        DBObject dBbject = cursor.next();

        return dBbject.get("_id").toString();
    }
}
