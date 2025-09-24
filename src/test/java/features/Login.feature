Feature: Login functionality

  Scenario: Login with empty fields
    Given Denying Notifications
    When Choosing language and closing bottom sheet
    When Tap skip carousel button
    When Tap finish button
    When Tap login button
    Then Assert that Username error exists
    Then Assert that password error exists
