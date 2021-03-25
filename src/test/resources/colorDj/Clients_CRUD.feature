Feature: Testing the add, edit and delete clients

  Background:
    Given Open Chrome and launch the application
    When Activate ColorDj Device
    And Wait for Offline cache
    And Redirect to "Select stylist profile" page
    And Click "Test"

  Scenario Outline: Add new stylist
    Given User selects "Clients"
    When Go to Add New page
    And User fills in the "<ClientName>", "<Phone>" and "<Email>" fields
    Then Save new client

    Examples:
      | ClientName         | Phone               | Email               |
      | ClientName         | 40747828207         | someone@someone.com |
      | ClientName 2       | 40747828207         | someone2@someone.com|

  Scenario Outline:  Edit clients
    Given User selects "Clients"
    Given User selects "<ClientName>"
    When Go to View client info page
    And User fills in the "<ClientName>", "<Phone>" and "<Email>" fields
    Then Save new client

    Examples:
      | ClientName      | Phone               | Email                    |
      | ClientName      | 40741231234         | othersomeone@someone.com |
      | ClientName 2    | 40747828207         | othersomeone2@someone.com|


    Scenario Outline: Delete clients
      Given User selects "Clients"
      Given User selects "<ClientName>"
      When Go to View client info page
      And Remove Client
      Then Confirm remove Client

      Examples:
      | ClientName          |
      | ClientName          |
      | ClientName 2        |

