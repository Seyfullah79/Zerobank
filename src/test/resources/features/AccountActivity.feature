
#Account drop down should have the following options: Savings, Checking, Loan, Credit Card, Brokerage.
#Transactions table should have column names Date, Description, Deposit,
#Withdrawal.

  Feature: Account Activity Page

    Background:
      Given the user is logged in
      When the user clicks on Account Activity page

    Scenario: Check the title
      Then the user should see "Zero - Account Activity" as a title

    Scenario: Check Account dropdown default
      Then Account drop down should have "Savings" selected