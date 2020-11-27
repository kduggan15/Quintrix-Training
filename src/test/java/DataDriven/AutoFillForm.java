package DataDriven;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import DataDriven.framework.FormModelObject;
import TheInternet.foundation.TestBase;

import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AutoFillForm extends TestBase{
  @Test
  public void Test1() {
	  //Arrange
	  String url = "https://the-internet.herokuapp.com/";
	  List<FormModelObject> expectedFormObjects = getFormObjectFromCSV();
	  //Act
	  for(FormModelObject expectedFormObject: expectedFormObjects) {
		  FormModelObject actualFormObject = new FormPage(driver,url)
				  .navigate()
				  .fillForm(expectedFormObject)
				  .submit()
				  .getResults();
		  //Assert
		  Assert.assertTrue(actualFormObject.equals(expectedFormObject));
	  }
	  
  }
  @Test
  public void Test3() {
	  //Arrange
	  String url = "https://the-internet.herokuapp.com/";
	  List<FormModelObject> expectedFormObjects = getFormObjectFromXML();
	  //Act
	  for(FormModelObject expectedFormObject: expectedFormObjects) {
		  FormModelObject actualFormObject = new FormPage(driver,url)
				  .navigate()
				  .fillForm(expectedFormObject)
				  .submit()
				  .getResults();
		  //Assert
		  Assert.assertTrue(actualFormObject.equals(expectedFormObject));
	  }
	  
  }
  
  private List<FormModelObject> getFormObjectFromXML() {
	List<FormModelObject> studentObjects = new ArrayList<FormModelObject>();
	
	
	try {
		URL resource = getClass().getClassLoader().getResource("Students.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(resource.getFile());
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("person");
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		for(int i=0; i<nList.getLength();i++) {
			Node n = nList.item(i);
			System.out.println("\nCurrent Element :" + n.getNodeName());
			if(n.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) n;
				String first = e.getElementsByTagName("f_name").item(0).getTextContent();
				String last = e.getElementsByTagName("l_name").item(0).getTextContent();
				String email = "noemail@none.org";
				String gender = e.getElementsByTagName("gender").item(0).getTextContent();
				String number = e.getElementsByTagName("contact").item(0).getTextContent().replace("-", "");
				System.out.println(first+last+email+gender+number);
				studentObjects.add(new FormModelObject(first, last, email,  gender, number));
			}
		}
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return studentObjects;
}

private List<FormModelObject> getFormObjectFromCSV() {
	  List<FormModelObject> studentObjects = new ArrayList<FormModelObject>();

	  try {
		  URL resource = getClass().getClassLoader().getResource("Students.csv");
		  Reader f = new FileReader(resource.getFile());
		  CSVReader csvReader = new CSVReader(f);
		  String[] values = null;
		  csvReader.readNext();
		  while ((values = csvReader.readNext()) != null) {
			  System.out.println(values[0]+values[2]+values[9]+values[8]);
			  String first = values[0].split(",")[1];
			  String last = values[0].split(",")[0];
			  String email = values[2];
			  String gender = values[9];
			  String number = values[8].replace("-", "");
			  studentObjects.add(new FormModelObject(first, last, email,  gender, number));
		  }
		  csvReader.close();
	  } catch (FileNotFoundException e) {
		  e.printStackTrace();
	  } catch (CsvValidationException e) {
		  e.printStackTrace();
	  } catch (IOException e) {
		  e.printStackTrace();
	  }
	  return studentObjects;
  }
@BeforeTest
  public void beforeTest() {
	  super.beforeTest();
  }

  @AfterTest
  public void afterTest() {
	  super.afterTest();
  }

}
