Feature: Account Module - My Appointments

Background:
  Given user opens My Account panel

@MyAppointments @AppointmentDisplay
Scenario: Verify My Appointments page loads successfully

  When user clicks My Appointments
  Then Appointments section should be displayed


@MyAppointments @PageReload
Scenario: Verify My Appointments page persists after refresh

  When user clicks My Appointments
  And user refreshes the page
  Then Appointments section should still be displayed