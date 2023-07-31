@test

Feature: lh_Login

  Scenario Outline: <TestCase>

    Given User launches lufthansa web application
    And User handles privacy settings
    When User clicks on Login & Registration Button
    And User enters "<email>" address
    And User clicks on Next Button
    And User enters "<password>"
    Then User clicks on Log in Button

    Examples:
      |email|password|
      |osprodbasic1093@yopmail.com|Test@123|

