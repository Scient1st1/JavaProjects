package TestNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNgBasics {
//testNg can work without main function 
	@Test(groups= {"group1"}) //groups the test cases and can be triggered from xml by group
	public void demo() {
		System.out.println("test one");
	}
	
	@Test (dependsOnMethods= {"fourthTest"})//dependency - so fourth test will run before second
	public void secondTest() {
		System.out.println("test two");
	}
	@Test(groups= {"group1"})
	public void thirdTest() {
//		skip third test in xml file with excludes tag -> check testng.xml
		System.out.println("test three");
	}
	
	@Test
	public void fourthTest() {
		System.out.println("test four");
		
	}
	@Test(enabled=false) //skips test
	public void fifthTest() {
		System.out.println("test five");
	}
	@Test(timeOut=4000) //timeouts test
	public void sixthTest() {
		System.out.println("test six");
	}
	@Parameters({"URL", "APIkey"})//check xml file top
	@Test 
	public void seventhTest(String urlname, String key) {//parameters URL = urlname
		System.out.println(urlname);
		System.out.println(key);
	}
	@Test(dataProvider = "provideData")
	public void eightthTest(String username, String password) {
		System.out.println(username);
		System.out.println(password);
	}
	@DataProvider
	public Object[][] provideData() {
//		give combinations of data for example:
//		username-password
//		second username and password
		Object[][] data = new Object[3][2];
//		1 set 
		data[0][0] = "firstUsername";
		data[0][1] = "firstPassword";
//		2 set
		data[1][0] = "secondUsername";
		data[1][1]= "secondPassword";
//		3 set
		data[2][0]="thirdUsername";
		data[2][1]="thirdPassword";
//		eightTh test should run with this data 
		return data;
	}
//	testNg annotations
	@AfterTest
	public void executesLast() {
		System.out.println("goes last");
	}
	@BeforeTest
	public void prerequisite() {
		System.out.println("executes before test, cleaning data or something");
	}
	
	@BeforeSuite
	public void bfSuite() {
		System.out.println("this will execute before everything");
	}
	@AfterSuite
	public void afSuite() {
		System.out.println("this will execute after everything");
	}
	@BeforeMethod
	public void bfMethod() {
		System.out.println("this will execute before every method, every test");
	}
	@AfterMethod
	public void afMethod() {
		System.out.println("this will execute after every method, every test");
	}
	@BeforeClass 
	public void bfClass() {
		System.out.println("executes before everything in the class");
	}
	@AfterClass
	public void afClass() {
		System.out.println("executes after everything in the class");
	}
}
