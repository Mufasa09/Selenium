#Feature: SauceDemoProducts
  #
  #Basic scenarios of the Sauce Demo Product page
#
  #Scenario: Verify you can add an item to the cart
    #Given I verify the title of the site is "Swag Labs"
    #When I enter "standard_user" user credentials on SauceDemo site
    #Then I add the item "Sauce Labs Backpack" from the list of products to the cart
    #* I verify item "Sauce Labs Backpack" in cart before removing
#
  #Scenario Outline: Verify you can add one item to the cart as multiple users
    #Given I verify the title of the site is "Swag Labs"
    #When I enter user credentials on SauceDemo site
      #| Key  | Value  |
      #| Role | <Role> |
    #Then I "add" the item to the cart
      #| Key      | Value      |
      #| ItemName | <ItemName> |
    #* I verify items in cart before removing
      #| Key      | Value      |
      #| ItemName | <ItemName> |
#
    #Examples: 
      #| Role          | ItemName                          |
      #| standard_user | Sauce Labs Backpack               |
      #| standard_user | Sauce Labs Bike Light             |
      #| standard_user | Sauce Labs Bolt T-Shirt           |
      #| standard_user | Sauce Labs Fleece Jacket          |
      #| standard_user | Sauce Labs Onesie                 |
      #| standard_user | Test.allTheThings() T-Shirt (Red) |
      #| visual_user   | Sauce Labs Backpack               |
      #| visual_user   | Sauce Labs Bike Light             |
      #| visual_user   | Sauce Labs Bolt T-Shirt           |
      #| visual_user   | Sauce Labs Fleece Jacket          |
      #| visual_user   | Sauce Labs Onesie                 |
      #| visual_user   | Test.allTheThings() T-Shirt (Red) |
#
  #Scenario Outline: Verify you can add multiple items to the cart as multiple users
    #Given I verify the title of the site is "Swag Labs"
    #When I enter user credentials on SauceDemo site
      #| Key  | Value  |
      #| Role | <Role> |
    #Then I "add" the list of items to the cart
      #| Key      | Value                             |
      #| ItemName | Sauce Labs Backpack               |
      #| ItemName | Sauce Labs Bike Light             |
      #| ItemName | Sauce Labs Bolt T-Shirt           |
      #| ItemName | Sauce Labs Fleece Jacket          |
      #| ItemName | Sauce Labs Onesie                 |
      #| ItemName | Test.allTheThings() T-Shirt (Red) |
    #* I verify the list of items in cart before removing
      #| Key      | Value                             |
      #| ItemName | Sauce Labs Backpack               |
      #| ItemName | Sauce Labs Bike Light             |
      #| ItemName | Sauce Labs Bolt T-Shirt           |
      #| ItemName | Sauce Labs Fleece Jacket          |
      #| ItemName | Sauce Labs Onesie                 |
      #| ItemName | Test.allTheThings() T-Shirt (Red) |
#
    #Examples: 
      #| Role          |
      #| standard_user |
      #| visual_user   |
