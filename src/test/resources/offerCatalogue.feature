#Author: nikhil.b@flytxt.com


@tagOfferCatalog
Feature: Offer Catalogue 

@tag1125
Scenario: Verify Creating Offer Catalogue
  Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
  Then Create New Offer Catalogue
  Then Add offer to Offer Catalogue
  Then Delete Created Offer Catalogue
  Then logout
	
@tag1126

Scenario: Verify Canceling Offer Catalogue 
Given login
Then navigate to precision marketing
Then  Navigate to Offer Management 
Then Navigate to Offer Catalogue
Then Cancel the New offer Catalogue
Then logout

@tag1146

Scenario: Verify Canceling Selected Offer 
  Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
  Then Create New Offer Catalogue
  Then Cancel Selected Offer
  Then Delete Created Offer Catalogue
  Then logout
 
@tag1145  
Scenario: Verify Adding Selected Offers
Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
  Then Create New Offer Catalogue
  Then Add offers to Offer Catalogue
  Then Delete Created Offer Catalogue
  Then logout
  
@tag1139
Scenario: Verify Selecting Multiple Offers
Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
  Then Create New Offer Catalogue
  Then Select Multiple Offers
  Then Delete Created Offer Catalogue
  Then logout
 
 @tag1138
 Scenario: Search Offers Using Combination of fields
  Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
  Then Create New Offer Catalogue
  Then Search Offers with Combination of details
  Then Delete Created Offer Catalogue
  Then logout
  
 @tag1137
 Scenario: Search Offers Using Service leg
  Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
  Then Create New Offer Catalogue
  Then Search Offers Using Service leg
  Then Delete Created Offer Catalogue
  Then logout
  
@tag1146
Scenario: Verify Canceling selected Offers
Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
  Then Create New Offer Catalogue
  Then Cancel Selected Offers
  Then Delete Created Offer Catalogue
  Then logout
  
@tag1135
Scenario: Verify Selecting Offers Using Product Name
Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
  Then Create New Offer Catalogue
  Then Select Offers Using Product Name
  Then Delete Created Offer Catalogue
  Then logout
  
@tag1128
Scenario:  Verify the newly added offer catalog in the Offer Catalog screen
Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
  Then Create New Offer Catalogue
  Then Add offer to Offer Catalogue
  Then Verify Added Catalogue
  Then Delete Created Offer Catalogue
  Then logout

@tag1127
Scenario: Verify the field validations for the catalogue name and description
Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
  Then Validate Catalogue Name
  Then logout
  
@tag5984
Scenario: Verify Deleting Offer from catalogue
Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
  Then Create New Offer Catalogue
  Then Add offer to Offer Catalogue
  Then Delete Offer from Catalogue
  Then Delete Created Offer Catalogue
  Then logout
  
@tag5985
Scenario: Verify displaying offers in Offer catalog when more than 50 offers are added 
Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
  Then Create New Offer Catalogue
  Then Add fifty more offers to Offer Catalogue
  Then Delete Created Offer Catalogue
  Then logout
 
@tag2185
Scenario: Verify Help Icon in Offer Catalogue Page
Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
	Then Verify Help Of Offer Catalogue
	Then logout
	
@tag2102
Scenario: verify sql injection in Offer Catalog
Given login
Then navigate to precision marketing
Then  Navigate to Offer Management 
Then Navigate to Offer Catalogue
Then verify sql injection in offer catalogue
Then logout
	
@tag2074
Scenario: verify Cross site scripting in Offer Catalog
Given login
Then navigate to precision marketing
Then  Navigate to Offer Management 
Then Navigate to Offer Catalogue
Then verify Cross site scripting in offer catalogue
Then logout


@tag1160
Scenario: Verify Edit Offer Catalogue 
Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
  Then Create New Offer Catalogue
  Then Add offer to Offer Catalogue
  Then Verify Edit Offer Catalog
  Then logout
  

@tag1159
Scenario: Verify Colapsing Offer in Offer Catalog
Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
  Then Create New Offer Catalogue
  Then Add offer to Offer Catalogue
  Then Verify Collapsing Offer in Offer Catalog
  Then Delete Created Offer Catalogue
  Then logout

