package htmlreport.com.nxgreport.writer;

import htmlreport.com.nxgreport.utils.TestDirectory;

import java.io.*;

/**
 * Created by tan.pham on 6/26/2017.
 */
public class ResourceFilesWriter {
    public ResourceFilesWriter() {
    }

    public static void writeCSS() {
        copyFile("styles/design.css", TestDirectory.CSSDIR);
        copyFile("styles/jquery-ui.min.css", TestDirectory.CSSDIR);
    }

    public static void writeIMG() {
        copyImage("images/fail.png", TestDirectory.IMGDIR);
        copyImage("images/pass.png", TestDirectory.IMGDIR);
        copyImage("images/skip.png", TestDirectory.IMGDIR);
        copyImage("images/loginfo.png", TestDirectory.IMGDIR);
        copyImage("images/logpass.png", TestDirectory.IMGDIR);
        copyImage("images/logfail.png", TestDirectory.IMGDIR);
        copyImage("images/logwarning.png", TestDirectory.IMGDIR);
        copyImage("images/NXGlogo.png", TestDirectory.IMGDIR);
    }

    public static void writeJS() {
        copyFile("js/excanvas.js", TestDirectory.JSDIR);
        copyFile("js/pie.js", TestDirectory.JSDIR);
        copyFile("js/serial.js", TestDirectory.JSDIR);
        copyFile("js/amcharts.js", TestDirectory.JSDIR);
        copyFile("js/jquery.min.js", TestDirectory.JSDIR);
        copyFile("js/jquery-ui.min.js", TestDirectory.JSDIR);
    }

    private static void copyFile(String path, String directory) {
        File file = new File(path);
        InputStream fileinputStream = com.kirwa.nxgreport.writer.ResourceFilesWriter.class.getClassLoader().getResourceAsStream(path);
        FileOutputStream fileOutputStream = null;

        try {
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
        InputStream fileinputStream = com.kirwa.nxgreport.writer.ResourceFilesWriter.class.getClassLoader().getResourceAsStream(path);
        FileOutputStream fileOutputStream = null;

        try {
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
