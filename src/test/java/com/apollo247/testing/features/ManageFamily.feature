Feature: Account Module - Manage Family Members

Background:
  Given user opens My Account panel

@ManageFamily
Scenario: Add valid family member from Excel

  When user navigates to Manage Family Members
  And user adds family members from excel
  Then family member should be created successfully