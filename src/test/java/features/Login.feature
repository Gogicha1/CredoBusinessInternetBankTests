Feature: Login functionality

  Scenario Outline: Login with empty fields
    Given Denying Notifications
    When Choosing "<language>" language and closing bottom sheet
    And Tap finish button 4 times
    When Tap login button
    Then Assert that Username error exists
    And Assert that password error exists

    Examples:
      | language |
      | ka       |
      | en       |
      | ru       |

  Scenario Outline: Login with empty username
    Given Denying Notifications
    When Choosing "<language>" language and closing bottom sheet
    And Tap "<language>" skip carousel button
    And Tap finish button 1 times
    When Input password "123"
    And Tap login button
    Then Assert that Username error exists
    And Assert that password error does not exist

    Examples:
      | language |
      | ka       |
      | en       |
      | ru       |

  Scenario Outline: Login with empty password
    Given Denying Notifications
    When Choosing "<language>" language and closing bottom sheet
    And Tap "<language>" skip carousel button
    And Tap finish button 1 times
    When Input username "Saba"
    And Tap login button
    Then Assert that password error exists
    And Assert that username error does not exist

    Examples:
      | language |
      | ka       |
      | en       |
      | ru       |

