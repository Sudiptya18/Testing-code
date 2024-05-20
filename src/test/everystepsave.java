package test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Sudiptya
 */
public class everystepsave {
    // Here I'll do Automated testing where I'll complete user authentication, Patient Data manipulated

    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try (PrintWriter writer = new PrintWriter(new FileWriter("log.csv", true))) {
            writer.println("Timestamp,Step,Status");

            driver.get("https://carepro-training.ihmafrica.com/");
            driver.manage().window().maximize();
            logStep(writer, "Navigate to site", true);

            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[3]/form/div/div[1]/input")));
            usernameField.sendKeys("tester");
            Thread.sleep(2000);
            logStep(writer, "Enter username", true);

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[3]/form/div/div[2]/div[2]/input")));
            passwordField.sendKeys("tester2023!");
            Thread.sleep(2000);
            logStep(writer, "Enter password", true);

            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[3]/form/div/div[4]/button")));
            loginButton.click();
            Thread.sleep(10000);
            logStep(writer, "Click login button", true);

            WebElement provinceDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[3]/form/div[1]/div[1]/select")));
            Select provinceSelect = new Select(provinceDropdown);
            provinceSelect.selectByVisibleText("Lusaka");
            Thread.sleep(5000);
            logStep(writer, "Select province", true);

            WebElement districtDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[3]/form/div[1]/div[2]/select")));
            Select districtSelect = new Select(districtDropdown);
            districtSelect.selectByVisibleText("Lusaka");
            Thread.sleep(4000);
            logStep(writer, "Select district", true);

            WebElement facilityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[3]/form/div[1]/div[3]/div/div[2]/input")));
            facilityInput.sendKeys("Dr");

            WebElement dropdownOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Dr. Watson Dental Clinic')]")));
            dropdownOption.click();

            WebElement enterButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[3]/form/div[3]/button")));
            enterButton.click();
            logStep(writer, "Select facility and click enter", true);

            WebElement nrcButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div[1]/button[2]")));
            nrcButton.click();
            logStep(writer, "Click NRC button", true);

            WebElement nrcInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/form/div[1]/div/div/input")));
            nrcInput.sendKeys("111111111");

            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/form/div[2]/button")));
            searchButton.click();
            Thread.sleep(4000);
            logStep(writer, "Search patient", true);

            WebElement EditProfile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[3]/div/div/div/div[2]/div[2]/a")));
            EditProfile.click();
            Thread.sleep(5000);
            logStep(writer, "Click edit profile", true);

            WebElement Edit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div[3]/div/div[3]/div[1]/button")));
            Edit.click();
            Thread.sleep(4000);
            logStep(writer, "Click edit in contact info", true);

            WebElement contactInputField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/form/div[2]/div[2]/div[1]/div[1]/div[1]/div/div[2]/div/input")));
            contactInputField.clear();
            contactInputField.sendKeys("987564321");
            Thread.sleep(1000);
            logStep(writer, "Change contact number", true);

            WebElement countryCodeDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/form/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/div/select")));
            Select countryCodeSelect = new Select(countryCodeDropdown);
            countryCodeSelect.selectByValue("+244");
            Thread.sleep(2000);
            logStep(writer, "Select country code", true);

            WebElement additionalContactInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/form/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div/input")));
            additionalContactInput.sendKeys("954987321");
            Thread.sleep(2000);
            logStep(writer, "Add additional contact number", true);

            WebElement nextButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/form/div[3]/div/button[2]")));
            nextButton1.click();
            Thread.sleep(2000);
            logStep(writer, "Click next button 1", true);

            WebElement addFathersFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/form/div[1]/div[2]/div[2]/div[1]/div/input")));
            addFathersFirstName.sendKeys("Jesus");
            Thread.sleep(2000);
            logStep(writer, "Enter father's first name", true);

            WebElement addFathersLastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/form/div[1]/div[2]/div[2]/div[2]/div/input")));
            addFathersLastName.sendKeys("Christ");
            Thread.sleep(2000);
            logStep(writer, "Enter father's last name", true);

            WebElement FatherNationalityDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/form/div[1]/div[2]/div[2]/div[5]/div/select")));
            Select FatherNationalityselect = new Select(FatherNationalityDropdown);
            FatherNationalityselect.selectByValue("2");
            logStep(writer, "Select father's nationality", true);

            WebElement nextButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/form/div[2]/div/button[2]")));
            nextButton2.click();
            Thread.sleep(2000);
            nextButton2.click();
            Thread.sleep(2000);
            logStep(writer, "Click next button 2", true);

            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/form/div[2]/div/button[2]")));
            submitButton.click();
            logStep(writer, "Click submit button", true);
        } catch (Exception e) {
            logStep(new PrintWriter(new FileWriter("log.csv", true)), "Error", false);
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    private static void logStep(PrintWriter writer, String step, boolean status) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        writer.println(dtf.format(now) + "," + step + "," + (status ? "Success" : "Failure"));
        writer.flush();
    }
}
