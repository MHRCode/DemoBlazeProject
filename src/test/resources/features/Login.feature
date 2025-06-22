Feature: User login

  Scenario: Valid login
    Given user is on homepage
    When user clicks on login link
    And enters username and password
    Then user should be logged in successfully
