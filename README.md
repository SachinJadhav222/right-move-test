README

RightMove Automation Test

Overview

* IDE → IntelliJ Idea
* Programming Language → JAVA
* Build Management → Maven
* Web Testing Tool → Selenium WebDriver
* Cucumber Gherkin for BDD Scenarios
* Junit
* Log Mechanism → Log4j
* Reporting Structure → Cucumber Extent Report

Framework Structure

* The main code is devided into main and test folders
* main folder contains main java code 
* test folders contains test resources and feature files
* pages folder in main contains all the application page classes, where corrosponding elements of that page are initilised
* stepDefinition folder contains all the step definitions for the cucumber steps in featureFiles(test folder)
* DriverBase is parent call for all the page class(page folder),it initialise the Webdriver, it opens the broseer before Test run and close after run
* Hooks is where @Before & @After methods defined, it executes before and after every scenarios in cucumber files
*WebUtility is all common utility and frequently used method collection
 * CucumberTest class is the test runner, it contains @BeforeClass and @AfterClass annotations, which runs before and afther the Test suit run
 We can filter out which perticular scenario to run , or which feature file to run or even we can run entire test suit
 * Ccucumber files , where we describe actual test in BDD format using Gherkin Language in given when then format
 * Extent report configuration is detaisl about reporting
 * Log4J properties file is used for keeping the test log , it creates HTML file store into targte folder.
 * System property file contains details abot the System, like URL, which broser we are using, we cna change the browser and other detials from this file and it will refelct into entile framework.
 * Extent report is generated at the end of test run and stored into target folder(whic can be deleted each time we run maven test mnv clean test)

* Cucumber Feature Files 
* Step Definitions
* PageObject Model
* Page Factory
* Utility 
* CucumberTest Class(with @BeforeClass and @AfterClass ) (No need of @Test annotations to run the test)
* Test Data can be passed using Cucumber files, we can pass  parameters for test 
* Test report and Screenshots are in Target Folder(target/Test-Reports)

 Steps to Run The Test 
 
1. Go to CucumberTest class(src\test\java\com.rmtest\CucumberTest.java)
2. Select the CucumberTest
3. Enter the required Feature file or scenario Tag to run individual scenario, feature files or entire test suit
 eg. tags = {"@search_for_sale"}
4. Run the test
5. Check the test reports in target Folders (This folder will only generated after first test execution) (\target\Test-Reports)
6. Check the Screen shoots attached to the reports for failed test cases (Open the report from actual folder to see the screenshots of the failed test cases)
7. Check the Test Log for more details

Steps to Run the test from Command Line (Maven)

1. Go the the terminal(command prompt)
2. Go the project root directory
3. Enter  c:\project directory > mvn clean test -Dcucumber.options="--tags @rm"
 We can choose any tag to run individual scenariao, or featurefille or entire test suit