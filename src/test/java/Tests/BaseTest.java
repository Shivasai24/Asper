package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.ReadConfig;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {
    public static WebDriver driver;
    ReadConfig rc = new ReadConfig();
    public String url=rc.getApplicationURL();
    public String username=rc.getUserName();
    public String password=rc.getPassword();
    public String name=rc.getName();
    public String Address=rc.getAddress();
    public String city=rc.getCity();
    public String state=rc.getState();
    public String pincode=rc.getPincode();
    public String telephone=rc.getTelephone();
    public String email=rc.getEmail();
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;
    @BeforeSuite
    public void beforeSuite() {
        createFolderExtendReport();
        htmlReporter = new ExtentHtmlReporter(
                System.getProperty("user.dir") + "/ExtendReport/" + "TestReport" + ".html");
        htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host name", "Shiva");
        extent.setSystemInfo("Environment","QA".toString());
        htmlReporter.config().setDocumentTitle("Main Automation report");
        htmlReporter.config().setReportName("Main Automation report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
    }
    public void createFolderExtendReport() {
        try {
            File file = new File(System.getProperty("user.dir") + "/" + "ExtendReport");
            file.mkdir();
            boolean flag = file.mkdir();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(ITestResult result, java.lang.reflect.Method methodName) {
        logger = extent.createTest(methodName.getName());
    }
   @Parameters("browser")
   @BeforeMethod(alwaysRun = true)
    public void setup(String br){
       if(br.equals("chrome")){
         System.setProperty("webdriver.chrome.driver",rc.getGooglepath());
         WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
       }
       else if(br.equals("firefox")){
           System.setProperty("webdriver.gecko.driver",rc.getfireFoxpath());
           WebDriverManager.firefoxdriver().setup();
           driver=new FirefoxDriver();
       }
       driver.get(url);
       driver.manage().window().maximize();
   }
    @AfterMethod(alwaysRun = true)
    public void captureScreenShot(ITestResult result, java.lang.reflect.Method methodname, ITestContext context){
        if (result.getStatus() == ITestResult.FAILURE) {
            getScreenshot(driver,result.getMethod().getMethodName() );
        }
    }
    public static String getScreenshot(WebDriver driver, String screenshotName) {
        String destination = null;
        try {
            String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            destination = System.getProperty("user.dir") + "/target/Screenshots/" + screenshotName+"_"+dateName + ".png";
            File finalDestination = new File(destination);
            FileUtils.copyFile(source, finalDestination);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            return destination;
        }
    }
//    @AfterMethod()
    public void teardown(){
        driver.quit();
    }
    @AfterSuite(alwaysRun = true)
    public void quit(){
        extent.flush();
    }
}
