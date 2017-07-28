package com.auvenir.ui.pages.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by vien.pham on 7/28/2017.
 */
public class TeamPage extends AbstractPage {
    public TeamPage(Logger logger, WebDriver driver) {
        super(logger, driver);
    }

    @FindBy(xpath = "//tbody[@id='w-team-tableBody']/tr/td[2]")
    protected List<WebElement> listTeamMember;


    public int findMemberByName(String memberName) {
        int index = -1;
        for (int i = 0; i < listTeamMember.size(); i++) {
            if (listTeamMember.get(i).getText().equals(memberName)) {
                index = i;
                break;
            }
        }
        return index;
    }


}
