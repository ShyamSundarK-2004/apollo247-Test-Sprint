Feature: Apollo 247 Module Navigation

  Background:
    Given User is on Lab Tests page

  @smoke @labTest
  Scenario: Verify user can access Lab Tests module
    Then check user in on correct module

  @labTest
  Scenario Outline: Verify search functionality for lab tests
    When User searches for "<input>"
    Then results should be displayed

    Examples:
      | input    |
      | CBC Test |
