#Author: madhan.kumar@flytxt.com

@madhan_test_suite_on_OfferCreation
Feature: Test suite on Offer creation
  I want to check all test cases related to offer page

 @tag1349
  Scenario: Create offer:Track: Verify creating offers with SMS channel NX-1349
    Given login
    When navigate to precision marketing
    Then navigate to offer management
    Then Navigate_to_Offers
    Then Create_offers_with_SMS_channel
    #Then logout
 @tag1351
  Scenario: Create offer:Track: Verify creating offers with Voice Push channel NX-1351
    Given login
    When navigate to precision marketing
    Then navigate to offer management
    Then Navigate_to_Offers
    Then Create_offers_with_VOICEpush_channel
    #Then logout
 @tag1353
  Scenario: Create offer:Track: Verify creating offers with Wap Push channel NX-1353
    Given login
    When navigate to precision marketing
    Then navigate to offer management
    Then Navigate_to_Offers
    Then Create_offers_with_WAPpush_channel
    #Then logout
 @tag1376	
  Scenario: Offer Management-->Create new offer-->Cancel button NX-1376
    Given login
    When navigate to precision marketing
    Then navigate to offer management
    Then Navigate_to_Offers
    Then Check_Offer_cancel_button
    #Then logout
 @tag2173
  Scenario: Offer Management : Verify for the Offers Help icon NX-2173
    Given login
    When navigate to precision marketing
    Then navigate to offer management
    Then Navigate_to_Offers
    Then Check_Offer_help_icon
    #Then logout
 @tag885
  Scenario: Create offer: Creative: Verify the proceed button not entering details NX-885
    Given login
    When navigate to precision marketing
    Then navigate to offer management
    Then Navigate_to_Offers
    Then Check_details_tab_without_entering_details
    #Then logout
 @tag3035	
  Scenario: Verify the 'Add' button displayed in Products tab NX-3035
    Given login
    When navigate to precision marketing
    Then navigate to offer management
    Then Navigate_to_Offers
    Then Check_add_button_in_product_tab
    #Then logout
 @tag6214
  Scenario: Offer-Creation: Verify filtering based on product name inside product tab NX-6214
    Given login
    When navigate to precision marketing
    Then navigate to offer management
    Then Navigate_to_Offers
    Then Check_filter_operation_in_products_tab
    #Then logout