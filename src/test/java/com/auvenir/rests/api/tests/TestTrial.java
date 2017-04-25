package com.auvenir.rests.api.tests;

import com.auvenir.rests.api.services.AbstractAPIService;
import com.auvenir.ui.services.AbstractService;
import com.auvenir.utilities.MongoDBService;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

import com.jayway.restassured.path.json.JsonPath;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.UnknownHostException;
import java.util.Map;

/**
 * Created by doai.tran on 4/20/2017.
 */
public class TestTrial extends AbstractAPIService {
    public static final String restBaseUrl="http://auvenir-qa.com";
    // Connect DB and reset Data
    @BeforeClass
    public void getRestBaseUrl()throws Exception{
        RestAssured.basePath=restBaseUrl;
        MongoDBService.connectDBServer("34.205.90.145",27017,"serviceFinicity");
        MongoDBService.deleteOwner("Owner1");
        MongoDBService.insertOwner("Owner1");
        MongoDBService.deleteConsumer("Consumer1");
        MongoDBService.insertConsumer("Consumer1");
        MongoDBService.deleteInstitution("Institution1");
        MongoDBService.insertInstitution("Institution1");
        MongoDBService.deleteConsumerAccount("ConsumerAccount1");
        MongoDBService.insertConsumerAccount("ConsumerAccount1");
    }
    // Connect DB
    /*@BeforeMethod
    public void preCondition() throws UnknownHostException {
        MongoDBService.connectDBServer("34.205.90.145",27017,"serviceFinicity");
        MongoDBService.insertOwner("Owner1");
    }*/

    /*
    TestCase1: Get owner from owner ID
     */
    @Test(priority = 1, enabled = true, description = "TestCase 1")
    private void uuuuuuu()  {
        try {


            System.out.println("CHAY");
        }
        catch (AssertionError e)
        {

        }
        catch (Exception e){

        }
    }

}
