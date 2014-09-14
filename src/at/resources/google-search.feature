Feature: Google search

  Scenario: Search 1
    Given an anonyne user connected to google search home page
    When he makes a search for keyword Xebia
    Then the title of the page is Xebia - Recherche Google
