package com.auvenir.ui.pages.common;

import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by tan.pham on 5/22/2017.
 */
public class PopUpPage extends AbstractPage {

    // Constants
    static final  String POP_UP_TITLE = "popup title";
    static final  String POP_UP_TITLE_CORRECT = "Popup title is show correct";
    static final  String POP_UP_TITLE_ERROR = "TestScript Failed: popup title show is not correct.";

    static final  String GUIDE_SENTENCE_UP_TITLE = "guide sentence description";
    static final  String GUIDE_SENTENCE_UP_TITLE_CORRECT = "Popup Guide sentence is show correct";
    static final  String GUIDE_SENTENCE_UP_TITLE_ERROR = "TestScript Failed: guide sentence is not correct.";

    static final  String DELETE_BUTTON_TITLE = "delete button";
    static final  String DELETE_BUTTON_COLOR = "rgba(255, 255, 255, 1)";
    static final  String DELETE_BUTTON_BACK_GROUND_COLOR = "rgba(241, 103, 57, 1)";

    static final  String CANCEL_BUTTON_TITLE = "cancel button";
    static final  String CANCEL_BUTTON_COLOR = "rgba(255, 255, 255, 1)";
    static final  String CANCEL_BUTTON_BACK_GROUND_COLOR = "rgba(151, 147, 147, 1)";

    static final  String POP_UP_DELETE_TITLE_TEXT = "Delete To-Do?";
    static final  String POP_UP_DELETE_GUIDE_SENTENCE_TEXT = "Are you sure you'd like to delete these To-Dos? " +
                                                             "Once deleted, you will not be able to retrieve any documents uploaded to the selected To-Dos.";

    static final String BACK_GROUND_BUTTON_TITLE = "background-color";
    static final String BACK_GROUND_BUTTON_FIRST_MESSAGE_ERROR = "TestScript Failed: background-color of ";
    static final String BACK_GROUND_BUTTON_LAST_MESSAGE_ERROR = " is not correct.";
    static final String BACK_GROUND_BUTTON_FIRST_MESSAGE_SUCCESS = "Background-color of ";
    static final String BACK_GROUND_BUTTON_LAST_MESSAGE_SUCCESS = " is show correct.";

    static final String COLOR_BUTTON_TITLE = "color";
    static final String COLOR_BUTTON_FIRST_MESSAGE_ERROR = "TestScript Failed: color of ";
    static final String COLOR_BUTTON_LAST_MESSAGE_ERROR = " is not correct.";
    static final String COLOR_BUTTON_FIRST_MESSAGE_SUCCESS = "Color of ";
    static final String COLOR_BUTTON_LAST_MESSAGE_SUCCESS = " is show correct.";



    //public constructor
    public PopUpPage(Logger logger, WebDriver driver)
    {
        super(logger,driver);
        PageFactory.initElements(driver, this);
    }

    public boolean verifyGUIPopUpDelete(WebElement elePopUpTile,WebElement eleGuideSentenceTitle,
                                        WebElement eleCancelButton, WebElement eleDeleteButton){
        if(verifyGUIPopUp(elePopUpTile,POP_UP_DELETE_TITLE_TEXT,
                          eleGuideSentenceTitle,POP_UP_DELETE_GUIDE_SENTENCE_TEXT,
                          eleCancelButton, CANCEL_BUTTON_TITLE,CANCEL_BUTTON_COLOR,CANCEL_BUTTON_BACK_GROUND_COLOR,
                          eleDeleteButton, DELETE_BUTTON_TITLE,DELETE_BUTTON_COLOR,DELETE_BUTTON_BACK_GROUND_COLOR));
        return true;
    }

    public boolean verifyGUIPopUp(WebElement elePopUpTile, String popUpTitleDescription,
                                  WebElement eleGuideSentenceTitle, String guideSentenceTitleDescription,
                                  WebElement eleOneButton, String txtOneButton, String txtOneButtonColor, String txtOneButtonBackGround,
                                  WebElement eleTwoButton, String txtTwoButton, String txtTwoButtonColor, String txtTwoButtonBackGround){

        // verify popup title
        waitForVisibleElement(elePopUpTile,POP_UP_TITLE);
        if(!validateElementText(elePopUpTile,popUpTitleDescription)){
            NXGReports.addStep(POP_UP_TITLE_ERROR, LogAs.FAILED,new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
        NXGReports.addStep(POP_UP_TITLE_CORRECT, LogAs.PASSED, null);

        // verify guide sentence
        waitForVisibleElement(eleGuideSentenceTitle,GUIDE_SENTENCE_UP_TITLE);
        if(!validateElementText(eleGuideSentenceTitle, guideSentenceTitleDescription)){
            NXGReports.addStep(GUIDE_SENTENCE_UP_TITLE_ERROR, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
        NXGReports.addStep(GUIDE_SENTENCE_UP_TITLE_CORRECT, LogAs.PASSED, null);

        // verify back-ground of one button
        waitForVisibleElement(eleOneButton,txtOneButton);
        if(!validateCSSValueElement(eleOneButton,BACK_GROUND_BUTTON_TITLE,txtOneButtonBackGround)){
            NXGReports.addStep(BACK_GROUND_BUTTON_FIRST_MESSAGE_ERROR + txtOneButton   + BACK_GROUND_BUTTON_LAST_MESSAGE_ERROR , LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
        NXGReports.addStep(BACK_GROUND_BUTTON_FIRST_MESSAGE_SUCCESS + txtOneButton + BACK_GROUND_BUTTON_LAST_MESSAGE_SUCCESS, LogAs.PASSED, null);

        // verify color of one button
        if(!validateCSSValueElement(eleOneButton,COLOR_BUTTON_TITLE,txtOneButtonColor)){
            NXGReports.addStep(COLOR_BUTTON_FIRST_MESSAGE_ERROR + txtOneButton  + COLOR_BUTTON_LAST_MESSAGE_ERROR, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
        NXGReports.addStep(COLOR_BUTTON_FIRST_MESSAGE_SUCCESS + txtOneButton + COLOR_BUTTON_LAST_MESSAGE_SUCCESS, LogAs.PASSED, null);


        // verify back-ground of two button
        waitForVisibleElement(eleTwoButton, txtTwoButton);
        if(!validateCSSValueElement(eleTwoButton,BACK_GROUND_BUTTON_TITLE,txtTwoButtonBackGround)){
            NXGReports.addStep(BACK_GROUND_BUTTON_FIRST_MESSAGE_ERROR + txtTwoButton   + BACK_GROUND_BUTTON_LAST_MESSAGE_ERROR, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
        NXGReports.addStep(BACK_GROUND_BUTTON_FIRST_MESSAGE_SUCCESS + txtTwoButton + BACK_GROUND_BUTTON_LAST_MESSAGE_SUCCESS, LogAs.PASSED, null);
        // verify color of one button
        if(!validateCSSValueElement(eleTwoButton,COLOR_BUTTON_TITLE,txtTwoButtonColor)){
            NXGReports.addStep(COLOR_BUTTON_FIRST_MESSAGE_ERROR + txtTwoButton  + COLOR_BUTTON_LAST_MESSAGE_ERROR, LogAs.FAILED,
                    new CaptureScreen(CaptureScreen.ScreenshotOf.BROWSER_PAGE));
            return false;
        }
        NXGReports.addStep(COLOR_BUTTON_FIRST_MESSAGE_SUCCESS + txtTwoButton + COLOR_BUTTON_LAST_MESSAGE_SUCCESS, LogAs.PASSED, null);
        return true;
    }

}
