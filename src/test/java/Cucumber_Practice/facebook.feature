# This is my first trial
Feature: My first cucumber test

  Background: Login into account for better performance
    # Now goes description for access facebook page

  Scenario: Try to login in user account
    Given user is on login page
    When user enters <login> and <password>
    And clicks on login button
    Then the user is logged in


