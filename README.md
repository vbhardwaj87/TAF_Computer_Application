<H1>Test Automation Framework - Computer Database Application</H1>
                            **Vishal Bhardwaj**
<H2>**Selenium WebDriver BDD Framework using cucumber***</H2>
<body>

*This framework is developed using cucumber with Selenium Webdriver and the scenarios
are written in Gherkin plain text so any person within the team could understand
the application.

Below is the 
Project Structure:

        ├───reports
        │ └───html-reports
        │ └───cucumber-html-reports
        │ ├───css
        │ ├───embeddings
        │ ├───fonts
        │ ├───images
        │ └───js
         └───src
        ├───main
        ───java
        │ │ ├───Pages
        │ │ └───Support
        │ └───resources
        │ └───drivers
        └───test
        ├───java
        │ ├───runner
        │ └───Steps
        └───resources
        ├───config
        └───features

#Features of the Framework:

    *Utlilizes Page factory design pattern
    *Test Configuration properties can be amended as per the requirements
    *screenshots on Failure
    *Maven cucumber HTML report is generated
    *Features are placed in the Features package
    *Logging is enabled using LOG4J

</body>

#Features

This contains the Create, read, Update and Delete operations on the Computer Database Application
GUI validation scenarios are also integrated
Dashboard related scenarios are also included in the test coverage.


#Installation</H2> 

Clone the project

git clone

You need to have Java 8 JDK installed along with maven.
To install all dependencies, run

$ mvn clean install
To execute the tests

$ mvn clean test

To execute the regression only scenarios, add only the @regression tag
By default in the Test Run all scenarios are executed.


Reports are generated in the /reports folder


