import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utils.ReadExcel;

public class FBPage {
	WebDriver driver;
	
	@BeforeTest
	public void openBrowser(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://facebook.com");
	}
	
	@Test
	public void testData(int row) throws Exception{
		String [][] data = ReadExcel.getData("C:\\Minu\\Training\\H2k\\TestData.xlsx","Sheet1");
		for(int i=1; i<data.length; i++){

			String uname = data[i][0];
			String pwd = data[i][1];
			driver.findElement(By.id("email")).sendKeys(uname);
			driver.findElement(By.id("pass")).sendKeys(pwd);
			driver.findElement(By.id("u_0_q")).click();
			
			System.out.println(driver.getTitle());
			driver.navigate().back();
		}
	}
	
	@AfterTest
	public void closeBrowser(){
		driver.close();
	}

}
