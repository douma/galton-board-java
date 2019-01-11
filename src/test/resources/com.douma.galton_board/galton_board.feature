Feature: Galton board

  Scenario: 5 trays, left
    Given I have 5 trays
    Given the bullet will fall "left,left,left,left"
    When I drop the bullet
    Then The bullet should be in tray 1

  Scenario: 5 trays, right
    Given I have 5 trays
    Given the bullet will fall "right,right,right,right"
    When I drop the bullet
    Then The bullet should be in tray 5

  Scenario: 5 trays, switching
    Given I have 5 trays
    Given the bullet will fall "right,left,right,left"
    When I drop the bullet
    Then The bullet should be in tray 3

  Scenario: 2 trays
    Given I have 2 trays
    Given the bullet will fall "left"
    When I drop the bullet
    Then The bullet should be in tray 1