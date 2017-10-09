#Author: Joel Jose
#Keywords Summary : Product page test cases
#Feature: Product Page Features

@tag
Feature: Title of your feature
	Product page test cases
@tag1
Scenario: Create Product: Verify the field validations for the benefit details
Given login
Then navigate to precision marketing
Then navigate to offer management
Then check field validations under the benefits grid
Then close browser
@tag2
Scenario: Products Grid: Verify scrolling functionality to view the product at the end of the screen
Given login
Then navigate to precision marketing
Then navigate to offer management
Then scrolling to view the entire product list
Then close browser
@tag3
Scenario: Create Product: Verify the field validations for the Basic informations
Given login
Then navigate to precision marketing
Then navigate to offer management
Then field validations for the Basic Information
Then close browser
@tag4
Scenario: Create Product: Verify saving the products by not adding the mandatory fields
Given login
Then navigate to precision marketing
Then navigate to offer management
Then saving the products by not adding the mandatory fields
Then close browser
@tag5
Scenario: Create Product: Verify adding more than 3 benefits
Given login
Then navigate to precision marketing
Then navigate to offer management
Then verify adding more than 3 benefits for product
Then close browser
@tag6
Scenario: Create Product: Verify adding more benefits for the product
Given login
Then navigate to precision marketing
Then navigate to offer management
Then clicking on the Add button to add benefits for the product
Then close browser
@tag7
Scenario: Create Product: Verify adding multiple benefits for the single product
Given login
Then navigate to precision marketing
Then navigate to offer management
Then saving product with multiple benefits
Then close browser

@tag8
Scenario: Create Product: Verify saving the product without adding the benefit
Given login
Then navigate to precision marketing
Then navigate to offer management
Then verify saving the product without adding benefits
Then close browser
@tag9
Scenario: Products Grid: Verify the product details displayed in the Products screen
Given login
Then navigate to precision marketing
Then navigate to offer management
Then create new product
Then verify product details displayed in the products screen
Then close browser
@tag10
Scenario: Create Product: Verify adding multiple benefit with same usage leg and Type
Given login
Then navigate to precision marketing
Then navigate to offer management
Then create product having multiple benefits with same usage leg and type combinations
Then close browser
@tag11
Scenario: Create Product: Verify clicking on the cancel option after adding all the details
Given login
Then navigate to precision marketing
Then navigate to offer management
Then enter valid details and click cancel
And check if offer is saved
Then close browser

@tag12
Scenario: Checking cross site scripting in creation of new product under CLV Max
Given login
Then navigate to precision marketing
Then navigate to offer management
Then enter special characters for name and validate
Then close browser

#@tag2
#Scenario: create product with valid details
#Given login
#Then navigate to precision marketing
#Then navigate to offer management
#Then create new product
#Then delete product
#Then logout
#And verify created offer
