Feature: This feature tests a Youtube video

    Scenario: I test my Smashing Pumpkins video
        Given I navigate to YouTube
        And I search for "The Smashing Pumpkins 1979"
        And I find the video with tag "4aeETEoNfOg"
        When I mute the volume
        And I make my video fullscreen
        And I wait for the advertisement to finish
        Then I skip through my video
        And Verify that it's over

    Scenario: I test my Gorillaz video
        Given I navigate to YouTube
        And I search for "Gorillaz On Melancholy Hill"
        And I find the video with tag "04mfKJWDSzI"
        When I mute the volume
        And I disable autoplay
        Then I skip through my video
        And Verify that it's over

    Scenario: I test my Muse video
        Given I navigate to YouTube
        And I search for "Muse Madness"
        And I find the video with tag "Ek0SgwWmF9w"
        When I mute the volume
        Then I skip through my video
        And Verify that it's over