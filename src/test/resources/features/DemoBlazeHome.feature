Feature: DemoBlaze Homepage Sanity Test

  Background:
    Given user launches the browser
    And navigates to "https://www.demoblaze.com/"

  Scenario: Verify homepage loads successfully
    Then the homepage should load successfully

  Scenario: Verify the page title
    Then the page title should be "STORE"

  Scenario: Verify login modal appears
    When user clicks on the "Login" button
    Then the login modal should appear

  Scenario: Verify sign up modal appears
    When user clicks on the "Sign up" button
    Then the sign up modal should appear