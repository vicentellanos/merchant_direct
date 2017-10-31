Feature: Create User Profile

  Scenario Outline: Successfully finalizing a Create User Profile and changing its password
    Given the Merchant Direct home page
    When user signs in with credentials from excel file:"Create Users - Test.xlsx" on row:"<excel_row_index>" with username in column:"0" and password in column:"14"
    Then user is on Terms of Use page
    And user clicks on the I Agree button of the Terms of Use page
    Then user is on Change Password Page
    And user enters the Old Password "<excel_row_index>"
    And user enters the New Password "<excel_row_index>"
    And user re-enters the New Password "<excel_row_index>"
    And user clicks on the Submit button of the Change Pasword page
    Then user is on Update Your Profile Page
    And user selects the Preferred Language "English"
    And user clicks on the Update Profile button
    Then user is on the Home Page
    And user clicks on the "Sign Out" link
   
#    Examples: Input data
#      |username|password|new_password|preferred_language|signOut|
#      |AUTO_M1_TEST2|HXDmHDUDDZw4|AUTO_M1_TEST2_Password|English|Sign Out|
#      |2|
#      |3|
#      |4|
#      |5|
#      |6|
#      |7|
    
    Examples: Input Data
      |excel_row_index|
      |1|
      |2|
#      |3|
#      |4|
#      |5|
#      |6|
#      |7|