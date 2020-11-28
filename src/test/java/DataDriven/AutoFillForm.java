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
import TheInternet.foundation.ConfigurationReader;
import TheInternet.foundation.TestBase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AutoFillForm extends TestBase{
	
	@DataProvider (name = "data-provider")
	public Object[][] dpMethod(){
		return new Object[][] {
			{new FormModelObject("John", "Bender", "lsr@bclub.com",  "male", "2135557613")},
			{new FormModelObject("Greg", "Doe", "Doe@gmail.com",  "male", "1800343555")}
		};
	}
	
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
  @Test (dataProvider = "data-provider")
  public void Test2(FormModelObject expectedFormObject) {
	  String url = "https://the-internet.herokuapp.com/";
	  FormModelObject actualFormObject = new FormPage(driver,url)
			  .navigate()
			  .fillForm(expectedFormObject)
			  .submit()
			  .getResults();
	  //Assert
	  Assert.assertTrue(actualFormObject.equals(expectedFormObject));
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
  
  @Test
  public void Test4() {
	  //Arrange
	  String url = "https://the-internet.herokuapp.com/";
	  List<FormModelObject> expectedFormObjects = getFormObjectFromSQL();
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
  
  private List<FormModelObject> getFormObjectFromSQL() {
	  List<FormModelObject> studentObjects = new ArrayList<FormModelObject>();
	  
	  HashMap<String,String> configs = null;
	  try {
		  configs = new ConfigurationReader().getPropertiesFromResourceFile("config.properties");
	  } catch (IOException e) {
		  //e.printStackTrace();
		  throw new RuntimeException(e+"Config file does not exist");
	  }

	  String url = "jdbc:mysql://localhost:3306/world_x?allowPublicKeyRetrieval=true&useSSL=false";
	  String user = "root";
	  String password = configs.get("dbpass");
	  
	  String query = "SELECT first_name,last_name,isMale,phone FROM students;";
	  try {
		  Connection con = DriverManager.getConnection(url, user, password);
		  Statement st = con.createStatement();
		  ResultSet rs = st.executeQuery(query);
		  while (rs.next()) {
			  String first = rs.getString(1);
			  String last = rs.getString(2);
			  String email = "nomail@no.com";
			  String gender = rs.getBoolean(3) ? "male":"female";
			  String number = rs.getString(4).replace("-", "");
			  studentObjects.add(new FormModelObject(first, last, email,  gender, number));
		  }

	  } catch (SQLException ex) {
		  System.out.println(ex);
	  } 

	  return studentObjects;
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
		for(int i=0; i<nList.getLength();i++) {
			Node n = nList.item(i);
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
