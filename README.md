# Testing-code
Assignment Submission for QA Engineer

All the processes are discussed in the pdf file (Attached with Gmail), and codes are well-commented. 
Now, I just want to highlight some methods I've used during testing:
1. WebDriverWait with a timeout of 40 seconds, This will wait until the specified condition is met before proceeding.
2. I Used a try-finally block to ensure the driver quits even if an exception occurs, avoiding resource leaks.
3. Using the Select class to interact with dropdown elements.
4. After entering "Dr" in the facility input, the code waits for the specific dropdown option containing "Dr. Watson Dental Clinic" to appear and then clicks on it using the Search Facility Field.
5. Explicit Waits: Used WebDriverWait to wait for elements to be visible or clickable before interacting with them.
6. JavaScript Executor is used to scroll the element into view and click it directly. This helps bypass issues with elements being obstructed.
7. I use WebDriverWait along with ExpectedConditions to wait for elements to be visible or clickable before interacting with them.
8. The visibilityOfElementLocated and elementToBeClickable conditions ensure that the username input field, password input field, and login button are present and ready for interaction.
9. After entering credentials and clicking the login button, we wait for the next page to load (assuming there's a redirection after successful login).
10. I've created a 2D array of credentials to store multiple username-password pairs. I was looped through each pair and attempted to log in using them. After attempting each username-password pair, there's a pause of 3 seconds before starting the next test case.

In **everystepsave class**, 
* The code begins by specifying the package **test** and importing several classes necessary for web automation and file handling:
	FileWriter, IOException, PrintWriter for writing logs to a file.
	Duration, LocalDateTime, DateTimeFormatter for handling timestamps.
	By, JavascriptExecutor, WebDriver, WebElement, ChromeDriver, ExpectedConditions, Select, WebDriverWait from Selenium for web automation.

* The entry point of the program, throws InterruptedException and IOException to handle potential exceptions.

* Sets the path to the ChromeDriver executable and initializes WebDriver and WebDriverWait with a timeout of 40 seconds. A JavascriptExecutor is also created for executing JavaScript commands.

* Creates a PrintWriter for writing logs to log.csv. The log file records the timestamp, step description, and status (success or failure).
* Opens the specified URL and maximizes the browser window. Waits for the username field to be visible, enters the username "tester", and logs the step.
* Selects options from dropdowns and logs the steps.
* Catches any exceptions, logs an error step, prints the stack trace, and ensures the WebDriver quits.
* A helper method to log each step with a timestamp, step description, and status. Uses DateTimeFormatter to format the current time.

For testing everystepsave class: Just set the property for web driver, upload the selenium library (JAR file) into the package, also download and Add file commonlang 3 (https://commons.apache.org/proper/commons-lang/download_lang.cgi) for further testing. After completing the task just run the class file (everystepsave.java)
Output: The detailed output result is discussed in the doc file (I've attached it in the mail)

In **AdmitPatient.java**,
* The code starts by specifying the package **test** and importing necessary classes.
* The AdmitPatient class contains the main method for automating the patient admission process.
* Sets the path to the ChromeDriver executable and initializes WebDriver, WebDriverWait with a timeout of 40 seconds, and JavascriptExecutor for executing JavaScript commands.
* Opens the specified URL and maximizes the browser window.
* Waits for the username and password fields to be visible, enters the credentials, and waits for the login button to be clickable before clicking it.
* Waits for the province and district dropdowns to be visible, selects the appropriate options, and waits for a few seconds to ensure the selections are processed. Waits for the facility input field to be visible, enters a partial name, waits for the dropdown option to appear, clicks it, and then clicks the enter button to proceed.
* Waits for the NRC button to be clickable, clicks it, enters the NRC number, and clicks the search button. Waits for the search results to load.
* Waits for the admission button to be clickable, clicks it, waits, and then clicks the admit patient button.
* Waits for each dropdown to be visible, and selects the appropriate options for department, firm, ward, and bed. Enters a comment in the comment input field.
Finally, Waits for the submit button to be clickable and clicks it to finalize the admission process.
This code performs an automated end-to-end process of admitting a patient in a web application using Selenium WebDriver. It navigates to the login page, logs in, selects the necessary options for province, district, and facility, searches for the patient, and fills in the admission details before submitting the form. The code uses explicit waits to ensure each web element is ready before interacting with it, providing a robust and reliable automation script.

For run this test class, Just run the file after importing the necessary elements, and set web driver.

In **AutomatedTesting.java**,

The **AutomatedTesting** class performs an automated test for a web application, It completes user authentication and manipulates patient data on the website.
Steps for this testing:
Setup -> Navigation and Login -> Select Location and facility selection -> Search Patient -> Edit Patient Data -> Update Additional Information

In Edit Patient Data,
* Updates the primary contact number to "987564321".
* Selects the country code "+244".(Select by value actually it's AO)
* Adds an additional contact number "954987321".

In Update Additional Information, 
* Adds the father's first name ("Jesus") and last name ("Christ").
* Select the father's nationality from a dropdown.

For checking the file just run the java file to check whether it is successful or not.
This code effectively demonstrates the automation of a patient data manipulation workflow on a web application, utilizing explicit waits and element interactions to ensure the script runs reliably.


In **testtillimport.java**,
The **Testtillimport** class performs automated testing on the CarePro website, It also incorporates data import from a CSV file to fill in patient vital information.
Steps for this testing:
Setup -> Navigation and Login -> Select Location and facility selection -> Search Patient -> Attend to Patient -> Vital Information Entry -> Data Import Handling -> Quit

In Vital Information Entry,
* Navigate to the vital information section.
* Reads patient vital data from a CSV file.
* Iterates through each row of the CSV file, filling in vital information for each record.
* Saves the entered vital information.

In Data Import Handling,
* Use OpenCSV library to read data from the CSV file.
* Handles exceptions related to file reading and CSV parsing.

For checking the file just run the java file to check whether it is successful or not.
This code demonstrates a comprehensive automated testing process that includes interacting with web elements, navigating through the application, and importing data from an external source for testing purposes.
In **Securitytesting.java**,
The **Securitytesting** class conducts security testing by attempting to log in with different username-password pairs on the website. It verifies if login attempts are successful or not.

The following steps are:
Configures the Chrome WebDriver and maximizes the browser window. Then, navigate to the CarePro Training website. Initializes a WebDriverWait instance with a timeout duration. Defines an array of username-password pairs for testing. Iterates through each pair and enters the username and password in the respective input fields. Click the login button. Waits for 3 seconds to allow the page to load. Check if the login was successful or failed by looking for specific elements on the page. Prints the result of each login attempt. Finally, Quit the WebDriver session after completing all login attempts.

For checking the file just run the java file to check whether it is successful or not.
This code performs security testing by simulating login attempts with different credentials and validating the login outcome, which helps identify potential security vulnerabilities such as weak passwords or unauthorized access.

Note: All testing classes need libraries where the selenium drive tools are necessary. Also, for **Testtillimport** class needs commonlang drive file. So, Make sure the necessary files are there while running these files.
