package ui;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.lang.Thread;
import io.github.bonigarcia.wdm.WebDriverManager;

public class test {

	public static void main(String args[]) throws Exception {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dreams.ntpc.co.in/Account/Login?ReturnUrl=%2F");

        // Find the username and password fields and enter your credentials
        WebElement usernameField = driver.findElement(By.id("Email"));
        WebElement passwordField = driver.findElement(By.id("Password"));
        usernameField.sendKeys("your_username");
        passwordField.sendKeys("your_password");

        // Check if a captcha element is present on the page
        WebElement captchaElement = driver.findElement(By.id("CaptchaImage"));

        if (captchaElement.isDisplayed()) {
            // Prompt the user to fill out the captcha manually
            JOptionPane.showMessageDialog(null, "Please fill out the captcha manually.");

            // Wait for the user to fill out the captcha (assuming the captcha element has id="captchaInput")
            WebElement captchaInput = driver.findElement(By.id("CaptchaInputText"));
            // You may need to add additional wait logic here, such as a loop or explicit wait, depending on the captcha implementation
            Thread.sleep(2000);
            // After the captcha is filled, find the login button and click it
            WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"con\"]/div/div/div[2]/div[3]/div[2]/form/div[4]/input"));
            loginButton.click();
        } else {
            // Perform other operations, such as search, download files, etc.
            // Find the login button and click it
        	WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"con\"]/div/div/div[2]/div[3]/div[2]/form/div[4]/input"));
            loginButton.click();
        }

        // Close the browser
        driver.quit();
	}
}
