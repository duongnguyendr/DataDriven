package com.auvenir.utilities;

import com.auvenir.rests.api.services.AbstractAPIService;
import com.mongodb.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.bson.types.ObjectId;
import java.io.FileInputStream;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.auvenir.utilities.GenericService.sDirPath;
import static com.mongodb.MongoClientOptions.builder;

/*===================================================================
 * Created by doai.tran on 4/24/2017.
 * Description:
 *
 *=================================================================== */
public class MongoDBService {
    private static String dataBaseSer;
    private static int port;
    private static String DB;
    private static String username;
    private static String ssl;
    private static String password;
    public static String sTestDataFile = sDirPath + "\\TestData.xlsx";
    private static String testCaseId;
    static String[] sData = null;

    public MongoDBService(){
        AbstractAPIService ab = new AbstractAPIService();

        MongoDBService.dataBaseSer = ab.getDataBaseSer();
        MongoDBService.port = ab.getPort();;
        MongoDBService.DB = ab.getDataBase();
        MongoDBService.username = ab.getUserName();
        MongoDBService.password = ab.getPassword();
        MongoDBService.ssl=ab.getSSL();

    }
    /* ===================================================================
    Created by: Doai.Tran    - 24-Apr-2017 -
    In order to create a connection to DB server.
    Improve: 5/18/2017
     =================================================================== */
    public static MongoClient connectDBServer(String ServerHost, int portNo, String DB, String username, String password, String SSL) throws UnknownHostException {
        try {
            if (SSL.equals("yes")) {
                char[] pwd = password.toCharArray();
                MongoCredential credential = MongoCredential.createCredential(username, DB, pwd); // user "myadmin" on admin database
                List<MongoCredential> credentials = Collections.singletonList(credential);
                ServerAddress hosts = new ServerAddress(ServerHost + ":" + portNo);
                MongoClientOptions.Builder options = builder().sslEnabled(true).sslInvalidHostNameAllowed(true);
                MongoClient mongoClient = new MongoClient(hosts, credentials, options.build());
                return mongoClient;
            } else if (SSL.equals("no") && username == null && password == null){
                System.out.println("bbbbbbb");
                MongoClient mongoClient = new MongoClient( ServerHost , portNo );
                System.out.println("AAAAAAA");
                return mongoClient;
            }
            System.out.println("Connected");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("unable to connect.");
        }
        return null;
    }
    /* ===================================================================
    Created by: Doai.Tran    - 24-Apr-2017 -
    In order to insert a new owner to DB server.
     =================================================================== */
    public static void insertOwner(String valueId) throws UnknownHostException {
        try {
            sData = toReadExcelData(valueId, "owners");

            new MongoDBService();
            MongoClient MongoClient = connectDBServer(dataBaseSer, port, DB,username,password,ssl);
            com.mongodb.DB db = MongoClient.getDB(DB);
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
            new MongoDBService();
            MongoClient MongoClient = connectDBServer(dataBaseSer, port, DB,username,password,ssl);
            com.mongodb.DB db = MongoClient.getDB(DB);
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
            new MongoDBService();
            MongoClient MongoClient = connectDBServer(dataBaseSer, port, DB,username,password,ssl);
            com.mongodb.DB db = MongoClient.getDB(DB);
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
            new MongoDBService();
            MongoClient MongoClient = connectDBServer(dataBaseSer, port, DB,username,password,ssl);
            com.mongodb.DB db = MongoClient.getDB(DB);
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
            new MongoDBService();
            MongoClient MongoClient = connectDBServer(dataBaseSer, port, DB,username,password,ssl);
            com.mongodb.DB db = MongoClient.getDB(DB);
            DBCollection table = db.getCollection("institutions");
            BasicDBObject document = new BasicDBObject();
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
            new MongoDBService();
            MongoClient MongoClient = connectDBServer(dataBaseSer, port, DB,username,password,ssl);
            com.mongodb.DB db = MongoClient.getDB(DB);
            DBCollection table = db.getCollection("institutions");
            BasicDBObject document = new BasicDBObject();
            document.put("finID", sData[4]);
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
            new MongoDBService();
            MongoClient MongoClient = connectDBServer(dataBaseSer, port, DB,username,password,ssl);
            com.mongodb.DB db = MongoClient.getDB(DB);
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
            new MongoDBService();
            MongoClient MongoClient = connectDBServer(dataBaseSer, port, DB,username,password,ssl);
            com.mongodb.DB db = MongoClient.getDB(DB);
            DBCollection table = db.getCollection("consumerAccounts");
            BasicDBObject document = new BasicDBObject();
            document.put("finAccountID", sData[7]);
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
            new MongoDBService();
            MongoClient MongoClient = connectDBServer(dataBaseSer, port, DB,username,password,ssl);
            com.mongodb.DB db = MongoClient.getDB(DB);
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
            new MongoDBService();
            MongoClient MongoClient = connectDBServer(dataBaseSer, port, DB,username,password,ssl);
            com.mongodb.DB db = MongoClient.getDB(DB);
            DBCollection table = db.getCollection("accounts");
            BasicDBObject document = new BasicDBObject();
            document.put("institutionID", sData[3]);
            table.remove(document);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /* ===================================================================
    Created by: DoaiTran    - 26-Apr-2017 -
    In order to insert a new AuthSession to DB server.
     =================================================================== */
    public static void insertAuthSession(String valueId) throws UnknownHostException {
        try {
            sData = toReadExcelData(valueId, "authSessions");
            new MongoDBService();
            MongoClient MongoClient = connectDBServer(dataBaseSer, port, DB,username,password,ssl);
            com.mongodb.DB db = MongoClient.getDB(DB);
            DBCollection table = db.getCollection("authSessions");
            BasicDBObject document = new BasicDBObject();
            document.put("_id", new ObjectId(sData[1]));
            document.put("ownerID", new ObjectId(sData[2]));
            document.put("consumerID", sData[3]);
            document.put("dateCreated", sData[4]);
            document.put("expires", sData[5]);
            document.put("state", sData[6]);
            document.put("previousState", sData[7]);
            document.put("socketID", sData[8]);
            document.put("provider", sData[9]);
            document.put("finCustomerID", sData[10]);
            document.put("finLoginID", sData[11]);
            document.put("uid", sData[12]);
            document.put("userID", sData[13]);
            document.put("callbackURL", sData[14]);
            document.put("ownerUID", sData[15]);
            document.put("consumerUID", sData[16]);
            // loginForm

            List<DBObject> arrayLoginForm = new ArrayList<DBObject>();
            BasicDBObject documentLoginForm = new BasicDBObject();
            documentLoginForm.put("dateCreated", sData[17]);
            documentLoginForm.put("formDetails", sData[18]);
            arrayLoginForm.add(documentLoginForm);
            document.put("loginForm", arrayLoginForm);

            // mfa
            List<DBObject> arrayMfa = new ArrayList<DBObject>();
            BasicDBObject documentMfa = new BasicDBObject();
            documentMfa.put("dateCreated", sData[19]);
            documentMfa.put("details", sData[20]);
            arrayMfa.add(documentMfa);
            document.put("mfa", arrayMfa);

            // institution

            List<DBObject> arrayInstitution = new ArrayList<DBObject>();
            BasicDBObject documentInstitution = new BasicDBObject();
            documentInstitution.put("dateCreated", sData[21]);
            documentInstitution.put("finID", sData[22]);
            documentInstitution.put("name", sData[23]);
            documentInstitution.put("authorized", sData[24]);
            documentInstitution.put("rawSource", sData[25]);
            arrayInstitution.add(documentInstitution);
            document.put("institution", arrayInstitution);

            document.put("accounts",sData[26]);
            table.insert(document);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /* ===================================================================
    Created by: Doai.Tran    - 26-Apr-2017 -
    In order to delete a AuthSession to DB server.
     =================================================================== */
    public static void deleteAuthSession(String valueId)throws UnknownHostException{
        try {
            sData = toReadExcelData(valueId, "authSessions");
            MongoClient MongoClient = connectDBServer(dataBaseSer, port, DB,username,password,ssl);
            com.mongodb.DB db = MongoClient.getDB(DB);
            DBCollection table = db.getCollection("authSessions");
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
            Workbook wb = WorkbookFactory.create(fis);
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
