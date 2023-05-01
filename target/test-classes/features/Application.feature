#Author: jyothi.k@gmail.com


Feature: Unit Testing on the Whatfix application

@WhatFixApplication
Scenario: Validate the whatfix Url
    Given User is clicking the valid URL
    When Portal navigates to the Homepage
    Then User validate the site is opened or not

@WhatFixApplication   
Scenario: Validate the Customers link
    Given User is clicking the Customers link
    When Customers page is opened
    Then User validate the Customers page is opened or not

@WhatFixApplication   
Scenario: Validate the Pricing link
    Given User is clicking the Pricing link
    When Pricing page is opened
    Then User validate the Pricing page is opened or not

@WhatFixApplication
Scenario: Validate the Resources link
    Given User is clicking the Resources link
    When Resources page is opened
    Then User validate the Resources page is opened or not

@91Mobiles
Scenario: Validate the mobiles Url
    Given User is clicking the mobile URL 
    When user is in mobile landing 
    Then search for the Apple mobiles in the search box 
    And Count the number of search is displaying in the page
    And Print the mobile names and its price in console
    And Close the browser 
