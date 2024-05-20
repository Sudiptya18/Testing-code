import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.Select;
import java.io.FileReader;
import java.util.List;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.By;

public class Testtillimport {

    public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
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
            nrcInput.sendKeys("111111111");

            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[2]/form/div[2]/button")));
            searchButton.click();
            Thread.sleep(4000);

            WebElement attendToPatientButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div[3]/div/div/div/div[2]/div[2]/button[4]")));
            attendToPatientButton.click();
            Thread.sleep(2000);
            
//            WebElement skipButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div[2]/div/div/div[2]/div[2]/div/button[1]")));
//            skipButton.click();
//            Thread.sleep(2000);
//
//            WebElement technicalIssuesCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div[2]/div/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/div/input")));
//            technicalIssuesCheckbox.click();
//            Thread.sleep(2000);
//
//            WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div[2]/div/div/div[2]/div/div[3]/div/button[2]")));
//            saveButton.click();
            
            WebElement vitalButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div/div[2]/div/div[2]/a/div"))); 
            vitalButton.click();
           
            try (CSVReader csvReader = new CSVReader(new FileReader("C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\Test\\Testdata\\Sample Dataset.csv"))) {
                List<String[]> records = csvReader.readAll();
                boolean firstRow = true;

                for (String[] record : records) {
                    if (firstRow) {
                        firstRow = false;
                        continue; // Skip header row
                    }

                    WebElement addVitalButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/div/div/div/div[1]/div/button")));
                    js.executeScript("arguments[0].scrollIntoView(true);", addVitalButton);
                    js.executeScript("arguments[0].click();", addVitalButton);
                    Thread.sleep(2000);

                    fillVitalForm(driver, wait, js, record);

                    WebElement saveVitalButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/form/div[2]/div/button[2]")));
                    js.executeScript("arguments[0].scrollIntoView(true);", saveVitalButton);
                    js.executeScript("arguments[0].click();", saveVitalButton);
                    Thread.sleep(5000);
                }
            } catch (IOException | CsvException e) {
                e.printStackTrace();
            }
        } finally {
            driver.quit();
        }
    }

    private static void fillVitalForm(WebDriver driver, WebDriverWait wait, JavascriptExecutor js, String[] record) {
        try {
//            WebElement clearDatenTime = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/form/div[1]/div/div/div/div[1]/div/div[2]/div/button")));
//            clearDatenTime.click();
//            Thread.sleep(2000);
            
            WebElement dateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/form/div[1]/div/div/div/div[1]/div/div[2]/div/input")));
            js.executeScript("arguments[0].value='" + record[1] + "';", dateInput);
            Thread.sleep(2000);
            
            WebElement timeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/form/div[1]/div/div/div/div[2]/div/div[2]/div/input")));
            timeInput.sendKeys(record[2]);
            Thread.sleep(2000);

            WebElement weightInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/form/div[1]/div/div/div/div[3]/div/input")));
            weightInput.clear(); // Clear the input field
            weightInput.sendKeys(record[3]); // Enter the new value
            Thread.sleep(2000);

            WebElement heightInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/form/div[1]/div/div/div/div[4]/div/input")));
            heightInput.clear(); // Clear the input field
            heightInput.sendKeys(record[4]); // Enter the new value
            Thread.sleep(2000);

            WebElement temperatureInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/form/div[1]/div/div/div/div[5]/div/input")));
            temperatureInput.sendKeys(record[5]);
            Thread.sleep(2000);
            
            WebElement systolicBPInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/form/div[1]/div/div/div/div[6]/div/input")));
            systolicBPInput.sendKeys(record[6]);
            Thread.sleep(2000);

            WebElement diastolicBPInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/form/div[1]/div/div/div/div[7]/div/input")));
            diastolicBPInput.sendKeys(record[7]);
            Thread.sleep(2000);

            WebElement heartRateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/form/div[1]/div/div/div/div[9]/div/input")));
            heartRateInput.sendKeys(record[8]);
            Thread.sleep(2000);

            WebElement respiratoryRateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/form/div[1]/div/div/div/div[10]/div/input")));
            respiratoryRateInput.sendKeys(record[9]);
            Thread.sleep(2000);

            WebElement o2SaturationInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/form/div[1]/div/div/div/div[11]/div/input")));
            o2SaturationInput.sendKeys(record[10]);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
