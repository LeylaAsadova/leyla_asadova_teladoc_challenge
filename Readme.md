# leyla_asadova_teladoc_challenge Project with Maven, Cucumber, and Page Object Model

## Project Structure

This project follows the Page Object Model (POM) design pattern and integrates Selenium with Cucumber 
for Behavior-Driven Development (BDD). 
Below is an overview of the project structure:

```
src
├── test
 ├── java
 │ ├── pages
 │ ├── step_definitions
 │ └── utils
 ├── resources
 │ ├── config
 └── features
```

### Directories

- `src/test/resources/features`: Contains all Cucumber feature files in BDD format.
- `src/test/java/step_definitions`: Contains all BDD step definitions - java implementations.
- `src/test/java/pages`: Contains page object locators and reusable methods with PageFactory implementation.
- `src/test/java/utilities`: Contains utility classes like BrowserFactory, ConfigurationReader.
- `src/test/resources/config`: Contains configuration files, including environment variables and service credentials.

## Design Patterns

### Singleton WebDriver
The WebDriver instance is implemented using the Singleton design pattern to ensure that 
only one instance of WebDriver is created and shared across the tests. This will make sure both sequential and parallel execution achieved.

### Page Object Model (POM)
Page classes contain web element locators and methods to interact with the web elements. PageFactory is used for initializing web elements.

### Cucumber BDD
Feature files are written in Gherkin syntax and stored in the `features` directory. Step definitions are implemented in the `step_definitions` package.

## Setup and Installation

1. **Clone the repository:**
   * git clone <repository-url>

2. Install dependencies:
Make sure you have Maven installed. Run the following command to install the project dependencies:
   * mvn clean install

3. Running Tests 
   * Using Maven
      * Execute tests with a custom tag and browser: This command will execute tests tagged with @regression using the Chrome browser.
        * mvn clean verify -Dtest=UITestRunner -Dbrowser=chrome -Dcucumber.filter.tags="@regression"
       * Execute tests with default browser and default tag - @regression tag:
        * mvn clean verify -Dtest=UITestRunner

4. Reporting
The test reports will be generated automatically after the Maven execution. You can find the reports in the target directory.
   target/cucumber-html-reports/overview-features.html
5. Hooks
The Hooks class contains setup and teardown methods:
  * Setup: Creates a browser instance before each scenario.
  * Teardown: Closes the browser after each scenario and takes screenshots on failure. 

## Contributions and License
Feel free to clone this repository and submit pull requests. For significant changes, please open an issue first to discuss what you would like to change.

License
This project is meant for teladoc challenge

This `README.md` provides an overview of the project, setup instructions, and details on leyla_asadova_teladoc_challenge project.