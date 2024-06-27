//package parabank.util;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//public class ExtentManager {
//    private static ExtentReports extent;
//    private static ExtentHtmlReporter htmlReporter;
//    private static ExtentTest test;
//
//    public static ExtentReports createInstance(String fileName) {
//        htmlReporter = new ExtentHtmlReporter(fileName);
//        htmlReporter.config().setTheme(Theme.STANDARD);
//        htmlReporter.config().setDocumentTitle("Automation Test Report");
//        htmlReporter.config().setEncoding("utf-8");
//        htmlReporter.config().setReportName("Automation Test Report");
//
//        extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);
//
//        extent.setSystemInfo("Host Name", "Your Host Name");
//        extent.setSystemInfo("Environment", "Your Environment");
//        extent.setSystemInfo("User Name", "Your Name");
//
//        return extent;
//    }
//
//    public static ExtentReports getInstance() {
//        if (extent == null)
//            extent = createInstance("test-output/extent.html");
//
//        return extent;
//    }
//}
