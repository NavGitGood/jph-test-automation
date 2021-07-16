@positive
Feature: Comments

  Scenario: Comments route - no query parameter
    Given the url for JPH
    When get request is made for comments endpoint
    Then there should be 500 records in response
    And should follow the schema for comments