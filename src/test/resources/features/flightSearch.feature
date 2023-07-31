@test

Feature: Flight search

  Scenario: <TestCase>
    Given User launches lufthansa web application
    And User handles privacy settings
    When User clicks on one way trip on Flights
    And User enters from place of departure
    And User enters departure date
    And User enters to place of arrival
    Then User clicks on search flight
