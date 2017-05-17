package com.auvenir.ui.services;

import com.auvenir.ui.pages.auditor.AuditorEditCategoriesPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by vien.pham on 5/10/2017.
 */
public class AuditorEditCategoryService extends AbstractService {

    AuditorEditCategoriesPage auditorEditCategoryPage;

    /*
 * contructor
 */
    public AuditorEditCategoryService(Logger logger, WebDriver driver) {

        super(logger, driver);
        auditorEditCategoryPage = new AuditorEditCategoriesPage(getLogger(), getDriver());
    }

    public void navigateToEditCategoriesOption() throws Exception {

        auditorEditCategoryPage.selectEditCategories();

    }

    public void returnToCreateNewTodoPage(){
        auditorEditCategoryPage.returnToCreateNewTodoPage();
    }

    public void verifyEditCategoriesTitle() {
        auditorEditCategoryPage.verifyEditCategoriesPopupTitle();
    }

    public void verifyEditCategoriesGuide() {
        auditorEditCategoryPage.verifyEditCategoriesPopupGuide();
    }


    public void verifyDefaultCancelButton() throws Exception {

        auditorEditCategoryPage.verifyCancelBtn();
//        auditorEditCategoryPage.selectCancelBtn();
//        auditorEditCategoryPage.verifyReturnToCreateNewTodoPage();
    }


    public void verifyDefaultSaveButton() throws Exception {
        auditorEditCategoryPage.verifyDefaultSaveBtn();
    }

    public void editValidValue() throws Exception {
        auditorEditCategoryPage.editCategoryItem();
//        auditorEditCategoryPage.verifyDataSaved();
//        navigateToEditCategoriesOption();
    }

    public void editValidMultiItems() throws Exception {
        auditorEditCategoryPage.editValidMultiItems();
//        navigateToEditCategoriesOption();
    }

    public void editUnvalidMultiItems() throws Exception {
        auditorEditCategoryPage.editInValidMultiItems();
//        navigateToEditCategoriesOption();

    }

    public void editOnlyNumber() throws Exception {

        auditorEditCategoryPage.editOnlyNumber();
//        navigateToEditCategoriesOption();
    }

    public void editNullChars() throws Exception {
        auditorEditCategoryPage.editNullChar();
//        navigateToEditCategoriesOption();
    }

    public void editSpecialChars() throws Exception {
        auditorEditCategoryPage.editSpecialChars();

    }


}








