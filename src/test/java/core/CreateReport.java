package core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class CreateReport {
    public ExtentReports report;
    public ExtentTest test;

    public void setupReport(){
        ExtentSparkReporter spark = new ExtentSparkReporter("./reports");
        report = new ExtentReports();
        report.attachReporter(spark);
    }

    public void setTest(String testName){
        test = report.createTest(testName);
    }

    public ExtentTest getTest(){
        return test;
    }


}
