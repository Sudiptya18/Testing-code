package test;

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
 * @author Sudiptya
 */
public class AutomatedTesting {
    // Here I'll do Automated testing where I'll complete user authentication, Patient Data manipulated
    
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
            

            // Wait for the District dropdown to be visible and select "Lusaka"
            WebElement districtDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[3]/form/div[1]/div[2]/select")));
            Select districtSelect = new Select(districtDropdown);
            districtSelect.selectByVisibleText("Lusaka");
            Thread.sleep(4000);

            WebElement facilityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[3]/form/div[1]/div[3]/div/div[2]/input")));
            facilityInput.sendKeys("Dr");

            // Wait for the dropdown option to appear and select "Dr. Watson Dental Clinic"
            WebElement dropdownOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Dr. Watson Dental Clinic')]")));
            dropdownOption.click();

            // Wait for the Enter button to be clickable and then click it
            WebElement enterButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div/div[3]/form/div[3]/button")));
            enterButton.click();
             // Click on the NRC button
            WebElement nrcButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/div[1]/button[2]")));
            nrcButton.click();

            // Enter "111111111" in the input field that appears
            WebElement nrcInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/form/div[1]/div/div/input")));
            nrcInput.sendKeys("111111111");

            // Click on the Search button
            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/form/div[2]/button")));
            searchButton.click();
            Thread.sleep(4000);
            
            
            // On this step brings to my patient, which data I manipulated, Here I will change patient mobile No. and add one additional phone number as well
            
            
            //Click on the edit profile button
            WebElement EditProfile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[3]/div/div/div/div[2]/div[2]/a")));
            EditProfile.click();
            Thread.sleep(5000);
            
            //Click on edit in the contact information section
            WebElement Edit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div[3]/div/div[3]/div[1]/button")));
            Edit.click();
            Thread.sleep(4000);
            
            
            // Locate the contact information input field and wait until it's visible and enabled
            WebElement contactInputField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/form/div[2]/div[2]/div[1]/div[1]/div[1]/div/div[2]/div/input")));

            // Clear the input field where the value was "971122352"
            contactInputField.clear();

            // Enter the new contact number "987564321"
            contactInputField.sendKeys("987564321");

            // Add a brief pause to ensure the input is processed
            Thread.sleep(1000);



            // Locate the country code dropdown and select "AO"
            WebElement countryCodeDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/form/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/div/select")));
            Select countryCodeSelect = new Select(countryCodeDropdown);
            countryCodeSelect.selectByValue("+244");
            Thread.sleep(2000);
            
            
            // Locate the additional contact input field and enter the new mobile number "954987321"
            WebElement additionalContactInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/form/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div/input")));
            additionalContactInput.sendKeys("954987321");
            Thread.sleep(2000);

            // Click on the next button 1 to update the contact information
            WebElement nextButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/form/div[3]/div/button[2]")));
            nextButton1.click();
            Thread.sleep(2000);
            
            // Add Father's Name
            WebElement addFathersFirstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/form/div[1]/div[2]/div[2]/div[1]/div/input")));
            addFathersFirstName.sendKeys("Jesus");
            Thread.sleep(2000);
            
            WebElement addFathersLastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/form/div[1]/div[2]/div[2]/div[2]/div/input")));
            addFathersLastName.sendKeys("Christ");
            Thread.sleep(2000);
            
            WebElement FatherNationalityDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/form/div[1]/div[2]/div[2]/div[5]/div/select")));
            Select FatherNationalityselect = new Select(FatherNationalityDropdown);
            FatherNationalityselect.selectByValue("2");
            
            // Click on the next button 2 to update the contact information
            WebElement nextButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/form/div[2]/div/button[2]")));
            nextButton2.click();
            Thread.sleep(2000);
            nextButton2.click();
            Thread.sleep(2000);
            
            // Click on the Submit button to update information
            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/form/div[2]/div/button[2]")));
            submitButton.click();
    }
    
}