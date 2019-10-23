package suites;


	import java.util.ArrayList;
	import java.util.List;

	import org.testng.TestNG;
	import org.testng.xml.XmlClass;
	import org.testng.xml.XmlSuite;
	import org.testng.xml.XmlTest;

import com.konakart.testscenarios.SearchProductScenario;
import com.konakart.testscenarios.SpecificProductValidationScenario;

	
	public class DynamicXML {


	public static <xmlclass> void main(String[] args) {
	XmlSuite xmlsuite = new XmlSuite();
	xmlsuite.setName("suitename");
	   xmlsuite.setVerbose(2);
	   
	   XmlTest xmltest= new XmlTest(xmlsuite);
	   xmltest.setName("HomePageScript");
	 
	   XmlTest xmltestCase= new XmlTest(xmlsuite);
	   xmltest.setName("ProductDetailsScript");
	 
	   XmlClass homePage = new XmlClass(SearchProductScenario.class);
	   XmlClass productDetail = new XmlClass(SpecificProductValidationScenario.class);
	   List<XmlClass> list= new ArrayList<XmlClass>();
	   list.add(homePage);
	   
	   List<XmlClass> list1= new ArrayList<XmlClass>();
	   list1.add(productDetail);
	   
	  xmltest.setXmlClasses(list);
	  xmltest.setXmlClasses(list1);
	 
	  TestNG testng = new TestNG();
	  List<XmlSuite> suites = new ArrayList<XmlSuite>();
	  suites.add(xmlsuite);
	 
	  testng.setXmlSuites(suites);
	  testng.run();
	 



	}
}
