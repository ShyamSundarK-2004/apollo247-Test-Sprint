Feature: upload and book a test using prescription

  @labTest
  Scenario: Verify booking lab test using prescription
    Given User is on Lab Tests page
    When User clicks on book test using prescription
    And User uploads valid prescription
    Then verify prescription testis successfully created
