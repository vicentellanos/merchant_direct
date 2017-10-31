Feature: User views the daily transaction report menu

  Scenario: Successfully viewing of the daily transaction report
    Given the Merchant Direct home page
    When user signs in with credentials username:"VICENTEMANAGER" password:"50CentVitent"
    And user clicks on the View Customer Reports/Statements
    And user enters the customer number:"30404836557"
    And user clicks on the submit button
    And user clicks on the Daily Transaction Report Menu
    And user clicks on the Select Report button
    Then user is on Daily Transaction Report Menu page