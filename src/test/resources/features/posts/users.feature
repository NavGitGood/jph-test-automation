@positive
Feature: Users

  Scenario: Users route - no query parameter
    Given the url for JPH
    When get request is made for users endpoint
    Then there should be 10 records in response
    And should follow the schema for users