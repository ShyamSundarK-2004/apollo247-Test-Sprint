Feature: Account Module - Need Help

  Background:
    Given user opens My Account panel

  @NeedHelp @Navigation
  Scenario: Verify Need Help page categories are displayed
    When user navigates to Need Help
    Then all help categories should be visible

  @NeedHelp @Medicines
  Scenario: Verify user can navigate to Medicines help section
    When user navigates to Need Help
    And user clicks on Medicines category
    Then Medicines help page should be loaded