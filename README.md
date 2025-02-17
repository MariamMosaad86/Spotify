# Spotify

This repository contains automated test cases for the Spotify website. The test cases cover various scenarios such as user registration, login, adding products to the cart, and placing orders. This project follows the Page Object Model (POM) for better organization and maintainability.

## Prerequisites

To run these test cases, ensure the following tools and dependencies are installed:

- **Selenium WebDriver** (for browser automation)
- **Java** (depending on the language you are using)
- **Maven/NPM** (for managing dependencies)
- **TestNG** (for running the test cases)
- **Browser**: Chrome (based on current settings)



## Setup

1. Clone this repository to your local machine:
   ```bash
   git clone https://github.com/MariamMosaad86/Spotify
   ```
2. Install the required dependencies:
   ```bash
   npm install / mvn install
   ```
3. Configure the browser settings in the properties file:
   - **BrowserType**: CHROME
   - **HeadlessMode**: false
   - **BaseURL**: `https://open.spotify.com/`

## Running the Tests

### Running Selenium Tests

To execute all test cases, use the following command:
```bash
npm test / mvn test
```

You can also run individual test cases by specifying the test case file.


## Project Structure

This project follows a structured layout for better modularity and clarity:

```
Spotify
│
├── main
│   └── java
│       ├── browserActions          # Handles browser-specific actions
│       ├── driverFactory           # Sets up WebDriver configurations
│       ├── elementActions          # Methods for interacting with web elements
│       ├── listeners               # Test listeners for reporting/logging
│       ├── pages                   # Page Object Model (POM) classes for web pages
│       └── utilities               # Utility classes for reusable methods
│
├── resources
│   ├── Reporting.properties        # Reporting configuration settings
│   └── WebConfigurations.properties # WebDriver and browser settings
│
├── test
    └── java
        └── tests                   # Test classes for each test case
            ├──Sigup on spotify.com
            ├── Login to spotify
            ├── Logout from spotify
            ├── Add PlayList
            ├── Run The PlayList
            
### Explanation:

- **browserActions**: Handles browser-level actions like opening and closing.
  
- **driverFactory**: Configures and initializes the WebDriver.

- **elementActions**: Contains methods to interact with web elements like click, type, select, etc.

- **listeners**: Tracks test execution, logs information, and handles reporting.

- **pages**: POM classes representing different pages of the Automation Exercise website.

- **utilities**: Contains utility methods used across different classes.

- **resources**: Includes property files for configuration settings related to WebDriver and reporting.

