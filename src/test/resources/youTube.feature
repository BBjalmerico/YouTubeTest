Feature: This feature tests a Youtube video

  Background: I go to the page
    Given I navigate to YouTube

    Scenario: I test my video
      Given I find my video after searching
      And I disable autoplay
      When I skip the ad
      And I make my video fullscreen
      Then I mute the volume
      And Skip to the end
      And Verify that it's over