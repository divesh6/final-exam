package Final;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {

	WebDriver driver;
  @BeforeTest
  public void hello() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("launching browser");
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(2000);
		  

		     driver.manage().window().maximize();
		   }

		                    @Test(priority=0)
		  public void Login() throws InterruptedException {


		  //Login with wrong username and password
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("Divesh");
		  driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("Divesh");
		  driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		  driver.findElement(By.xpath("//input[@id=\"user-name\"]")).clear();


		  //login with right values
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//input[@id=\"user-name\"]")).sendKeys("standard_user");
		  driver.findElement(By.xpath("//input[@id=\"password\"]")).clear();
		  driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("secret_sauce");
		  driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
		   }

		                    @Test(priority=1)
		  //for next button
		  public void dropdown() throws InterruptedException {
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]//option[4]")).click();
		  }
		                   
		   @Test(priority=2)
		   public void list() throws InterruptedException
		   //add items
		   {
		   String[] listNeeded= {"Sauce Labs Backpack","Sauce Labs Bike Light","Sauce Labs Bolt T-Shirt","Sauce Labs Fleece Jacket","Sauce Labs Onesie","Test.allTheThings() T-Shirt (Red)"};

		   Thread.sleep(2000);
		  int j=0;
		  List<WebElement> products=driver.findElements(By.className("inventory_item_name"));
		  for(int i=0;i<products.size();i++)

		  {
		  Thread.sleep(2000);
		  WebElement name=products.get(i);
		  String formattedName=name.getText();
		  List itemsNeededList=Arrays.asList(listNeeded);
		  if(itemsNeededList.contains(formattedName))
		  {
		  j++;
		  driver.findElements(By.xpath("//div[@class='pricebar']/button")).get(i).click();
		  if(j==listNeeded.length)
		  {
		  break;

		  }
		  }
		   }
		   }
		   
		   @Test (priority=3)
		   //to cart
		   public void cart() throws InterruptedException {
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//a[@class=\"shopping_cart_link\"]")).click();
		   }
		   
		   @Test(priority=4)
		   //remove item to cart
		   public void remove() throws InterruptedException
		   {
		   String[] itemList= {"Sauce Labs Fleece Jacket"};

		   Thread.sleep(2000);
		  int j=0;
		  List<WebElement> products=driver.findElements(By.className("inventory_item_name"));
		  for(int i=0;i<products.size();i++)

		  {
		  Thread.sleep(2000);
		  WebElement name=products.get(i);
		  String formattedName=name.getText();
		  List items=Arrays.asList(itemList);
		  if(items.contains(formattedName))
		  {
		  j++;
		  driver.findElements(By.xpath("//div[@class='item_pricebar']//button")).get(i).click();
		  if(j==itemList.length)
		  {
		  break;

		  }
		  }
		   }
		   }
		   
		  @Test(priority=5)
		  //for continue 
		  public void shopping() throws InterruptedException
		  {
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//button[@id='continue-shopping']")).click();
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

		  }

		  @Test(priority=6)
		  //for checkout in account
		  public void checking() throws InterruptedException {
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//button[@id=\"checkout\"]")).click();
		  }

		  @Test(priority=7)
		  //for input values
		  public void Input() throws InterruptedException {
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//input[@id=\"first-name\"]")).sendKeys("Divesh");
		  driver.findElement(By.xpath("//input[@id=\"last-name\"]")).sendKeys("Sachdeva");
		  driver.findElement(By.xpath("//input[@id=\"postal-code\"]")).sendKeys("L6Y3S7");
		  }

		  @Test(priority=8)
		  //for next button
		  public void buttoncontinue() throws InterruptedException {
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//input[@id=\"continue\"]")).click();
		  }

		  @Test(priority=9)
		  //for endinng
		  public void end() throws InterruptedException {
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//button[@id=\"finish\"]")).click();
		  }
		  @Test(priority=10)
		  //for go to home page
		  public void backtohomepage() throws InterruptedException {
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//button[@id=\"back-to-products\"]")).click();
		  }
		  }
