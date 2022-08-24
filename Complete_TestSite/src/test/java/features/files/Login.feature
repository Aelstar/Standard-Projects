Feature: Login Page by username and password

  Scenario Outline: login by valid testusers
    Given i open browser and navigate to url
    When i login by <'username'> and <'password'>
    Then I click at logout button
    
    Examples: 
      | username								|password|
    	|Ahmed.3bdelstar@gmail.com|	Ahmed123456|
			|Ahmed 2									|Password|
			|Ahmed 3									|Password|
			|Ahmed 4									|Password|
			|Ahmed 5									|Password|
      
