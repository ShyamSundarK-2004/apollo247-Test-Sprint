Feature: Buy Medicines - Search and Add to Cart Validation

Background:
  Given user launches Apollo 24/7 application
  And user closes popup if displayed
  And user logs in with valid mobile number
  And user enters OTP manually and clicks verify
  And user navigates to Buy Medicines module

@SearchMedicine
Scenario Outline: Validate user is able to search medicine and add to cart
  When user searches for "<MedicineName>"
  And user clicks add button for searched medicine
  Then medicine should be added to cart successfully

Examples:
  | MedicineName   |
  | Crocin 500mg   |
  | Dolo 650       |
  | Paracetamol    |