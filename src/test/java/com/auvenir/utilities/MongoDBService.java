package com.auvenir.utilities;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.bson.types.ObjectId;

import java.io.FileInputStream;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.auvenir.utilities.GenericService.sDirPath;

/*===================================================================
 * Created by doai.tran on 4/24/2017.
 * Description:
 *
 *=================================================================== */
public class MongoDBService {
    private static String ServerHost;
    private static int portNo;
    private static String DB;
    public static String sTestDataFile = sDirPath + "\\TestData.xlsx";
    private static String testCaseId;
    static String[] sData = null;

    public MongoDBService(String ServerHost, int portNo, String DB){
        this.ServerHost = ServerHost;
        this.portNo = portNo;
        this.DB = DB;
    }
    /* ===================================================================
    Created by: Doai.Tran    - 24-Apr-2017 -
    In order to create a connection to DB server.

     =================================================================== */
    public static void connectDBServer(String ServerHost, int portNo, String DB) throws UnknownHostException {
        try{
            new MongoDBService(ServerHost,portNo,DB);
            MongoClient mongo = new MongoClient( ServerHost , portNo );
            com.mongodb.DB db = mongo.getDB(DB);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /* ===================================================================
    Created by: Doai.Tran    - 24-Apr-2017 -
    In order to insert a new owner to DB server.
     =================================================================== */
    public static void insertOwner(String valueId) throws UnknownHostException {
        try {
            sData = toReadExcelData(valueId, "owners");
            new MongoDBService(ServerHost, portNo, DB);
            MongoClient mongo = new MongoClient(ServerHost, portNo);
            com.mongodb.DB db = mongo.getDB(DB);
            DBCollection table = db.getCollection("owners");
            BasicDBObject document = new BasicDBObject("_id", new ObjectId(sData[1]));

            document.put("ownerUID", sData[2]);
            document.put("uid", sData[3]);
            document.put("status", sData[4]);
            document.put("dateCreated", sData[5]);

            List<DBObject> array = new ArrayList<DBObject>();
            BasicDBObject documentfin = new BasicDBObject();
            documentfin.put("consumerID", sData[6]);
            documentfin.put("institutionID", sData[7]);
            documentfin.put("status", sData[8]);
            array.add(documentfin);
            document.put("finCustomer", array);
            table.insert(document);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /* ===================================================================
    Created by: Doai.Tran    - 24-Apr-2017 -
    In order to delete a new owner to DB server.
     =================================================================== */
    public static void deleteOwner(String valueId)throws UnknownHostException{
        try {
            sData = toReadExcelData(valueId, "owners");
            new MongoDBService(ServerHost, portNo, DB);
            MongoClient mongo = new MongoClient(ServerHost, portNo);
            com.mongodb.DB db = mongo.getDB(DB);
            DBCollection table = db.getCollection("owners");
            BasicDBObject document = new BasicDBObject();
            document.put("ownerUID", sData[2]);
            table.remove(document);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /* ===================================================================
    Created by: DoaiTran    - 24-Apr-2017 -
    In order to insert a new Customer to DB server.
     =================================================================== */
    public static void insertConsumer(String valueId) throws UnknownHostException {
        try {
            sData = toReadExcelData(valueId, "consumers");
            new MongoDBService(ServerHost, portNo, DB);
            MongoClient mongo = new MongoClient(ServerHost, portNo);
            com.mongodb.DB db = mongo.getDB(DB);
            DBCollection table = db.getCollection("consumers");
            BasicDBObject document = new BasicDBObject("_id", new ObjectId(sData[1]));
            document.put("ownerID", new ObjectId(sData[2]));
            document.put("institutionID", new ObjectId(sData[3]));
            document.put("consumerUID", sData[4]);
            document.put("userID", sData[5]);
            document.put("callbackURL", sData[6]);
            document.put("status", sData[7]);
            document.put("integration", sData[8]);
            document.put("dateCreated", sData[9]);
            document.put("finLoginID", sData[10]);
            table.insert(document);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /* ===================================================================
    Created by: Doai.Tran    - 24-Apr-2017 -
    In order to delete a customer to DB server.
     =================================================================== */
    public static void deleteConsumer(String valueId)throws UnknownHostException{
        try {
            sData = toReadExcelData(valueId, "consumers");
            new MongoDBService(ServerHost, portNo, DB);
            MongoClient mongo = new MongoClient(ServerHost, portNo);
            com.mongodb.DB db = mongo.getDB(DB);
            DBCollection table = db.getCollection("consumers");
            BasicDBObject document = new BasicDBObject();
            document.put("consumerUID", sData[4]);
            table.remove(document);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /* ===================================================================
    Created by: DoaiTran    - 25-Apr-2017 -
    In order to insert a new institution to DB server.
     =================================================================== */
    public static void insertInstitution(String valueId) throws UnknownHostException {
        try {
            sData = toReadExcelData(valueId, "institutions");
            new MongoDBService(ServerHost, portNo, DB);
            MongoClient mongo = new MongoClient(ServerHost, portNo);
            com.mongodb.DB db = mongo.getDB(DB);
            DBCollection table = db.getCollection("institutions");
            BasicDBObject document = new BasicDBObject();
            //System.out.println(sData[1]);
            document.put("_id", new ObjectId(sData[1]));
            document.put("integration", sData[2]);
            document.put("dateCreated", sData[3]);
            document.put("finID", sData[4]);
            document.put("name", sData[5]);
            document.put("typeDescription", sData[6]);
            document.put("urlHomeApp", sData[7]);
            document.put("urlLogonApp", sData[8]);
            document.put("urlProductApp", sData[9]);
            document.put("phone", sData[10]);
            document.put("currency", sData[11]);
            document.put("email", sData[12]);
            document.put("specialText", sData[13]);
            document.put("address", sData[14]);
            document.put("raw", sData[15]);
            table.insert(document);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /* ===================================================================
    Created by: Doai.Tran    - 25-Apr-2017 -
    In order to delete a customer to DB server.
     =================================================================== */
    public static void deleteInstitution(String valueId)throws UnknownHostException{
        try {
            sData = toReadExcelData(valueId, "institutions");
            new MongoDBService(ServerHost, portNo, DB);
            MongoClient mongo = new MongoClient(ServerHost, portNo);
            com.mongodb.DB db = mongo.getDB(DB);
            DBCollection table = db.getCollection("institutions");
            BasicDBObject document = new BasicDBObject();
            document.put("_id", sData[1]);
            table.remove(document);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /* ===================================================================
    Created by: DoaiTran    - 25-Apr-2017 -
    In order to insert a new ConsumerAccount to DB server.
     =================================================================== */
    public static void insertConsumerAccount(String valueId) throws UnknownHostException {
        try {
            sData = toReadExcelData(valueId, "consumerAccounts");
            new MongoDBService(ServerHost, portNo, DB);
            MongoClient mongo = new MongoClient(ServerHost, portNo);
            com.mongodb.DB db = mongo.getDB(DB);
            DBCollection table = db.getCollection("consumerAccounts");
            BasicDBObject document = new BasicDBObject();

            document.put("_id", new ObjectId(sData[1]));
            document.put("consumerID", new ObjectId(sData[2]));
            document.put("status", sData[3]);
            document.put("dateCreated", sData[4]);
            document.put("selected", new Boolean(sData[5]) );
            document.put("dateSelected", sData[6]);
            document.put("finAccountID", sData[7]);
            document.put("number", sData[8]);
            document.put("name", sData[9]);
            document.put("type", sData[10]);
            document.put("loaded", new Boolean(sData[11]));
            document.put("dateLoaded", sData[12]);
            document.put("loadFailCode", sData[13]);
            document.put("txnFromDate", sData[14]);
            document.put("txnToDate", sData[15]);
            table.insert(document);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /* ===================================================================
    Created by: Doai.Tran    - 25-Apr-2017 -
    In order to delete a ConsumerAccount to DB server.
     =================================================================== */
    public static void deleteConsumerAccount(String valueId)throws UnknownHostException{
        try {
            sData = toReadExcelData(valueId, "consumerAccounts");
            new MongoDBService(ServerHost, portNo, DB);
            MongoClient mongo = new MongoClient(ServerHost, portNo);
            com.mongodb.DB db = mongo.getDB(DB);
            DBCollection table = db.getCollection("consumerAccounts");
            BasicDBObject document = new BasicDBObject();
            document.put("_id", sData[1]);
            table.remove(document);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /* ===================================================================
    Created by: DoaiTran    - 25-Apr-2017 -
    In order to insert a new Account to DB server.
     =================================================================== */
    public static void insertAccount(String valueId) throws UnknownHostException {
        try {
            sData = toReadExcelData(valueId, "accounts");
            new MongoDBService(ServerHost, portNo, DB);
            MongoClient mongo = new MongoClient(ServerHost, portNo);
            com.mongodb.DB db = mongo.getDB(DB);
            DBCollection table = db.getCollection("accounts");
            BasicDBObject document = new BasicDBObject();

            document.put("_id", new ObjectId(sData[1]));
            document.put("ownerID", new ObjectId(sData[2]));
            document.put("institutionID", sData[3]);
            document.put("integration", sData[4]);
            document.put("dateCreated", sData[5]);
            document.put("finID", sData[6]);
            document.put("finCustomerID", sData[7]);
            document.put("finInstitutionID", sData[8]);
            document.put("finLoginID", sData[9]);
            document.put("number", sData[10]);
            document.put("name", sData[11]);
            document.put("status", sData[12]);
            document.put("type", sData[13]);
            document.put("balance", sData[14]);
            document.put("balanceDate", sData[15]);
            document.put("currency", sData[16]);
            document.put("finDateCreated", sData[17]);
            document.put("lastTransactionDate", sData[18]);
            document.put("raw", sData[19]);
            table.insert(document);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /* ===================================================================
    Created by: Doai.Tran    - 25-Apr-2017 -
    In order to delete a Account to DB server.
     =================================================================== */
    public static void deleteAccount(String valueId)throws UnknownHostException{
        try {
            sData = toReadExcelData(valueId, "accounts");
            new MongoDBService(ServerHost, portNo, DB);
            MongoClient mongo = new MongoClient(ServerHost, portNo);
            com.mongodb.DB db = mongo.getDB(DB);
            DBCollection table = db.getCollection("accounts");
            BasicDBObject document = new BasicDBObject();
            document.put("_id", sData[1]);
            table.remove(document);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /* ===================================================================
	 * @author: LAKSHMI BS Description: To read tests data from excel sheet
	 * Edited by Doai.Tran
	 =================================================================== */
    public static String[] toReadExcelData(String sTestCaseID, String SheetName) {
        String sData[] = null;
        try {
            FileInputStream fis = new FileInputStream(sTestDataFile);
            Workbook wb = (Workbook) WorkbookFactory.create(fis);
            Sheet sht = wb.getSheet(SheetName);

            System.out.println(SheetName);
            int iRowNum = sht.getLastRowNum();
            int k = 0;
            for (int i = 1; i <= iRowNum; i++) {
                if (sht.getRow(i).getCell(0).toString().equals(sTestCaseID)) {
                    int iCellNum = sht.getRow(i).getLastCellNum();
                    sData = new String[iCellNum];
                    System.out.println("Dong: " + i);
                    System.out.println("So Cot:" + iCellNum);
                    for (int j = 1; j <=iCellNum; j++) {
                        sData[j] = sht.getRow(i).getCell(j).getStringCellValue();
                        System.out.println(sData[j]);
                    }
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sData;
    }
}
