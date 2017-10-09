#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: Offer Page Features

@tag
Feature: Title of your feature
	broadcast creation using valid details

@tag1
Scenario: create broadcast with valid details
Given login
Then navigate to precision marketing
Then navigate to life cycle marketing
Then create new bc
#Then delete product
Then logout
#And verify created offer