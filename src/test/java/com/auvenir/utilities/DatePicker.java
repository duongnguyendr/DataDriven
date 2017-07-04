package com.auvenir.utilities;

import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.List;

/**
 * Created by huy.huynh on 15/05/2017.
 * add more 18/05/2017
 */
public class DatePicker {
    private WebElement datePicker;
    private WebDriver driver;

    @FindBy(className = "ui-icon-circle-triangle-w")
    private WebElement btnPrev;

    @FindBy(className = "ui-icon-circle-triangle-e")
    private WebElement btnNext;

    @FindBy(id = "ui-datepicker-div")
    private WebElement defaultDatePickerElement;

    @FindBy(xpath = "//div[@id='ui-datepicker-div']//td[@data-handler]/a")
    private List<WebElement> listValidDates;

    @FindBy(xpath = "//*[contains(@class,'ui-state-default')]")
    private List<WebElement> listDates;

    @FindBy(className = "ui-datepicker-title")
    private WebElement titleMonthYear;


    String enableDateOnDatePicker = "//a[contains(text(),'%s')][@href='#']";
    String parentDate = "//*[text()='%s']/ancestor::td";

    public DatePicker(WebDriver driver, WebElement ele) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        datePicker = ele;
    }

    public DatePicker(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.datePicker = defaultDatePickerElement;
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
        datePicker.findElement(By.xpath(String.format(enableDateOnDatePicker, date))).click();
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

    public WebElement getAEnableDate(String date) {
        return datePicker.findElement(By.xpath(String.format(enableDateOnDatePicker, date)));
    }

    public WebElement getADateParent(String date) {
        return datePicker.findElement(By.xpath(String.format(parentDate, date)));
    }

    public List<WebElement> getListValidDates() {
        return listValidDates;
    }

    public int getDates() {
        return listDates.size();
    }

    public WebElement getFirstValidDate() {
        return listValidDates.get(0);
    }

    public WebElement getSecondValidDate() {
        return listValidDates.get(1);
    }

    public void selectFirstValidDate() throws Exception {
        listValidDates.get(0).click();
    }

    public void selectSecondValidDate() throws Exception {
        listValidDates.get(1).click();
    }

    public WebElement getValidDateHasIndex(int idx) throws Exception {
        return listValidDates.get(idx);
    }

    public String getMonthYearTitle() {
        return titleMonthYear.getText();
    }

//    public boolean isMouseHovering(WebElement webElement){
//
//    }

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


}
