#Author: Joel Jose
#Keywords Summary : Product page test cases
#Feature: Product Page Features

@tagjoeltestsuite
Feature: Title of your feature
	Product page test cases
@tag1046
Scenario: Create Product: Verify the field validations for the benefit details NX-1046
Given login
Then navigate to precision marketing
Then navigate to offer management
Then check field validations under the benefits gridk
@tag1012
Scenario: Products Grid: Verify scrolling functionality to view the product at the end of the screen NX-1012
Given login
Then navigate to precision marketing
Then navigate to offer management
Then create single product from sheet "singleProductPage"
Then scrolling to view the entire product list
@tag1036
Scenario: Create Product: Verify the field validations for the Basic informations NX-1036
Given login
Then navigate to precision marketing
Then navigate to offer management
Then field validations for the Basic Information

@tag1038
Scenario: Create Product: Verify saving the products by not adding the mandatory fields NX-1038
Given login
Then navigate to precision marketing
Then navigate to offer management
Then saving the products by not adding the mandatory fields

@tag1045
Scenario: Create Product: Verify adding more than 3 benefits NX-1045
Given login
Then navigate to precision marketing
Then navigate to offer management
Then verify adding more than 3 benefits for product

@tag1042
Scenario: Create Product: Verify clicking on the Add button to add benefits NX-1042
Given login
Then navigate to precision marketing
Then navigate to offer management
Then clicking on the Add button to add benefits for the product

@tag1047
Scenario: Create Product: Verify adding multiple benefits for the single product NX-1047
Given login
Then navigate to precision marketing
Then navigate to offer management
Then saving product with multiple benefits


@tag1048
Scenario: Create Product: Verify saving the product without adding the benefit NX-1048
Given login
Then navigate to precision marketing
Then navigate to offer management
Then verify saving the product without adding benefits

@tag1011
Scenario: Products Grid: Verify the product details displayed in the Products screen NX-1011
Given login
Then navigate to precision marketing
Then navigate to offer management
Then create single product from sheet "singleProductPage"
Then verify product details displayed in the products screen

@tag11051
Scenario: Create Product: Verify adding multiple benefit with same usage leg and Type NX-1051
Given login
Then navigate to precision marketing
Then navigate to offer management
Then create product having multiple benefits with same usage leg and type combinations

@tag1061
Scenario: Create Product: Verify clicking on the cancel option after adding all the details NX-1061
Given login
Then navigate to precision marketing
Then navigate to offer management
Then enter valid details and click cancel
And check if offer is saved


@tag2064
Scenario: Checking cross site scripting in creation of new product under CLV Max NX-2064
Given login
Then navigate to precision marketing
Then navigate to offer management
Then enter special characters for name and validate

@tag1023
Scenario: Verify Clicking on the Remove Icon in the products tab NX-1023
Given login
Then navigate to precision marketing
Then navigate to offer management
Then create single product from sheet "singleProductPage"
Then delete product

@tag2055
Scenario: Offer Management : Check for the Filter icon in Products NX-2055
Given login
Then navigate to precision marketing
Then navigate to offer management
Then navigate to products
Then check if  the filter option is saving data after cancel

@tag1058
Scenario: Create Product: Verify adding products with same price under segmented scope NX-1058

Given login
Then navigate to precision marketing
Then navigate to offer management
Then create new product from sheet "productsSamePrice"

@tag1057
Scenario: Create Product: Verify adding products with same price under open market NX-1057

Given login
Then navigate to precision marketing
Then navigate to offer management
Then create new product from sheet "productsSamePrice"
@tag1055
Scenario: Create Product: Verify the product with Segmented scope NX-1055, NX-1015
Given login
Then navigate to precision marketing
Then navigate to offer management
Then create new product from sheet "singleProductPage"

@tag1053
Scenario: Create Product: Verify the product with Open Market scope NX-1053
Given login
Then navigate to precision marketing
Then navigate to offer management
Then create new product from sheet "singleProductPage"

@tag1026
Scenario: Products Grid: Verify View offers options for the products added NX-1026
Given login
Then navigate to precision marketing
Then navigate to offer management
Then create single product from sheet "singleProductPage"
Then navigate to offer management
Then navigate to offers
Then create new offer for product
Then navigate to offer management
Then navigate to products
Then check if offer is shown in view offers

@tag1022
Scenario: Products Grid: Verify the duplicate option of the product added NX-1022
Given login
Then navigate to precision marketing
Then navigate to offer management
Then create single product from sheet "singleProductPage"
Then check duplicate product functionality

@tag1021
Scenario: Products Grid: Verify the Edit option of the product added NX-1021
Given login
Then navigate to precision marketing
Then navigate to offer management
#Then navigate to products
Then create single product from sheet "singleProductPage"
Then check edit product functionality

@tag1014
Scenario: Products Grid: Verify by clicking on the Options icon available at the end of the product row. NX-1014
Given login
Then navigate to precision marketing
Then navigate to offer management
Then navigate to products
Then verify clicking on options icon

@tag2072
Scenario: Verify cross site scripting for Filtering products under CLV Max NX-2072
Given login
Then navigate to precision marketing
Then navigate to offer management
Then navigate to products
Then check script in product name field "<script>alert(document.cookies)</script>"

@tag2100
Scenario: Verify cross site scripting for Filtering products under CLV Max NX-2100
Given login
Then navigate to precision marketing
Then navigate to offer management
Then navigate to products
Then check script in product name field "productname'; SELECT * FROM products;"


@tag99
Scenario: create product with valid details
Given login
Then navigate to precision marketing
Then navigate to offer management
Then create new product from sheet "singleProductPage"
#Then delete product
#Then logout
#And verify created offer
