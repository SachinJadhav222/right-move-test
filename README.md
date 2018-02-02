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

Steps to Run the test from Commadn Line (Maven)

1. Go the the terminal(command prompt)
2. Go the project root directory
3. Enter  c:\project directory > mvn clean test -Dcucumber.options="--tags @rm"
 We can choose any tag to run individual scenariao, or featurefille or entire test suit