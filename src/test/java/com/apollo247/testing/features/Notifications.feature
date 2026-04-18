Feature: Account Module - Notification Preferences

  Background:
    Given user opens My Account panel

  # ============================================================
  # SCENARIO 1: Navigate to Notification Preferences
  # Navigation: Profile → Manage Family Members → Notification Preferences
  # ============================================================
  @Notifications @NavigationCheck
  Scenario: Verify Notification Preferences page loads successfully
    When user navigates to Manage Family Members
    And user clicks on Notification Preferences
    Then Notification Preferences page should be displayed

  # ============================================================
  # SCENARIO 2: Enable Push Notifications
  # ============================================================
  @Notifications @PushNotification
  Scenario: Enable Push Notifications toggle successfully
    When user navigates to Manage Family Members
    And user clicks on Notification Preferences
    And user enables Push Notifications
    Then Push Notifications toggle should be active

  # ============================================================
  # SCENARIO 3: Enable SMS Notifications
  # ============================================================
  @Notifications @SmsNotification
  Scenario: Enable SMS Notifications toggle successfully
    When user navigates to Manage Family Members
    And user clicks on Notification Preferences
    And user enables SMS Notifications
    Then SMS Notifications toggle should be active

  # ============================================================
  # SCENARIO 4: Enable Both Notifications - DataTable
  # ============================================================
  @Notifications @AllNotifications
  Scenario: Enable all notification types from the preferences page
    When user navigates to Manage Family Members
    And user clicks on Notification Preferences
    And user enables the following notification types
      | notificationType   |
      | Push Notifications |
      | SMS Notifications  |
    Then all selected notifications should be enabled