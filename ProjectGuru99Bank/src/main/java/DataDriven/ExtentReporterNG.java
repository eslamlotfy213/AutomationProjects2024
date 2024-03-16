package DataDriven;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
        public static ExtentReports getReportObject()
        {
            String path =System.getProperty("user.dir")+"\\reports\\index.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(path);
            reporter.config().setReportName("Web Automation Results");
            reporter.config().setDocumentTitle("Test Results");

            ExtentReports extent =new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "SQA");
            extent.setSystemInfo("Environment","Testing");
            extent.setSystemInfo("Release","Current Sprint");
            return extent;
        }
    }