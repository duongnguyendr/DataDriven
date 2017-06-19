package com.auvenir.ui.tests.admin;

import com.auvenir.ui.pages.marketing.engagement.AdminPortalReviewPage;
import com.auvenir.ui.tests.AbstractTest;
import org.testng.annotations.Test;

/**
 * Created by toan.nguyenp on 5/8/2017.
 */
public class AdminPortalReviewTest extends AbstractTest {

    private AdminPortalReviewPage adminPortalReviewPO = null;

    @Test(priority = 1, description = "Sort user by ascending")
    public void sortAscendingUserByNameTest(){
        adminPortalReviewPO = new AdminPortalReviewPage(getDriver());
        adminPortalReviewPO.sortUser(true);
    }

    @Test(priority = 2, description = "Sort user by descending")
    public void sortDescendingUserByNameTest(){
        adminPortalReviewPO.sortUser(false);
    }

    @Test(priority = 3, description = "Sort user type by ascending")
    public void sortAscendingUserTypeTest(){
        adminPortalReviewPO.sortUserType(true);
    }

    @Test(priority = 4, description = "Sort user type by descending")
    public void sortDescendingUserTypeTest(){
        adminPortalReviewPO.sortUserType(false);
    }


}
