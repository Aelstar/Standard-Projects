$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "line": 1,
  "name": "login feature file",
  "description": "I want to use this template for my feature file",
  "id": "login-feature-file",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 12,
  "name": "valid test users by outline",
  "description": "",
  "id": "login-feature-file;valid-test-users-by-outline",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 11,
      "name": "@outline"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "I want to Login by valid user",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "I open browser login by valid credintials outline \"\u003cuserName\u003e\" and \"\u003cPassword\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "user login sucessfully",
  "keyword": "Then "
});
formatter.examples({
  "line": 17,
  "name": "",
  "description": "",
  "id": "login-feature-file;valid-test-users-by-outline;",
  "rows": [
    {
      "cells": [
        "userName",
        "Password"
      ],
      "line": 18,
      "id": "login-feature-file;valid-test-users-by-outline;;1"
    },
    {
      "cells": [
        "name1",
        "5"
      ],
      "line": 19,
      "id": "login-feature-file;valid-test-users-by-outline;;2"
    },
    {
      "cells": [
        "name2",
        "7"
      ],
      "line": 20,
      "id": "login-feature-file;valid-test-users-by-outline;;3"
    },
    {
      "cells": [
        "Ahmed.3bdelstar@gmail.com",
        "Test!123"
      ],
      "line": 21,
      "id": "login-feature-file;valid-test-users-by-outline;;4"
    },
    {
      "cells": [
        "qacart",
        "Test123!"
      ],
      "line": 22,
      "id": "login-feature-file;valid-test-users-by-outline;;5"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 19,
  "name": "valid test users by outline",
  "description": "",
  "id": "login-feature-file;valid-test-users-by-outline;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 11,
      "name": "@outline"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "I want to Login by valid user",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "I open browser login by valid credintials outline \"name1\" and \"5\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "user login sucessfully",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 20,
  "name": "valid test users by outline",
  "description": "",
  "id": "login-feature-file;valid-test-users-by-outline;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 11,
      "name": "@outline"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "I want to Login by valid user",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "I open browser login by valid credintials outline \"name2\" and \"7\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "user login sucessfully",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 21,
  "name": "valid test users by outline",
  "description": "",
  "id": "login-feature-file;valid-test-users-by-outline;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 11,
      "name": "@outline"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "I want to Login by valid user",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "I open browser login by valid credintials outline \"Ahmed.3bdelstar@gmail.com\" and \"Test!123\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "user login sucessfully",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 22,
  "name": "valid test users by outline",
  "description": "",
  "id": "login-feature-file;valid-test-users-by-outline;;5",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 11,
      "name": "@outline"
    }
  ]
});
formatter.step({
  "line": 13,
  "name": "I want to Login by valid user",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "I open browser login by valid credintials outline \"qacart\" and \"Test123!\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "user login sucessfully",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});