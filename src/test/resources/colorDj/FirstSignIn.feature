Feature: First Sign in

  Background:
    Given Open Chrome and launch the application
    When Activate ColorDj Device

  Scenario: Add first stylist
    Given User selects "Add stylist"
    And Enter "Stylist name4"
    Then Save new stylist