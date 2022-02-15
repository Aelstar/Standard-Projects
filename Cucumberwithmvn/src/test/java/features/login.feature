Feature: login feature file
  I want to use this template for my feature file

  @variables
  Scenario: login by valid test users
    Given I want to Login by valid user
    When I open browser login by "userName"  and "Password"valid credintials
   Then user login sucessfully
 

  @outline
  Scenario Outline: valid test users by outline
    Given I want to Login by valid user
    When I open browser login by valid credintials outline "<userName>" and "<Password>"
    Then user login sucessfully

    Examples: 
      | userName  | Password |  
      | name1 		|     5 		|
      | name2 		|     7 		|
      | Ahmed.3bdelstar@gmail.com 		|    Test!123  		|
        | qacart 		|    Test123!  		|
      
      
       @datatable
  Scenario: valid test users by datatable
    Given I want to Login by valid user
    When I open browser login by valid credintials userName and Password
    |userName1|Password1|
    |userName2|Password2|
    Then user login sucessfully 
    