package test;

import com.opencsv.exceptions.CsvException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
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
 * @author USER
 */
public class AdmitPatient {
public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://carepro-training.ihmafrica.com/");
        driver.manage().window().maximize();
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[3]/form/div/div[1]/input")));
        usernameField.sendKeys("tester");
        Thread.sleep(2000);
        
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[3]/form/div/div[2]/div[2]/input")));
        passwordField.sendKeys("tester2023!");
        Thread.sleep(2000);
        
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[3]/form/div/div[4]/button")));
        loginButton.click();
        Thread.sleep(10000);
        
        WebElement provinceDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[3]/form/div[1]/div[1]/select")));
        Select provinceSelect = new Select(provinceDropdown);
        provinceSelect.selectByVisibleText("Lusaka");
        Thread.sleep(5000);
        
        WebElement districtDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[3]/form/div[1]/div[2]/select")));
        Select districtSelect = new Select(districtDropdown);
        districtSelect.selectByVisibleText("Lusaka");
        Thread.sleep(4000);
        
        WebElement facilityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[3]/form/div[1]/div[3]/div/div[2]/input")));
        facilityInput.sendKeys("Dr");
        
        WebElement dropdownOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Dr. Watson Dental Clinic')]")));
        dropdownOption.click();
        
        WebElement enterButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[3]/form/div[3]/button")));
        enterButton.click();
        
        WebElement nrcButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div[1]/button[2]")));
        nrcButton.click();
        
        WebElement nrcInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/form/div[1]/div/div/input")));
        nrcInput.sendKeys("555555555");
        
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/form/div[2]/button")));
        searchButton.click();
        Thread.sleep(4000);
        
        WebElement admissionButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[3]/div/div/div/div[2]/div[2]/button[1]")));
        admissionButton.click();
        Thread.sleep(4000);
        
        WebElement admitPatientButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div/div[2]/div/div[1]/div[2]/button")));
        admitPatientButton.click();
        Thread.sleep(4000);
        
        WebElement admitDepartmentDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div[2]/div/div/div[2]/div/div/form/div[1]/div[2]/div/select")));
        Select DepartmentSelect = new Select(admitDepartmentDropdown);
        DepartmentSelect.selectByVisibleText("Emergency Room");
        Thread.sleep(5000);
        
        WebElement FirmDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div[2]/div/div/div[2]/div/div/form/div[1]/div[3]/div/div[1]/div/select")));
        Select FirmSelect = new Select(FirmDropdown);
        FirmSelect.selectByVisibleText("Lifeline Response");
        Thread.sleep(5000);
        
        WebElement WardDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div[2]/div/div/div[2]/div/div/form/div[1]/div[3]/div/div[2]/div/select")));
        Select wardSelect = new Select(WardDropdown);
        wardSelect.selectByVisibleText("Word-1");
        Thread.sleep(5000);
        
        WebElement admitBedDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div[2]/div/div/div[2]/div/div/form/div[1]/div[3]/div/div[3]/div/select")));
        Select BedSelect = new Select(admitBedDropdown);
        BedSelect.selectByValue("2524");
        Thread.sleep(5000);
        
        WebElement CommentInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div[2]/div/div/div[2]/div/div/form/div[1]/div[4]/div/textarea")));
        CommentInput.sendKeys("About to Die!");
        Thread.sleep(4000);
        
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div[2]/div/div/div[2]/div/div/form/div[2]/button[2]")));
        submitButton.click();
        
    }
}
