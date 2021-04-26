Feature: Delivery Agents App Authentication

  Scenario: Element Presence on Home Page
    Given I Launch Delivery Agents App
    When Performing Authentication
    Then Verify Element Presence
    And Quit Driver