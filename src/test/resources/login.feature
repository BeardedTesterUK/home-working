Feature: Authentication

  @First
  Scenario: Successfully logging in
    Given the home page
    When logging in as an admin
    Then the home page navigation is available

    @Second
  Scenario: Successfully using Frame
    Given the Frame home pages
    When Input into frames
    Then Text input is corrects