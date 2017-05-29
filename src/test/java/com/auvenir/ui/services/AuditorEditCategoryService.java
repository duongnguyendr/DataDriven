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

    public void navigateToEditAtCreateTodoPage() throws Exception {

        auditorEditCategoryPage.selectEditCategories();

    }

//    public void navigateToEditAtTodoListPage() throws Exception {
//
//        auditorEditCategoryPage.selectEditCategoriesAtTodoPage();
//    }

    public void returnToCreateNewTodoPage() {
        auditorEditCategoryPage.returnToCreateNewTodoPage();
    }

    public void verifyEditCategoriesTitle() {

        auditorEditCategoryPage.verifyEditCategoriesPopupTitle();
    }

    public void verifyEditCategoriesGuide() {

        auditorEditCategoryPage.verifyEditCategoriesPopupGuide();
    }

    public void hoverOnCategoryItem() {
        auditorEditCategoryPage.verifyHoverOnCategoryItem();
    }

    public void hoverOnCategoryItem_TodoListPage(){
        auditorEditCategoryPage.verifyHoverOnCategoryItem_TodoListPage();
    }


    public void verifyDefaultCancelButton() throws Exception {

        auditorEditCategoryPage.verifyCancelBtn();
    }


    public void verifyDefaultSaveButton() throws Exception {
        auditorEditCategoryPage.verifyDefaultSaveBtn();
    }

    public void editValidValue() throws Exception {
        auditorEditCategoryPage.editCategoryItem();

    }

    public void editValidValue_TodoListPage() throws Exception {
        auditorEditCategoryPage.editCategoryItem_TodoListPage();
    }

    public void editSameMultiValidItems() throws Exception {
        auditorEditCategoryPage.editSameMultiItems();

    }
    public void editSameMultiValidItems_TodoListPage() throws Exception {
        auditorEditCategoryPage.editSameMultiItems_TodoListPage();
    }


    public void editOnlyNumber() throws Exception {
        auditorEditCategoryPage.editOnlyNumber();


    }

    public void editOnlyNumber_TodoListPage() throws Exception {
        auditorEditCategoryPage.editOnlyNumber_TodoListPage();
    }

    public void editNullChars() throws Exception {
        auditorEditCategoryPage.editNullChar();

    }
    public void editNullChars_TodoListPage() throws Exception {
        auditorEditCategoryPage.editNullChar_TodoListPage();
    }

    public void editSpecialChars() throws Exception {
        auditorEditCategoryPage.editSpecialChars();


    }

    public void editSpecialChars_TodoListPage() throws Exception {
        auditorEditCategoryPage.editSpecialChars_TodoListPage();
    }


    public void remove1Item() throws Exception {
        auditorEditCategoryPage.remove1Item();


    }

    public void removeMultiItems() throws Exception {
        auditorEditCategoryPage.removeMultiItems();


    }
}








