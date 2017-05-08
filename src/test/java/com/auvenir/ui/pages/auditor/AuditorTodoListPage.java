package com.auvenir.ui.pages.auditor;

import com.auvenir.ui.pages.common.AbstractPage;
import com.auvenir.ui.services.AbstractService;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by cuong.nguyen on 5/8/2017.
 */


    public class AuditorTodoListPage extends AbstractPage {



        public AuditorTodoListPage(Logger logger, WebDriver driver)
        {
            super(logger,driver);
        }


    public void verifyTodoListPage() {
    }

    public void verifyEmptyTodoList() {
    }
}
