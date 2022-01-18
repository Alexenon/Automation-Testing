# This is my first trial
Feature: My first cucumber test

  Background: Facebook is one of the most used
  social applications to interact with people.
  Here you can leave likes, comments, text
  with your friends and many other things.

  Scenario: Check login is successful
    Given user is on login page
    When user enters <login> and <password>
    And clicks on login button
    Then the user is logged in

  Scenario: Leave a comment to a post
    Given <user page> where user would like to leave a comment
    When user chooses a <post>
    And send <keys> in comment section
    Then the comment is posted

