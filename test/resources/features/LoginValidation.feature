Feature: Login validation for HRMS portal

  Background:
  #Given user is able to access HRMS application

  @emptyUserName
  Scenario: Empty username

    When user attempts to log in with an empty username
    And user enters valid password
    And user clicks on login button
    Then user can see the error message

    @emptyPassword
    Scenario: Empty password

      When user enters a valid username
      And user attempts to log in with an empty password
      And user clicks on login button
      Then user can see the error message stating

      @incorrectCredentials
      Scenario: Wrong password or username
        When the user enters an invalid username and password
        And user clicks on login button
    Then the error message about invalid credentials should be displayed


  @correctInput
  Scenario: User can correct their input after an error
    When the user enters an invalid username and password
    And user clicks on login button
    Then the error message about invalid credentials should be displayed
    When the user enters valid username and password
    And user clicks on login button
    Then user is navigated to dashboard page

