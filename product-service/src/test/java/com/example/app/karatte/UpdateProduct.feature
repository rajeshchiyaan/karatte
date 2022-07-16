Feature: PUT Api call
 Scenario: Testing a PUT endpoint with request body
   Given url 'http://localhost:8080/rest/prod/update'
   And request {prodId:1,prodCode:'Type',prodCost:500.0,prodVendor:'Vendor Type'}
   When method PUT
   Then status 200
 Scenario: Testing a PUT endpoint with request body
   Given url 'http://localhost:8080/rest/prod/update'
   And request {prodId:1,prodCode:'Type',prodCost:500.0,prodVendor:'Vendor Type2'}
   When method PUT
   Then status 200
 Scenario: Testing a PUT endpoint with request body
   Given url 'http://localhost:8080/rest/prod/update'
   And request {prodId:1,prodCode:'Type',prodCost:500.0,prodVendor:'Vendor Type3'}
   When method PUT
   Then status 200