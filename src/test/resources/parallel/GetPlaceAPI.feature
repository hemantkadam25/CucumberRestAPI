@Sanity
Feature: Verify get place api

  Background: 
    Given I load "GooglePlaceBaseURI"

  Scenario Outline: To test get place api with get http method
  
    Given I load add place payload with "<name>", "<address>", "<phone_number>", "<accuracy>", "<website>", "<language>"
    When I call get place api with get http method
    Then I get status code as 200 in response
    And I verify "name" as "<name>" in response
    And I verify "address" as "<address>" in response
    And I verify "language" as "<language>" in response
    
    Examples:
    | name       | address       | phone_number  | accuracy | website               | language |
    | Hemu Kadam | Borivali West | +919838933937 | 100      | http://www.google.com | English  |
    
