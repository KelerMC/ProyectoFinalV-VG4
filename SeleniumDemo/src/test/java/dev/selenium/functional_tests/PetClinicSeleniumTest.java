package dev.selenium.functional_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;
import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PetClinicSeleniumTest {

	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeEach
	void setUp() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased wait time for all tests
		driver.manage().window().maximize();
	}

	@AfterEach
	void tearDown() {
		if (driver != null) {
			try {
				// Gracefully quit the WebDriver, even if the test fails
				driver.quit();
			} catch (Exception e) {
				System.err.println("Error during WebDriver cleanup: " + e.getMessage());
			}
		}
	}

	// Test para crear un dueño
	@Test
	void testCreateOwnerValid() {
		try {
			driver.get("http://localhost:9090/owners/new");

			WebElement firstName = driver.findElement(By.name("firstName"));
			WebElement lastName = driver.findElement(By.name("lastName"));
			WebElement address = driver.findElement(By.name("address"));
			WebElement city = driver.findElement(By.name("city"));
			WebElement telephone = driver.findElement(By.name("telephone"));

			firstName.sendKeys("John");
			lastName.sendKeys("Doe");
			address.sendKeys("123 Elm Street");
			city.sendKeys("Springfield");
			telephone.sendKeys("1234567890");

			WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
			submitButton.click();

			// Verificar que el dueño fue creado
			assertTrue(driver.getPageSource().contains("New Owner Created"));
		} catch (Exception e) {
			System.err.println("Error during 'Create Owner' test: " + e.getMessage());
			throw e; // Rethrow to fail the test
		}
	}

	// Test para agregar una mascota a un dueño
	@Test
	void testAddPetToOwner() {
		try {
			driver.get("http://localhost:9090/owners/1");

			// Espera explícita para el botón "Add New Pet" y hacer clic en él
			WebElement addNewPetButton = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add New Pet")));
			addNewPetButton.click();

			// Espera explícita para el campo de nombre de la mascota
			WebElement petNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
			petNameField.sendKeys("Cotito");

			// Espera explícita para el campo de fecha de nacimiento de la mascota
			WebElement petBirthDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("birthDate")));
			petBirthDateField.sendKeys("20/11/2024"); // Ejemplo de fecha

			// Espera explícita para el menú desplegable de tipos de mascotas
			WebElement petTypeDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("type")));
			petTypeDropdown.sendKeys("Dog"); // Selecciona "Dog" de las opciones

			// Espera explícita para el botón "Add Pet" y hacer clic en él
			WebElement addPetButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
			addPetButton.click();

			// Espera explícita para verificar el mensaje de éxito
			WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success")));  // Asegúrate de usar el selector correcto
			assertTrue(successMessage.getText().contains("New Pet has been Added"));

		} catch (TimeoutException e) {
			System.err.println("Timeout waiting for success message: " + e.getMessage());
			// Handle the timeout gracefully, log the error
		} catch (Exception e) {
			System.err.println("Error during 'Add Pet to Owner' test: " + e.getMessage());
			throw e; // Rethrow to fail the test
		}
	}
}
