package Tower_Package;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {
	
	/**
	 * @param arg
	 */
	public static void main(String arg[])
	{
        System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		//Open the site
		driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
		
		driver.manage().window().maximize();
		
		// Enter First name as - "Mike"
		driver.findElement(By.name("firstname")).sendKeys("Mike");
		
		//Print the entered text
		System.out.println(driver.findElement(By.name("firstname")).getAttribute("value")); 
		
		//Type Last name "Irwin" without using object
		driver.findElement(By.name("lastname")).sendKeys("Irwin");
		
		//Select the Male radio button.
		driver.findElement(By.cssSelector("input[name='sex'][value='Male']")).click();
		
		// Validate Male radio button is selected now.
		System.out.println(driver.findElement(By.cssSelector("input[name='sex'][value='Male']")).isSelected());
		
		//Select the Experience radiobutton "6" by using Collections (Hint: Findelements())
		//driver.findElement(By.cssSelector("input[name='exp'][value='6']")).click();
		
		java.util.List<WebElement> buttons = driver.findElements(By.cssSelector("input[name='exp']"));
		buttons.get(5).click();
						
		// Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dateFormat.format(date);
		 
		 // Print the Date
		 System.out.println(date1);
		 
		//Type the Current date in date Textbox.
			driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/div[1]/div/div[6]/div/form/table/tbody/tr[5]/td[2]/input")).sendKeys(date1);
			
			driver.findElement(By.cssSelector("input[target='_blank'")).sendKeys(date1);
		
		//Select Automation Tester Checkbox		
		driver.findElement(By.cssSelector("input[name='profession'][value='Automation Tester']")).click();
		
		// validate Manual tester is unchecked and Automation tester is checked.
		System.out.println(driver.findElement(By.cssSelector("input[name='profession'][value='Automation Tester']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[name='profession'][value='Manual Tester']")).isSelected());
		
		//Upload a file and validate filename is displayed.		
		driver.findElement(By.name("photo")).sendKeys("C:\\Users\\ankur.rana\\Desktop\\a.JPG");
		
		System.out.println(driver.findElement(By.name("photo")).isDisplayed());
		
		//Select Selenium Webdriver Checkbox and validate it's selected.
		driver.findElement(By.cssSelector("input[name='tool'][value='Selenium Webdriver']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[name='tool'][value='Selenium Webdriver']")).isSelected());
					
		//Get Count and list of Continents
				
		Select var = new Select(driver.findElement(By.name("continents")));
		System.out.println("No of Continenets : " + var.getOptions().size());
		
		for(int k=0;k<var.getOptions().size();k++)
		{
			System.out.println(var.getOptions().get(k).getText());
		}
		
		//Select the "North America" from the list
		var.selectByIndex(5);
				
		// Do the Multiple selection:-
	    //- Browser Commands
		// - Wait Commands
		Select var1 = new Select(driver.findElement(By.name("selenium_commands")));
		var1.selectByIndex(3);
				
		//Pressing ctrl
        Actions action = new Actions(driver);
		
		action.sendKeys(Keys.CONTROL).build().perform();
		var1.selectByIndex(0);
		
		//clicking button
		driver.findElement(By.name("submit")).click();
		
		//Handling the pop up
		driver.switchTo().alert().dismiss();
		
		//Get the text of Heading "Webdriver Commands Example"
		System.out.println("\n" +driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/div[1]/div/h1[2]")).getText());
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		
		//clicking 
		driver.findElement(By.linkText("dynamicText5")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
		
		driver.navigate().back();
		
		//Printing the color of text
		System.out.println(driver.findElement(By.id("dynamicColor")).getAttribute("style"));;
				
        //Total no of links on the page 
		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("\n No of Links :" + links.size());
		for (int i = 0; i<=links.size()-1; i++)
		{
    		System.out.println(links.get(i).getText());
		}
		
		// Get collection of all labels on the Page like - First name:	, Last name:, Sex:, Years of Experience: etc.
				java.util.List<WebElement> alllink = driver.findElements(By.tagName("strong"));
				System.out.println("Collection of lebals--");
				for (int j = 0; j<=alllink.size()-1; j++)
				{
		    		System.out.println(alllink.get(j).getText());
				}
		
		
	}

}