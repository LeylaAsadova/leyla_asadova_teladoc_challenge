@regression
Feature: Add new user

  Background:
    Given User navigates to way2automation website

  Scenario Outline: User should be able to add a new user with all fields
    Then User should be able to see Add User button
    And Add User button should be enabled
    When User clicks Add User button
    Then User enters first name as "<fName>"
    And User enters last name as "<lName>"
    And User enters user name as "<userName>"
    Then User enters password as "<pwd>"
    And User choose Company name as "<company>"
    And User selects role as "<role>"
    Then User enters email as "<email>"
    Then User enters phone number as "<pNumber>"
    And User clicks the save button
    Then User should be able to see a newly created user data with "<fName>" , "<lName>" , "<userName>" , "<email>" , "<pNumber>"
    Then User should be able to delete newly created user data with "<userName>" , "<email>" , "<pNumber>"

    Examples:
      | fName | lName  | userName | pwd        | company | role       | email            | pNumber    |
      | Tom   | Jerry  | t_jerry  | Test123@   | AAA     | Customer   | jerry@gmail.com  | 5180001122 |
      | Tom   | Hanks  | t_hanks  | 123hanks@  | BBB     | Sales Team | hanks@gmail.com  | 5186778899 |
      | Tom   | Cruise | t_cruise | 123cruise@ | AAA     | Admin      | cruise@gmail.com | 5186078099 |