Feature: Cura Healthcare Appointment Booking

  Scenario: Book an appointment successfully
    Given user launches the Cura Healthcare website
    When user logs in with valid credentials
    And user selects the facility and date
    And user books the appointment
    Then appointment should be confirmed
