@positive
Feature: Albums

  Scenario: Albums route - no query parameter
    Given the url for JPH
    When get request is made for albums endpoint
    Then there should be 100 records in response
    And should follow the schema for albums