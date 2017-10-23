
@tagOfferCatalog
Feature: Offer Catalogue 

@tag1
Scenario: Verify Creating Offer Catalogue
  Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
  Then Create New Offer Catalogue
  Then Add offer to Offer Catalogue
  Then Delete Created Offer Catalogue
  Then logout
	
@tag2

Scenario: Verify Canceling Offer Catalogue 
Given login
Then navigate to precision marketing
Then  Navigate to Offer Management 
Then Navigate to Offer Catalogue
Then Cancel the New offer Catalogue
Then logout

@tag3 

Scenario: Verify Canceling Selected Offer 
  Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
  Then Create New Offer Catalogue
  Then Cancel Selected Offer
  Then Delete Created Offer Catalogue
  Then logout
 
@tag3  
Scenario: Verify Adding Selected Offers
Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
  Then Create New Offer Catalogue
  Then Add offers to Offer Catalogue
  Then Delete Created Offer Catalogue
  Then logout
  
@tag4
Scenario: Verify Selecting Multiple Offers
Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
  Then Create New Offer Catalogue
  Then Select Multiple Offers
  Then Delete Created Offer Catalogue
  Then logout
 
 @tag5 
 Scenario: Search Offers Using Combination of fields
  Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
  Then Create New Offer Catalogue
  Then Search Offers with Combination of details
  Then Delete Created Offer Catalogue
  Then logout
  
 @tag6
 Scenario: Search Offers Using Service leg
  Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
  Then Create New Offer Catalogue
  Then Search Offers Using Service leg
  Then Delete Created Offer Catalogue
  Then logout
  
@tag7
Scenario: Verify Canceling selected Offers
Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
  Then Create New Offer Catalogue
  Then Cancel Selected Offers
  Then Delete Created Offer Catalogue
  Then logout
  
@tag8
Scenario: Verify Selecting Offers Using Product Name
Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
  Then Create New Offer Catalogue
  Then Select Offers Using Product Name
  Then Delete Created Offer Catalogue
  Then logout
  
@tag9
Scenario: Verify Added Catalogue
Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
  Then Create New Offer Catalogue
  Then Add offer to Offer Catalogue
  Then Verify Added Catalogue
  Then Delete Created Offer Catalogue
  Then logout

@tag10
Scenario: Verify Field validation in Offer Catalogue
Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
  Then Validate Catalogue Name
  Then logout
  
@tag11
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
  
@tag12
Scenario: Verify Adding Fifty more offers to catalogue
Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
  Then Create New Offer Catalogue
  Then Add fifty more offers to Offer Catalogue
  Then Delete Created Offer Catalogue
  Then logout
 
@tag13
Scenario: Verify Help Icon in Offer Catalogue Page
Given login
	When navigate to precision marketing
	Then Navigate to Offer Management 
	Then Navigate to Offer Catalogue
	Then Verify Help Of Offer Catalogue
	Then logout
	
@tag14
Scenario: verify sql injection in Offer Catalog
Given login
Then navigate to precision marketing
Then  Navigate to Offer Management 
Then Navigate to Offer Catalogue
Then verify sql injection in offer catalogue
Then logout
	
@tag15
Scenario: verify Cross site scripting in Offer Catalog
Given login
Then navigate to precision marketing
Then  Navigate to Offer Management 
Then Navigate to Offer Catalogue
Then verify Cross site scripting in offer catalogue
Then logout

@tag16
Scenario: verify sql injection in Offer Catalog
Given login
Then navigate to precision marketing
Then  Navigate to Offer Management 
Then Navigate to Offer Catalogue
Then verify sql injection in offer catalogue
Then logout

@tag17
Scenario: verify Cross site scripting in Offer Catalog
Given login
Then navigate to precision marketing
Then  Navigate to Offer Management 
Then Navigate to Offer Catalogue
Then verify Cross site scripting in offer catalogue
Then logout

@tag18
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

