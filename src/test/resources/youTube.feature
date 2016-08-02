Feature: This feature tests a Youtube video

    Scenario: I test my video
      Given I navigate to YouTube
      And I find my video after searching
      When I mute the volume
      And I disable autoplay
      And I make my video fullscreen
      Then I skip through my video
      And I wait until the video ends
      And Verify that it's over