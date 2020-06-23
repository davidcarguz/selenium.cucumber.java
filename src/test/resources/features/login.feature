@login_feature
Feature: login test cases

  @successful_login
  Scenario: successful login into the app
    When User enters username "Admin" and password "admin123"
    Then User validates correct login
