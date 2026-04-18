Feature: Apollo 247 Module Navigation

  Background:
    Given User is on Lab Tests page
    Then check user in on correct module

  @labTest @functionality
  Scenario Outline: Verify search functionality for lab tests
    When User searches for "<input>"
    Then validate search result for "<type>"

    Examples:
      | input    | type    |
      | CBC Test | valid   |
      | @@@@     | invalid |
      |          | empty   |
