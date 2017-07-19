package com.auvenir.utilities.initialize;

import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.MongoDBService;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.mongodb.*;
import com.mongodb.util.JSON;
import org.bson.types.ObjectId;
import org.testng.annotations.Test;

import java.net.UnknownHostException;
import java.util.Set;

/**
 * Created by huy.huynh on 24/05/2017.
 * Updated by Doai. Tran on 18/07/2017
 * Run one time before Regression Testing with config on properties file ./resources/properties/MongoDB.properties
 * Execute this main() to run
 */
public class InitData extends AbstractTest {

    /**
     * create some users for init regresstion test with multiple roles
     */
    @Test(priority = 1, enabled = true, description = "Initialize data before testing.")
    public void initUserAndMapping() throws UnknownHostException {
        try {

            MongoClient MongoClient = MongoDBService.connectDBServer(dataBaseServer, port, dataBase, userName, password, ssl);
            //DB db = MongoClient.getDB(dataBase);
            com.mongodb.DB db = MongoClient.getDB(dataBase);
            DBCollection usersCollection = db.getCollection("users");

            //code to drop all records of collections on DB. TODO: be careful
            dropAllCollections(db);

            DBObject adminDBObject = (DBObject) JSON.parse(getDataColumn("User Json"));
            adminDBObject.put("_id", new ObjectId(getDataColumn("ID")));
            ISO8601DateFormat df = new ISO8601DateFormat();
            /*adminDBObject.put("lastLogin", df.parse(getDataColumn("Last Login")));
            adminDBObject.put("dateCreated", df.parse(getDataColumn("Date Created")));

            BasicDBObject access = new BasicDBObject();
            access.put("expires", df.parse(getDataColumn("Expires")));
            BasicDBObject auth = new BasicDBObject();
            auth.put("id", getDataColumn("Auth Id"));
            auth.put("access", access);
            adminDBObject.put("auth", auth);
            usersCollection.insert(adminDBObject);*/
            adminDBObject.put("lastLogin", getDataColumn("Last Login"));
            adminDBObject.put("dateCreated", getDataColumn("Date Created"));
            BasicDBObject access = new BasicDBObject();
            access.put("expires",getDataColumn("Expires"));
            BasicDBObject auth = new BasicDBObject();
            auth.put("id", getDataColumn("Auth Id"));
            auth.put("access", access);
            adminDBObject.put("auth", auth);
            adminDBObject.put("password",getDataColumn("Password"));
            adminDBObject.put("password_salt",getDataColumn("PasswordSalt"));
            usersCollection.insert(adminDBObject);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*@Test(priority = 2, enabled = false, description = "Initialize data before testing.",dataProvider = "initUserAndMapping")
    public void initUserAndMappingRRRR(String userJsonStr,String iDStr,String lastLoginStr,
            String dateCreatedStr,String expiresStr,String AuthIDsStr) throws UnknownHostException {
        try {

            MongoClient MongoClient = MongoDBService.connectDBServer(dataBaseServer, port, dataBase, userName, password, ssl);
            DB db = MongoClient.getDB(dataBase);
            DBCollection usersCollection = db.getCollection("users");

            //code to drop all records of collections on DB. TODO: be careful
            dropAllCollections(db);

            DBObject adminDBObject = (DBObject) JSON.parse(userJsonStr);
            adminDBObject.put("_id", new ObjectId(iDStr));
            ISO8601DateFormat df = new ISO8601DateFormat();
            adminDBObject.put("lastLogin", lastLoginStr);
            adminDBObject.put("dateCreated", dateCreatedStr);

            BasicDBObject access = new BasicDBObject();
            access.put("expires",expiresStr);
            BasicDBObject auth = new BasicDBObject();
            auth.put("id", AuthIDsStr);
            auth.put("access", access);
            adminDBObject.put("auth", auth);
            usersCollection.insert(adminDBObject);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    private void dropAllCollections(DB db) {
        Set<String> collectionsName = db.getCollectionNames();
        collectionsName.remove("system.indexes");

        for (String s : collectionsName) {
            //System.out.println("+++++++++++++++++db.getCollectionNames: " + s);
            DBCollection collection = db.getCollection(s);
            collection.drop();
        }
    }


    private String getDataColumn(String columnName) {
        return GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User1", columnName);
    }

    private static String userJsonStr = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User1", "User Json");
    private static String iDStr = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User1", "ID");
    private static String lastLoginStr= GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User1", "Last Login");
    private static String dateCreatedStr = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User1", "Date Created");
    private static String expiresStr = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User1", "Expires");
    private static String AuthIDsStr = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User1", "Auth Id");

    /*private static String userJsonStr2 = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User2", "User Json");
    private static String iDStr2 = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User2", "ID");
    private static String lastLoginStr2= GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User2", "Last Login");
    private static String dateCreatedStr2 = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User2", "Date Created");
    private static String expiresStr2 = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User2", "Expires");
    private static String AuthIDsStr2 = GenericService.getTestDataFromExcelNoBrowserPrefix("usersRegression", "User2", "Auth Id");

    @DataProvider(name ="initUserAndMapping")
    public static Object[][] getInitUserAndMapping() {
        Object[][] arrayData = new Object[][]{{userJsonStr,iDStr,lastLoginStr,dateCreatedStr,expiresStr,AuthIDsStr},{userJsonStr2,iDStr2,
                lastLoginStr2,dateCreatedStr2,expiresStr2,AuthIDsStr2}};
        arrayData = new Object[][]{{userJsonStr,iDStr,lastLoginStr,dateCreatedStr,expiresStr,AuthIDsStr},{userJsonStr2,iDStr2,
                lastLoginStr2,dateCreatedStr2,expiresStr2,AuthIDsStr2}};
        return arrayData;
    }
*/

    //    public void initUserAndMappingManual() throws UnknownHostException {
//        try {
//            String[][] data = GenericService.readExcelSheetData("usersRegression");
//
//            MongoClient mongoClient = new MongoClient("192.168.1.168", 27017);
//            DB db = mongoClient.getDB("auvenir");
//
//            DBCollection usersCollection = db.getCollection("users");
//            DBCollection firmsCollection = db.getCollection("firms");
//            DBCollection businessesCollection = db.getCollection("businesses");
//
//            //code to drop all records of collections on DB
//            //dropAllCollections(db);
//
//            for (int i = 0; i < data.length; i++) {
//                DBObject usersDBObject = (DBObject) JSON.parse(data[i][9]);
//                DBObject mappingDBObject = (DBObject) JSON.parse(data[i][10]);
//
//                usersDBObject.put("_id", new ObjectId(data[i][4]));
//
//                ISO8601DateFormat df = new ISO8601DateFormat();
//                usersDBObject.put("lastLogin", df.parse(data[i][5]));
//                usersDBObject.put("dateCreated", df.parse(data[i][6]));
//
//                BasicDBObject access = new BasicDBObject();
//                access.put("expires", df.parse(data[i][8]));
//                BasicDBObject auth = new BasicDBObject();
//                auth.put("id", data[i][7]);
//                auth.put("access", access);
//                usersDBObject.put("auth", auth);
//                usersCollection.insert(usersDBObject);
//
//                BasicDBObject userInMapping = new BasicDBObject();
//                userInMapping.put("id", new ObjectId(data[i][4]));
//                userInMapping.put("admin", true);
//                List<BasicDBObject> usersInMapping = new ArrayList<>();
//                usersInMapping.add(userInMapping);
//                mappingDBObject.put("acl", usersInMapping);
//
//                if (data[i][1].toString().equals("AUDITOR")) {
//                    firmsCollection.insert(mappingDBObject);
//                } else if (data[i][1].toString().equals("CLIENT")) {
//                    businessesCollection.insert(mappingDBObject);
//                } else {
//                    System.out.println("Admin created");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) throws UnknownHostException {
//        InitData initMongoDB = new InitData();
//        initMongoDB.initUserAndMapping();
//    }
}
