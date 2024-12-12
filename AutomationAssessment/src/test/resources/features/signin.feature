#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@sign_in
Feature: Sign In Existing User
  I want to test sign in for an existing user

  @successful_sign_in
  Scenario: User successfully signs in with valid credentials
    Given User is on the homepage
    When User navigates to the Sign In page
    And User signs in with valid credentials
    Then User should be redirected to the homepage

  @unsuccessful_login
  Scenario Outline: User fails to sign in with invalid credentials
    Given User is on the homepage
    When User navigates to the Sign In page
    And User signs in with invalid <username> and <password> 
    Then User should see an error message indication invalid sign-in

    Examples: 
      | name  			  | value 					 | status  |
      | invalidemail1 | invalidpassword1 | fail 	 |
      | invalidemail2 | invalidpassword2 | fail 	 |
