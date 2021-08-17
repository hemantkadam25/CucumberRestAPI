@Sanity
Feature: Verify add place api

  Background: 
    Given I load "GooglePlaceBaseURI"

  Scenario Outline: To test add place api with post http method
  
    Given I load add place payload with "<name>", "<address>", "<phone_number>", "<accuracy>", "<website>", "<language>"
    When I call add place api with post http method
    Then I get status code as 200 in response
    And I get "status" as "OK" in response
    And I get "scope" as "APP" in response
    And I get "place_id" in response
    
    Examples:
    | name       | address       | phone_number  | accuracy | website               | language |
    | Hemu Kadam | Borivali West | +919838933937 | 100      | http://www.google.com | English  |
