Feature: Get Product
Scenario: Run a GET request to get product 

  Given url 'http://localhost:8080/rest/prod/find/1';
  When method GET
  Then status 200
  And match $.prodCost == 500.0