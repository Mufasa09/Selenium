#Feature: SauceDemo Login Tests
  #
  #Basic scenarios of the Sauce Demo login
#
#
  #Scenario: I verify all elements are displayed on login page
  #	When I verify the title of the site is "Swag Labs"
  #	Then I verify login page elements
#
  #Scenario: Verify you can log in the site
  #	Given I verify the title of the site is "Swag Labs"
  #	When I enter "locked_out_user" user credentials on SauceDemo site
  #	Then I verify login error
  #		| Key  | Value      |
  #		| Role | locked_out |
  #
  #Scenario: I verify negative login scenario
  #	Given I verify the title of the site is "Swag Labs"
  #	When I verify login page elements
  #	Then I verify login error
  #		| Key  | Value |
  #		| Role |       |
  #
  #Scenario Outline: Verify you can log in the site with multiple users
    #Given I verify the title of the site is "Swag Labs"
    #When I enter <Role> user credentials on SauceDemo site
    #Then I verify user is on the main page
#
    #Examples: 
      #| Role                      |
      #| "standard_user"           |
      #| "performance_glitch_user" |
      #| "problem_user"            |
      #| "visual_user"             |
      #| "error_user"              |
#
#Scenario Outline: Verify you can log in the site with multiple users and logout
#	Given I verify the title of the site is "Swag Labs"
#	When I enter <Role> user credentials on SauceDemo site
#	Then I verify user is on the main page
#	* I logout
#
    #Examples: 
      #| Role                      |
      #| "standard_user"           |
      #| "performance_glitch_user" |
      #| "problem_user"            |
      #| "visual_user"             |
      #| "error_user"              |
