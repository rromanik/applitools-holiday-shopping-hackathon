# applitools-holiday-shopping-hackathon
This project is my submission to Applitools Holiday Shoping Hackathon organized by [Applitools](https://applitools.com/).  
The hackathon instructions can be found here: https://applitools.com/hackathon-v20-3-instructions/  
Out of Eligible Testing Frameworks, I selected
* Selenium WebDriver

Out of Eligible programming languages, I selected
* Java

## Prerequisites
To execute the test on a local machine, the following needs to be installed:
* [Java (JDK 8+)](https://www.oracle.com/java/technologies/javase-downloads.html)
* [Maven](https://maven.apache.org/)
* [Google Chrome](https://www.google.com/chrome/)

## Test Execution
### Part 1
Run the following Maven command from the root folder of the project:  
```mvn clean test -Dprofile=part1```  
This will execute the three tests, i.e. 'main page', 'filter by color', and 'product details', in Chrome browser locally.   
The Eyes will execute each of the three tests across the following configurations 
using [Applitools Ultrafast Grid](https://applitools.com/docs/topics/sdk/vg-configuration.html?Highlight=grid).  
* Chrome (1200 x 800)  

The tests will run against the V1 production version, `URL=https://demo.applitools.com/tlcHackathonMasterV1.html`.

### Part 2
Run the following Maven command from the root folder of the project:  
```mvn clean test -Dprofile=part2```  
This will execute the three tests in Chrome browser locally.
The Eyes will execute each of the three tests across the following configurations 
using [Applitools Ultrafast Grid](https://applitools.com/docs/topics/sdk/vg-configuration.html?Highlight=grid).  
* Chrome (1200 x 800)  

The tests will run against the dev-branch version, `URL=https://demo.applitools.com/tlcHackathonDev.html`.

### Part 3
Run the following Maven command from the root folder of the project:  
```mvn clean test -Dprofile=part3```  
This will execute the three tests in Chrome browser locally.
The Eyes will execute each of the three tests across the following configurations
using [Applitools Ultrafast Grid](https://applitools.com/docs/topics/sdk/vg-configuration.html?Highlight=grid):
* Chrome (1200 x 800)
* Firefox (1200 x 800)
* Edge Chromium (1200 x 800)
* Safari (1200 x 800)
* iPhone X  

NOTE: for `iPhone X` the PORTRAIT orientation will be used.  
The tests will run against the final production version, `URL=https://demo.applitools.com/tlcHackathonMasterV2.html`.

### Other Supported Configurations
The table below summarizes the properties that can be provided via Maven command line arguments, 
or via `config.properties` file.  
Usage example for Maven: `-Dapp.url=https://demo.applitools.com/tlcHackathonMasterV2.html`  

|                           | Property           | Supported values      | Notes |
|---------------------------|--------------------|-----------------------|-------|
| Application URL           | app.url            | <any_value>           | The value can be any URL for the AppliFashion app  |
| UFG Browser configuration | ufg.browser.config | 'single', 'multiple'  | 'single' will run for Chrome (1200 x 800) only, 'multiple' - for 5 browsers|
| Applitools API KEY        | applitools.api.key | <your_api_key>        | If you want to execute tests and get the result on your UFG dashboard, provide your key via command line or into 'config.properties' file  |
| Application Name          | app.name           | <any_value>           | The application name as will be associated with tests on the Applitools Eyes dashboard |

## Used Technologies / Libraries
* Applitools Eyes  
com.applitools:eyes-selenium-java3:3.186.0 - for visual testing using Applitools Ultrafast Grid;
* WebDriver Manager  
io.github.bonigarcia:webdrivermanager:4.2.2 - to automatically set up ChromeDriver for local run;
* JUnit 5  
org.junit.jupiter:junit-jupiter-api:5.7.0  
org.junit.jupiter:junit-jupiter-api:5.7.0 - as the test runner.


## My Hackathon Experience
