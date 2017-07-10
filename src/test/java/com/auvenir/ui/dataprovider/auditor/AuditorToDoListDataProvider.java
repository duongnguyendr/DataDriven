package com.auvenir.ui.dataprovider.auditor;

import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import org.codehaus.groovy.ast.tools.GenericsUtils;
import org.testng.annotations.DataProvider;

import java.util.Random;

/**
 * Created by tan.pham on 7/10/2017.
 */
public class AuditorToDoListDataProvider {

    @DataProvider(name="verifyAuditorEmptyTodoListPage")
    public static Object[][] getVerifyAuditorEmptyTodoListPage(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementType = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Type", "Valid Data");
        String companyName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Company Name", "Valid Data");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementType,companyName, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementType,companyName, engagementName}};
        }
        return  arrayData ;
    }

    @DataProvider(name="verifyCreateToDoPageCategorySearchData")
    public static Object[][] getVerifyCreateToDoPageCategorySearchData(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "To Do Name", "Valid Data");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,toDoName,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,toDoName,engagementName}};
        }
        return  arrayData ;
    }


    @DataProvider(name="verifyNewCategoryPopup")
    public static Object[][] getVerifyNewCategoryPopup(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "To Do Name", "Valid Data");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,toDoName,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,toDoName,engagementName}};
        }
        return  arrayData ;
    }

    @DataProvider(name = "verifyButtonFilter")
    public static Object[][] getVerifyButtonFilter(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifySearchPlaceholder")
    public static Object[][] getVerifySearchPlaceholder(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifySearchHover")
    public static Object[][] getVerifySearchHover(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifySearchInputText")
    public static Object[][] getVerifySearchInputText(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyDataGridToDoTaskPage")
    public static Object[][] getVerifyDataGridToDoTaskPage(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
        String toDoListNames[] = {"416 To Do Task02", "a To Do Task02", "z To Do Task02", "b To Do Task02", "c To Do Task02"};
        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName, toDoListNames}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName, toDoListNames}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyCategoryComboBoxOnCreateToDo")
    public static Object[][] getVerifyCategoryComboBoxOnCreateToDo(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "To Do Name", "Valid Data");
        String categoryName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Category Name", "Valid Data");
        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, toDoName, categoryName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, toDoName, categoryName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyFilterButton")
    public static Object[][] getVerifyFilterButton(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name="verifyDefaultValueFilterButton")
    public static Object[][] getVerifyDefaultValueFilterButton(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyBorderOnFilterButton")
    public static Object[][] getVerifyBorderOnFilterButton(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyChooseAnOptionFilterButton")
    public static Object[][] getVerifyChooseAnOptionFilterButton(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name="verifyUnableAddMoreOptionFilter")
    public static Object[][] getVerifyUnableAddMoreOptionFilter(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "selectAnVaLueOnAssignOptionFilter")
    public static Object[][] getSelectAnVaLueOnAssignOptionFilter(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "clickAndDoNotSelectOptionFilter")
    public static Object[][] getClickAndDoNotSelectOptionFilter(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyGUIToDoTextBox")
    public static Object[][] getVerifyGUIToDoTextBox(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyGUIToDoAddBulkActions")
    public static Object[][] getVerifyGUIToDoAddBulkActions(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyGUISelectDateDropDownInNewToDoPage")
    public static Object[][] getVerifyGUISelectDateDropDownInNewToDoPage(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyToDoDetailsCommenting")
    public static Object[][] getVerifyToDoDetailsCommenting(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "To Do Name", "Valid Data");
        String inputComment = "commentTest";
        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName, toDoName, inputComment}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName, toDoName, inputComment}};
        }
        return  arrayData;
    }

    @DataProvider(name="verifyMarkAsComplete")
    public static Object[][] getVerifyMarkAsComplete(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
        String toDoName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "To Do Name", "Valid Data");
        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName, toDoName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName, toDoName}};
        }
        return  arrayData;
    }

    @DataProvider(name="verifyButtonUndoExist")
    public static Object[][] getVerifyButtonUndoExist(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = "engagement" + GeneralUtilities.getTimeStampForNameSuffix();
        String engagementType = "type" + GeneralUtilities.getTimeStampForNameSuffix();
        String companyName = "company" + GeneralUtilities.getTimeStampForNameSuffix();

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyButtonUndoStatus")
    public static Object[][] getVerifyButtonUndoStatus(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = "engagement" + GeneralUtilities.getTimeStampForNameSuffix();
        String engagementType = "type" + GeneralUtilities.getTimeStampForNameSuffix();
        String companyName = "company" + GeneralUtilities.getTimeStampForNameSuffix();
        String toDoName = "toDoName01" + GeneralUtilities.getTimeStampForNameSuffix();

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName, toDoName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName, toDoName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyUndoActionWithCompleteCase")
    public static Object[][] getVerifyUndoActionWithCompleteCase(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = "engagement" + GeneralUtilities.getTimeStampForNameSuffix();
        String engagementType = "type" + GeneralUtilities.getTimeStampForNameSuffix();
        String companyName = "company" + GeneralUtilities.getTimeStampForNameSuffix();
        String toDoName01 = "toDoName01" + GeneralUtilities.getTimeStampForNameSuffix();
        String toDoName02 = "toDoName02" + GeneralUtilities.getTimeStampForNameSuffix();

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName, toDoName01, toDoName02}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName, toDoName01, toDoName02}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyUndoActionWithAssignToCase")
    public static Object[][] getVerifyUndoActionWithAssignToCase(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = "engagement" + GeneralUtilities.getTimeStampForNameSuffix();
        String engagementType = "type" + GeneralUtilities.getTimeStampForNameSuffix();
        String companyName = "company" + GeneralUtilities.getTimeStampForNameSuffix();
        String toDoName01 = "toDoName01" + GeneralUtilities.getTimeStampForNameSuffix();
        String toDoName02 = "toDoName02" + GeneralUtilities.getTimeStampForNameSuffix();

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName, toDoName01, toDoName02}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName, toDoName01, toDoName02}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyUndoActionWithDeleteCase")
    public static Object[][] getVerifyUndoActionWithDeleteCase(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = "engagement" + GeneralUtilities.getTimeStampForNameSuffix();
        String engagementType = "type" + GeneralUtilities.getTimeStampForNameSuffix();
        String companyName = "company" + GeneralUtilities.getTimeStampForNameSuffix();
        String toDoName01 = "toDoName01" + GeneralUtilities.getTimeStampForNameSuffix();
        String toDoName02 = "toDoName02" + GeneralUtilities.getTimeStampForNameSuffix();

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName, toDoName01, toDoName02}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName, toDoName01, toDoName02}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyDownloadAttachmentsDisable")
    public static Object[][] getverifyDownloadAttachmentsDisable(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = "engagement" + GeneralUtilities.getTimeStampForNameSuffix();
        String engagementType = "type" + GeneralUtilities.getTimeStampForNameSuffix();
        String companyName = "company" + GeneralUtilities.getTimeStampForNameSuffix();
        String toDoName01 = "toDoName01" + GeneralUtilities.getTimeStampForNameSuffix();

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName, toDoName01}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName, toDoName01}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyGUIDeleteIconInToDoListPage")
    public static Object[][] getVerifyGUIDeleteIconInToDoListPage(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
        String engagementType = "";
        String companyName = "Auvenir Company";

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyDefaultStatusDeleteIconInToDoListPage")
    public static Object[][] getVerifyDefaultStatusDeleteIconInToDoListPage(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyGUIDeleteConfirmPopupInToDoListPage")
    public static Object[][] getVerifyGUIDeleteConfirmPopupInToDoListPage(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyCheckAllCheckBoxInToDoListPage")
    public static Object[][] getVerifyCheckAllCheckBoxInToDoListPage(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyWorkFlowOfDeleteButtonInToDoListPage")
    public static Object[][] getVerifyWorkFlowOfDeleteButtonInToDoListPage(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyWorkFlowOfCancelButtonInToDoListPage")
    public static Object[][] getVerifyWorkFlowOfCancelButtonInToDoListPage(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyDefaultEditCategoryGuiAtCreateNewTodoPage")
    public static Object[][] getVerifyDefaultEditCategoryGuiAtCreateNewTodoPage(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String categoryName01 = "cate04";
        String categoryName02 = "cate05";
        String categoryName03 = "cate06";

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, categoryName01, categoryName02, categoryName03}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, categoryName01, categoryName02, categoryName03}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyEditFunctionAtCreateNewTodoPage")
    public static Object[][] getVerifyEditFunctionAtCreateNewTodoPage(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
        String categoryName = "Vien Pham 11111";
        String editCategoryName = "Vien Pham 1308";
        String numberCategoryName = "444";
        String nullCategoryName ="";
        String specialCategoryName ="@#$%^VienPham";


        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, categoryName, editCategoryName, numberCategoryName, nullCategoryName, specialCategoryName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, categoryName, editCategoryName, numberCategoryName, nullCategoryName, specialCategoryName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyRemoveFunctionAtTodoListPage")
    public static Object[][] getVerifyRemoveFunctionAtTodoListPage(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
        String categoryName01 = "cate04";
        String categoryName02 = "cate05";
        String categoryName03 = "cate06";


        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, categoryName01, categoryName02, categoryName03}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, categoryName01, categoryName02, categoryName03}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyWorkFlowOfDeleteMultiToDoInToDoListPage")
    public static Object[][] getVerifyWorkFlowOfDeleteMultiToDoInToDoListPage(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyWorkFlowOfDeleteAllToDoInToDoListPage")
    public static Object[][] getVerifyWorkFlowOfDeleteAllToDoInToDoListPage(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyWorkFlowOfCancelMultiToDoInToDoListPage")
    public static Object[][] getVerifyWorkFlowOfCancelMultiToDoInToDoListPage(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyWorkFlowOfCancelAllToDoInToDoListPage")
    public static Object[][] getVerifyWorkFlowOfCancelAllToDoInToDoListPage(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyCompletedFieldUpdateSuccessful")
    public static Object[][] getVerifyCompletedFieldUpdateSuccessful(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
        Random random = new Random();
        String toDoName = "Task-2305" + random.nextInt(1000);
        String categoryName = "Category1";
        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, toDoName, categoryName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, toDoName, categoryName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyCancelCompleteAction")
    public static Object[][] getverifyCancelCompleteAction(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "Valid User", "Auditor");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("LoginData", "USER_PWD", "Auditor");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("AuditorTodoListTest", "Engagement Name", "Valid Data");
        Random random = new Random();
        String toDoName = "Task-2305" + random.nextInt(1000);
        String categoryName = "Category1";
        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, toDoName, categoryName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, toDoName, categoryName}};
        }
        return  arrayData;
    }

}


