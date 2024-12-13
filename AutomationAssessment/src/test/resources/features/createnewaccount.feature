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
	@create_new_account
	Feature: Create New User Account
	  I want to test user account creation
	
	  #Positive Scenario: New account created successfully
	  @successful_account_creation
	  Scenario: User successfully creates a new account
    Given User is on the homepage
    When User navigates to the create account page
    And User fills in the registration form with valid details
    Then User should see a success message indicating account creation is successful
	
	  #Negative Scenario Outline: Missing mandatory field details
	  @unsuccessful_account_creation
	  Scenario Outline: User fails to create new account with missing mandatory fields
	    Given User is on the homepage
	    When User navigates to the create account page
	    And User fills in the registration form with missing <field>
	    Then User should see an error message for the <field>
	
	    Examples: 
	      | field  				|
	      | firstname 		|
	      | lastname 			|
	      | email_address |
	      | password 			|
	      | confirm_password |
	      
	   #Negative Scenario: Invalid email
	   @unsuccessful_account_creation
	   Scenario: User fails to create new account with invalid email
    Given User is on the homepage
    When User navigates to the create account page
    And User fills in the registration form with invalid email
    Then User should see an weak message indicating invalid email address
    
    
     #Negative Scenario: Weak Password
	   @unsuccessful_account_creation
	   Scenario: User fails to create new account with a weak password
    Given User is on the homepage
    When User navigates to the create account page
    And User fills in the registration form with a weak password
    Then User should see an error message indicating weak password
    
	  #Negative Scenario: Account Creation with Already Registered Email
	   @unsuccessful_account_creation
	   Scenario: User fails to create new account with an already registered email
    Given User is on the homepage
    When User navigates to the create account page
    And User fills in the registration form with an already registered email
    Then User should see an error message indicating there is already an existing account with this email address
    
    #Negative Scenario: Mismatched Passwords 
	   @unsuccessful_account_creation
	   Scenario: User fails to create new account with mismatched passwords
    Given User is on the homepage
    When User navigates to the create account page
    And User fills in the registration form with separate values in Password and Confirm Password fields
    Then User should see an error message indicating password mismatch
     
