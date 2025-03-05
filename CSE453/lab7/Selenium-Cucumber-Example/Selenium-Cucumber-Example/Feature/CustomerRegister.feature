Feature: CustomerRegister
Scenario: New customer can register
    Given User will open the chrome browser
    When Users open URL "https://demo.nopcommerce.com/login"
     And Users click register
     Then Users can view Register page
     When Users enters customers info
     And Users click register button
     Then Users can view "Your registration completed"
     When Users click continue
     Then users view page titled as "nopCommerce demo store" 
     And users write prices displayed in that page those are greater than $1,000.00 in console in descending order
     And user close browser 