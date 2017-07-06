package com.auvenir.utilities.listeners;

import com.auvenir.utilities.GenericService;
import org.testng.ISuite;
import org.testng.ISuiteListener;

/**
 * Created by duong.nguyen on 6/5/2017.
 */
public class SuiteListener implements ISuiteListener{
    public void onStart(ISuite suite) {
    }

    public void onFinish(ISuite suite) {
        // send report...

        TestngListener.pdf.toExecute(TestngListener.sTestName, TestngListener.sDescription, TestngListener.sStatus, TestngListener.iPassCount, TestngListener.iFailCount, TestngListener.iSkippedCount, TestngListener.pdfReports);
        GenericService.sendMail(TestngListener.iPassCount, TestngListener.iFailCount, TestngListener.iSkippedCount, TestngListener.iTotalExecuted, TestngListener.pdfReports, TestngListener.sTestName, TestngListener.sStatus);
    }
}
