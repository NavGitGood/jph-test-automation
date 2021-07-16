@positive
Feature: Photos

  Scenario: Photos route - no query parameter
    Given the url for JPH
    When get request is made for photos endpoint
    Then there should be 5000 records in response
    And should follow the schema for photos