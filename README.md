# spirteCloud
TestNG -Test automation framework developed using Java and Selenium with page object model. Developed as a Maven project that can be easily integrated with Jenkins and run the test.

******About the project

Test automation framework contains following packages and files as shown

Project: Testing http://automationpractice.com/

Packages

pages: This package contains all the page classes. All the static methods that are defined in the each page class can be re used in test classes by importing the class to perform actions on web elements.

webdriver: This package contains test classes where handle everything related to selenium webdriver

utils: This package contains different classes can be shared through all classes

Xml files:
1.pom.xml Contains all the plugins and dependencies that are required to run the test as maven project. testng.xml is configured in this pom.xml to trigger the test.
2.testng.xml Contains the all class names that are to be triggered to run the complete suite of test cases.

Test Output folders. Reports like index.html and testng-results.xml are generated under these folders once the test is run. 
reportPath = baseDirecotry + "test-output/Extent.html"
reportPath = baseDirecotry + "target/surefire-reports/index.html" 
reportPath = baseDirecotry + "test-output/emailable-report.html"

Instructions to run the test automation:

Method1 : To Run as Maven Project locally

Install and set up Java

Install and set up Maven plugin

Clone the project.

Open IntelliJ IDEA , from file menu press open -> choose your local git project repo. 
use below commands to run Navigate to the project main folder using terminal 
or cmd and type below commands ========> mvn test

Method2 : To Run as Maven Project using Jenkins
Install and set up Jenkins Fork the project to your account Configure to Jenkins as maven project and build the test.

Method3 : To Run manually
Download all the below required jars and configure in build path
• Download and add Selenium Jars to the project build path Go to http://www.seleniumhq.org/download/ Download Selenium Client & WebDriver Language Bindings for Java and add to Java build path.

• Download and set Web driver for example chromedriver to invoke the Chrome browser (default browser).

• Download the project, Open the project using IDE and run the testng.xml as testng suite to obtain the results.