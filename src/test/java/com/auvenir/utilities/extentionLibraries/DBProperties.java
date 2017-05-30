package com.auvenir.utilities.extentionLibraries;

import com.auvenir.utilities.GenericService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by huy.huynh on 29/05/2017.
 */
public class DBProperties {
    private Properties properties = null;

    private DBProperties() {
        try {
            if (properties == null) {
                FileInputStream fis = new FileInputStream(GenericService.MONGODBPROPERTIESFILE);
                properties = new Properties();
                properties.load(fis);
            }
        } catch (Exception ex) {
            NXGReports.addStep("Can't find/load DBProperties file", LogAs.FAILED, null);
            ex.printStackTrace();
        }
    }

    private static String getProperty(String propertyName) {
        DBProperties dbProperties = new DBProperties();

        if ((dbProperties.properties.getProperty(propertyName) == null) || (dbProperties.properties.getProperty(propertyName).isEmpty())) {
            NXGReports.addStep("Property not exist or empty", LogAs.FAILED, null);
            return null;
        }

        return dbProperties.properties.getProperty(propertyName);
    }

    public static String getServer() {
        return getProperty("server");
    }

    public static int getPort() {
        int port = 0;
        try {
            port = Integer.parseInt(getProperty("port"));
        } catch (Exception ex) {
            NXGReports.addStep("Can't parse port property as Integer", LogAs.FAILED, null);
            ex.printStackTrace();
        }
        return port;
    }

    public static String getDBname() {
        return getProperty("dbName");
    }

    public static String getUserName() {
        return getProperty("username");
    }

    public static String getPassword() {
        return getProperty("password");
    }

    public static String getSSL() {
        return getProperty("ssl");
    }

    public static String getSheetForInitMongoDB() {
        return getProperty("sheetForInitMongoDB");
    }

    public static String getUsersCollection() {
        return getProperty("usersCollection");
    }

    public static String getFirmsCollection() {
        return getProperty("firmsCollection");
    }

    public static String getBusinessesCollection() {
        return getProperty("businessesCollection");
    }

    public static String getEngagementsCollection() {
        return getProperty("engagementsCollection");
    }

    public static String getToDoJsonKey() {
        return getProperty("todoJsonKey");
    }

    public static String getNameToDoJsonKey() {
        return getProperty("todoNameJsonKey");
    }
}
