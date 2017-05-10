package com.auvenir.ui.pages.auditor;

import com.auvenir.ui.pages.common.AbstractPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.awt.windows.WEmbeddedFrame;

/**
 * Created by vien.pham on 5/10/2017.
 */
public class AuditorCategoryPage extends AbstractPage {


    public AuditorCategoryPage(Logger logger, WebDriver driver) throws InterruptedException {
        super(logger, driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "category-dropdown")
    WebElement eleCategoryMenu;

    @FindBy(xpath = "//*[@id=\"category-dropdown-menu\"]/div[2]")
    WebElement eleEditCategory;

    @FindBy(xpath = "//*[@id=\"m-ce-systemContainer\"]/h3/text()")
    WebElement eleCategoryTitle;

    @FindBy(xpath = "//*[@id=\"edit-category-container\"]/div[1]")
    WebElement eleCategoryGuide;

    @FindBy(id = "cat-edit-btn")
    WebElement eleCategoryPen;

    @FindBy(id = "cat-trash-btn")
    WebElement eleCategoryTrash;

    @FindBy (id = "m-ce-cancelBtn")
    WebElement eleCategoryCancelBtn;

    @FindBy(id = "category-updateBtn")
    WebElement eleCategorySaveBtn;


    public void navigateToCategoryMenu() throws Exception{
        waitForClickableOfElement(eleCategoryMenu);
        eleCategoryMenu.click();
    }

    public void navigateToEditCategory()
    {
        waitForVisibleElement(eleEditCategory);
        eleEditCategory.click();
    }



}
