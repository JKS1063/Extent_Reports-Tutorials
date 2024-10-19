package Reports;

import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class R3_LogDifferentTypesInfo {

	public static void main(String[] args) throws Exception {
		
		ExtentReports extentReport = new ExtentReports();
		String filePath = "D:\\JKS\\Education\\Personal\\Online courses\\Naresh\\Project workspaces\\ExtentReports\\Reports\\reports3.html";
		File file = new File(filePath);
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentReport.attachReporter(sparkReporter);
		
		//Text Bold Italic reports
		extentReport.createTest("Test 1")
		.log(Status.INFO, "info 1")
		.log(Status.INFO, "<b>info 2</b>")
		.log(Status.INFO, "<i>info 3</i>")
		.log(Status.INFO, "<b><i>info 4</i></b>");
		
		//XML, JSON based reports
		String xmlData = "<widget>\r\n"
				+ "    <debug>on</debug>\r\n"
				+ "    <window title=\"Sample Konfabulator Widget\">\r\n"
				+ "        <name>main_window</name>\r\n"
				+ "        <width>500</width>\r\n"
				+ "        <height>500</height>\r\n"
				+ "    </window>\r\n"
				+ "    <image src=\"Images/Sun.png\" name=\"sun1\">\r\n"
				+ "        <hOffset>250</hOffset>\r\n"
				+ "        <vOffset>250</vOffset>\r\n"
				+ "        <alignment>center</alignment>\r\n"
				+ "    </image>\r\n"
				+ "    <text data=\"Click Here\" size=\"36\" style=\"bold\">\r\n"
				+ "        <name>text1</name>\r\n"
				+ "        <hOffset>250</hOffset>\r\n"
				+ "        <vOffset>100</vOffset>\r\n"
				+ "        <alignment>center</alignment>\r\n"
				+ "        <onMouseUp>\r\n"
				+ "            sun1.opacity = (sun1.opacity / 100) * 90;\r\n"
				+ "        </onMouseUp>\r\n"
				+ "    </text>\r\n"
				+ "</widget>";
		
		extentReport
		.createTest("XML based Test")
		.info(MarkupHelper.createCodeBlock(xmlData, CodeLanguage.XML));
		
		String jsonData = "{\"widget\": {\r\n"
				+ "    \"debug\": \"on\",\r\n"
				+ "    \"window\": {\r\n"
				+ "        \"title\": \"Sample Konfabulator Widget\",\r\n"
				+ "        \"name\": \"main_window\",\r\n"
				+ "        \"width\": 500,\r\n"
				+ "        \"height\": 500\r\n"
				+ "    },\r\n"
				+ "    \"image\": { \r\n"
				+ "        \"src\": \"Images/Sun.png\",\r\n"
				+ "        \"name\": \"sun1\",\r\n"
				+ "        \"hOffset\": 250,\r\n"
				+ "        \"vOffset\": 250,\r\n"
				+ "        \"alignment\": \"center\"\r\n"
				+ "    },\r\n"
				+ "    \"text\": {\r\n"
				+ "        \"data\": \"Click Here\",\r\n"
				+ "        \"size\": 36,\r\n"
				+ "        \"style\": \"bold\",\r\n"
				+ "        \"name\": \"text1\",\r\n"
				+ "        \"hOffset\": 250,\r\n"
				+ "        \"vOffset\": 100,\r\n"
				+ "        \"alignment\": \"center\",\r\n"
				+ "        \"onMouseUp\": \"sun1.opacity = (sun1.opacity / 100) * 90;\"\r\n"
				+ "    }\r\n"
				+ "}} ";
		
		extentReport
		.createTest("JSON based Test")
		.info(MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON));
		
		//Collection base (List, Set, Map) based reports
		List<String> listData = new ArrayList<>();
		listData.add("Krishna");
		listData.add("Sekhar");
		listData.add("HariHara");
		
		Map<Integer, String> mapData = new HashMap<>();
		mapData.put(101, "Krishna");
		mapData.put(102, "Sekhar");
		mapData.put(103, "HariHara");
		
		Set<Integer> setData =  mapData.keySet();
		
		extentReport
		.createTest("List based Test")
		.info(MarkupHelper.createOrderedList(listData))
		.info(MarkupHelper.createUnorderedList(listData));
		
		extentReport
		.createTest("Map based Test")
		.info(MarkupHelper.createOrderedList(mapData))
		.info(MarkupHelper.createUnorderedList(mapData));
		
		extentReport
		.createTest("Set based Test")
		.info(MarkupHelper.createOrderedList(setData))
		.info(MarkupHelper.createUnorderedList(setData));
		
		//Highlight Text based report
		extentReport
		.createTest("Highlight text based report")
		.info("This is a normal Text")
		.info(MarkupHelper.createLabel("This is a highlighted message", ExtentColor.RED));
		
		//Exception based report
		try {
			@SuppressWarnings("unused")
			int i = 5/0;
		} catch (Exception e) {
			extentReport
			.createTest("Exception Test")
			.fail(e);
		}
		
		Throwable t =  new RuntimeException("This is custom Exception");
		extentReport
		.createTest("Exception test 1")
		.fail(t);
		
		Throwable t2 = new RuntimeException("This is also custom Exception");
		extentReport
		.createTest("Exception test 2")
		.fail(t2);
		
		extentReport.flush();
		Desktop.getDesktop().browse(new File(filePath).toURI());
	}
}
