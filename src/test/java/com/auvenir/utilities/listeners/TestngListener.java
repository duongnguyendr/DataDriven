/***********************************************************************
 * @author 			:		LAKSHMI BS
 * @description		: 		Implemented ITestListener interface and overrided methods as per requirement. It listenes to all the events performed by Testng and keep track of it.
 */
package com.auvenir.utilities.listeners;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.auvenir.utilities.GenericService;
import com.auvenir.utilities.PdfGenerater;
import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;


@Parameters({"server"})
public class TestngListener implements ITestListener {
	public static File sHtmlReports;
	public static File sTestngReports;
	public static File sPdfReports;
	public static String sdateTime;
	public static int iPassCount=0;
	public static int iFailCount=0;
	public static int iSkippedCount=0;
	public static int iTotalExecuted=0;
	public static ArrayList sTestName= new ArrayList<String>();
	public static ArrayList sStatus= new ArrayList<String>();
	public static ArrayList sDescription= new ArrayList<String>();
	
	public TestngListener() throws IOException 
	{
		Date date = new Date();
	    SimpleDateFormat sdtf=new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss");
	    sdateTime = sdtf.format(date);
		sHtmlReports=new File(GenericService.sDirPath+"//..//Reports//HTMLReports");
		sTestngReports= new File(GenericService.sDirPath+"//..//Reports//TestNGReports");
		sPdfReports = new File(GenericService.sDirPath+"//..//Reports//PDFReports");
		if(!sHtmlReports.exists())
		{
			FileUtils.forceMkdir(sHtmlReports);		
		}
		if(!sTestngReports.exists())
		{
			FileUtils.forceMkdir(sTestngReports);	
		}
		if(!sPdfReports.exists())
		{
			FileUtils.forceMkdir(sPdfReports);	
		}
		System.setProperty("KIRWA.reporter.config", "KIRWA.properties");	
	}

	public void onTestStart(ITestResult result) 
	{
		GenericService.setConfigValue(GenericService.sConfigFile, "DATE", sdateTime);
	}

	public void onTestSuccess(ITestResult result) 
	{
		sDescription.add(result.getMethod().getDescription());
		iPassCount = iPassCount+1;
		sTestName.add(result.getName().toString());
		sStatus.add("Passed");
	}

	public void onTestFailure(ITestResult result) 
	{
		sDescription.add(result.getMethod().getDescription());
		iFailCount = iFailCount+1;
		sTestName.add(result.getName().toString());
		sStatus.add("Failed");
	}

	public void onTestSkipped(ITestResult result) 
	{
		sDescription.add(result.getMethod().getDescription());
		iSkippedCount = iSkippedCount+1;
		sTestName.add(result.getName().toString());
		sStatus.add("Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
	}

	public void onStart(ITestContext context) 
	{
	}

	public void onFinish(ITestContext context) 
	{
		 File testOuput = new File(GenericService.sDirPath+"\\tests-output");
		 String sTestngReports= GenericService.sDirPath+"\\..\\Reports\\TestNGReports\\TestNG_"+sdateTime;
		 File pdfReports = new File(sPdfReports+"\\PDFReports"+sdateTime+".pdf");
		 iPassCount=context.getPassedTests().size(); 
	     iFailCount=context.getFailedTests().size(); 
	     iSkippedCount=context.getSkippedTests().size(); 
	     iTotalExecuted = iPassCount+iFailCount+iSkippedCount;
	     //GenericService.getPieChart(iPassCount,iFailCount,iSkippedCount);
		//GenericService.getBarChart(iPassCount,iFailCount,iSkippedCount);
		 GenericService.getPieChartFollowBrowser(sTestName,sStatus);
		 GenericService.getBarChartFollowBrowser(sTestName,sStatus);
         PdfGenerater pdf = new PdfGenerater();
         pdf.toExecute(sTestName, sDescription, sStatus, iPassCount, iFailCount, iSkippedCount, pdfReports);
         GenericService.sendMail(iPassCount, iFailCount, iSkippedCount, iTotalExecuted, pdfReports);
         //File reports = new File(sTestngReports);
     	try
        {
     		FileUtils.copyDirectoryToDirectory(testOuput,new File(sTestngReports));
     		//GenericService.sendMail(iPassCount, iFailCount, iSkippedCount, iTotalExecuted, pdfReports);
     		System.out.println("testoutput is moved");
        }
        catch(Exception e)
        {
        	System.out.println("testoutput is not moved");
        }
	}
}
