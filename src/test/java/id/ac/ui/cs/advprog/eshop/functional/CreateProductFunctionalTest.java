package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateProductFunctionalTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void userCanCreateProductAndSeeItInProductList() {
        driver.get("http://localhost:8080/product/create");

        driver.findElement(By.name("productId"))
                .sendKeys("FT-001");

        driver.findElement(By.id("nameInput"))
                .sendKeys("Functional Test Product");

        driver.findElement(By.id("quantityInput"))
                .sendKeys("25");

        driver.findElement(By.tagName("button")).click();

        driver.get("http://localhost:8080/product/list");

        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Functional Test Product"));
        assertTrue(pageSource.contains("FT-001"));
    }
}
