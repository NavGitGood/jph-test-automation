@positive
Feature: Todos

  Scenario: Todos route - no query parameter
    Given the url for JPH
    When get request is made for todos endpoint
    Then there should be 200 records in response
    And should follow the schema for todos