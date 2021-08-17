@Sanity
Feature: Verify update place api

  Background: 
    Given I load "GooglePlaceBaseURI"

  Scenario Outline: To test update place api with put http method
  
    Given I load add place payload with "<name>", "<address>", "<phone_number>", "<accuracy>", "<website>", "<language>"
    When I call update place api with "<update address>" request
    Then I get status code as 200 in response
    And I get "msg" as "Address successfully updated" in response
    And I verify "address" is updated to "<update address>" using get place api  
    
    Examples:
    | name       | address           | phone_number  | accuracy | website               | language | update address    |
    | Hemu Kadam | Mumbai West MH IN | +919838933937 | 100      | http://www.google.com | English  | Navi Mumbai MH IN |
