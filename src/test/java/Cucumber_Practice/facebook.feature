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

  Scenario: Leave a like and a comment to a post
    Given <user page> where you would like to leave a comment
    When user chooses <post>
    And clicks on
