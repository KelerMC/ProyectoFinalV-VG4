package dev.selenium.functional_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class PetClinicSeleniumTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Test para crear un dueño
    @Test
    void testCreateOwnerValid() {
        driver.get("http://localhost:8080/owners/new");

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
    }

    // Test para agregar una mascota a un dueño
    @Test
    void testAddPetToOwner() {
        driver.get("http://localhost:8080/owners/new");

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

        // Agregar una mascota
        driver.findElement(By.linkText("Add New Pet")).click();
        driver.findElement(By.id("name")).sendKeys("Buddy");
        driver.findElement(By.id("birthDate")).sendKeys("2021-01-01");
        driver.findElement(By.id("type")).click();
        driver.findElement(By.cssSelector("option[value='dog']")).click();
        submitButton.click();

        // Verificar que la mascota fue añadida
        assertTrue(driver.getPageSource().contains("New Pet has been Added"));
    }

    // Test para agregar una visita a la mascota
    @Test
    void testAddVisitToPet() {
        driver.get("http://localhost:8080/owners");

        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Doe");

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        driver.findElement(By.linkText("John Doe")).click();
        driver.findElement(By.linkText("Add Visit")).click();

        driver.findElement(By.id("description")).sendKeys("General Checkup");
        driver.findElement(By.id("visitDate")).sendKeys("2024-11-25");

        submitButton.click();

        // Verificar que la visita fue registrada
        assertTrue(driver.getPageSource().contains("Your visit has been booked"));
    }

    // Test para encontrar dueño por apellido
    @Test
    void testFindOwnerByLastName() {
        driver.get("http://localhost:8080/owners/find");

        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Doe");

        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();

        // Verificar que se muestra el dueño encontrado
        assertTrue(driver.getPageSource().contains("John Doe"));
    }

    // Test para navegar a la página de Veterinarios
    @Test
    void testVetPageNavigation() {
        driver.get("http://localhost:8080/vets.html?page=1");

        WebElement page1 = driver.findElement(By.cssSelector("a[href*='page=1']"));
        page1.click();
        assertTrue(driver.getCurrentUrl().contains("page=1"));

        WebElement page2 = driver.findElement(By.cssSelector("a[href*='page=2']"));
        page2.click();
        assertTrue(driver.getCurrentUrl().contains("page=2"));
    }
}
