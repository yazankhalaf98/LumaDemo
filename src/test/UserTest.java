package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CreateUser;
import pages.SignupPage;
import utils.DriverFactory;
import utils.TestData;

public class UserTest {

    WebDriver driver;
    CreateUser createUser; 
    String firstname;
    String lastname;
    String email;
    String confirmpass;
    String password = confirmpass;
    

    @BeforeTest
    public void setup() {
        driver = DriverFactory.getDriver();  
        driver.get("https://luma.enablementadobe.com");
        createUser = new CreateUser(driver); 
        driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
  
    
    }

    @Test(priority = 1)
    public void CreateAccount() throws InterruptedException {
        Thread.sleep(4000);
        driver.get("https://luma.enablementadobe.com/content/luma/us/en/community/signin.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,150)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div/div/div/div/div/form/div[2]/span[1]/a")).click();
        
        firstname = TestData.getRandomFirstName();
        lastname = TestData.getRandomLastName();

        email = TestData.getEmail(firstname, lastname);
        password = TestData.getRandomPass();
       
      
        
        System.out.println("🧪 Signup email: " + email);
        System.out.println("🔑 Password: " + password);
        createUser.Fillform(firstname, lastname, email, password );
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div/div/div/div/div/div/div/div[2]/a")).click();
        
        
      
        
        	
        	
        }
    @Test(priority = 2)
    public void loginpage() throws InterruptedException {
    	  JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("window.scrollTo(0,200)");
          Thread.sleep(2000);

          if (email != null && password != null) {
              driver.findElement(By.name("j_username")).sendKeys(email);
              driver.findElement(By.name("j_password")).sendKeys(password);
              Thread.sleep(2000);
              driver.findElement(By.xpath("//button[@type='submit']")).click();
          } else {
              System.err.println("❌ Email or password is null. Make sure testSignup() ran first.");
          }
    	
    	
    	
    }
    
    @Test(priority = 3)
    public void AddtoProduct () throws InterruptedException {
        Thread.sleep(2000);

        List<WebElement> products = driver.findElements(By.cssSelector(".we-ProductsGrid-item-link"));

        if (products.size() > 0) {
            int randomIndex = (int) (Math.random() * products.size());

            products.get(randomIndex).click();
            Thread.sleep(2000);

            WebElement addToCartBtn = driver.findElement(By.xpath("//button[@type='submit']"));
            addToCartBtn.click();
            Thread.sleep(2000);

            System.out.println("✅ Added random product to cart: " + randomIndex);
        } else {
            System.out.println("❌ No products found.");
        }
        driver.findElement(By.xpath("(//button[@type=\"submit\"])[1]")).click();
        driver.findElement(By.xpath("//a[@class=\"btn btn-primary btn-action pull-right\"]")).click();
    }
    
    @Test(priority = 4)
    public void CheckOut() throws InterruptedException {
    	
    	driver.findElement(By.xpath("//*[@id=\"page-d534efa0bb\"]/div[1]/div/div/div[2]/div/div[5]/a")).click();
    	driver.findElement(By.name("shipping.firstname")).sendKeys(firstname);
    	driver.findElement(By.name("shipping.lastname")).sendKeys(lastname);
    	driver.findElement(By.name("shipping.street1")).sendKeys("Amman");
    	driver.findElement(By.name("shipping.street2")).sendKeys("Amman");
    	driver.findElement(By.name("shipping.city")).sendKeys("Amman");
    	driver.findElement(By.name("shipping.zip")).sendKeys("1118");
    	
    	
    	Thread.sleep(2000);
    	WebElement selectTag = driver.findElement(By.name("shipping.country"));

		Select myselect = new Select(selectTag);
		
		myselect.selectByIndex(5);
		
		Thread.sleep(2000);
		WebElement RadioButtonField = driver.findElement(By.xpath("//*[@id=\"checkout\"]/div[2]/div/div[4]"));

		RadioButtonField.findElements(By.tagName("input")).get(1).click();
		driver.findElement(By.id("form-button-1573303396")).click();
		driver.findElement(By.id("form-button-1244170883")).click();
		driver.findElement(By.xpath("//a[@role=\"button\"]")).click();





    	
    	
    }
    
   
    }
    
    
    
    


