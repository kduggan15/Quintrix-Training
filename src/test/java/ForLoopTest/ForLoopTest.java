package ForLoopTest;

import org.testng.annotations.Test;

import com.sun.tools.javac.util.List;

import org.testng.annotations.BeforeTest;

import java.util.ArrayList;

import org.testng.annotations.AfterTest;

public class ForLoopTest {
  @Test
  public void f() {
	  ArrayList<Integer> arr = new ArrayList<Integer>(List.of(1,3,5,7,9));
	  for(int i=0;i<arr.size();i++) {
		  System.out.println(arr.get(i));
	  }
	  for(Integer i: arr) {
		  System.out.println(i);
	  }
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
