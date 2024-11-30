package dev.selenium.functional_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ProductFunctionalTest {

	private WebDriver driver;

	@BeforeEach
	void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterEach
	void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	void testCreateProductValid() {
		driver.get("http://localhost:8083/product/new");

		WebElement productId = driver.findElement(By.name("productId"));
		WebElement description = driver.findElement(By.name("description"));
		WebElement price = driver.findElement(By.name("price"));
		WebElement imageUrl = driver.findElement(By.name("imageUrl"));
		WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

		productId.sendKeys("12345");
		description.sendKeys("Producto válido");
		price.sendKeys("25.99");
		imageUrl.sendKeys("https://example.com/product.jpg");
		submitButton.click();

		// Verificar que el producto fue creado
		assertTrue(driver.getPageSource().contains("Producto válido"));
	}

	@Test
	void testCreateProductEmptyFields() {
		driver.get("http://localhost:8083/product/new");

		WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
		submitButton.click();

		// Verificar que aparezca un mensaje de error
		assertTrue(driver.getPageSource().contains("Todos los campos son obligatorios"));
	}

	@Test
	void testCreateProductNegativePrice() {
		driver.get("http://localhost:8083/product/new");

		WebElement productId = driver.findElement(By.name("productId"));
		WebElement description = driver.findElement(By.name("description"));
		WebElement price = driver.findElement(By.name("price"));
		WebElement imageUrl = driver.findElement(By.name("imageUrl"));
		WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

		productId.sendKeys("12346");
		description.sendKeys("Producto con precio negativo");
		price.sendKeys("-5.00");
		imageUrl.sendKeys("https://example.com/product.jpg");
		submitButton.click();

		// Verificar mensaje de error
		assertTrue(driver.getPageSource().contains("El precio no debe ser negativo"));
	}

	@Test
	void testCreateProductDuplicateID() {
		driver.get("http://localhost:8083/product/new");

		WebElement productId = driver.findElement(By.name("productId"));
		WebElement description = driver.findElement(By.name("description"));
		WebElement price = driver.findElement(By.name("price"));
		WebElement imageUrl = driver.findElement(By.name("imageUrl"));
		WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

		productId.sendKeys("235268845711068308"); // ID existente
		description.sendKeys("Producto duplicado");
		price.sendKeys("15.99");
		imageUrl.sendKeys("https://example.com/product.jpg");
		submitButton.click();

		// Verificar mensaje de error
		assertTrue(driver.getPageSource().contains("El ID ya existe!"));
	}
	@Test
	void testCreateProductInvalidURL() {
	    driver.get("http://localhost:8083/product/new");

	    WebElement productId = driver.findElement(By.name("productId"));
	    WebElement description = driver.findElement(By.name("description"));
	    WebElement price = driver.findElement(By.name("price"));
	    WebElement imageUrl = driver.findElement(By.name("imageUrl"));
	    WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));

	    productId.sendKeys("12348");
	    description.sendKeys("Producto con URL inválida");
	    price.sendKeys("18.99");
	    imageUrl.sendKeys("invalid-url");
	    submitButton.click();

	    // Verificar mensaje de error
	    assertTrue(driver.getPageSource().contains("URL Inválido"));
	}


}
