Feature: Post Api call
 Scenario: Testing a POST endpoint with request body
   Given url 'http://localhost:8080/rest/prod/save'
   And request {prodId:1,prodCode:'Type',prodCost:500.0,prodVendor:'Vendor'}
   When method POST
   Then status 201