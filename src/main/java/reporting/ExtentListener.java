package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class ExtentListener implements ITestListener {
    private static ExtentReports extentReports;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        String fileName = System.getProperty("user.dir") + "//Reports//" + ExtentReportsManager.getReportNameInTimeStamp() + ".html";
        extentReports = ExtentReportsManager.createInstance(fileName, "API Test Execution Report", "Execution Report");
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extentReports != null) {
            extentReports.flush();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        extentTest.set(extentReports.createTest(result.getTestClass().getName() + " - "
                + result.getMethod().getMethodName()));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportsManager.logFailureDetails(result.getThrowable().getMessage());
        String stacktrace = Arrays.toString(result.getThrowable().getStackTrace());
        stacktrace = stacktrace.replaceAll(",", "<br>");
        String formattedStacktrace = "<details>\n" +
                "  <summary>Click here to view stacktrace</summary>\n" +
                "" + stacktrace + "\n" +
                "</details>";
        ExtentReportsManager.logExceptionDetails(formattedStacktrace);
    }
}
