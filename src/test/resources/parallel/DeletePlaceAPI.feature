@Sanity
Feature: Verify delete place api

  Background: 
    Given I load "GooglePlaceBaseURI"

  Scenario Outline: To test delete place api with post http method
  
    Given I load add place payload with "<name>", "<address>", "<phone_number>", "<accuracy>", "<website>", "<language>"
    When I call delete place api with post http method
    Then I get status code as 200 in response
    And I get "status" as "OK" in response
    
     Examples:
    | name       | address       | phone_number  | accuracy | website               | language |
    | Hemu Kadam | Borivali West | +919838933937 | 100      | http://www.google.com | English  |
    
