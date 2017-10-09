#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: Offer Page Features

@tag
Feature: Title of your feature
	product creation using valid details

@tag1
Scenario: Products Grid: Verify scrolling functionality to view the product at the end of the screen
Given login
Then navigate to precision marketing
Then navigate to offer management
Then scrolling to view the entire product list
Then close browser
