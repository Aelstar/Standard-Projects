Feature: setupbasic configuration

Scenario: install selenuim

Given open browser and checkStatus
When check Status
Then link open Successful


Scenario: check Data json

Given open browser
When check Datajson
Then link open Successful



Scenario: check Data2

Given open browser
When check data2
Then link open Successful


Scenario: get Page Data

Given open browser
When get Page Data
Then link open Successful


Scenario: rest Test2 Status code

Given open browser
When rest Test2 Status code
Then link open Successful


Scenario: test all rest

Given open browser
When test all rest
Then link open Successful



Scenario: test all rest

Given open browser
When getTilte
Then link open Successful

Scenario: test all rest

Given open browser
When getURL
Then link open Successful
