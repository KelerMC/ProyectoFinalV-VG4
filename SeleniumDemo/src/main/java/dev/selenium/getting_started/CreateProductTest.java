package dev.selenium.getting_started;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateProductTest {

	// Método principal para ejecutar los casos de prueba
	public static void main(String[] args) {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		String title = driver.getTitle();
		System.out.println("Web form: " + title);
		WebElement textBox = driver.findElement(By.name("my-text"));
		WebElement submitButton = driver.findElement(By.cssSelector("button"));
		textBox.sendKeys("Selenium");
		submitButton.click();
		WebElement message = driver.findElement(By.id("message"));
		String value = message.getText();
		System.out.println("Received! " + value);
		driver.quit();
	}
}
