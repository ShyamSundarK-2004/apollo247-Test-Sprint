Feature: Apollo 247 Module Navigation

  Background:
    When User clicks on "Lab Tests" module

  @smoke @labTest
  Scenario: Verify user can access Lab Tests module
    Then check user in on correct module

  @labTest
  Scenario Outline: Verify search functionality for lab tests
    When User searches for "<input>"
    Then "<result>" should be displayed

    Examples:
      | input    | result             |
      | CBC Test | results            |
      | xyz123   | no results         |
      | blo      | suggestions        |
      |          | validation message |
