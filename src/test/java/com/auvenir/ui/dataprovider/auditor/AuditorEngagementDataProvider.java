package com.auvenir.ui.dataprovider.auditor;

import com.auvenir.utilities.GeneralUtilities;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

/**
 * Created by tan.pham on 7/6/2017.
 */
public class AuditorEngagementDataProvider {

    @DataProvider(name = "engagementData")
    public static Object[][] getEngagementData(ITestContext iTestContext){
        Object[][] groupArray = null;
        for (String group : iTestContext.getIncludedGroups()) {
            if(group.equalsIgnoreCase("A")){
                groupArray =  new Object[][]{
                        { "chr.auvenirauditor@gmail.com", "Changeit@123"}
                };
            }else if(group.equalsIgnoreCase("A")){
                groupArray =  new Object[][]{
                        { "chr.auvenirauditor@gmail.com", "Changeit@123", "engagement" + GeneralUtilities.getTimeStampForNameSuffix()}
                };
            }else{
                groupArray =  new Object[][]{
                        { "chr.auvenirauditor@gmail.com", "Changeit@123", "Company Auvenir"}
                };
            }
        }
        return groupArray;
    }
}
