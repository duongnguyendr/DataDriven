package com.auvenir.utilities;

import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.time.Month;

/**
 * Created by huy.huynh on 15/05/2017.
 * add more 18/05/2017
 */
public class DatePicker {
    private WebElement datePicker;
    private WebDriver driver;

    @FindBy(className = "ui-icon ui-icon-circle-triangle-w")
    private WebElement btnPrev;

    @FindBy(className = "ui-icon ui-icon-circle-triangle-e")
    private WebElement btnNext;

    public DatePicker(WebDriver driver, WebElement ele) {
        this.driver = driver;
        datePicker = ele;
    }

    public void clickPreviousButton() {
        btnPrev.click();
    }

    public void clickNextButton() {
        btnNext.click();
    }

    /**
     * choose given date of current month
     *
     * @param date name of To-Do to choose
     */
    public void pickADate(String date) {
        datePicker.findElement(By.xpath("//a[contains(text(),'" + date + "')][@href='#']")).click();
    }

    /**
     * choose given date as paramaters
     *
     * @param date  date of month
     * @param month month of year
     * @param year  year AD
     */
    public void pickADate(String date, String month, String year) throws Exception {
        if (!timeValidation(date, month, year)) {
            throw new Exception("Date input for DatePicker wrong!");
        }
        int monthDif = monthDif(year, month);
        if (monthDif(year, month) > 0) {
            for (int i = 0; i < Math.abs(monthDif); i++) {
                clickNextButton();
                Thread.sleep(500);
            }
        } else {
            for (int i = 0; i < Math.abs(monthDif); i++) {
                clickPreviousButton();
                Thread.sleep(500);
            }
        }
        pickADate(date);
    }

    /**
     * count months from now
     *
     * @param month month of year
     * @param year  year AD
     */
    private int monthDif(String year, String month) {
        DateTime now = new DateTime();
        int yearDif = Integer.valueOf(year) - now.getYear();
        int monthOfYearDif = Month.valueOf(month.toUpperCase()).getValue() - now.getMonthOfYear();

        return yearDif * 12 + monthOfYearDif;
    }

    /**
     * choose given name To-Do and cho an action for it
     *
     * @param date  date of month
     * @param month month of year
     * @param year  year AD
     */
    private boolean timeValidation(String date, String month, String year) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            simpleDateFormat.setLenient(false);
            simpleDateFormat.parse(date + "-" + month + "-" + year);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {

//        String data[][] = MongoDBService.readExcelSheetData("usersRegression");
//        String jsonUser = data[0][8];
//        String jsonFirm = data[0][9];
//        //JSONObject jsonObject= new JSONObject(json);
//        //System.out.println("jsonObject.get(\"_id\") = " + jsonObject.get("_id"));
//
//
//        try {
//            DBObject usersDBObject = (DBObject) JSON.parse(jsonUser);
//            MongoClient mongoClient = new MongoClient("34.205.90.145", 27017);
//            DB dB = mongoClient.getDB("auvenir");
//            DBCollection dbCollection = dB.getCollection("users");
//            usersDBObject.put("_id",new ObjectId(data[0][0]));
//
//            ISO8601DateFormat df = new ISO8601DateFormat();
//            usersDBObject.put("lastLogin", df.parse(data[0][5]));
//            usersDBObject.put("dateCreated", df.parse(data[0][6]));
//
//            BasicDBObject access = new BasicDBObject();
//            access.put("expires", df.parse(data[0][7]));
//            BasicDBObject auth = new BasicDBObject();
//            auth.put("id","DwaPhuT7HzBo-dc4D8v7QjP3G");
//            auth.put("access", access);
//            usersDBObject.put("auth", auth);
//
//            dbCollection.insert(usersDBObject);
//
//            DBObject firmDBObject = (DBObject) JSON.parse(data[0][9]);
//            MongoClient mongoClient2 = new MongoClient("34.205.90.145", 27017);
//            DB dB2 = mongoClient2.getDB("auvenir");
//            DBCollection dbCollection2 = dB2.getCollection("firms");
//            BasicDBObject obj = new BasicDBObject();
//            obj.put("id",new ObjectId(data[0][0]) );
//            obj.put("admin", true);
//            List<BasicDBObject> milestones = new ArrayList<>();
//            milestones.add(obj);
//            firmDBObject.put("acl",milestones);
//
//            dbCollection2.insert(firmDBObject);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
