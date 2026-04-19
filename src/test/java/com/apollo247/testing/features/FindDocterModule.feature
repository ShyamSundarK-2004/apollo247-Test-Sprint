Feature: Apollo 247 End-to-End Functional Testing

# -----------------------------------------
# Scenario 1: Doctor Booking
# -----------------------------------------
Scenario: Book a hospital visit appointment
  When user clicks on Find Doctors
  And user searches for "Andrology" specialist in "Chennai" on date "20"
  And user selects doctor "Dr. Amvrin Chatterjee"
  And user selects available slot
  And user adds new patient with details
  | firstName  | lastName    | gender | email                | year | month | day |
  | Babu       | Subramani   | Male   | babuindu18@gmail.com | 1983 | Jan   | 29  |
  Then booking details should be displayed

# -----------------------------------------
# Scenario 2: Filter Doctor and Book
# -----------------------------------------
Scenario: Filter the doctor and book appointment
  When User click the general Physician
  And user applies sorting as "Price - low to high"
  And user filters doctors by experience "6-10"
  And user filters doctors by language "English"
  And user clicks on first displayed docter
  And select the slot and continue to book
  Then verify the booking details

# -----------------------------------------
# Scenario 3: Rebook Appointment
# -----------------------------------------
Scenario: Verify Book Appointment option after rebooking
  When User navigates to My Appointments and clicks View All
  And User clicks on Rebook for a doctor
  And User clicks Continue
  And User click ChangeBtn to Change the patient and click proceed
  Then User should see Book Appointment option

# -----------------------------------------
# Scenario 4: BMI Calculator (Excel Driven)
# -----------------------------------------
Scenario: Verify BMI result for Female user using Excel data
  When User navigates to Health Tools page
  And User clicks CALCULATE for Body Mass Index
  And User selects gender as Female
  And User navigates to height input
  And User enters BMI data from excel
  Then BMI result should be displayed

# -----------------------------------------
# Scenario 5: Doctor Description Validation
# -----------------------------------------
Scenario: Validate doctor description
  When User selects location and specialization
  And User sorts by Most Liked
  And User opens doctor description
  Then Doctor description should be validated