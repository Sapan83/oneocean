Feature: Amazon Search and Shopping Cart

Scenario: search an item and add to the cart

Given initialize the browser with Chrome 
And   user should navigate to www.amazon.com
When  user enter in search "Teddy bear"
And   selects "Teddy bear" in the list 
Then  user must be redirected to Products Detail Page
And   user sorts Product according to "Avg. Customer Review"
And   user selects the Age range between "5 to 7 Years" 
When  user adds Product in his cart
Then  user must be redirected to on Cart Page
And   user must see two products in the cart

