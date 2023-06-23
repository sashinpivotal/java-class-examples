## Food catering application

Cater Mate is a web-based application intended to be used in house by a catering business owner and 
a few users that work for the owner, to keep track of the orders placed by the customers and also to have the information 
available for the kitchen workers to view and make food to fulfill the order on the promised date and time.

The design of this app is very similar to a general shopping app having products, shopping carts, orders, and customer
information, so it can be modified to be used with any type of products.

## Contents

- [Case Study Rubrics](https://docs.google.com/document/d/1vX3oHn2rudg7hKWhudUCl5nQ-k447fwGf1XPg2YYBh0/edit)  -- Please contact [Supamas Sirichotiyakul](mailto:supamas.sirichotiyakul@gmail.com) to access this file
- [Presentation Slides](doc/Presentation.pdf)
- [Daily Progress](#daily-progress)
- [User Stories](#user-stories)
  - [Admin](#admin)
  - [User](#user)
- [Technical Architecture](doc/Cater%20Mate%20Technical%20Architecture.pdf)
- [Wire Frame](doc/Cater%20Mate-wireframe.pdf)
- [Schema Diagram](Sirichotiyakul_Supamas_Schema.pdf)
- [Technical Challenges](#technical-challenges)
- [Lessons Learned](#lessons-learned)
- [Future Improvements](#future-improvements)

## Daily Progress
- April 26th (100% done)
  - Added presentation
  - Added wire frame
  - Minor style edits
  - Added Logger to CartServiceImpl

- April 24th (97% done)
  - Removed KITCHEN from navbar.
  - Fixed test issues with isTrue().
  - Rearranged files into packages according to models.
  - Added JavaDoc to CartItemServiceImpl.getNewCartItemFromMenuItem() method.
  - Added tests for custom queries at repository level.
  

- April 23rd (96% done)
  - Added more lessons learned related to Thymeleaf.
  - Fixed a bug in order_submitted.html that didn't show the image.
  - Removed save cart in the controller method for "/order" so that a new cart is saved to the database only
    after an item has been added to the cart.
  

- April 22nd (95% done)
  - Added Description, Technical Architecture, Technical Challenges, Lessons Learned, Future Improvements
  - Cleaned up CSS
  - Added lambda expressions in the main CaterMateApplication class.
  

- April 21st (92% done)
  - Updated README.md to link to Schema.pdf.
  - Created schema for the project in Schema.png file.
  

- April 20th (92% done)
  - Added parameterized test for CartServiceImplTest
  - Added OrderServiceImplTest
  - Fixed bug where updating order is not saving orderItemList correctly
  - Added data.sql for populating the database by SQL statements, both in main and in test
  - Added application.properties in test/resources folder
  - Added test code MenuItemServiceImplTest
  - Removed cart reference from CartItem class
  - Fixed update user functionality bug


- April 19th (90% done)
  - Added Logger and log messages to controller classes.
  - Added JavaDoc folder and JavaDoc files.
  

- April 18th (87% done)
  - Added OrderRestController to provide web services.
  - Updated README.md file to have links and Contents section.
  - Created Schema.mwb file from SQL Server database.
  - Made Order -> OrderItem relationship uni-directional instead of bi-directional.
  

- April 16th (85% done)
  - styled the order search boxes so they align properly
  - rename things to match the requirements
  - changed permissions so anyone can view orders but only ADMIN and SUPERADMIN can edit or delete.


- April 15th (80% done)
  - Added ADMIN, SUPERADMIN roles and have permission set for "/users" as accessible by SUPERADMIN and "/menu" and
    "/viewOrders" are for ADMIN & SUPERADMIN
  - Addressed role assignment with:
    - any user with first name starting with "admin" will be assigned "ROLE_USER" and "ROLE_ADMIN" role
    - any user with first name starting with "superadmin" will be assigned "ROLE_USER", "ROLE_ADMIN", and "SUPERADMIN" role
  - added 3 error html pages - 403, 404, and 500 errors under "templates/error" folder.
  - added 3 custom queries for Order class and add search boxes in "View Orders" page (currently all 3 searches are "OR"
    together)
  - TODO: style 3 search boxes so they align


- April 14th (75% done)
  - created a MenuItemServiceImpl bean using @Bean annotation (to satisfy a Capstone requirement)
  - finished styling registration page
  - merged the old User class to Spring security login User class


- April 12th (70% done)
  - add Spring security login from class example - still need to style registration.html page
    and merge the old User class and related code to the example User class
  

## User Stories

### Admin

- As an admin, I want to log in with an admin privilege so that I can edit the list of items in the menu, update
  the price, etc.

  - Tasks:
    1. Create a database and a User table containing username, password and privilege.
    2. Login screen asking for username and password.
    3. Check if the username exists in the User table
    4. Check if the password matches the entry in the table
    5. Assign the privilege to the current user login session
    6. If login is successful, show the main screen with options according to login privilege.
  - Question: How to encrypt the password?
  
- As an admin, I want to create a new menu item so that it's available on the menu.

- As an admin, I want to view all the items on the menu listed with the price.

- As an admin, I want to edit a menu item in terms of name, description, and price, so that it's up-to-date.

- As an admin, I want to delete a menu item so that it is no longer available on the menu.

- As an admin, I want to search the orders based on customer name, date, and location.

#### Not implemented in this version

- As an admin, I want to view the quantity ordered for each menu item so that I know which item is popular.

- As an admin, I want to add a new ingredient so that it can be used as part of an item in the menu.

- As an admin, I want to view the list of ingredients so that I see what's available.

- As an admin, I want to edit an ingredient so that I can keep it up to date.

- As an admin, I want to delete an ingredient so that it is removed from the list.


### User

- As a user, I want to log in with a user privilege so that I can do basic operations like entering a customer's order.
  - Tasks:
    1. Same as for admin login a-e
    2. If login is successful, show the screen for ordering.
    
- As a user, I want to add each item in the order, with the name and quantity.

- As a user, I want to check out and add customer information after desired items have been added to the cart.

- As a user, I want to see the total amount as I add each item so that I can tell the customer if needed.

- As a user, I want to query the orders that need to be filled for a specific day so that I can give the information
  to the people who work in the kitchen.

- As a user, I want to create an invoice from the order in pdf format.

#### Not implemented in this version

- As a user, I want to have the kitchen pick sheet automatically created after I place an order.

- As a user, I want to create an invoice as a pdf file so that I can send it to the customer.


## Technical Challenges
- Thymeleaf can only return a single object with the form submission 
  - An example was in the CartController @PostMapping("/addToCart/{menu_item_id}") - both the cart information and 
    the menu item are needed by the controller so it can add the menu item to the cart. 
  - The solution was to send the cart back as a model but send the menu item id with the path variable, then query 
    the database for the menu item in order to get name & price.
  

- The original design was to have the order and checkout pages combined in one page but things become too complicated in
  a single page with @PostMapping required both for adding an item to the cart (which is saved to the database in case
  the cart gets abandoned) and submitting customer information. 
  - The solution was to split them out into 2 pages which made the implementation much easier to understand.

## Lessons Learned
- Thymeleaf was new to me, and I assumed things work a certain way with the model attributes, but it was not
  correct. Because of that I spent a large amount of time debugging and experimenting on things, I should have tried
  to find a good resource to learn and really understand Thymeleaf more thoroughly first.


- Defining the project scope that is small enough to accomplish in the given time frame is critical.


- Making decisions early and getting implementation done early then having time to go back to improve things was
  a lot better than taking a long time to try to make a perfect decision and running short on time closer to the deadline.


- Project management and setting priorities and daily goals using a tool like Jira was very helpful.

## Future Improvements
- Add functionality for an admin to create, read, update, delete:
  - ingredients 
  - list of ingredients with associated amount for each menu item. 
  - a kitchen pick sheet after the order is submitted
- Allow customers to log in as users, save the following customer information and use them for the order:
  - first name
  - last name
  - address
  - phone number
  - credit card information
- List menu item with associated total quantity ordered so that the business owner knows which menu items are popular.


