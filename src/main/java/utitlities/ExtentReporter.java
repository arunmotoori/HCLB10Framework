package utitlities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	static ExtentReports extentReport = null;
	
	public static ExtentReports getExtentReport() {
		
		String extentReportPath = "./Reports/ExtentReport.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
		
		reporter.config().setReportName("TutorialsNinja Automation Results");
		reporter.config().setDocumentTitle("TN Automation Results");
		
		extentReport = new ExtentReports();
		
		extentReport.attachReporter(reporter);
		extentReport.setSystemInfo("Operating System","Windows 11");
		extentReport.setSystemInfo("Executed By","Arun Motoori");
		
		return extentReport;
	}

}
