Feature: Complete Automation Testing on LabTest Module

  Background:
    Given User is on Lab Tests page
    Then check user in on correct module

  @labTest @searchScenario
  Scenario Outline: Verify search functionality for lab tests
    When User searches for "<input>"
    Then validate search result for "<type>"

    Examples:
      | input    | type    |
      | CBC Test | valid   |
      | @@@@     | invalid |

  @labTest @prescriptionScenario
  Scenario: Verify booking lab test using prescription
    Given User is on Lab Tests page
    When User clicks on book test using prescription
    And User uploads valid prescription
    Then verify  proceed button is enabled

  @labTest @radiologyScenario
  Scenario: Verify user can initiate radiology request successfully
    Given User is on Lab Tests page
    When User clicks on lab test search bar
    And User clicks on explore radiology option and switch to radiology tab
    Then User should be on radiology page
    When User enters radiology details
      | city    | hospital               | date     | tests             | file       |
      | Chennai | T Nagar- Apollo Clinic | 23-April | X-Ray,ECG,CT Scan | report.pdf |
    Then User should see request call button is enabled

  @labTest @EndtoEndScenario
  Scenario: Verify user can complete lab test booking till payment page
    Given User is on Lab Tests page
    When User searches for "testName"
    Then User should see relevant test results
    When User selects a test
    Then User should be on test details page
    When User adds test to cart
    And User navigates to cart page
    Then User should see selected test in cart
    When User proceeds to checkout
    And User adds new patient details
    Then User should see patient added successfully
    When User selects slot and reviews cart
    And User proceeds to payment
    Then User should be on payment page
