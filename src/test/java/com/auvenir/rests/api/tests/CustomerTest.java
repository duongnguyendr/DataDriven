package com.auvenir.rests.api.tests;

import com.auvenir.rests.api.services.AbstractAPIService;
import com.auvenir.ui.services.AbstractService;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import static com.auvenir.rests.api.tests.AccountTest.restBaseUrl;
import static com.jayway.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

import com.jayway.restassured.path.json.JsonPath;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by doai.tran on 4/21/2017.
 */
public class CustomerTest extends AbstractAPIService {
    public static final String restBaseUrl="http://auvenir-qa.com";
    // Connect DB and reset Data
    @BeforeClass
    public void getRestBaseUrl(){
        RestAssured.basePath=restBaseUrl;

    }
    /*
    // Connect DB
    @BeforeMethod
    public void preCondition(){

    }*/

    /*
    TestCase1: Get owner from Customer ID
     */
    @Test(priority = 1, enabled = true, description = "Get owner from Customer ID")
    public void getCustomerFromCustomerID() throws Exception {
        try {
            Response response = given().get(restBaseUrl+"/v1/consumer/8283407");
            if (response.getStatusCode() == 200) {
                getLogger().info("Request successfully with code: " + response.getStatusCode());
            } else {
                Assert.fail();
            }
            String json = response.asString();
            JsonPath jp = new JsonPath(json);
            //  CustomerID
            assertionEquals(jp.get("consumerID").toString(),"8283407");
            /*assertEquals("8283407",jp.get("consumerID").toString());
            getLogger().info("Request successfully with CustomerID: " + jp.get("consumerID").toString());*/
            //  institutionID
            assertionEquals(jp.get("institutionID").toString(),"58f73f957d63f4745a0175fa");
            /*assertEquals("58f73f957d63f4745a0175fa",jp.get("institutionID").toString());
            getLogger().info("Request successfully with institutionID: " + jp.get("institutionID").toString());*/
            //  userID
            assertionEquals(jp.get("userID").toString(),"58f707a6004d69fc2aeb8e51");
            /*assertEquals("58f707a6004d69fc2aeb8e51",jp.get("userID").toString());
            getLogger().info("Request successfully with institutionID: " + jp.get("userID").toString());*/
            //  status
            assertionEquals(jp.get("status").toString(),"ACTIVE");
            /*assertEquals("ACTIVE",jp.get("status").toString());
            getLogger().info("Request successfully with institutionID: " + jp.get("status").toString());*/
            //  callbackURL
            assertionEquals(jp.get("callbackURL").toString(),"https://finicity-qa.com/v2");
            /*assertEquals("https://finicity-qa.com/v2",jp.get("callbackURL").toString());
            getLogger().info("Request successfully with institutionID: " + jp.get("callbackURL").toString());*/
            //  dateCreated
            assertionEquals(jp.get("dateCreated").toString(),"1492599536");
            /*assertEquals("1492599536",jp.get("dateCreated").toString());
            getLogger().info("Request successfully with institutionID: " + jp.get("dateCreated").toString());*/

            Assert.assertTrue(AbstractService.sStatusCnt==0, "Script Failed");
            NXGReports.addStep("Request successfully with CustomerID", LogAs.PASSED, null);
        }catch (AssertionError e)
            {
                NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
                throw e;
            }
        catch (Exception e){
                NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
                throw e;
        }
    }
    /*
    TestCase2: Get owner from Customer ID
     */
    @Test(priority = 1, enabled = true, description = "Get owner from Invalid Customer ID")
    public void getCustomerInvalidCustomerID() throws Exception {
        try {
            Response response = given().get(restBaseUrl+"/v1/consumer/12345");
            if(response.getStatusCode()==400){
                getLogger().info("Request successfully with code: " + response.getStatusCode());
            }
            else {
                Assert.fail();
            }
            String json = response.asString();
            JsonPath jp = new JsonPath(json);
            //
            assertionEquals(jp.get("code").toString(),"api-023");
            /*assertEquals("api-023",jp.get("code").toString());
            getLogger().info("Request successfully with code: " + jp.get("code").toString());*/
            //
            assertionEquals(jp.get("msg").toString(),"Error, missing or invalid consumerID.");
            /*assertEquals("Error, missing or invalid consumerID.",jp.get("msg").toString());
            getLogger().info("Request successfully with msg: " + jp.get("msg").toString());*/
            //
        }
        catch(AssertionError e){
                NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
                throw e;
            }
        catch(Exception e){
                NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
                throw e;
        }
    }
    /*
    TestCase3: Get owner from Customer ID
     */
    @Test(priority = 1, enabled = true, description = "Get owner from Invalid Customer ID")
    public void getCustomerWronginstitutionID() throws Exception {
        try{
            Response response = given().get(restBaseUrl+"/v1/consumer/");
            if(response.getStatusCode()==404){
                getLogger().info("Request successfully with code: " + response.getStatusCode());
                NXGReports.addStep("Request with wrong institutionID format with code: " +response.getStatusCode() , LogAs.PASSED, null);
            }
            else {
                Assert.fail();
            }

            //
            Assert.assertTrue(AbstractService.sStatusCnt==0, "Script Failed");
            NXGReports.addStep("Request successfully with WronginstitutionID", LogAs.PASSED, null);
        }catch (AssertionError e)
        {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
        catch (Exception e){
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
    }
}
