package com.auvenir.utilities.initialize;

import com.auvenir.utilities.MongoDBService;
import com.auvenir.utilities.extentionLibraries.DBProperties;
import com.auvenir.utilities.extentionLibraries.Excel;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.mongodb.*;
import com.mongodb.util.JSON;
import org.bson.types.ObjectId;
import org.testng.annotations.Test;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by huy.huynh on 24/05/2017.
 * Run one time before Regression Testing with config on properties file ./resources/properties/MongoDB.properties
 * Execute this main() to run
 */
public class InitData {

    private static String server;
    private static int port;
    private static String dbName;
    private static String username;
    private static String password;
    private static String ssl;
    //private Properties properties = GeneralUtilities.getMongoDBProperties();

    public void initData() {
        server = DBProperties.getServer();
        port = DBProperties.getPort();
        dbName = DBProperties.getDBname();
        username = DBProperties.getUserName();
        password = DBProperties.getPassword();
        ssl = DBProperties.getSSL();
    }

    /**
     * create some users for init regresstion test with multiple roles
     */
    @Test(priority = 1, enabled = true, description = "Initialize data before testing.")
    public void initUserAndMapping() throws UnknownHostException {
        try {
            initData();
            String[][] data = Excel.readExcelSheetData(DBProperties.getSheetForInitMongoDB());

//            MongoClient mongoClient = new MongoClient("34.205.90.145", 27017);
//            DB db = mongoClient.getDB("huytest");
            System.out.println("server = " + server);
            System.out.println("++++++++++++++++++++");
            MongoClient MongoClient = MongoDBService.connectDBServer(server, port, dbName, username, password, ssl);
            System.out.println("MongoClient = " + MongoClient);
            DB db = MongoClient.getDB(dbName);

            DBCollection usersCollection = db.getCollection(DBProperties.getUsersCollection());
            DBCollection firmsCollection = db.getCollection(DBProperties.getFirmsCollection());
            DBCollection businessesCollection = db.getCollection(DBProperties.getBusinessesCollection());

            //code to drop all records of collections on DB
            dropAllCollections(db);

            for (int i = 0; i < data.length; i++) {
                DBObject usersDBObject = (DBObject) JSON.parse(data[i][9]);
                DBObject mappingDBObject = (DBObject) JSON.parse(data[i][10]);

                usersDBObject.put("_id", new ObjectId(data[i][4]));

                ISO8601DateFormat df = new ISO8601DateFormat();
                usersDBObject.put("lastLogin", df.parse(data[i][5]));
                usersDBObject.put("dateCreated", df.parse(data[i][6]));

                BasicDBObject access = new BasicDBObject();
                access.put("expires", df.parse(data[i][8]));
                BasicDBObject auth = new BasicDBObject();
                auth.put("id", data[i][7]);
                auth.put("access", access);
                usersDBObject.put("auth", auth);
                usersCollection.insert(usersDBObject);

                BasicDBObject userInMapping = new BasicDBObject();
                userInMapping.put("id", new ObjectId(data[i][4]));
                userInMapping.put("admin", true);
                List<BasicDBObject> usersInMapping = new ArrayList<>();
                usersInMapping.add(userInMapping);
                mappingDBObject.put("acl", usersInMapping);

                if (data[i][1].toString().equals("AUDITOR")) {
                    firmsCollection.insert(mappingDBObject);
                } else if (data[i][1].toString().equals("CLIENT")) {
                    businessesCollection.insert(mappingDBObject);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dropAllCollections(DB db) {
        Set<String> collectionsName = db.getCollectionNames();
        collectionsName.remove("system.indexes");

        for (String s : collectionsName) {
            //System.out.println("+++++++++++++++++db.getCollectionNames: " + s);
            DBCollection collection = db.getCollection(s);
            collection.drop();
        }
    }

//    public static void main(String[] args) throws UnknownHostException {
//        InitData initMongoDB = new InitData();
//        initMongoDB.initUserAndMapping();
//    }
}
