@signin
Feature: Sign in to Merchant Direct

  Scenario Outline: Successfully signing in
    Given the Merchant Direct home page
    When user signs in with credentials "<row_index>"
    And user clicks on the Message Centre Link
    And user clicks on Display Messages For User ID radio button
    And user enters the User ID:"CHAT_MM01"
    And user clicks on the search button
    Then signout is available
    Examples: User Credentials
      |row_index|
      |1|
      |2|