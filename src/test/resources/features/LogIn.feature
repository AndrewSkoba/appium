Feature: As a user want to able enter into the app

  @HealthCheck
  Scenario: Default credentials should be displayed and valid
    Then verify that displayed admin user name
    When click on 'Log In' btn
    Then logged in successfully

  @HealthCheck
  Scenario Outline: Login with wrong credential
    When type <username> username
    And type <password> password
    And click on 'Log In' btn
    Then window with <errorMessage> error message displayed

    Examples:
      | username | password | errorMessage                      |
      | Admin    | admin    | Invalid Credentials               |
      | admin    | Admin    | Invalid Credentials               |
      | test     | admin    | Invalid Credentials               |
      |          | admin    | Please enter Username or password |
      | admin    |          | Please enter Username or password |