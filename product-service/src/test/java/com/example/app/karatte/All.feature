Feature: Test All cases
 Scenario: Testing a POST endpoint with request body
   Given url 'http://localhost:8080/rest/prod/save'
   And request {prodId:1,prodCode:'Type',prodCost:500.0,prodVendor:'Vendor'}
   When method POST
   Then status 201
 Scenario: Run a GET request to get product
  Given url 'http://localhost:8080/rest/prod/find/1';
  When method GET
  Then status 200
  And match $.prodId == 1
 Scenario: Run a GET request to get list of products 
  Given url 'http://localhost:8080/rest/prod/all';
  When method GET
  Then status 200
 Scenario: Testing a PUT endpoint with request body
   Given url 'http://localhost:8080/rest/prod/update'
   And request {prodId:1,prodCode:'Type',prodCost:500.0,prodVendor:'Vendor Type'}
   When method PUT
   Then status 200
 Scenario: Run a Delete request to get product
  Given url 'http://localhost:8080/rest/prod/remove/1';
  When method DELETE
  Then status 200