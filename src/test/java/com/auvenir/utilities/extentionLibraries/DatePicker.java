package com.auvenir.utilities.extentionLibraries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by huy.huynh on 15/05/2017.
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

    public void pickADate(String date) {
        datePicker.findElement(By.xpath("//a[contains(text(),'" + date + "')][@href='#']")).click();
    }
}
