@positive
Feature: Positive Scenario

  Scenario: Post route - no query parameter
    Given the url for JPH
    When get request is made for posts endpoint
    Then there should be 100 records in response
    And should follow the schema