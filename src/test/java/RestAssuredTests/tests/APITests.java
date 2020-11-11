package RestAssuredTests.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class APITests {
  @Test
  public void verifiesUser2IsJanet() {
	  given()
	  .when()
	  .get("https://reqres.in/api/users/2")
	  .then()
	  .assertThat()
	  .body("data.email", equalTo("janet.weaver@reqres.in"));
  }
  
  @Test
  public void verifiesCanLogin() {
	  given()
	  	.param("email", "eve.holt@reqres.in")
	  	.param("password", "cityslicka")
	  .when()
	  	.get("https://reqres.in/api/login")
	  .then()
	  	.assertThat()
	  	.statusCode(200);
  }
  
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
