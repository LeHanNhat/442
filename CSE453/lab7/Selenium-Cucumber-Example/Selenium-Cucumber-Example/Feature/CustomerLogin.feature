Feature: Login
Scenario: Succesful Login with Valid Credentials
      Given User Launch Chrome browser
      When Users open "https://admin-demo.nopcommerce.com/login"
      And Users enters Email as "admin@yourstore.com" and Password as "admin"
      And Click on Login
      Then Page title should be "Dashboard / nopCommerce administration"
      When Users click on Log out
      Then Page Title should be "Your store. Login"
      And Close Browser
      
Scenario Outline: Login Data Driven
      Given User Launch Chrome browser
      When Users open "https://admin-demo.nopcommerce.com/login"
      And Users enters Email as "<email>" and Password as "<password>"
      And Click on Login
      Then Page title should be "Dashboard / nopCommerce administration"
      When Users click on Log out
      Then Page Title should be "Your store. Login"
      And Close Browser
     
     Examples:
                |email|password|
                |admin@yourstore.com|admin|
                |admin1@yourstore.com|admin123|