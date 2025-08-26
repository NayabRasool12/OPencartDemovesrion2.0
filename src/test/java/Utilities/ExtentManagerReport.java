package Utilities;

import testBase.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.BaseClassFinder;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExtentManagerReport implements ITestListener {

    public static ExtentSparkReporter sparkReporter;
    public static  ExtentReports extent ;
    public static ExtentTest test;
    String repName;

    public void onStart(ITestContext context) {


       /* String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName = "Test-Report-" + timeStamp + ".html";
        sparkReporter = new ExtentSparkReporter(".\\reports" + repName); // speficfy location of the report
        */
       sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "\\reports\\nayab.html");
        sparkReporter.config().setDocumentTitle("Open cart automation Testing ");     // title oo the report
        sparkReporter.config().setReportName(" Open cart functional Testing Nayab "); // Name of the report 
        sparkReporter.config().setTheme(Theme.DARK);


        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application" , "opencart");
        extent.setSystemInfo("Module" , "Admin");
        extent.setSystemInfo("Sub Module" , "Customers");
        extent.setSystemInfo(" user name" , System.getProperty("Nayab"));
        extent.setSystemInfo(" Environment" , "QA");


        String os = context.getCurrentXmlTest().getParameter("os"); // os report 
        extent.setSystemInfo("Operating System" , os);

        String browser = context.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("browser" , browser);

        List<String> includedGroups = context.getCurrentXmlTest().getIncludedGroups();
        if(!includedGroups.isEmpty()){
            extent.setSystemInfo("Groups",includedGroups.toString());
        }
    }
    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getClass().getName());
        test.assignCategory(result.getMethod().getGroups()); //  to display group report 

        test.log(Status.PASS,result.getName() +" got successfully Excuted");

    }

   public void onTestFailure(ITestResult result) {
       test = extent.createTest(result.getClass().getName());
       test.assignCategory(result.getMethod().getGroups()); // TO DISPLAY GROUPS IN REPORT

       test.log(Status.FAIL,result.getName() +" got failed");
       test.log(Status.INFO, result.getThrowable().getMessage());

       try {
           String imgPath = new BaseClass().captureScreen(result.getName());
           test.addScreenCaptureFromPath(imgPath);
           }
       catch (IOException e1){
           e1.printStackTrace();
       }
   }

    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getClass().getName());
        test.assignCategory(result.getMethod().getGroups());    // TO DISPLAY GROUPS IN REPORT
        test.log(Status.SKIP,result.getName() +" got  skipped");
        test.log(Status.INFO, result.getThrowable().getMessage());
    }

   public void onFinish(ITestContext context) {
        extent.flush();


       // automaticaly report open
        String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\nayab.html";
       File extentReport = new File(pathOfExtentReport);
       try {
           Desktop.getDesktop().browse(extentReport.toURI());
       }catch (IOException e){
           e.printStackTrace();
       }
   /*

          email report
       try {
           URL url = new URL("file://"+ System.getProperty("user.dir")+ "\\reports\\"+repName);

           // creating emai; message
           ImageHtmlEmail email = new ImageHtmlEmail();
           email.setHostName("smtp.yourdomain.com");
           email.setSmtpPort(465);
           email.setAuthenticator(new DefaultAuthenticator("your-email@domain.com", "your-password"));
           email.setSSLOnConnect(true);
           email.setFrom("nayab2396@gmail.com"); // from
           email.setSubject("test results");
           email.setMsg("Please find the attached report.");
           email.addTo("nayab5816@gmail.com");  // sender
           email.attach( url , "extent report", " Please check report");
           email.send(); // sending email

       } catch (Exception e) {
           e.printStackTrace();
       }
       */


    }
}
