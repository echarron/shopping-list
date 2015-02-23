Feature: Shopping list

  Scenario:
    Given Claire, an existing user
    When she creates a new list with title 'Apero tonight'
    Then she sees the new list with title 'Apero tonight' in her shopping lists

  Scenario:
    Given Claire, an existing user
    And she creates a new list with title 'Romantic dinner'
    When she adds 'candels' in the list 'Romantic dinner'
    Then the list 'Romantic dinner' contains the product 'candels'
