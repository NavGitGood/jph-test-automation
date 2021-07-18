Feature: All Base Routes

  @AllRoutes
  Scenario Outline: Basic test for all resources
    Given the url for JPH
    When get request is made for <resourceName> endpoint
    Then response code should be 200
    And there should be <recordCount> records in response
    And should follow the schema for <resourceName>

    Examples:
      | resourceName | recordCount |
      | "albums"     | 100         |
      | "comments"   | 500         |
      | "photos"     | 5000        |
      | "posts"      | 100         |
      | "todos"      | 200         |
      | "users"      | 10          |