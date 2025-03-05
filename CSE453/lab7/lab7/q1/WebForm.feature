Feature: Web Form Test

  Scenario: Fill out and submit the web form
    Given I open the web form page
    When I enter "Test Input" in the text field
    And I enter "password123" in the password field
    And I enter "This is a test message" in the textarea
    And I click on the "Return to index" link
    Then I should see the page title as "Index of Available Pages"
    When I navigate back to the web form page
    And I select "Two" from the dropdown
    Then the checkbox with id "my-check-1" should be selected
    And the radio button with id "my-radio-1" should be selected
    And the default checkbox below "my-check-2" should be selected
    When I set the color picker to "#FF0000"
    And I set the date picker to "2024-02-21"
    And I click on the submit button
    Then I should see the message "Received!"