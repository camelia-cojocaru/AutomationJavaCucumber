Feature: Testing the add, edit and delete stylists

 Background:
   Given Open Chrome and launch the application
   When Activate ColorDj Device
   And Wait for Offline cache
   And Redirect to "Select stylist profile" page
   And Click "Test"

  Scenario: Add new stylist
    Given User selects "Stylist management"
    When Go to Add New page
    And Enter "Test1"
    Then Save the stylist

  Scenario: Edit stylist
    Given User selects "Stylist management"
    When Click "Test1"
    And Enter "sss"
    Then Save the stylist

  Scenario: Delete stylist
    Given User selects "Stylist management"
    When Click "sss"
    And Remove stylist
    Then Confirm remove stylist

  Scenario: Add new stylist from Select stylist page
    Given User selects "Switch Stylist"
    When User selects "Add new stylist!"
    And Enter "Test2"
    And Save first stylist
    Then Confirm continue


