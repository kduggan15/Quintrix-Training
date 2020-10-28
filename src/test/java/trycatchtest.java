import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class trycatchtest {
  @Test
  public void f() {
	  Integer i = 5;
	  try {
		  i = i/0;
	  }catch(Exception E){
		  System.out.println("Error caught! Something went wrong");
	  }
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
