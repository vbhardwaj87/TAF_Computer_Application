Feature: Create and Update operations on the Computer Database application
Background: Given user is on the homepage of computer database application

  @GUI
  Scenario: Checking the UI Validations while adding the computer
    And selects add computer
    When computer is added without the name
    Then computer name is highlighted as mandatory

  @GUI
  Scenario: Checking the UI validations on the date field while adding the computer
    And selects add computer
    When alphanumeric characters are entered in the Date
    Then date field are shown highlighted

  @regression
  Scenario: Adding the computer with name only
    And selects add computer
    And computer is added with only name
    Then computer is added to the database

  @regression
  Scenario: Adding the computer with the names, dates and the company
    And selects add computer
    And computer name is provided with the introduced and discontinued date
    And company name is selected
    Then computer is added to the database with the details provided

  @GUI
  Scenario: Clicking cancel button on Add Computer takes user to the Homepage
    And selects add computer
    And selects cancel button
    Then user is taken to the Homepage






