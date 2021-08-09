@regression
Feature: Modify and Delete the added computer
   Scenario: Amend and delete the updated computer in the application
    And selects add computer
    And computer is added with only name
    Then computer is added to the database
    When searches for existing saved computer
    And details of saved computer are amended
    Then updated details are saved in the application
    When searches for existing saved computer
    Then selecting delete computer removes the computer from the application


