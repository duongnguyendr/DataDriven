/***********************************************************************
 * @author            :		LAKSHMI BS
 * @description        : 		Generic utilities with reusable methods that can be used across porjects.
 * @method            :		getCongigValue()
 * @method            :		toReadExcelData()
 * @method            :		toWriteIntoExcel()
 * @method            :		setStatus()
 * @method
 */

package com.auvenir.utilities;

import com.auvenir.ui.services.AbstractService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.awt.*;
import java.util.List;
import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class GenericService {
    public static String sFile;
    public static int iPassCount = 0;
    public static int iFailCount = 0;
    public static int iSkippedCount = 0;
    static public String sDirPath = System.getProperty("user.dir");
    public static String sTestDataFile = sDirPath + "\\TestData.xlsx";
    public final static String MONGODBPROPERTIESFILE = sDirPath + "\\src\\test\\resources\\properties\\MongoDB.properties";
    public final static String LOCATORPROPERTIESFILE = sDirPath + "\\src\\test\\resources\\properties\\Locator.properties";
    public static String sConfigFile = null;
    public static String sExecutionDate = null;
    public static String sBrowserData = null;
    public static ArrayList sBrowserTestNameList = new ArrayList<String>();
    public static String [] browserAutomationTest = new String [] {"CHROME", "FIREFOX", "IE", "SAFARI"};

	/*
     * @author: LAKSHMI BS Description: To read the basic environment settings
	 * data from config file
	 */

    public static String getConfigValue(String sFile, String sKey) {
        Properties prop = new Properties();
        String sValue = null;
        try {
            InputStream input = new FileInputStream(sFile);
            prop.load(input);
            sValue = prop.getProperty(sKey);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sValue;
    }

    /*
     * @author: LAKSHMI BS Description: To write the basic environment settings
     * data from config file
     */
    public static void setConfigValue(String sFile, String sKey, String sValue) {
        Properties prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(new File(sFile));
            prop.load(fis);
            fis.close();

            FileOutputStream fos = new FileOutputStream(new File(sFile));
            prop.setProperty(sKey, sValue);
            prop.store(fos, "Updating folder path");
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * @author: LAKSHMI BS Description: To read tests data from excel sheet
     */
    public static String[] toReadExcelData(String sTestCaseID) {
        String sData[] = null;
        try {

            FileInputStream fis = new FileInputStream(sTestDataFile);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sht = wb.getSheet("TestData");
            int iRowNum = sht.getLastRowNum();
            int k = 0;
            for (int i = 1; i <= iRowNum; i++) {
                if (sht.getRow(i).getCell(0).toString().equals(sTestCaseID)) {
                    int iCellNum = sht.getRow(i).getLastCellNum();
                    sData = new String[iCellNum];
                    for (int j = 0; j < iCellNum; j++) {
                        sData[j] = sht.getRow(i).getCell(j).getStringCellValue();
                    }
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sData;
    }

    public static void getPieChart(int iPassCount, int iFailCount, int iSkippedCount) {
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("FAIL", new Integer(iFailCount));
        pieDataset.setValue("SKIP", new Integer(iSkippedCount));
        pieDataset.setValue("PASS", new Integer(iPassCount));

        JFreeChart piechart = ChartFactory.createPieChart("Pie Chart", pieDataset, true, true, false);
        PiePlot plot = (PiePlot) piechart.getPlot();

        plot.setSectionPaint("FAIL", Color.RED);
        plot.setSectionPaint("SKIP", Color.ORANGE);
        plot.setSectionPaint("PASS", new Color(192 * 85 + 192 * 104 + 192 * 47));
        plot.setBackgroundPaint(new Color(192 * 65536 + 192 * 256 + 192));
        plot.setExplodePercent("FAIL", 0.05);
        plot.setSimpleLabels(true);
        plot.setSectionOutlinesVisible(true);

        PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator("{0}: {1} ({2})", new DecimalFormat("0"),
                new DecimalFormat("0%"));
        plot.setLabelGenerator(gen);
        plot.setLabelFont(new Font("SansSerif", Font.BOLD, 12));
        try {
            ChartUtilities.saveChartAsJPEG(
                    new File(System.getProperty("user.dir") + "\\src\\test\\resources\\images\\PieChart.png"), piechart,
                    400, 400);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void getBarChart(int iPassCount, int iFailCount, int iSkippedCount) {
        final String series1 = "First";
        final String series2 = "Second";
        final String series3 = "Third";
        final String category1 = "Status";

        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        dataSet.addValue(iPassCount, series1, "Status");
        dataSet.addValue(iFailCount, series2, "Status");
        dataSet.addValue(iSkippedCount, series3, "Status");

        JFreeChart chart = ChartFactory.createBarChart("Bar Graph", "Execution Status", "Testcases", dataSet,
                PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot barplot = chart.getCategoryPlot();
        // barplot.setBackgroundPaint(paint);
        barplot.setBackgroundPaint(Color.white);
        barplot.setBackgroundPaint(new Color(192 * 65536 + 192 * 256 + 192));

        barplot.setDomainGridlinePaint(Color.white);

        NumberAxis rangeAxis = (NumberAxis) barplot.getRangeAxis();
        rangeAxis.setRange(0.0, 70.0);
        rangeAxis.setTickUnit(new NumberTickUnit(10));
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setAutoRangeIncludesZero(true);

        final BarRenderer renderer = (BarRenderer) barplot.getRenderer();
        renderer.setDrawBarOutline(false);
        renderer.setMaximumBarWidth(0.20);

        // set up gradient paints for series...
        final GradientPaint gp0 = new GradientPaint(0.0f, 0.0f, new Color(192 * 85 + 192 * 104 + 192 * 47), 0.0f, 0.0f,
                Color.lightGray);
        final GradientPaint gp1 = new GradientPaint(

                0.0f, 0.0f, Color.red, 0.0f, 0.0f, Color.lightGray);

        final GradientPaint gp2 = new GradientPaint(0.0f, 0.0f, Color.orange, 0.0f, 0.0f, Color.lightGray);
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);

        try {
            ChartUtilities.saveChartAsJPEG(
                    new File(System.getProperty("user.dir") + "\\src\\test\\resources\\images\\BarChart.png"), chart,
                    400, 400);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void sendMail(int iPassCount, int iFailCount, int skippedCount, int iTotalExecuted, File pdfReports, ArrayList sTestName, ArrayList sStatus) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        sExecutionDate = simpleDateFormat.format(date);
        Properties properties = new Properties();
        List<String> sTestNameList = PdfGenerater.getTestNameList(sTestName);
        ArrayList<Integer> listTestCasePassed = new ArrayList<>();
        ArrayList<Integer> listTestCaseFailed = new ArrayList<>();
        ArrayList<Integer> listTestCaseSkipped = new ArrayList<>();
        String passedRow = "";
        String failedRow = "";
        String skippedRow = "";
        for(int i=0; i<browserAutomationTest.length; i++){
            if(PdfGenerater.checkBrowserIsSkip(browserAutomationTest[i],sBrowserTestNameList)){
                listTestCasePassed.add(0);
            }else{
                listTestCasePassed.add(PdfGenerater.countTotalTestNameStatusFollowBrowser(sTestName, sBrowserTestNameList,
                        browserAutomationTest[i], sStatus, "Passed"));
            }
        }
        for(int i=0; i<browserAutomationTest.length; i++){
            if(PdfGenerater.checkBrowserIsSkip(browserAutomationTest[i],sBrowserTestNameList)){
                listTestCaseFailed.add(0);
            }else{
                listTestCaseFailed.add(PdfGenerater.countTotalTestNameStatusFollowBrowser(sTestName, sBrowserTestNameList,
                        browserAutomationTest[i], sStatus, "Failed"));
            }
        }
        for(int i=0; i<browserAutomationTest.length; i++){
            int totalTestCase = sTestNameList.size();
            int totalPassedCount = 0;
            int totalFailedCount = 0;
            int totalSkippedCase = 0;
            if(!PdfGenerater.checkBrowserIsSkip(browserAutomationTest[i],sBrowserTestNameList)){
                totalPassedCount = PdfGenerater.countTotalTestNameStatusFollowBrowser(sTestName, GenericService.sBrowserTestNameList,
                        browserAutomationTest[i], sStatus, "Passed");
                totalFailedCount = PdfGenerater.countTotalTestNameStatusFollowBrowser(sTestName, GenericService.sBrowserTestNameList,
                        browserAutomationTest[i], sStatus, "Failed");
                totalSkippedCase = PdfGenerater.countTotalTestNameStatusFollowBrowser(sTestName, GenericService.sBrowserTestNameList,
                        browserAutomationTest[i], sStatus, "Skipped");
            }
            listTestCaseSkipped.add(totalTestCase - (totalSkippedCase + totalPassedCount + totalFailedCount));
        }
        for(int i = 0; i < listTestCasePassed.size(); i++){
            passedRow += "<td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">" + listTestCasePassed.get(i) + "</td>";
        }
        for(int i = 0; i < listTestCaseFailed.size(); i++){
            failedRow += "<td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">" + listTestCaseFailed.get(i) + "</td>";
        }
        for(int i = 0; i < listTestCaseSkipped.size(); i++){
            skippedRow += "<td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">" + listTestCaseSkipped.get(i) + "</td>";
        }
        String message = "<p>Team,</p><div style=\"font-family:Verdana;\">Find the tests automation execution status as below. For detail information, find the attached pdf file.</div><p></p><p></p><p></p><p></p>"
                + "<p><div style=\"font-family:Verdana;\"><b> EXECUTION SUMMARY : </b></div></p>"
                + "<table bgcolor=\"#BDE4F6\" style=\"border-radius: 20px; padding: 25px;\"><tr><td>&nbsp;&nbsp;&nbsp;<table style=\"height:180px; width:200px; border-width:2px; border-style:groove; float: left\"><tbody>"
                + "<tr style=\"outline: thin solid; font-family:Verdana; color: #000000; text-align: left; border-width:2px; \"><th style=\"outline: thin solid;\">Total Executed</th><td style=\"outline: thin solid; font-weight: bold;\">&nbsp;&nbsp;"
                + iTotalExecuted + "&nbsp;&nbsp;</td></tr>"
                + "<tr style=\"outline: thin solid;  font-family:Verdana; color: #000000; text-align: left; border-width:2px; \"><th style=\"outline: thin solid;\">Passed</th><td style=\"outline: thin solid; font-weight: bold;\">&nbsp;&nbsp;"
                + iPassCount + "&nbsp;&nbsp;</td></tr>"
                + "<tr style=\"outline: thin solid; font-family:Verdana; color: #000000; text-align: left; border-width:2px; \"><th style=\"outline: thin solid;\">Failed</th><td style=\"color: Red; outline: thin solid; font-weight: bold;\">&nbsp;&nbsp;"
                + iFailCount + "&nbsp;&nbsp;</td></tr>"
                + "<tr style=\"outline: thin solid; font-family:Verdana; color: #000000; text-align: left; border-width:2px; \"><th style=\"outline: thin solid;\">Skipped</th><td style=\"outline: thin solid; font-weight: bold;\">&nbsp;&nbsp;"
                + skippedCount + "&nbsp;&nbsp;</td></tr>" + "</tbody></table></td>" + "&nbsp;&nbsp;&nbsp;"
                + "<td><img src=\"cid:image\" style=\"height:200px; width: 200px; outline: thin solid;\"></td></tr></table><p></p><p></p><p></p><p></p>"
                + "<p><div style=\"font-family:Verdana;\"><b> EXECUTION SUMMARY FOR BROWSER: </b></div></p>"
                + "<table style=\"border: 1px solid black;border-collapse: collapse;\"><col width=\"130\"><col width=\"80\"><col width=\"80\"><col width=\"80\"><col width=\"80\">"
                + "<tr style=\"border: 1px solid black;border-collapse: collapse; padding: 5px;text-align: left\">"
                + "<th style=\"border: 1px solid black;border-collapse: collapse; padding: 5px;text-align: left\">Test Summary</th>"
                + "<th style=\"border: 1px solid black;border-collapse: collapse; padding: 5px;text-align: left\">CHROME</th>"
                + "<th style=\"border: 1px solid black;border-collapse: collapse; padding: 5px;text-align: left\" >FIREFOX</th>"
                + "<th style=\"border: 1px solid black;border-collapse: collapse; padding: 5px;text-align: left\">IE</th>"
                + "<th style=\"border: 1px solid black;border-collapse: collapse; padding: 5px;text-align: left\">SAFARY</th></tr>"
                + "<tr><td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">Total Test case</td>"
                + "<td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">" + sTestNameList.size() + "</td>"
                + "<td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">" + sTestNameList.size() + "</td>"
                + "<td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">" + sTestNameList.size() + "</td>"
                + "<td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">" + sTestNameList.size() + "</td></tr>"
                + "<tr><td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">Passed</td>"
                + passedRow
                + "</tr>"
                + "<tr><td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">Failed</td>"
                + failedRow
                + "</tr>"
                + "<tr><td style=\"border: 1px solid black;border-collapse: collapse;padding: 5px;text-align: left;\">Skiped</td>"
                + skippedRow
                + "</tr></table>"
                + "<p></p><div style=\"font-family:Verdana;\">Regards,</div><p></p>"
                + "<div style=\"font-family:Verdana;\">Automation Team</div>";
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.debug", "true");
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(GenericService.getConfigValue(GenericService.sConfigFile, "FROM_EMAILID"),
                        GenericService.getConfigValue(GenericService.sConfigFile, "FROM_PWD"));
            }
        });
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(GenericService.getConfigValue(GenericService.sConfigFile, "FROM_EMAILID")));
            msg.setRecipients(Message.RecipientType.TO,
                    GenericService.getConfigValue(GenericService.sConfigFile, "TO_EMAILID"));
            msg.setRecipients(Message.RecipientType.CC,
                    GenericService.getConfigValue(GenericService.sConfigFile, "CC_EMAILID"));
            // msg.setSubject("Auvenir_Execution_Report_"+GenericService.getCongigValue(GenericService.sConfigFile,"EXECUTION_REPORT_DATE"));
            /*msg.setSubject("Auvenir Execution Report on " + GenericService.getConfigValue(GenericService.sConfigFile, "SERVER")
                    + " " + sExecutionDate);*/
            msg.setSubject("Auvenir Execution Report on " + GenericService.getConfigValue(GenericService.sConfigFile, AbstractService.baseUrl)
                    + " " + sExecutionDate);
                    msg.setSentDate(new Date());
            Multipart multipart = new MimeMultipart();
            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setContent(message, "text/html");
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            DataSource fds = new FileDataSource(
                    System.getProperty("user.dir") + "\\src\\test\\resources\\images\\PieChartCHROME.png");
            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setHeader("Content-ID", "<image>");
            multipart.addBodyPart(textPart);
            multipart.addBodyPart(messageBodyPart);
            MimeBodyPart attachementPart = new MimeBodyPart();
            // attachementPart.attachFile(new File(pdfReports));
            attachementPart.attachFile(pdfReports);
            multipart.addBodyPart(attachementPart);
            msg.setContent(multipart);
            Transport.send(msg);
            System.out.println("Mail Sent Successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private static String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * Generate radom password
     * @param lenght
     * @return
     */
    public static String genPassword(int lenght, boolean isContainsUpperCase, boolean isContainsLowerCase, boolean isContainsDigit) {
        Random r = new Random();
        while (true) {
            char[] password = new char[lenght];
            boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;
            for (int i = 0; i < password.length; i++) {
                char ch = symbols.charAt(r.nextInt(symbols.length()));
                if (isContainsUpperCase && Character.isUpperCase(ch))
                    hasUpper = true;
                else if (isContainsLowerCase && Character.isLowerCase(ch))
                    hasLower = true;
                else if (isContainsDigit && Character.isDigit(ch))
                    hasDigit = true;
                password[i] = ch;
            }
            if (hasUpper && hasLower && hasDigit) {
                return new String(password);
            }
        }
    }

    /**
     * Parse Rgb to color to hex
     * @param rgb
     * @return
     */
    public static String parseRgbTohex(String rgb) {
        String value = null;
        try {
            int indexOpen = rgb.indexOf("(");
            rgb = rgb.substring(indexOpen + 1, rgb.length() - 1);

            String[] temp = rgb.split(",");

            int r = Integer.parseInt(temp[0].trim());
            int g = Integer.parseInt(temp[1].trim());
            int b = Integer.parseInt(temp[2].trim());


            value = String.format("#%02x%02x%02x", r, g, b);
        } catch (Exception e) {
        }
        return value;
    }

    /**
     * Validate email address
     * @param email
     * @return
     */
    public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
    /**
     * @param fileName
     * @param sheetName
     * @param numberColumn
     * @param numberRow
     * @return
     */
    public static String readExcelData(String fileName, String sheetName, int numberColumn, int numberRow) {
        String cellValue = null;
        try {
            // Read the spreadsheet
            FileInputStream fis = new FileInputStream(fileName);

            // Using XSSF for xlsx format, for xls use HSSF
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            cellValue = String.valueOf(sheet.getRow(numberRow).getCell(numberColumn).getStringCellValue());
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cellValue;
    }

    /**
     * @param fileName
     * @param sheetName
     * @param numberColumn
     * @param numberRow
     * @param data
     */
    public static void updateExcelData(String fileName, String sheetName, int numberColumn, int numberRow, String data) {
        try {
            //Read the spreadsheet that needs to be updated
            FileInputStream fis = new FileInputStream(fileName);

            // Using XSSF for xlsx format, for xls use HSSF
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            sheet.getRow(numberRow).getCell(numberColumn).setCellValue(data);

            //write this workbook in excel file.
            FileOutputStream fos = new FileOutputStream(fileName);
            workbook.write(fos);
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Get browser list not duplicate
     * @return browser list
     */
    private static List<String> getBrowserList(){
        java.util.List<String> result = new ArrayList<String>();
        int totalRow = sBrowserTestNameList.size();
        for(int i=0; i<totalRow; i++){
            if(!result.contains(sBrowserTestNameList.get(i).toString())){
                result.add(sBrowserTestNameList.get(i).toString());
            }
        }
        return result;
    }

    /**
     * Count total test name follow status
     * @param sTestNames : test name list
     * @param sBrowserList : browser list
     * @param sBrowser : browser need check
     * @param sStatus : status test name list
     * @param statusTest : status need check
     * @return 0 | >0
     */
    private static int countTotalTestNameStatusFollowBrowser(ArrayList sTestNames,
                                                             ArrayList sBrowserList, String sBrowser,
                                                             ArrayList sStatus, String statusTest){
        int count =0 ;
        for (int i = 0; i < sTestNames.size(); i++) {
            if (sBrowserList.get(i).equals(sBrowser) &&
                    sStatus.get(i).equals(statusTest)){
                count++;
            }
        }
        return  count;
    }

    /**
     * Get pie chart follow browser list
     * Author : TanPham 01/06/2017
     * @param sTestNames : test name list
     * @param sStatus : status test name list
     */
    public static void getPieChartFollowBrowser(ArrayList sTestNames,ArrayList sStatus) {
        List<String> browserList = getBrowserList();
        int totalBrowser = browserList.size();
        for(int i=0; i<totalBrowser; i++){

            iPassCount = countTotalTestNameStatusFollowBrowser(sTestNames,
                    sBrowserTestNameList,browserList.get(i),
                    sStatus, "Passed");

            iFailCount = countTotalTestNameStatusFollowBrowser(sTestNames,
                                                                sBrowserTestNameList,browserList.get(i),
                                                                sStatus, "Failed");

            iSkippedCount = countTotalTestNameStatusFollowBrowser(sTestNames,
                                                                  sBrowserTestNameList,browserList.get(i),
                                                                  sStatus, "Skipped");

            String browserName = browserList.get(i).substring(0,browserList.get(i).length()-1);
            DefaultPieDataset pieDataset = new DefaultPieDataset();
            pieDataset.setValue("FAIL", new Integer(iFailCount));
            pieDataset.setValue("SKIP", new Integer(iSkippedCount));
            pieDataset.setValue("PASS", new Integer(iPassCount));

            JFreeChart piechart = ChartFactory.createPieChart("Pie Chart", pieDataset, true, true, false);
            PiePlot plot = (PiePlot) piechart.getPlot();

            plot.setSectionPaint("FAIL", Color.RED);
            plot.setSectionPaint("SKIP", Color.ORANGE);
            plot.setSectionPaint("PASS", new Color(192 * 85 + 192 * 104 + 192 * 47));
            plot.setBackgroundPaint(new Color(192 * 65536 + 192 * 256 + 192));
            plot.setExplodePercent("FAIL", 0.05);
            plot.setSimpleLabels(true);
            plot.setSectionOutlinesVisible(true);

            PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator("{0}: {1} ({2})", new DecimalFormat("0"),
                    new DecimalFormat("0%"));
            plot.setLabelGenerator(gen);
            plot.setLabelFont(new Font("SansSerif", Font.BOLD, 12));
            try {
                ChartUtilities.saveChartAsJPEG(
                        new File(System.getProperty("user.dir") + "\\src\\test\\resources\\images\\PieChart"+ browserName +".png"), piechart,
                        400, 400);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * Get bar chart follow browser list
     * Author : TanPham 01/06/2017
     * @param sTestNames : test name list
     * @param sStatus : status test name list
     */
    public static void getBarChartFollowBrowser(ArrayList sTestNames,ArrayList sStatus) {
        List<String> browserList = getBrowserList();
        int totalBrowser = browserList.size();
        for (int i = 0; i < totalBrowser; i++) {
            final String series1 = "First";
            final String series2 = "Second";
            final String series3 = "Third";
            final String category1 = "Status";

            iPassCount = countTotalTestNameStatusFollowBrowser(sTestNames,
                    sBrowserTestNameList,browserList.get(i),
                    sStatus, "Passed");

            iFailCount = countTotalTestNameStatusFollowBrowser(sTestNames,
                    sBrowserTestNameList,browserList.get(i),
                    sStatus, "Failed");

            iSkippedCount = countTotalTestNameStatusFollowBrowser(sTestNames,
                    sBrowserTestNameList,browserList.get(i),
                    sStatus, "Skipped");

            String browserName = browserList.get(i).substring(0,browserList.get(i).length()-1);

            DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
            dataSet.addValue(iPassCount, series1, "Status");
            dataSet.addValue(iFailCount, series2, "Status");
            dataSet.addValue(iSkippedCount, series3, "Status");

            JFreeChart chart = ChartFactory.createBarChart("Bar Graph" , "Execution Status", "Testcases", dataSet,
                    PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot barplot = chart.getCategoryPlot();
            // barplot.setBackgroundPaint(paint);
            barplot.setBackgroundPaint(Color.white);
            barplot.setBackgroundPaint(new Color(192 * 65536 + 192 * 256 + 192));

            barplot.setDomainGridlinePaint(Color.white);

            NumberAxis rangeAxis = (NumberAxis) barplot.getRangeAxis();
            rangeAxis.setRange(0.0, 70.0);
            rangeAxis.setTickUnit(new NumberTickUnit(10));
            rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
            rangeAxis.setAutoRangeIncludesZero(true);

            final BarRenderer renderer = (BarRenderer) barplot.getRenderer();
            renderer.setDrawBarOutline(false);
            renderer.setMaximumBarWidth(0.20);

            // set up gradient paints for series...
            final GradientPaint gp0 = new GradientPaint(0.0f, 0.0f, new Color(192 * 85 + 192 * 104 + 192 * 47), 0.0f, 0.0f,
                    Color.lightGray);
            final GradientPaint gp1 = new GradientPaint(

                    0.0f, 0.0f, Color.red, 0.0f, 0.0f, Color.lightGray);

            final GradientPaint gp2 = new GradientPaint(0.0f, 0.0f, Color.orange, 0.0f, 0.0f, Color.lightGray);
            renderer.setSeriesPaint(0, gp0);
            renderer.setSeriesPaint(1, gp1);
            renderer.setSeriesPaint(2, gp2);

            try {
                ChartUtilities.saveChartAsJPEG(
                        new File(System.getProperty("user.dir") + "\\src\\test\\resources\\images\\BarChart"+ browserName +".png"), chart,
                        400, 400);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /** huyhuynh 01/06/2017
     * get all data on given sheet into 2-dimension array
     *
     * @param sheetName sheet which we want to get data
     */
    public static String[][] readExcelSheetData(String sheetName) {
        String data[][] = null;
        try {
            FileInputStream fis = new FileInputStream(GenericService.sTestDataFile);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheet(sheetName);

            //System.out.println("sheetName = " + sheetName);
            int rowCount = sheet.getLastRowNum();
            data = new String[rowCount][sheet.getRow(0).getLastCellNum()];
            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    data[i - 1][j] = row.getCell(j).getStringCellValue();
                    //System.out.print(row.getCell(j).getStringCellValue() + "/");
                }
                //System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    /* ===================================================================
     * @author: LAKSHMI BS Description: To read tests data from excel sheet
     * Edited by Doai.Tran
     =================================================================== */
    public static String[] toReadExcelData(String sTestCaseID, String SheetName) {
        String sData[] = null;
        try {
            FileInputStream fis = new FileInputStream(GenericService.sTestDataFile);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sht = wb.getSheet(SheetName);

            System.out.println(SheetName);
            int iRowNum = sht.getLastRowNum();
            int k = 0;
            for (int i = 1; i <= iRowNum; i++) {
                if (sht.getRow(i).getCell(0).toString().equals(sTestCaseID)) {
                    int iCellNum = sht.getRow(i).getLastCellNum();
                    sData = new String[iCellNum];
                    System.out.println("Row: " + i);
                    System.out.println("The number of Columns:" + iCellNum);
                    for (int j = 1; j <= iCellNum; j++) {
                        sData[j] = sht.getRow(i).getCell(j).getStringCellValue();
                        System.out.println(sData[j]);
                    }
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sData;
    }

    /**
     * Description: This method to read from Excel file to
     *              get the value of userID following Chrome parameter
     *              that we input on testNG.XML
     *              Data file: TestData.xlsx
     * @param SheetName
     * @param sTestCaseID
     * @param userRole
     * @return
     */
    public static String getUserFromExcelData(String SheetName,String sTestCaseID, String userRole){
        String userData = null;
        try{
            String userDataExcel=null;
            FileInputStream fis = new FileInputStream(GenericService.sTestDataFile);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sht = wb.getSheet(SheetName);
            System.out.println(SheetName);
            int iRowNum = sht.getLastRowNum();
            int k = 0;
            for (int i = 1; i <= iRowNum; i++) {
                if (sht.getRow(i).getCell(0).toString().equals(sTestCaseID)) {
                    int iCellNum = sht.getRow(i).getLastCellNum();
                    System.out.println("Row: " + i);
                    System.out.println("The number of Columns:" + iCellNum);
                    System.out.println(userRole);
                    for (int j = 1; j <= iCellNum; j++) {
                        if(sht.getRow(0).getCell(j).toString().equals(userRole)){
                            userDataExcel = sht.getRow(i).getCell(j).getStringCellValue();
                            System.out.println("Data login: "+userDataExcel);
                            break;
                        }
                    }
                    break;
                }
            }
            userData = GenericService.sBrowserData+ userDataExcel;
        }catch (Exception e){
            e.printStackTrace();
        }
        return userData;
    }
}