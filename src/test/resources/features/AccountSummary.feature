Feature: Account summary

  Background:
    When the user is logged in

  Scenario: Account summary page should have the title Zero – Account summary
    Then the user should see "Zero - Account Summary" as a title


  Scenario: Check the List in Account Summary
    Then Account summary page should have to following account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |


  Scenario: Credit Accounts Table

    Then Credit Accounts table must have columns
      | Account     |
      | Credit Card |
      | Balance     |
