Feature: List of Products
Scenario: Run a GET request to get list of products 

  Given url 'http://localhost:8080/rest/prod/all';
  When method GET
  Then status 200
