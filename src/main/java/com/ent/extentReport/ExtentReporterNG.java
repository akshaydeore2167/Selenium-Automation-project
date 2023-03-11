package com.ent.extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReporterNG {
    static ExtentReports extent=new ExtentReports();
    public static ExtentReports extentReportGEnerator()
    {
        SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("ddMMYYhhmmss");
        String dateAsString = simpleDateFormat.format(new Date());
        System.out.println(dateAsString);
        //String value= timestamp2.toString();

        System.out.println("In BEfore Test");
        //initialize ExtentReports and attach the HtmlReporter
        String path=System.getProperty("user.dir")+"\\Exreports\\"+dateAsString+"index.html";
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(path);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Insyghts Automation Report");
        htmlReporter.config().setReportName("ExtentReports");
        extent.attachReporter(htmlReporter);
        return extent;

    }
}
