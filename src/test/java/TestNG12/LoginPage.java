package TestNG12;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPage {
	//ID:mngr532503
	//PWD: EjAtAqU
	
WebDriver driver;
	
@Test   //Annotation Test
	void OpenApp () { // this is a OpeApp 1st method
		
		driver = new ChromeDriver(); // ChromeDriver browser details,WebDriver driver created in Method, so this is called Local Variabl to create as Universal or Instance Object 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.demo.guru99.com/v4");
		
}

		@Test(priority=1)
		void Login() {  //Login page is failure due to given wrong password
			driver.findElement(By.name("uid")).sendKeys("mngr532503");
			driver.findElement(By.name("password")).sendKeys("EjAtAq"); // Failure due to wrong password given
			driver.findElement(By.name("btnLogin")).click();
			//driver.switchTo().alert().accept();
			boolean Manger=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).isDisplayed();
		
			Assert.assertTrue(Manger); //Assert true       (Manager) only in TESTNG
	
	}
	
		@Test(priority=2, dependsOnMethods= {"Login"}) //Skip
		void New_Customer () {
		driver.findElement(By.linkText("New Cutomer")).click();
		driver.navigate().refresh();
		driver.findElement(By.linkText("New Cutomer")).click();
		
	}
	
	@Test(priority=3)
	void CloseApp() {
		driver.close();
	}
	
}
