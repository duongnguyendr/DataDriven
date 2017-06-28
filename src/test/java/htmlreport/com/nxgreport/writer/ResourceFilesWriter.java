package htmlreport.com.nxgreport.writer;

import com.auvenir.ui.pages.marketing.MarketingPage;
import com.auvenir.ui.tests.AbstractTest;
import com.auvenir.utilities.GenericService;
import htmlreport.com.nxgreport.utils.TestDirectory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.*;

/**
 * Created by tan.pham on 6/26/2017.
 */
public class ResourceFilesWriter {
    public ResourceFilesWriter() {
    }


    public static void writeCSS() {
        //Update code replace reloaded class function of source code
        copyFile(GenericService.sDirPath +"/src/test/java/htmlreport/styles/design.css", TestDirectory.CSSDIR);
        copyFile(GenericService.sDirPath +"/src/test/java/htmlreport/styles/jquery-ui.min.css", TestDirectory.CSSDIR);
    }

    public static void writeIMG() {
        //Update code replace reloaded class function of source code
        copyImage(GenericService.sDirPath + "/src/test/java/htmlreport/images/fail.png", TestDirectory.IMGDIR);
        copyImage(GenericService.sDirPath + "/src/test/java/htmlreport/images/pass.png", TestDirectory.IMGDIR);
        copyImage(GenericService.sDirPath + "/src/test/java/htmlreport/images/skip.png", TestDirectory.IMGDIR);
        copyImage(GenericService.sDirPath + "/src/test/java/htmlreport/images/loginfo.png", TestDirectory.IMGDIR);
        copyImage(GenericService.sDirPath + "/src/test/java/htmlreport/images/logpass.png", TestDirectory.IMGDIR);
        copyImage(GenericService.sDirPath + "/src/test/java/htmlreport/images/logfail.png", TestDirectory.IMGDIR);
        copyImage(GenericService.sDirPath + "/src/test/java/htmlreport/images/logwarning.png", TestDirectory.IMGDIR);
        copyImage(GenericService.sDirPath + "/src/test/java/htmlreport/images/NXGlogo.png", TestDirectory.IMGDIR);
        copyImage(GenericService.sDirPath + "/src/test/java/htmlreport/images/Auvenir_01.png", TestDirectory.IMGDIR);
    }

    public static void writeJS() {
        //Update code replace reloaded class function of source code
        copyFile(GenericService.sDirPath + "/src/test/java/htmlreport/js/excanvas.js", TestDirectory.JSDIR);
        copyFile(GenericService.sDirPath + "/src/test/java/htmlreport/js/pie.js", TestDirectory.JSDIR);
        copyFile(GenericService.sDirPath + "/src/test/java/htmlreport/js/serial.js", TestDirectory.JSDIR);
        copyFile(GenericService.sDirPath + "/src/test/java/htmlreport/js/amcharts.js", TestDirectory.JSDIR);
        copyFile(GenericService.sDirPath + "/src/test/java/htmlreport/js/jquery.min.js", TestDirectory.JSDIR);
        copyFile(GenericService.sDirPath + "/src/test/java/htmlreport/js/jquery-ui.min.js", TestDirectory.JSDIR);
    }

    private static void copyFile(String path, String directory) {
        File file = new File(path);
        InputStream fileinputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileinputStream = new FileInputStream(path);
            fileOutputStream = new FileOutputStream(directory + TestDirectory.SEP + file.getName());

            int tmpbit;
            while((tmpbit = fileinputStream.read()) >= 0) {
                fileOutputStream.write(tmpbit);
            }
        } catch (FileNotFoundException var16) {
            ;
        } catch (IOException var17) {
            ;
        } finally {
            try {
                fileinputStream.close();
                fileOutputStream.close();
                file = null;
            } catch (Exception var15) {
                fileinputStream = null;
                fileOutputStream = null;
                file = null;
            }

        }

    }

    private static void copyImage(String path, String directory) {
        File file = new File(path);
        InputStream fileinputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileinputStream = new FileInputStream(path);
            fileOutputStream = new FileOutputStream(directory + TestDirectory.SEP + file.getName());

            int tmpBit;
            while((tmpBit = fileinputStream.read()) >= 0) {
                fileOutputStream.write(tmpBit);
            }
        } catch (FileNotFoundException var16) {
            ;
        } catch (IOException var17) {
            ;
        } finally {
            try {
                fileinputStream.close();
                fileOutputStream.close();
                file = null;
            } catch (Exception var15) {
                fileinputStream = null;
                fileOutputStream = null;
                file = null;
            }

        }

    }
}
