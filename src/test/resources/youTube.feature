Feature: This feature tests a Youtube video

  Background: I go to the page
    Given I navigate to YouTube

    Scenario: I test my video
      Given I search for my video
      And I locate my video
      When I start my video
      And I make it fullscreen
      Then I skip to the end
      And Verify that it's over