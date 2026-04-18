Feature: Account Module - Logout Functionality

  Background:
    Given user is logged into the application

  @Logout @Navigation
  Scenario: Verify user can successfully logout from the application
    When user clicks on profile icon
    And user clicks on logout option
    Then user should be redirected to login page