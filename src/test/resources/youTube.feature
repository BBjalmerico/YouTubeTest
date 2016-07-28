Feature: This feature tests a Youtube video

  Background: I go to the page
    Given I navigate to my YouTube video

    Scenario: I test my video
      Given I verify that I am on my videos page
      And I disable autoplay
      When I pause my video
      And I increase the resolution
      Then I close fullscreen
      And Skip to the end
      And Verify that it's over