package org.springframework.samples.petclinic.Functional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.samples.petclinic.PetClinicApplication;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = PetClinicApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OwnerPetVisitFunctionalTests {

	@LocalServerPort
	private int port;

	private WebDriver driver;

	private WebDriverWait wait;

	@BeforeEach
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	@AfterEach
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void testCreateOwnerAndAddPet() {
		// Navegar a la página de creación de dueño
		driver.get("http://localhost:" + port + "/owners/new");

		// Verificar que estamos en la página de creación de dueños
		wait.until(ExpectedConditions.titleContains("New Owner"));

		// Rellenar el formulario para crear un nuevo dueño
		driver.findElement(By.id("firstName")).sendKeys("John");
		driver.findElement(By.id("lastName")).sendKeys("Doe");
		driver.findElement(By.id("address")).sendKeys("123 Elm Street");
		driver.findElement(By.id("city")).sendKeys("Springfield");
		driver.findElement(By.id("telephone")).sendKeys("1234567890");

		// Enviar el formulario
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		// Verificar que el dueño fue creado con éxito
		WebElement ownerInfoHeader = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Owner Information')]")));
		assertThat(ownerInfoHeader.getText()).contains("Owner Information");

		// Agregar una mascota al dueño creado
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add New Pet"))).click();
		wait.until(ExpectedConditions.titleContains("Add Pet"));

		driver.findElement(By.id("name")).sendKeys("Buddy");
		driver.findElement(By.id("birthDate")).sendKeys("2021-01-01");

		// Seleccionar el tipo de mascota
		WebElement typeDropdown = driver.findElement(By.id("type"));
		Select typeSelect = new Select(typeDropdown);
		typeSelect.selectByVisibleText("dog");

		// Enviar el formulario de la mascota
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		// Verificar que la mascota fue creada con éxito
		WebElement petName = wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//table[contains(@class, 'table')]//td[contains(text(), 'Buddy')]")));
		assertThat(petName.getText()).contains("Buddy");
	}

	@Test
	public void testAddVisitToPet() {
		// Navegar a la página de dueños existentes
		driver.get("http://localhost:" + port + "/owners");

		boolean ownerFound = false;

		// Iterar sobre las páginas hasta encontrar al dueño específico
		while (!ownerFound) {
			try {
				// Buscar el dueño creado anteriormente (John Doe) en la página actual
				WebElement johnDoeLink = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.linkText("John Doe")));
				if (johnDoeLink != null) {
					johnDoeLink.click();
					ownerFound = true;
				}
			}
			catch (org.openqa.selenium.TimeoutException e) {
				// Si el dueño no está en la página actual, intentar navegar a la
				// siguiente
				// página
				List<WebElement> nextPageLinks = driver.findElements(By.linkText("›"));
				if (nextPageLinks.size() > 0) {
					nextPageLinks.get(0).click();
					wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ownersTable")));
				}
				else {
					// Si no hay más páginas, salir del bucle
					break;
				}
			}
		}

		// Verificar que se haya encontrado al dueño
		assertThat(ownerFound).isTrue();

		// Navegar a la página de agregar visita para la mascota
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add Visit"))).click();
		wait.until(ExpectedConditions.titleContains("Add Visit"));

		// Rellenar el formulario para agregar una visita
		driver.findElement(By.id("description")).sendKeys("General Checkup");
		driver.findElement(By.id("visitDate")).sendKeys("2024-11-25");

		// Enviar el formulario
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		// Verificar que la visita fue registrada con éxito
		WebElement visitDescription = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//table[contains(@class, 'table')]//td[contains(text(), 'General Checkup')]")));
		assertThat(visitDescription.getText()).contains("General Checkup");
	}

}
