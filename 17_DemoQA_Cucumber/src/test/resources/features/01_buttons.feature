@buttons
Feature: Buttons
  This feature includes /Buttons tests

  Background: TC00 First and must
    Given open "https://demoqa.com/elements" page
    And click "Buttons" button

  Scenario: TC01 Buttons Tests
    When click "Click Me" button
    Then check dynamic Click Message "You have done a dynamic click"
    And check dynamic Click Message
    And wait 1 seconds