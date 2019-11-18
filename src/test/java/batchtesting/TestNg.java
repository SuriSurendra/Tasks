package Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;


public class TestNg {
  
	
	public WebDriver driver;
	
	@Test
  public void f() 
	{
		
WebElement dropdown= driver.findElement(By.id("open_account"));
		
		dropdown.click();
		
		Select corpacc= new Select(dropdown);
		corpacc.selectByVisibleText("Corporate Account");
		
		driver.findElement(By.xpath("//input[@value='Open my Account']")).click();
		
		
		WebElement city=driver.findElement(By.id("FML_USR_ADDRSS_CTY_DROP"));
		
		
		List<WebElement> cityoptions= city.findElements(By.tagName("option"));
		
		int citycount= cityoptions.size();
		for(int i=0; i<citycount; i++)
		{
			WebElement cityoption= cityoptions.get(i);
			String cityname= cityoption.getText();
			
			WebElement state= driver.findElement(By.id("FML_USR_ADDRSS_STTE_DIS"));
			
			String statename= state.getAttribute("punjab");
			
			System.out.println(cityname+"   ==>     "+statename);
			
			if(state.equals("punjab"))
			{
				System.out.println(cityname);
			}
			
			}
	    
	    	    	
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.setProperty("webdriver.gecko.driver", "D:\\drivers\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		WebDriver driver= new FirefoxDriver();
		driver.get("http://content.icicidirect.com/idirectcontent/Home/Home.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
  }

}
