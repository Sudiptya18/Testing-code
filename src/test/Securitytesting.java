package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Securitytesting {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            driver.get("https://carepro-training.ihmafrica.com/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

            // Array of username-password pairs
            String[][] credentials = {
                    {"Sudiptya", "Pass123"},
                    {"Chanda", "Pass123.."},
                    {"tester", "tester2023!"}
            };

            for (String[] credential : credentials) {
                String username = credential[0];
                String password = credential[1];
                System.out.println("Test Case: Username - " + username + ", Password - " + password);

                WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[3]/form/div/div[1]/input")));
                usernameInput.sendKeys(username);

                WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[3]/form/div/div[2]/div[2]/input")));
                passwordInput.sendKeys(password);

                WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[3]/form/div/div[4]/button")));
                loginButton.click();

                Thread.sleep(3000);

                WebElement failedLoginElement = null;
                try {
                    failedLoginElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[2]/div[3]")));
                } catch (Exception e) {
                }

                if (failedLoginElement != null) {
                    System.out.println("Login Successful");
                } else {
                    System.out.println("Login Failed!!!");
                }

                driver.navigate().refresh();
            }
        } finally {
            driver.quit();
        }
    }
}
