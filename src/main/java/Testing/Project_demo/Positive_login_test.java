package Testing.Project_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Positive_login_test {

    public static void main(String[] args) {

       
    	WebDriverManager.chromedriver().setup();
    	
		WebDriver driver = new ChromeDriver();
       

        
        driver.get("https://practicetestautomation.com/practice-test-login/");

     
        driver.manage().window().maximize();

        
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        
        usernameField.sendKeys("student");
        passwordField.sendKeys("Password123");

     
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("practicetestautomation.com/logged-in-successfully/")) {
            System.out.println("✅ URL verification passed!");
        } else {
            System.out.println("❌ URL verification failed!");
        }

        
        WebElement pageBody = driver.findElement(By.tagName("body"));
        if (pageBody.getText().contains("Congratulations") || pageBody.getText().contains("successfully logged in")) {
            System.out.println("✅ Text verification passed!");
        } else {
            System.out.println("❌ Text verification failed!");
        }

        
        try {
            WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Log out']"));
            if (logoutButton.isDisplayed()) {
                System.out.println("✅ Log out button is displayed!");
            }
        } catch (Exception e) {
            System.out.println("❌ Log out button not found!");
        }

        
        driver.quit();
    }
}
