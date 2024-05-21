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

* The entry point of the program, it throws InterruptedException and IOException to handle potential exceptions.

* Sets the path to the ChromeDriver executable and initializes WebDriver and WebDriverWait with a timeout of 40 seconds. A JavascriptExecutor is also created for executing JavaScript commands.

* Creates a PrintWriter for writing logs to log.csv. The log file records the timestamp, step description, and status (success or failure).
* Opens the specified URL and maximizes the browser window. Waits for the username field to be visible, enters the username "tester", and logs the step.
* Selects options from dropdowns and logs the steps.
* Catches any exceptions, logs an error step, prints the stack trace, and ensures the WebDriver quits.
* A helper method to log each step with a timestamp, step description, and status. Uses DateTimeFormatter to format the current time.

For testing everystepsave class: Just set property for web driver, upload the selenium library (JAR file) into the package, also download and Add file commonlang 3 (https://commons.apache.org/proper/commons-lang/download_lang.cgi) for further testing. After completing the task just run the class file (everystepsave.java)
Output: The detailed output result is discussed in the doc file (I've attached in the mail)

