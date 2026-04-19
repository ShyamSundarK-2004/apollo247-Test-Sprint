Feature: Apollo 247 Doctor Booking

<<<<<<< HEAD
Scenario : Book a hospital visit appointment
  Given user clicks on Find Doctors
  When  user searches for "Andrology" specialist in "Chennai" on date "20"
  And   user selects doctor "Dr. Amvrin Chatterjee"
=======
Scenario: Book a hospital visit appointment
  When user clicks on Find Doctors
  And user searches for "Andrology" specialist in "Chennai" on date "20"
  And user selects doctor "Dr. Amvrin Chatterjee"
>>>>>>> feature/finddoctor
  And user selects available slot
  And user adds new patient with details
  | firstName  | lastName    | gender | email                   | year | month | day |
  | Babu       | Subramani   | Male   | babuindu18@gmail.com    | 1983 | Jan   | 29  |
  Then booking details should be displayed
