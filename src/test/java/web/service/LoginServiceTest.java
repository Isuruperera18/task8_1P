				package web.service;

				import org.junit.Assert;
				import org.junit.Test;
				import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
				import org.openqa.selenium.WebElement;
				import org.openqa.selenium.chrome.ChromeDriver;

				public class LoginServiceTest {

				    private WebDriver setupWebDriver() {
				        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
				        WebDriver driver = new ChromeDriver();
				        driver.navigate().to("C:\\Users\\ADEEPTHA HETTI\\Downloads\\ASHAN\\Deelaka Rathnayake\\selenium\\SIT707-Software Quality & Testing\\8.1P-resources\\8.1P-resources - I\\pages\\login.html");
				        return driver;
				    }

				    private void tearDown(WebDriver driver) {
				        if (driver != null) {
				            driver.quit();
				        }
				    }

				    private void performLogin(WebDriver driver, String username, String password, String dob) {
				        WebElement usernameField = driver.findElement(By.id("username"));
				        WebElement passwordField = driver.findElement(By.id("passwd"));
				        WebElement dobField = driver.findElement(By.id("dob"));
				        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));

				        usernameField.clear();
				        usernameField.sendKeys(username);
				        passwordField.clear();
				        passwordField.sendKeys(password);
				        dobField.clear();
				        JavascriptExecutor js = (JavascriptExecutor) driver;
				        js.executeScript("arguments[0].value='" + dob + "';", dobField);
				        submitButton.click();
				    }

				    @Test
				    public void testInvalidPasswordLogin() {
				        WebDriver driver = setupWebDriver();
				        performLogin(driver, "isuru", "wrong_password", "1997-10-15");
				        Assert.assertEquals("Login Fail", driver.getTitle());
				        tearDown(driver);
				    }

				    @Test
				    public void testInvalidDOBLogin() {
				        WebDriver driver = setupWebDriver();
				        performLogin(driver, "isuru", "isuru_pass", "2000-01-01");
				        Assert.assertEquals("Login Fail", driver.getTitle());
				        tearDown(driver);
				    }

				    @Test
				    public void testAllFieldsIncorrect() {
				        WebDriver driver = setupWebDriver();
				        performLogin(driver, "wrong_user", "wrong_pass", "2000-01-01");
				        Assert.assertEquals("Login Fail", driver.getTitle());
				        tearDown(driver);
				    }

				    @Test
				    public void testEmptyFieldsLogin() {
				        WebDriver driver = setupWebDriver();
				        performLogin(driver, "", "", "");
				        Assert.assertEquals("Login Fail", driver.getTitle());
				        tearDown(driver);
				    }

				    @Test
				    public void testFieldInjectionAttack() {
				        WebDriver driver = setupWebDriver();
				        performLogin(driver, "isuru' OR '1'='1", "isuru_pass", "1997-10-15");
				        Assert.assertEquals("Login Fail", driver.getTitle());
				        tearDown(driver);
				    }

				    @Test
				    public void testResponseTimeForLogin() {
				        WebDriver driver = setupWebDriver();
				        long startTime = System.currentTimeMillis();
				        performLogin(driver, "isuru", "isuru_pass", "1997-10-15");
				        long endTime = System.currentTimeMillis();
				        Assert.assertTrue("Login response time should be less than 2000 milliseconds", (endTime - startTime) < 2000);
				        tearDown(driver);
				    }
				}
