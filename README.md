# Automation-Assessment-Task

This repository contains an automation framework built using Selenium WebDriver, Cucumber (for BDD), and Page Object Model (POM) to automate the sign-up and login flow of the Magento website (https://magento.softwaretestingboard.com/).

Project Structure
/src/main/java/com.signup.pages: Contains Page Object Model classes for different pages (Create New Account, Sign In).
/src/main/java/com.signup.utils: Web driver manager to manage the web driver sessions and actions associated with the web (chrome or any other).
/src/main/java/com.signup.step_definitions: Cucumber step definitions for automation steps.
/src/test/java/com.signup.runner/Runner.java: Cucumber test runner to execute the feature files.
/src/test/resources/features: Contains the .feature files written in Gherkin format.
/pom.xml: Maven configuration file to manage dependencies.
/test-cases.xlsx: Excel file documenting Traditional and BDD-style test cases.
Prerequisites
Before running the tests, ensure you have the following installed:

Java (JDK 8 or higher)
Maven for dependency management and build
ChromeDriver (or another browser driver.

Setup & Installation
Clone the repository:

git clone https://github.com/Sunansh/Automation-Assessment-Task.git
cd Automation-Assessment-Task
Install project dependencies using Maven:

mvn clean install

Running the Tests
To execute the tests, run the following Maven command:

mvn test
This will run all Cucumber tests defined in the .feature files.

Test Cases
The test cases for the sign-up and login flow are written in BDD format and are documented in the test-cases.xlsx file.

Dependencies
This project uses the following dependencies:

Selenium WebDriver for browser automation
Cucumber for BDD-style testing
JUnit for running test cases
Maven for managing dependencies
Page Object Model (POM)
The Page Object Model is implemented to separate page-specific interactions and web elements into dedicated classes.
