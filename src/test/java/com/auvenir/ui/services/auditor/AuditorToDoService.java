package com.auvenir.ui.services.auditor;

import com.auvenir.ui.pages.auditor.AuditorCreateToDoPage;
import com.auvenir.ui.pages.auditor.AuditorToDoPage;
import com.auvenir.ui.services.AbstractService;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by huy.huynh on 04/07/2017.
 */
public class AuditorToDoService extends AbstractService {

    AuditorToDoPage toDoPage;
    AuditorCreateToDoPage createToDoPage;

    public AuditorToDoService(Logger logger, WebDriver driver) {
        super(logger, driver);
        toDoPage = new AuditorToDoPage(getLogger(), getDriver());
        createToDoPage = new AuditorCreateToDoPage(getLogger(), getDriver());
    }

    /**
     * Add new by huy.huynh on 28/06/2017.
     * R2.1 NewFeature
     */
    public String getToDoDueDateOnRow(String todoName) {
        return toDoPage.getToDoDueDateOnRow(todoName);
    }

    public void openPopupTodoDetail(String todoName) {
        toDoPage.clickImageTodoDetails(todoName);
    }

    public void verifyDueDateMatching(String rowDueDate) {
        toDoPage.verifyDueDateMatching(rowDueDate);
    }

    public void changeDueDateOnTodoDetail(int validDateIndex) {
        toDoPage.changeDueDateOnTodoDetail(validDateIndex);
    }

    public void closePopupTodoDetail() {
        createToDoPage.closeAddNewRequestWindow();
    }

    public void changeDueDateOnTodoRow(String todoName, int validDateIndex) {
        toDoPage.changeDueDateOnTodoRow(todoName, validDateIndex);
    }

    public void verifyDatePickerShow() {
        toDoPage.verifyDatePickerShow();
    }

    public void verifyDatePickerDateFormat() {
        toDoPage.verifyDatePickerDateFormat();
    }

    public void verifyHoverOnField() {
        toDoPage.verifyHoverOnField();
    }

    public void verifyDueDateFocusing() {
        toDoPage.verifyDueDateFocusing();
    }

    public int getEngagementDueDate() {
        return toDoPage.getEngagementDueDate();
    }

    public void verifyDisableDateAfterDueDate(int dueDate) {
        toDoPage.verifyDisableDateAfterDueDate(dueDate);
    }

    public void openDatePickerOnTodoDetail() {
        toDoPage.clickDueDateOnTodoDetail();
    }

    public int getValidDateHasIndex(int validDateIndex) {
        return toDoPage.getValidDateHasIndex(validDateIndex);
    }

    public void verifyChoosingAnotherDate(int date) {
        toDoPage.verifyChoosingAnotherDate(date);
    }

    public String getMonthYearTitle() {
        return toDoPage.getMonthYearTitle();
    }

    public void goToNextMonth() {
        toDoPage.clickNextMonthIcon();
    }

    public void goToPreviousMonth() {
        toDoPage.clickPreviousMonthIcon();
    }

    public void verifyNextMonthIcon(String monthYear) {
        toDoPage.verifyNextMonthIcon(monthYear);
    }

    public void verifyPreviousMonthIcon(String monthYear) {
        toDoPage.verifyPreviousMonthIcon(monthYear);
    }

    public void inputToDueDate(String value) {
        toDoPage.inputToDueDate(value);
    }
    /*-----------end of huy.huynh on 28/06/2017.*/
}
