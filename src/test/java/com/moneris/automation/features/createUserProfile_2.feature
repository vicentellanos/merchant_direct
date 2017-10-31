Feature: Create User Profile

  Background:
    Given the Merchant Direct home page
    When user signs in with credentials username:"VICENTEMANAGER" password:"50CentVitent"
    Then user is on Manager Functions page
    And user clicks on the Create User Profiles Link
    
   Scenario Outline: Successfully creating a user profile
    Given user is on the Create User Profile page
    And user enters the User ID "<row_index>"
    And user enters the Password Email Address "<row_index>"
    And user enters the Notification Email Address "<row_index>"
    And user enters the User Name "<row_index>"
    And user selects the User Type "<row_index>"
    And user enters the Customer ID "<row_index>"
    And user enters the Sales Rep Code "<row_index>"
    And user enters the Customer Type "<row_index>"
    And user selects the Message Centre Access "<row_index>"
    And user selects the Outgoing Messages Access "<row_index>"
    And user selects the Cardholder Data Access "<row_index>"
    And user selects the Reports Access "<row_index>"
    And user selects the Rewards Management "<row_index>"
    And user enters the Additional Customer Numbers "<row_index>"
    And user clicks on the Submit button of Create User Profile
    Then the temporary password is displayed
    And the temporary password is saved on the excel spreadsheet row "<row_index>"
    
    Examples: User Information
      |row_index|
      |1|
      |2|
#      |3|
#      |4|
#      |5|
#      |6|
#      |7|