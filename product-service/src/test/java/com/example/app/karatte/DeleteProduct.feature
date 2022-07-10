Feature: Delete Product
Scenario: Run a Delete request to get product 

  Given url 'http://localhost:8080/rest/prod/remove/1';
  When method DELETE
  Then status 200