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
    When User clicks on book test using prescription
    And User uploads valid prescription
    Then verify  proceed button is enabled

  @labTest @radiologyScenario
  Scenario: Verify user can initiate radiology request successfully
    When User clicks on lab test search bar
    And User clicks on explore radiology option and switch to radiology tab
    Then User should be on radiology page
    When User enters radiology details
      | city      | hospital                   | date     | tests         | filePath                                               |
      | Bengaluru | Indiranagar- Apollo Clinic | April-15 | X-Ray,CT Scan | C:\\Users\\Shyam Sundar\\Documents\\prescription2.jpeg |
      | Chennai   | T Nagar- Apollo Clinic     | May-23   | X-Ray,ECG     | C:\\Users\\Shyam Sundar\\Documents\\prescription2.jpeg |
    Then User should see request call button is enabled

  @labTest @EndtoEndScenario
  Scenario: Verify user can complete lab test booking till payment page
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

  @labTest @viewReportScenario
  Scenario: verify user can able to see their order history for different patient names
    When user click on view report button
    Then verify myOrder page is displayed
