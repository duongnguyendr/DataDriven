package com.auvenir.utilities.extentionLibraries;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by huy.huynh on 15/05/2017.
 * add more 18/05/2017
 */
public class DatePicker {
    WebElement datePicker;
    WebDriver driver;

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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        try {
            simpleDateFormat.parse(date + "-" + month + "-" + year);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
//    public static void main(String[] args) {
//
//        System.out.println("yearDif*12+monthDif = " + timeValidation("10", "September", "1"));
//        System.out.println("yearDif*12+monthDif = " + timeValidation("10", "Octorbe", "2000"));
//        System.out.println("yearDif*12+monthDif = " + timeValidation("30", "July", "2017"));
//        System.out.println("yearDif*12+monthDif = " + timeValidation("32", "Octorber", "2017"));
//        System.out.println("yearDif*12+monthDif = " + timeValidation("-1", "a", ""));
//    }
}
