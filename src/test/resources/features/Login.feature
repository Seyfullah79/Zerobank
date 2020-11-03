@login
Feature: Login

  Background:
    When the user is on the login page

  @PositiveLogin
  Scenario: Only authorized users should be able to login
    And the user enters valid credentials and sign in
    Then the user should see Account Summary Page

  @negativeLogin
  Scenario Outline: Users with wrong username or wrong password should not be able to login
    And the user enters invalid "<username>" or "<password>"
    Then the user should see the "Login and/or password are wrong." message

    Examples:
      | username | password |
      | username | invalid  |
      | invalid  | password |
      | username |          |
      |          | password |
      | invalid  | invalid  |


