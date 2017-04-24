package com.auvenir.rests.api.tests;

import com.auvenir.rests.api.services.AbstractAPIService;
import com.auvenir.ui.services.AbstractService;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

import com.jayway.restassured.path.json.JsonPath;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Created by doai.tran on 4/21/2017.
 */
public class AccountTest extends AbstractAPIService {
    public static final String restBaseUrl="http://finicity-qa-331.com";
    // Connect DB and reset Data
    @BeforeSuite
    public void prepareData() {


    }
    /*
    // Connect DB
    @BeforeMethod
    public void preCondition(){

    }*/
    @BeforeClass
    public void getRestBaseUrl(){
        RestAssured.basePath=restBaseUrl;

    }
    /*
    TestCase1: Get account from Customer ID
     */
    @Test(priority = 1, enabled = true, description = "TestCase1: Get account from Customer ID")
    public void GetAccountCustomerID() throws Exception {
        try {
            Response response = given().get(restBaseUrl+"/v1/institution/58f73f957d63f4745a0175fa?consumerID=8283407");
            Assert.assertEquals(response.statusCode(), 200);
            NXGReports.addStep("Get account customer with correct code.", LogAs.PASSED, null);
            assertionEquals(response.then().extract().jsonPath().getString("identifier"), "58f73f957d63f4745a0175fa");
            assertionEquals(response.then().extract().jsonPath().getString("name"),"FinBank-local");
            assertionEquals(response.then().extract().jsonPath().getString("typeDescription"),"bank free for testing");
            assertionEquals(response.then().extract().jsonPath().getString("urlHomeApp"),"none");
            assertionEquals(response.then().extract().jsonPath().getString("urlLogonApp"),"none");
            assertionEquals(response.then().extract().jsonPath().getString("urlProductApp"),"none");
            assertionEquals(response.then().extract().jsonPath().getString("phone"),"064-984963856");
            assertionEquals(response.then().extract().jsonPath().getString("currency"),"none");
            assertionEquals(response.then().extract().jsonPath().getString("email"),"none");
            assertionEquals(response.then().extract().jsonPath().getString("specialText"),"none");
            assertionEquals(response.then().extract().jsonPath().getString("address"),"none");

            Assert.assertTrue(AbstractService.sStatusCnt==0, "Script Failed");
            NXGReports.addStep("Get account customer", LogAs.PASSED, null);
        }catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
        catch (Exception e){
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
    }
    /*
    TestCase2: Get account from out Customer ID
     */
    @Test(priority = 1, enabled = true, description = "TestCase2: Get account from Out Customer ID")
    public void GetAccountOutCustomerID() throws Exception {
        try{
            Response response = given().get(restBaseUrl+"/v1/institution/58f73f957d63f4745a0175fa");
            Assert.assertEquals(response.statusCode(), 401);
            NXGReports.addStep("Get account customer with correct code.", LogAs.PASSED, null);

            Assert.assertTrue(AbstractService.sStatusCnt==0, "Script Failed");
            NXGReports.addStep("Get account from out Customer ID", LogAs.PASSED, null);
        }catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
        catch (Exception e){
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
    }
    /*
    TestCase3: Get account from wrong Customer ID
     */
    @Test(priority = 1, enabled = true, description = "TestCase3: Get account from Out Customer ID")
    public void GetAccountWrongCustomerID() throws Exception {
        try{
            Response response = given().get(restBaseUrl+"/v1/institution/58f73f957d63f4745a0175fa?consumerID=12345");
            Assert.assertEquals(response.statusCode(), 400);
            NXGReports.addStep("Get account customer with correct code.", LogAs.PASSED, null);
            assertionEquals(response.then().extract().jsonPath().getString("code"),"api-005");
            assertionEquals(response.then().extract().jsonPath().getString("msg"),"Error, missing or invalid CustomerID.");

            Assert.assertTrue(AbstractService.sStatusCnt==0, "Script Failed");
            NXGReports.addStep("Get account with wrong Customer ID", LogAs.PASSED, null);
        }catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
        catch (Exception e){
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
    }
    /*
    TestCase4: Get account from wrong institutionID
     */
    @Test(priority = 1, enabled = true, description = "TestCase4: Get account from Out Customer ID")
    public void GetAccountWronginstitutionID() throws Exception {
        try{
            Response response = given().get(restBaseUrl+"/v1/institution/58f73f957d63f474340175fa?consumerID=8283407");
            Assert.assertEquals(response.statusCode(), 400);
            NXGReports.addStep("Get correct code.", LogAs.PASSED, null);
            assertionEquals(response.then().extract().jsonPath().getString("code"),"api-005");
            assertionEquals(response.then().extract().jsonPath().getString("msg"),"Error, missing or invalid institution ID.");
            Assert.assertTrue(AbstractService.sStatusCnt==0, "Script Failed");
            NXGReports.addStep("Get account with wrong Customer ID", LogAs.PASSED, null);
        }catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
        catch (Exception e){
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
    }
    /*
    TestCase5: Get account from wrong institutionIDformat
     */
    @Test(priority = 1, enabled = true, description = "TestCase4: Get account from Out Customer ID")
    public void GetAccountWronginstitutionIDFormat() throws Exception {
        try{
            Response response = given().get(restBaseUrl+"/v1/institution/58f73f957d63f4745260175fa?consumerID=8283407");
            Assert.assertEquals(response.statusCode(), 404);
            NXGReports.addStep("Get correct code.", LogAs.PASSED, null);
            /*assertionEquals(response.getBody().toString(),"Cannot GET /v1/institution/58f73f957d63f4745260175fa?consumerID=8283407");
            System.out.println("----------- "+ response.getBody().toString())*/;
            Assert.assertTrue(AbstractService.sStatusCnt==0, "Script Failed");
            NXGReports.addStep("Get account with wrong institutionIDformat", LogAs.PASSED, null);
        }catch (AssertionError e) {
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
        catch (Exception e){
            NXGReports.addStep("Testscript Failed", LogAs.FAILED, null);
            throw e;
        }
    }
}

