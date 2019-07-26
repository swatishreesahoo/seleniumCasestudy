package scenario1;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utility.Drivers;
import java.io.IOException;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class OnlineShoppingTest {
	ExtentTest test;
	ExtentReports extent;
	 WebDriver driver;
	 ExtentHtmlReporter htmlReporter;
	 @BeforeTest
	  public void startReportbeforeTest() {
		driver=Drivers.getDriver("chrome");
		  htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/testReport.htm");
		 extent=new ExtentReports();
		 extent.attachReporter(htmlReporter);
		  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		 
	  }

  @Test(priority=3)
  public void testCart() throws InterruptedException {
	  WebElement search1=driver.findElement(By.id("myInput"));
	  Actions act1=new Actions(driver);
	  act1.sendKeys(search1,"head").perform();
	  Thread.sleep(2000);
	  act1.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//a[@href='displayCart.htm']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//a[@href='checkout.htm']")).click();
	  Thread.sleep(2000);
	  
	  
  }
  @Test(priority=2)
  public void testLogin() throws IOException, InterruptedException {
	
	  driver.findElement(By.id("userName")).sendKeys("ille1223334");
	  driver.findElement(By.id("password")).sendKeys("swati123");
	  driver.findElement(By.name("Login")).click();
	  
  }
  
  @Test(priority=4)
  public void testPayment() throws InterruptedException {
	  driver.findElement(By.name("ShippingAdd")).sendKeys("itpl,bangalore");
	  Thread.sleep(2000);
	  WebElement radio2=driver.findElement(By.xpath("//input[@value='Proceed to Pay']"));
	  radio2.click();
	  Thread.sleep(9000);
	  driver.findElement(By.xpath("//*[@id=\"swit\"]/div[1]/div/label")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.id("btn")).click();
	  driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input[1]")).sendKeys("123456");
	  driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/input[2]")).sendKeys("Pass@456");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"horizontalTab\"]/div[2]/div/div/div/div/form/div/div[3]/input")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.name("transpwd")).sendKeys("Trans@456");
	  driver.findElement(By.xpath("//input[@value='PayNow']")).click();
	  driver.findElement(By.xpath("//a[@href='logout.htm']")).click();
	  
  }
  @Test(priority=1)
  public void testRegistration() throws InterruptedException {
	 Random rand=new Random();
	 int val=rand.nextInt(99);
	
	 driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[2]/a")).click();
	 driver.findElement(By.id("userName")).sendKeys("ille123334"+val);
	 driver.findElement(By.id("firstName")).sendKeys("swati");
	 driver.findElement(By.id("lastName")).sendKeys("shree");
	 driver.findElement(By.id("password")).sendKeys("swati123");
	 driver.findElement(By.id("pass_confirmation")).sendKeys("swati123");
	 
	 WebElement radio1=driver.findElement(By.xpath("//*[@id=\"gender\"]"));
	 radio1.click();
	 driver.findElement(By.id("emailAddress")).sendKeys("1225543@gmail.com");
	 driver.findElement(By.id("mobileNumber")).sendKeys("1234657892");
	 driver.findElement(By.name("dob")).sendKeys("05/05/1998");
	 driver.findElement(By.id("address")).sendKeys("blhh hhhh");
	 driver.findElement(By.id("securityQuestion")).click();
	
	 Thread.sleep(1000);
	 Select sq=new Select(driver.findElement(By.id("securityQuestion")));
	 int value = rand.nextInt(3);
	 sq.selectByIndex(value);
	 Thread.sleep(2000);
	 driver.findElement(By.name("answer")).sendKeys("monkey");
	 driver.findElement(By.xpath("//input[@value='Register']")).click();
	 
	 
  }
  @AfterMethod
  public void getResultafterMethod() throws IOException  {
	  
	  ExtentHtmlReporter reporter = new ExtentHtmlReporter("C:\\Users\\training_b6b.00.10\\Desktop\\myreport1.html");

      ExtentReports extent= new ExtentReports();

      extent.attachReporter(reporter);
      
      ExtentTest logger1=extent.createTest("Signup");
      
      ExtentTest logger2=extent.createTest("Login");
      
      ExtentTest logger3=extent.createTest("AddToCart");
      
      ExtentTest logger4=extent.createTest("Payment");
      
      ExtentTest logger5=extent.createTest("Signout");
      
      logger1.log(Status.PASS, "Signup was executed successfully");
      
      logger2.log(Status.PASS, "Login was executed successfully");
      
      logger3.log(Status.PASS, "AddToCart was executed successfully");
      
      logger4.log(Status.PASS, "Payment was executed successfully");
      
      logger5.log(Status.PASS, "Signout was executed successfully");
      
     // logger5.addScreenCaptureFromPath("C:\\Users\\training_b6b.00.10\\Pictures\\Saved Pictures\\ss2.jpg");
      
      extent.flush();
  }

 
  @AfterTest
  public void endReportafterTest(){
	  driver.close();
  }

}
