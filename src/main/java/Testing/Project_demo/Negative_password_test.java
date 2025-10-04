package Testing.Project_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Negative_password_test {

	public static void main(String[] args) {
		
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
 
            driver.get("https://practicetestautomation.com/practice-test-login/");

           
            driver.manage().window().maximize();

            
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));

            
            usernameField.sendKeys("student");
            passwordField.sendKeys("incorrectPassword");

            
            WebElement submitButton = driver.findElement(By.id("submit"));
            submitButton.click();

            
            try {
                WebElement errorMsg = driver.findElement(By.id("error")); // confirm actual ID on page
                if (errorMsg.isDisplayed()) {
                    System.out.println("✅ Error message displayed!");
                    
                    String msgText = errorMsg.getText();
                    if (msgText.equals("Your password is invalid!")) {
                        System.out.println("✅ Correct error message text!");
                    } else {
                        System.out.println("❌ Incorrect error message text: " + msgText);
                    }
                }
            } catch (Exception e) {
                System.out.println("❌ Error message not found!");
            }
        } finally {
            driver.quit();
        }
	}

}
