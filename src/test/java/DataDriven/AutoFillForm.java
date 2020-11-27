package DataDriven;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import DataDriven.framework.FormModelObject;
import TheInternet.foundation.TestBase;

import org.testng.annotations.BeforeTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
