README
# RightMove Automation Project
========
Overview
========
* IDE → IntelliJ Idea
* OOP Programming Language → JAVA
* Build Management → Maven
* Web Testing Tool → Selenium WebDriver
* Cucumber Gherkin for BDD Scenarios
* Junit
* Log Mechanism → Log4j
* Reporting Structure → Cucumber Extent Report


===================
Framework Structure
===================
* Cucumber Feature Files
* Step Definitions
* PageObject Model
* Page Factory
* Utility 
* Test Runner Class(with @BeforeClass and @AfterClass )
* Test report and Screenshots are in Target Folder(target/Test-Reports)

============ Steps to Run The Test =======================
1. Go to testRunners Folder (src\test\java\rightMove\testRunners)
2. Select the TestRunner
3. Enter the required Feature file or scenario Tag to run individual scenario, feature files or entire test suit
 eg. tags = {"@search_for_sale"}
4. Run the test
5. Check the test reports in target Folders (This folder will only generated after first test execution) (\target\Test-Reports)
6. Check the Screen shoots attached to the reports for failed test cases
7. Check the Test Log for more details

