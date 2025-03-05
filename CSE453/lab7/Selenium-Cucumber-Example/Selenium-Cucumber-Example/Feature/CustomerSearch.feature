Feature: Customer Search
Scenario: Search of a Registered Customer
     Given Users Launch Chrome browser
     When User opens URL "https://admin-demo.nopcommerce.com/login"
     And User enters Email as "admin@yourstore.com" and Password as "admin"
     And Clicks on Login
     Then User can view Dashboard
     When users click on Customers menu
     And click on Customers menu item
     And users enter Email "rim.rim4444@gmail.com"
     And users enter First name "Rimpi"
     And users enter Last name "Smith"
     And users select Date of Birth as 9th of June
     And users click search button
     Then User can view "No data available in table"
     And close browser