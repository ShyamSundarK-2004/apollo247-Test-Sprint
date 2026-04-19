Feature: Apollo 247 Health Tools - BMI Calculator
  Scenario: Verify BMI result for Female user
    When User navigates to Health Tools page
    And User clicks CALCULATE for Body Mass Index
    And User selects gender as Female
    And User navigates to height input
    And User enters height as "5.5"
    And User clicks next arrow
    And User enters weight as "80"
    And User clicks CALCULATE button
    Then BMI result should be displayed
    And BMI category should be "Overweight" or "Underweight" or "Normal"