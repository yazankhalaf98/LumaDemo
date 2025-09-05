package pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateUser {
	
	 WebDriver driver;
	 
	    public CreateUser(WebDriver thedriver) {
	        this.driver = thedriver;
	    }
	    
	    By firstname =By.name("fname");
	    By lastname =By.name("lname");
	    By email =By.name("email");
	    By Password =By.name("password");
	    By confirmPass =By.xpath("(//input[@type='password'])[2]");
	    
	    
	    
public void  Fillform(  String f, String l , String mail ,  String pass ) { 
	    	
	    	driver.findElement(firstname).sendKeys(f);
	        driver.findElement(lastname).sendKeys(l);
	        driver.findElement(email).sendKeys(mail);
	        driver.findElement(Password).sendKeys(pass);
	        driver.findElement(confirmPass).sendKeys(pass);
}
	    


}
