#Author: madhan.kumar@flytxt.com
@tag
Feature: To check login page
  I want to use this template to Login feature

  @tag1
  Scenario: check login feature
    Given enter valid data
    Then check the result

  @tag2
  Scenario Outline: check login feature with invalid scenarios
    Given enter username <name>
    When enter password <password>
    Then check the result <status>

    Examples: 
      | name              | password   | status  |
      | flyops@flytxt.com | flytxt  | success |
      | name2             | dsafdaf | Fail    |
      |                   | flytxt  | fail    |
