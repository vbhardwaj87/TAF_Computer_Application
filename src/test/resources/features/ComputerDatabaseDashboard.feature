Feature: Validate the Dashboard for the Computer Database application
  Background: Given user is on the homepage of computer database application
  @GUI
  Scenario: Verify the buttons and links on the dashboard
    When Play sample application — Computer database link is displayed on the dashboard
    Then buttons to add the computer is displayed

  @GUI
  Scenario: Validate the webtable on the Dashboard
    And computers table is displayed with the columns
    Then previous and next button are displayed for navigation

  @regression
  Scenario: Verify the descending sorting on the computer table
    And computers table is displayed with the columns
    Then table is sorted by descending when computer name heading is clicked

  @GUI
  Scenario: Verify that computer details table has four columns
    And computers table is displayed with the columns
    Then four columns are displayed in the table header

  @regression
  Scenario: Verify that the count of the computer on the Dashboard matches with the pagination
    And computers table is displayed with the columns
    Then count of computers matches with the pagination











