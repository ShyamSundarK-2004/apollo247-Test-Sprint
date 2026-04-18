Feature: Account Module - My Memberships

Background:
  Given user opens My Account panel

@MyMemberships @CorporateEmail
Scenario Outline: Verify error for invalid corporate email

  When user navigates to My Memberships
  And user clicks Activate Corporate Membership
  And user enters corporate email "<Email>"
  And user clicks Get OTP
  Then corporate benefits error message should be displayed
  And user dismisses the error popup

Examples:
  | Email              |
  | abc@capgemini.com  |
  | test@benz.com      |


@MyMemberships @PlanValidation
Scenario: Verify membership plan details after clicking Buy Now

  When user navigates to My Memberships
  And user clicks BUY NOW
  And user scrolls to 12 months plan and clicks Join Now
  Then the following plan details should be visible on the page
    | planDetail |
    | 12 Months  |
    | 199        |