package com.auvenir.ui.dataprovider.auditor;

import com.auvenir.ui.dataprovider.commonData.CommonDataProvider;
import com.auvenir.utilities.GeneralUtilities;
import com.auvenir.utilities.GenericService;
import org.codehaus.groovy.ast.tools.GenericsUtils;
import org.testng.annotations.DataProvider;

import java.util.Random;

/**
 * Created by tan.pham on 7/10/2017.
 */
public class AuditorToDoListDataProvider extends CommonDataProvider{

    private static String subjectContent = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "Subject Email Auditor Invite Client", "Valid Value");
    private static String greetingContent = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "Greeting Content", "Valid Value");
    private static String announcementContent = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "Announcement Content", "Valid Value");
    private static String introducingContent = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "Introducing Content", "Valid Value");
    private static String introducingBenefitContent = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "Introducing Benefit Content", "Valid Value");
    private static String firstBenefitContent = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "First Benefit Content", "Valid Value");
    private static String secondBenefitContent = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "Second Benefit Content", "Valid Value");
    private static String thirdBenefitContent = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "Third Benefit Content", "Valid Value");
    private static String feedBackContent = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "FeedBack Content", "Valid Value");
    private static String goodbyeContent = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "Goodbye Content", "Valid Value");


    @DataProvider(name="verifyAuditorEmptyTodoListPage")
    public static Object[][] getVerifyAuditorEmptyTodoListPage(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementType,companyName, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementType,companyName, engagementName}};
        }
        return  arrayData ;
    }

    @DataProvider(name="verifyCreateToDoPageCategorySearchData")
    public static Object[][] getVerifyCreateToDoPageCategorySearchData(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,toDoName,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,toDoName,engagementName}};
        }
        return  arrayData ;
    }


    @DataProvider(name="verifyNewCategoryPopup")
    public static Object[][] getVerifyNewCategoryPopup(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,toDoName,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,toDoName,engagementName}};
        }
        return  arrayData ;
    }

    @DataProvider(name = "verifyButtonFilter")
    public static Object[][] getVerifyButtonFilter(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifySearchPlaceholder")
    public static Object[][] getVerifySearchPlaceholder(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifySearchHover")
    public static Object[][] getVerifySearchHover(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifySearchInputText")
    public static Object[][] getVerifySearchInputText(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyDataGridToDoTaskPage")
    public static Object[][] getVerifyDataGridToDoTaskPage(){

        String toDoListNames[] = {"416 To Do Task02", "a To Do Task02", "z To Do Task02", "b To Do Task02", "c To Do Task02"};
        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName, toDoListNames}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName, toDoListNames}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyCategoryComboBoxOnCreateToDo")
    public static Object[][] getVerifyCategoryComboBoxOnCreateToDo(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, toDoName, categoryName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, toDoName, categoryName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyFilterButton")
    public static Object[][] getVerifyFilterButton(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name="verifyDefaultValueFilterButton")
    public static Object[][] getVerifyDefaultValueFilterButton(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyBorderOnFilterButton")
    public static Object[][] getVerifyBorderOnFilterButton(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyChooseAnOptionFilterButton")
    public static Object[][] getVerifyChooseAnOptionFilterButton(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name="verifyUnableAddMoreOptionFilter")
    public static Object[][] getVerifyUnableAddMoreOptionFilter(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "selectAnVaLueOnAssignOptionFilter")
    public static Object[][] getSelectAnVaLueOnAssignOptionFilter(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "clickAndDoNotSelectOptionFilter")
    public static Object[][] getClickAndDoNotSelectOptionFilter(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyGUIToDoTextBox")
    public static Object[][] getVerifyGUIToDoTextBox(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyGUIToDoAddBulkActions")
    public static Object[][] getVerifyGUIToDoAddBulkActions(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyGUISelectDateDropDownInNewToDoPage")
    public static Object[][] getVerifyGUISelectDateDropDownInNewToDoPage(){

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyToDoDetailsCommenting")
    public static Object[][] getVerifyToDoDetailsCommenting(){

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

        Object[][] arrayData = new Object[][]{{auditorId,auditorPwd,engagementName, toDoName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId,auditorPwd,engagementName, toDoName}};
        }
        return  arrayData;
    }

    @DataProvider(name="verifyButtonUndoExist")
    public static Object[][] getVerifyButtonUndoExist(){

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

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, engagementType, companyName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyDefaultStatusDeleteIconInToDoListPage")
    public static Object[][] getVerifyDefaultStatusDeleteIconInToDoListPage(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyGUIDeleteConfirmPopupInToDoListPage")
    public static Object[][] getVerifyGUIDeleteConfirmPopupInToDoListPage(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyCheckAllCheckBoxInToDoListPage")
    public static Object[][] getVerifyCheckAllCheckBoxInToDoListPage(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyWorkFlowOfDeleteButtonInToDoListPage")
    public static Object[][] getVerifyWorkFlowOfDeleteButtonInToDoListPage(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyWorkFlowOfCancelButtonInToDoListPage")
    public static Object[][] getVerifyWorkFlowOfCancelButtonInToDoListPage(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyDefaultEditCategoryGuiAtCreateNewTodoPage")
    public static Object[][] getVerifyDefaultEditCategoryGuiAtCreateNewTodoPage(){

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

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyWorkFlowOfDeleteAllToDoInToDoListPage")
    public static Object[][] getVerifyWorkFlowOfDeleteAllToDoInToDoListPage(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyWorkFlowOfCancelMultiToDoInToDoListPage")
    public static Object[][] getVerifyWorkFlowOfCancelMultiToDoInToDoListPage(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyWorkFlowOfCancelAllToDoInToDoListPage")
    public static Object[][] getVerifyWorkFlowOfCancelAllToDoInToDoListPage(){

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName}};
        }
        return  arrayData;
    }

    @DataProvider(name ="verifyCompletedFieldUpdateSuccessful")
    public static Object[][] getVerifyCompletedFieldUpdateSuccessful(){

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
    public static Object[][] getVerifyCancelCompleteAction(){

        Random random = new Random();
        String toDoName = "Task-2305" + random.nextInt(1000);
        String categoryName = "Category1";
        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, toDoName, categoryName}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, toDoName, categoryName}};
        }
        return  arrayData;
    }

    @DataProvider(name = "verifyNotificationAuditorInviteClient")
    public static Object[][] getVerifyNotificationAuditorInviteClient(){
        String auditorId = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "Auditor", "Valid Value");
        String auditorPwd = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "Auditor Password", "Valid Value");
        String engagementName = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "Engagement Name", "Valid Value");
        String clientId = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "New Client", "Valid Value");
        String clientEmailPassword = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "New Client Email Password", "Valid Value");
        String clientFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "New Client Full Name", "Valid Value");
        String auditorFullName = GenericService.getTestDataFromExcelNoBrowserPrefix("NotificationEmailTest", "Auditor Full Name", "Valid Value");

        Object[][] arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, clientId, clientEmailPassword,
                clientFullName, auditorFullName, subjectContent, greetingContent, announcementContent,
                introducingContent, introducingBenefitContent, firstBenefitContent, secondBenefitContent, thirdBenefitContent, feedBackContent, goodbyeContent}};
        if(GenericService.sLanguage.equalsIgnoreCase("French")){
            arrayData = new Object[][]{{auditorId, auditorPwd, engagementName, clientId, clientEmailPassword, clientFullName}};
        }
        return  arrayData;
    }

}


