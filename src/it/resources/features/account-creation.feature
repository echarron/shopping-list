Feature: Account creation
  As an unregistered user,
  I want to be able to create an account
  In order to be able to manage my shopping lists

  Scenario:
    When Julien creates an account
    Then he is logged in
     And he sees his empty shopping lists
