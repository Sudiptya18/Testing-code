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
