Feature: Apollo Doctor Description Validation

  Scenario: Validate doctor description
    
    When User selects location and specialization
    And User sorts by Most Liked
    And User opens doctor description
    Then Doctor description should be validated