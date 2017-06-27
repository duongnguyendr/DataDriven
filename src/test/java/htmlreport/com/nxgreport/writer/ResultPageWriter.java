package htmlreport.com.nxgreport.writer;

import com.auvenir.utilities.GenericService;
import htmlreport.com.nxgreport.NXGReports;
import htmlreport.com.nxgreport.ReportLabels;
import htmlreport.com.nxgreport.utils.TestDirectory;
import htmlreport.com.nxgreport.utils.Utils;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tan.pham on 6/26/2017.
 */
public class ResultPageWriter {
    public ResultPageWriter() {
    }

    public static void printHeader(PrintWriter printWriter, int passCount, int failCount, int skipCount) {
        printWriter.println("<!DOCTYPE html>\n\n<html>\n<head>\n\t\t<title>Suite Report</title>\n\n\t\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../" + TestDirectory.RESOURCESDIRName + "/" + TestDirectory.CSSDIRName + "/design.css\" />\n" + "\t\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>" + "     <link rel=\"stylesheet\" href=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css\">" + "\t\t<script src=\"https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js\"></script>"  + "\t\t\t<!--[if lt IE 9]>\n" + "\t\t\t<script language=\"javascript\" type=\"text/javascript\" src=\"../" + TestDirectory.RESOURCESDIRName + "/" + TestDirectory.JSDIRName + "/excanvas.js\"></script>\n" + "\t\t\t<![endif]-->\n\n" + "\t\t\t<script language=\"javascript\" type=\"text/javascript\" src=\"../" + TestDirectory.RESOURCESDIRName + "/" + TestDirectory.JSDIRName + "/amcharts.js\"></script>\n" + "\t\t\t<script type=\"text/javascript\" src=\"../" + TestDirectory.RESOURCESDIRName + "/" + TestDirectory.JSDIRName + "/pie.js\">\n</script>\n" + "\t\n\t\t<script language=\"javascript\" type=\"text/javascript\">" + "\t\n\t\t\t$(document).ready(function() { $(\".video\").hide();" + "\t\n\t\t\t\t$(\"#showmenu\").show(); " + "\t\n\t\t\t\t$('#showmenu').click(function(){ " + "\t\n\t\t\t\t\t$('.video').toggle(\"slide\"); " + "\t\n\t\t\t\t}); " + "\t\n\t\t\t});" + "\t\n\t\t</script>" + "\t\n\t\t<style>" + "\t\n\t\t\t\t#showmenu{text-align:center; padding-top:20px;color: #585858; font-size: 14px;}" + "\t\n\t\t\t\t#video{height: 550px;margin-top: 5px;width: 97%;border-style: solid;border-width: 1px;border-color: #21ABCD;/* Shadow for boxes */ -moz-box-shadow: 0 0 10px #CCCCCC; -ms-box-shadow: 0 0 10px #CCCCCC; -webkit-box-shadow: 0 0 10px #CCCCCC; box-shadow: 0 0 10px #CCCCCC; zoom: 1; filter: progid:DXImageTransform.Microsoft.Shadow(Color=#cccccc, Strength=2, Direction=0), progid:DXImageTransform.Microsoft.Shadow(Color=#cccccc, Strength=2, Direction=90), progid:DXImageTransform.Microsoft.Shadow(Color=#cccccc, Strength=2, Direction=180), progid:DXImageTransform.Microsoft.Shadow(Color=#cccccc, Strength=2, Direction=270); background-color: white;}" + "\t\n\t\t</style>" + "\t\n\t\t<script language=\"javascript\" type=\"text/javascript\">\n" + "\t\n\t\t\t$(document).ready(function(){\n" + "\t\n\t\t\t\t$('#tcFilter').on('change',function(){" + "\t\n\t\t\t\t\tif($(this).val()=='pass'){" + "\t\n\t\t\t\t\t\t$('.pass').show();" + "\t\n\t\t\t\t\t\t$('.fail').hide();" + "\t\n\t\t\t\t\t\t$('.skip').hide();" + "\t\n\t\t\t\t\t\t$('.config').hide();" + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t\tif($(this).val()=='fail'){" + "\t\n\t\t\t\t\t\t$('.pass').hide();" + "\t\n\t\t\t\t\t\t$('.fail').show();" + "\t\n\t\t\t\t\t\t$('.skip').hide();" + "\t\n\t\t\t\t\t\t$('.config').hide();" + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t\tif($(this).val()=='skip'){" + "\t\n\t\t\t\t\t\t$('.pass').hide();" + "\t\n\t\t\t\t\t\t$('.fail').hide();" + "\t\n\t\t\t\t\t\t$('.skip').show();" + "\t\n\t\t\t\t\t\t$('.config').hide();" + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t\tif($(this).val()=='tests'){ " + "\t\n\t\t\t\t\t\t$('.pass').show(); " + "\t\n\t\t\t\t\t\t$('.fail').show();" + "\t\n\t\t\t\t\t\t$('.skip').show(); " + "\t\n\t\t\t\t\t\t$('.config').hide(); " + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t\tif($(this).val()=='config'){" + "\t\n\t\t\t\t\t\t$('.pass').hide();" + "\t\n\t\t\t\t\t\t$('.fail').hide();" + "\t\n\t\t\t\t\t\t$('.skip').hide();" + "\t\n\t\t\t\t\t\t$('.config').show();" + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t\tif($(this).val()=='all'){" + "\t\n\t\t\t\t\t\t$('.pass').show();" + "\t\n\t\t\t\t\t\t$('.fail').show();" + "\t\n\t\t\t\t\t\t$('.skip').show();" + "\t\n\t\t\t\t\t\t$('.config').show();" + "\t\n\t\t\t\t\t}" + "\t\n\t\t\t\t});" + "\t\n\t\t\t});" + "\t\n\t\t</script>" + " \n <script> " + " \n var chart; " + " \n var legend; " + " \n " + " \n var chartData = [ " + " \n { " + " \n 'status': 'Passed', " + " \n 'value': " + passCount + ", 'color':'#0F9D28' " + " \n }, " + " \n { " + " \n 'status': 'Failed', " + " \n 'value': " + failCount + ", 'color':'#DF0C12' " + " \n }, " + " \n { " + " \n 'status': 'Skipped', " + " \n 'value': " + skipCount + ", 'color':'#F3F24D' " + " \n } " + " \n ]; " + " \n " + " \n AmCharts.ready(function () { " + " \n // PIE CHART " + " \n chart = new AmCharts.AmPieChart(); " + " \n chart.dataProvider = chartData; " + " \n chart.titleField = 'status'; " + " \n chart.valueField = 'value'; " + " \n chart.outlineColor = '#FFFFFF'; " + " \n chart.outlineAlpha = 0.8; " + " \n chart.outlineThickness = 2; " + " \n chart.colorField = 'color'; " + " \n chart.balloonText = '[[title]]<br><span style=\"font-size:14px\"><b>[[status]]</b> ([[value]])</span>';" + " \n // this makes the chart 3D " + " \n chart.depth3D = 15; " + " \n chart.angle = 30; " + " \n " + " \n // WRITE " + " \n chart.write('chart'); " + " \n }); " + " \n   $(function() {" + " \n     $( '#tabs' ).tabs();" + " \n   });" + " \n </script> " + "\t\t</head>" + "\t\t<body>" + "\t\t\t<table id=\"mainTable\">" + "\t\t\t\t<tr id=\"header\" >" + "\t\t\t\t\t<td id=\"logo\"><img src=\"../" + TestDirectory.RESOURCESDIRName + "/" + TestDirectory.IMGDIRName + "/" + ReportLabels.KIRWALOGO.getLabel() + "\" alt=\"Logo\" height=\"70\" width=\"140\" /> " + "<br/>" + ReportLabels.CAPTION.getLabel() + "</td>\n" + " \t <td id=\"headertext\">\n" + ReportLabels.HEADER_TEXT.getLabel() + "\t\t\t\t\t\t<div style=\"padding-right:20px;float:right\"><img src=\"" + ReportLabels.PROJLOGO.getLabel() + "\" height=\"70\" width=\"140\" /> </i></div>" + "\t\t\t\t\t</td>\n" + "\t\t\t\t</tr>");
    }

    public static void printMenuLink(PrintWriter printWriter, int i) {
        printWriter.println("<tr id=\"container\">\n\t\t<td id=\"menu\">\n<ul>\t<li class=\"menuStyle\"><a href=\"../index.html\" >Index</a></li>\n");
        if(i == 1) {
            printWriter.println("\n <li class=\"menuStyle\"><a href=\"" + TestDirectory.RUNName + i + TestDirectory.SEP + "CurrentRun.html\" >" + "Run " + i + " </a></li>\n");
        } else {
            for(int var2 = 1; var2 <= i; ++var2) {
                if(var2 == i) {
                    printWriter.println("\n <li style=\"padding-top: 4px;padding-bottom: 4px;\"><a href=\"" + TestDirectory.RUNName + var2 + TestDirectory.SEP + "CurrentRun.html\" >" + "Run " + var2 + " </a></li>\n");
                    break;
                }

                printWriter.println("\n <li class=\"menuStyle\"><a href=\"" + TestDirectory.RUNName + var2 + TestDirectory.SEP + "CurrentRun.html\" >" + "Run " + var2 + " </a></li>\n");
            }
        }

        printWriter.println("\n </ul>\n </td>\n\n");
    }

    public static void printContent(PrintWriter printWriter, ArrayList<String> nameTests, List<ITestResult> passedTests, List<ITestResult> failedTests, List<ITestResult> skippedTests, long startTime, long endTime) {
        printWriter.println("<td id=\"content\">\n\t\t<div id='tabs' style=\"border-style: none;\"> \n\t\t  <ul> \n\t\t\t<li><a href='#tabs-1'>CHORME</a></li> \n\t\t\t<li><a href='#tabs-2'>FIREFOX</a></li>\n\t\t  </ul> ");
        printWriter.println("\n\t\t  <div id='tabs-1'> \n\t\t\t\t<div style=\"width:100%;\" id='myLineChart'>");
        printContentFollowBrowser(printWriter, passedTests, failedTests, skippedTests, startTime, endTime ,"CHROME_");
        printWriter.println("</div> \n\t\t  </div> \n\t\t  </div>");
        printWriter.println("\n\t\t  <div id='tabs-2'> \n\t\t\t<div style=\"width:100%;\" id='myBarChart'></div> \n\t\t  </div>");
        printWriter.println("\n\t\t</div>");
        printWriter.print("</td>\n </tr>");

        /*int var13 = passedTests.size() + failedTests.size() + skippedTests.size();
        printWriter.println("<td id=\"content\">\n\t\t<div class=\"info\">\n\t\t\tThe following pie chart demonstrates the percentage of Passed, Failed and Skipped Test Cases<br/>\n\t\t\tTime Taken for Executing below Test Cases: <b>" + getExecutionTime(startTime, endTime) + "</b> <br/>\n" + "\t\t\tCurrent Run Number: <b>Run " + 1 + "</b>\n" + "\t\t</div>\n" + "\t\t<div class=\"info\"><br/>" + "\t\t\t<b>Run Description</b>" + "\t\t\t<br/><br/>" + NXGReports.currentRunDescription + "\t\t</div>" + "\t\t<div>\n");
        if(TestDirectory.recordSuiteExecution) {
            printWriter.println("<p id=\"showmenu\">Click Me to Show/Hide the Execution Video</p><div id=\"video\" class=\"video\"><object classid=\"clsid:9BE31822-FDAD-461B-AD51-BE1D1C159921\" codebase=\"http://downloads.videolan.org/pub/videolan/vlc/latest/win32/axvlc.cab\" width=\"400\" height=\"300\" id=\"vlc\" events=\"True\"> <param name=\"Src\" value=\"suite.mov\"></param> <param name=\"ShowDisplay\" value=\"True\" ></param> <param name=\"AutoLoop\" value=\"no\"></param> <param name=\"AutoPlay\" value=\"no\"></param> <embed type=\"application/x-google-vlc-plugin\" name=\"vlcfirefox\" autoplay=\"no\" loop=\"no\" width=\"99%\" height=\"100%\" target=\"suite.mov\"></embed> </object></div>");
        } else {
            printWriter.println("<p id=\"showmenu\">No Video Recording Available</p>");
        }

        printWriter.println("\t\t<div class=\"chartStyle summary\" style=\"width: 32%;background-color: #3B9C9C;\">\n\t\t\t<b>Summary</b><br/><br/>\n\t\t\t<table>\n\t\t\t\t<tr>\n\t\t\t\t\t<td>Execution Date</td>\n\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n\t\t\t\t\t<td>" + Utils.getCurrentTime() + "</td>\n" + "\t\t\t\t</tr>\n" + "\t\t\t\t<tr>\n" + "\t\t\t\t\t<td>Total Test Cases</td>\n" + "\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n" + "\t\t\t\t\t<td>" + var13 + "</td>\n" + "\t\t\t\t</tr>\n" + "\t\t\t\t<tr>\n" + "\t\t\t\t\t<td>Passed</td>\n" + "\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n" + "\t\t\t\t\t<td>" + passedTests.size() + "</td>\n" + "\t\t\t\t</tr>\n" + "\t\t\t\t<tr>\n" + "\t\t\t\t\t<td>Failed</td>\n" + "\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n" + "\t\t\t\t\t<td>" + failedTests.size() + "</td>\n" + "\t\t\t\t</tr>\n" + "\t\t\t\t<tr>\n" + "\t\t\t\t\t<td>Skipped</td>\n" + "\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n" + "\t\t\t\t\t<td>" + skippedTests.size() + "</td>\n" + "\t\t\t\t</tr>\n" + "\t\t\t</table> \n" + "\t\t</div>" + "\t\t<div class=\"chartStyle\" style=\"text-align: left;margin-left: 30px;float: left;width: 60%;\">\n" + "\t\t\t<div id=\"chart\" style=\"height:300px;color:black;\"></div>\n" + "\t\t</div>\n" + "\t</div>\n" + " <div>\n");
        printWriter.println("<div style=\"float:left; color: #585858; font-size: 14px;\">\n\t\t<select id=\"tcFilter\" class=\"filter\">\n\t\t\t<option class=\"filterOption\" value=\"all\">All Methods</option>\n\t\t\t<option class=\"filterOption\" value=\"tests\">Test Methods</option>\n\t\t\t<option class=\"filterOption\" value=\"pass\">Passed Test Cases</option>\n\t\t\t<option class=\"filterOption\" value=\"fail\">Failed Test Cases</option>\n\t\t\t<option class=\"filterOption\" value=\"skip\">Skipped Test Cases</option>\n\t\t\t<option class=\"filterOption\" value=\"config\">Configuration Methods</option>\n\t\t</select>Filter The Methods Based on Selection</div>");
        printWriter.println("<table id=\"tableStyle\" class=\"chartStyle\" style=\"height:50px; float: left\">\n\t\t<tr>\t\t\t<th>Package Name</th>\n\t\t\t<th>Class Name</th>\n\t\t\t<th>Method Type</th>\n\t\t\t<th>Test Case Name</th>\n<th>Iteration</th>\t\t\t<th>Time</th>\n\t\t\t<th style=\"width: 7%\">Status</th>\n\t\t</tr>\n");
        writePassedData(printWriter, passedTests, 1);
        writeFailedData(printWriter, failedTests, 1);
        writeSkippedData(printWriter, skippedTests, 1);
        printWriter.print(" </table>\n </div>\n </td>\n </tr>");*/
    }

    public static void printFooter(PrintWriter printWriter) {
        printWriter.println("\t\t\t<tr id=\"footer\">\n\t\t\t\t\t\t\t<td colspan=\"2\">\n\t\t\t\t\t\t\t\tBest Viewed in &nbsp;\n\t\t\t\t\t\t\t\t<a href=\"http://www.mozilla.org/en-US/firefox/new/\">Firefox</a> &nbsp;\n\t\t\t\t\t\t\t\t<a href=\"http://www.apple.com/in/safari/\">Safari</a>&nbsp;\n\t\t\t\t\t\t\t\t<a href=\"http://www.google.com/chrome/\">Chrome</a>&nbsp;\n\t\t\t\t\t\t\t\t<a href=\"http://windows.microsoft.com/en-IN/internet-explorer/download-ie\">IE 9 & Above</a>&nbsp;\n\t\t\t\t\t\t\t&nbsp;\n\t\t\t\t\t\t\tNXG Reporter Version: v1.0.0&nbsp;\n\t\t\t\t\t\t\tReports by: <a href=\"http://seleniumbyneeds.blogspot.in/\">Selenium By Needs</a>\n\t\t\t\t\t</td>\n \t\t\t\t</tr>\n\t\t\t</table>\n\t\t</body>\n</html>");
    }

    private static void writeSkippedData(PrintWriter printWriter, List<ITestResult> skippedTests, int runNumber) {
        String strPass = "skip";
        Iterator var5 = skippedTests.iterator();

        while(var5.hasNext()) {
            ITestResult testResult = (ITestResult)var5.next();
            printWriter.print("<tr class=\"all " + strPass + "\">\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getPackageName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getClassName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getMethodType(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getTestCaseName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getIteration(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getExecutionTime(testResult) + "</a></td>\n" + "\t\t<td><img style=\"border: none; width: 25px\" src=\"../" + TestDirectory.RESOURCESDIRName + "/" + TestDirectory.IMGDIRName + "/skip.png\"></td>\n" + "\t</tr>\n");
            if(!testResult.getMethod().isTest()) {
                strPass = "config";
            }
        }

    }

    private static void writeFailedData(PrintWriter printWriter, List<ITestResult> failedTests, int runNumber) {
        String strPass = "fail";
        Iterator var5 = failedTests.iterator();

        while(var5.hasNext()) {
            ITestResult testResult = (ITestResult)var5.next();
            printWriter.print("<tr class=\"all " + strPass + "\">\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getPackageName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getClassName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getMethodType(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getTestCaseName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getIteration(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getExecutionTime(testResult) + "</a></td>\n" + "\t\t<td><img style=\"border: none; width: 25px\" src=\"../" + TestDirectory.RESOURCESDIRName + "/" + TestDirectory.IMGDIRName + "/fail.png\"></td>\n" + "\t</tr>\n");
            if(!testResult.getMethod().isTest()) {
                strPass = "config";
            }
        }

    }

    private static void writePassedData(PrintWriter printWriter, List<ITestResult> passedTests, int runNumber) {
        String strPass = "pass";
        Iterator var5 = passedTests.iterator();

        while(var5.hasNext()) {
            ITestResult testResult = (ITestResult)var5.next();
            printWriter.print("<tr class=\"all " + strPass + "\">\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getPackageName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getClassName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getMethodType(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getTestCaseName(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getIteration(testResult) + "</a></td>\n" + "\t\t<td><a href=\"" + getTestCaseHTMLPath(testResult, runNumber) + "\">" + getExecutionTime(testResult) + "</a></td>\n" + "\t\t<td><img style=\"border: none; width: 25px\" src=\"../" + TestDirectory.RESOURCESDIRName + "/" + TestDirectory.IMGDIRName + "/pass.png\"></td>\n" + "\t</tr>\n");
            if(!testResult.getMethod().isTest()) {
                strPass = "config";
            }
        }

    }

    private static String getExecutionTime(ITestResult testResult) {
        long var1 = testResult.getEndMillis() - testResult.getStartMillis();
        if(var1 > 1000L) {
            var1 /= 1000L;
            return var1 + " Sec";
        } else {
            return var1 + " Milli Sec";
        }
    }

    private static String getIteration(ITestResult testResult) {
        return testResult.getAttribute("iteration").toString();
    }

    private static String getTestCaseName(ITestResult testResult) {
        return testResult.getName();
    }

    public static String getMethodType(ITestResult testResult) {
        ITestNGMethod var1 = testResult.getMethod();
        return var1.isAfterClassConfiguration()?"After Class":(var1.isAfterGroupsConfiguration()?"After Groups":(var1.isAfterMethodConfiguration()?"After Method":(var1.isAfterSuiteConfiguration()?"After Suite":(var1.isAfterTestConfiguration()?"After Test":(var1.isBeforeClassConfiguration()?"Before Class":(var1.isBeforeGroupsConfiguration()?"Before Groups":(var1.isBeforeMethodConfiguration()?"Before Method":(var1.isBeforeSuiteConfiguration()?"Before Suite":(var1.isBeforeTestConfiguration()?"Before Test":(var1.isTest()?"Test Method":"Unknown"))))))))));
    }

    private static String getClassName(ITestResult testResult) {
        return testResult.getTestClass().getRealClass().getSimpleName();
    }

    private static String getTestCaseHTMLPath(ITestResult testResult, int runCount) {
        String reportDir = testResult.getAttribute("relativeReportDir").toString();
        return reportDir + TestDirectory.SEP + getTestCaseName(testResult) + ".html";
    }

    private static String getPackageName(ITestResult testResult) {
        return testResult.getTestClass().getRealClass().getPackage().getName();
    }

    private static String getExecutionTime(long startTime, long endTime) {
        long executionTime = endTime - startTime;
        if(executionTime > 1000L) {
            executionTime /= 1000L;
            return executionTime + " Sec";
        } else {
            return executionTime + " Milli Sec";
        }
    }

    private static void printContentFollowBrowser(PrintWriter printWriter, List<ITestResult> passedTests, List<ITestResult> failedTests, List<ITestResult> skippedTests, long startTime, long endTime, String browserName){
        int var13 = passedTests.size() + failedTests.size() + skippedTests.size();
        printWriter.println("\n\t\t<div class=\"info\" style=\"border-style: none;\" >\n\t\t\tThe following pie chart demonstrates the percentage of Passed, Failed and Skipped Test Cases<br/>\n\t\t\tTime Taken for Executing below Test Cases: <b>" + getExecutionTime(startTime, endTime) + "</b> <br/>\n" + "\t\t\tCurrent Run Number: <b>Run " + 1 + "</b>\n" + "\t\t</div>\n" + "\t\t<div class=\"info\" style=\"border-style: none;\"><br/>" + "\t\t\t<b>Run Description</b>" + "\t\t\t<br/><br/>" + NXGReports.currentRunDescription + "\t\t</div>" + "\t\t<div>\n");
        if(TestDirectory.recordSuiteExecution) {
            printWriter.println("<p id=\"showmenu\">Click Me to Show/Hide the Execution Video</p><div id=\"video\" class=\"video\"><object classid=\"clsid:9BE31822-FDAD-461B-AD51-BE1D1C159921\" codebase=\"http://downloads.videolan.org/pub/videolan/vlc/latest/win32/axvlc.cab\" width=\"400\" height=\"300\" id=\"vlc\" events=\"True\"> <param name=\"Src\" value=\"suite.mov\"></param> <param name=\"ShowDisplay\" value=\"True\" ></param> <param name=\"AutoLoop\" value=\"no\"></param> <param name=\"AutoPlay\" value=\"no\"></param> <embed type=\"application/x-google-vlc-plugin\" name=\"vlcfirefox\" autoplay=\"no\" loop=\"no\" width=\"99%\" height=\"100%\" target=\"suite.mov\"></embed> </object></div>");
        } else {
            printWriter.println("<p id=\"showmenu\">No Video Recording Available</p>");
        }

        printWriter.println("\t\t<div class=\"chartStyle summary\" style=\"width: 32%;background-color: #3B9C9C;\">\n\t\t\t<b>Summary</b><br/><br/>\n\t\t\t<table>\n\t\t\t\t<tr>\n\t\t\t\t\t<td>Execution Date</td>\n\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n\t\t\t\t\t<td>" + Utils.getCurrentTime() + "</td>\n" + "\t\t\t\t</tr>\n" + "\t\t\t\t<tr>\n" + "\t\t\t\t\t<td>Total Test Cases</td>\n" + "\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n" + "\t\t\t\t\t<td>" + var13 + "</td>\n" + "\t\t\t\t</tr>\n" + "\t\t\t\t<tr>\n" + "\t\t\t\t\t<td>Passed</td>\n" + "\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n" + "\t\t\t\t\t<td>" + passedTests.size() + "</td>\n" + "\t\t\t\t</tr>\n" + "\t\t\t\t<tr>\n" + "\t\t\t\t\t<td>Failed</td>\n" + "\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n" + "\t\t\t\t\t<td>" + failedTests.size() + "</td>\n" + "\t\t\t\t</tr>\n" + "\t\t\t\t<tr>\n" + "\t\t\t\t\t<td>Skipped</td>\n" + "\t\t\t\t\t<td>&nbsp;&nbsp;:&nbsp;&nbsp;</td>\n" + "\t\t\t\t\t<td>" + skippedTests.size() + "</td>\n" + "\t\t\t\t</tr>\n" + "\t\t\t</table> \n" + "\t\t</div>" + "\t\t<div class=\"chartStyle\" style=\"text-align: left;margin-left: 30px;float: left;width: 60%;\">\n" + "\t\t\t<div id=\"chart\" style=\"height:300px;color:black;\"></div>\n" + "\t\t</div>\n" + "\t</div>\n" + " <div>\n");
        printWriter.println("<div style=\"float:left; color: #585858; font-size: 14px;\">\n\t\t<select id=\"tcFilter\" class=\"filter\">\n\t\t\t<option class=\"filterOption\" value=\"all\">All Methods</option>\n\t\t\t<option class=\"filterOption\" value=\"tests\">Test Methods</option>\n\t\t\t<option class=\"filterOption\" value=\"pass\">Passed Test Cases</option>\n\t\t\t<option class=\"filterOption\" value=\"fail\">Failed Test Cases</option>\n\t\t\t<option class=\"filterOption\" value=\"skip\">Skipped Test Cases</option>\n\t\t\t<option class=\"filterOption\" value=\"config\">Configuration Methods</option>\n\t\t</select>Filter The Methods Based on Selection</div>");
        printWriter.println("<table id=\"tableStyle\" class=\"chartStyle\" style=\"height:50px; float: left\">\n\t\t<tr>\t\t\t<th>Package Name</th>\n\t\t\t<th>Class Name</th>\n\t\t\t<th>Method Type</th>\n\t\t\t<th>Test Case Name</th>\n<th>Iteration</th>\t\t\t<th>Time</th>\n\t\t\t<th style=\"width: 7%\">Status</th>\n\t\t</tr>\n");
        writePassedData(printWriter, passedTests, 1);
        writeFailedData(printWriter, failedTests, 1);
        writeSkippedData(printWriter, skippedTests, 1);
        printWriter.print("</table>");
    }

    private static int countStatusStepTest(List<ITestResult> testResult, String browserName){
        int count =0;
        for(int i=0; i<testResult.size();i++){
            if(GenericService.sBrowserTestNameList.equals(browserName)){
                count++;
            }
        }
        return count;
    }
}
