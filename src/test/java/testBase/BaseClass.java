package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.Assert;


public class BaseClass {
public static WebDriver driver;

public Logger logger;
public Properties p;

	 
    @BeforeClass(groups={"sanity","regression","Master"})
    @Parameters({"browser"})
	public void setup(String br) throws InterruptedException, IOException {
    	
    	FileReader file  = new FileReader("./src//test//resources//config.propertiesfile");
    	p = new Properties();
    	p.load(file);
    	
    	
    	logger = LogManager.getLogger(this.getClass()); // loger is track the information for all testcases 
    	
    	switch(br.toLowerCase()) {
    	case"chrome": 
    		driver = new ChromeDriver();
    		break;
       	case"edge": 
       		driver = new EdgeDriver();
       		break;
       	case"Firefox": 
       		driver = new FirefoxDriver();
       		break;
       	default:System.out.println(" invalid browser");
       	return;
    	}
    	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appurl"));
		
	}

	@AfterClass(groups={"sanity","regression","Master"})
	public void taredwown() {
		driver.quit();
	}
	
	
	
	// randomString generator

	public String randomString() {
		String random = RandomStringUtils.randomAlphabetic(5);
		return random;
	}
	public String randomnum() {
		String randomnum = RandomStringUtils.randomNumeric(5);
		return randomnum;
	}
	
	public String randomAlphaNum() {
		String random = RandomStringUtils.randomAlphabetic(5);
		String randomnum = RandomStringUtils.randomNumeric(5);
		return (random+"@"+randomnum);
	}
	 public  String captureScreen(String tname) throws IOException {

	        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

	        String targetFilePath = System.getProperty("user.dir") + "\\screenShot\\" + tname + " -" + timeStamp + "nayab.png";
	        File targetFile = new File(targetFilePath);

	        sourceFile.renameTo(targetFile);
	        return targetFilePath;
	    }
}
