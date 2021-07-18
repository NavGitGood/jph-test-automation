@UserFlow
Feature: User Flow

  Scenario: User flow - verify that a user Delphine exists
    Given the url for JPH
    When get request is made for "users" endpoint
    Then a user with username "Delphine" should be present

  Scenario: User flow - verify that a user NotDelphine does not exist
    Given the url for JPH
    When get request is made for "users" endpoint
    Then a user with username "NotDelphine" should not be present

  Scenario: User flow - verify that emails in the comments made on the posts of a user Delphine are in proper format
    Given the url for JPH
    And a user with username "Delphine"
    When posts are retrieved for the user
    And comments are retrieved for those posts
    Then those comments must have emails in valid format
