Feature: Check Login Functionality

Scenario: check Login by Valid Username and Password

Given user has account at active Directory
When user login by valid username and password
Then user directed to home page



Scenario: use Variables for data
Given open website and login by valid user
When login by valid "Ahmed.3bdelstar@gmail.com" and "Ahmed@123" credentials
Then user login successfuully


Scenario: use Variables for data from dataTable
Given open website and login by valid user dataTable
When login by valid userName and Password credentials dataTable
|Ahmed.3bdelstar@gmail.com|Ahmed@123|
Then user login successfuully datatable



Scenario Outline: use Variables for data from scenario outline
Given open website and login by valid user scenario
When login by valid "<userName>" and "<Password>" credentials scenario
Then user login successfuully scenario

Examples:
|userName|Password|
|Ahmed.3bdelstar@gmail.com|Ahmed@123|
|Ahmed|Ahmed@123|
|Ahmed.3bdelstar@gmail.com|Ahme3|


