Feature: Account Module - Manage Family Members

Background:
Given Open the browser
And user launches the Apollo247 "https://www.apollo247.com/"
And user closes the popup
When user logs in with mobile number "<7448516380>"
And user clicks verify after entering OTP
And user opens My Account panel
And user navigates to Manage Family Members

Scenario Outline: Add valid family member
When user clicks Add New Profile
And user enters family member details "<FirstName>" "<LastName>" "<DOB>"
And user selects gender as Male and relation as Brother
And user clicks Save
And user clicks Ok
Then new family member "<FirstName>" should be displayed

Examples:
| FirstName | LastName | DOB        |
| Sathish   | K        | 20/05/1991 |
