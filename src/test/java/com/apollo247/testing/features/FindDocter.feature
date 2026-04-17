Feature: Apollo 247 Doctor Booking

Background:
  Given Open the Browser
  And user launches the Apollo247 "https://www.apollo247.com/"
  And user closes the popup
  When user logs in with mobile number "9500573968"
  And user clicks on Find Doctors

Scenario Outline: Book a hospital visit appointment
  And user searches for "Andrology" specialist in "Chennai" on date "20"
  And user selects doctor "Dr. Amvrin Chatterjee"
  And user selects available slot
  And user adds new patient with details
  | firstName  | lastName    | gender | email                   | year | month | day |
  | Babu       | Subramani   | Male   | babuindu18@gmail.com    | 1983 | Jan   | 29  |
  Then booking details should be displayed
