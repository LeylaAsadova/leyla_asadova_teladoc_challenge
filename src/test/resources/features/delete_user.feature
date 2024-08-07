@regression
Feature: Delete existing user

  Background:
    Given User navigates to way2automation website

  Scenario Outline: User should be able to delete an existing user
    When User should be able to see Add User button
    Then User should be able to see an existing user data with "<userName>"
    And User should be able to delete an existing user data with "<userName>"

    Examples:
      | userName |
      | novak   |
