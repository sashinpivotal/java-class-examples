#Cater Mate Project
### Developer: Supamas Sirichotiyakul

### Description:
A web application for taking and managing orders for a catering service.

### How to Run the Website:
- Start by opening the 'resources/templates/index.html' page.
- Type in any username and password (see Input Validation below) to log in.

### Technical Requirements:
#### HTML
- Use HTML tables: on "Order" and "Users" pages
- Implement at least two uses for forms: all pages use form(s)
- Dropped down menu: on "Order", "Add User", and "Update User" pages
- Use web fonts: the header "Cater Mate" font
- Use different types of content in the form of:
  - Text: every page
  - Images: login page
  - Videos: login page
  - GIFs: "Order Submitted" page after order is submitted.
- Regex validation: In "Order" page
#### CSS
- Inline, internal, and external styling: all in index.html page
- Use five different CSS selectors: check resources/static/css/styles.css file
- Don't use too many fonts
- Use colors that complement each other
- Use Flexbox (optional): all pages use flexbox(es)

#### Javascript
- External JS scripts: 
  - resources/static/script/login.js
  - resources/static/script/order.js
- Use variables, if statements, loops, at least one form of collections, functions/call back: order.js
- Use events: login.js

### Input Validation:
- index.html page (Login page):
  - Use an event listener
  - Username - regex validation in Javascript (login.js)
    - must be between 4-20 characters
    - must start with a letter 
    - can contain alphanumeric characters only

- order.html page (Order page):
  - Use call back "return validate()"
  - Phone number - regex validation in HTML
  - Catering Date and Kitchen Ready Time - regex validation in Javascript, but since a date picker and a time picker 
    are used, it can be difficult to check if regex works correctly. If these fields are left blank, there will be
    a pop-up alert box.
  - Catering Date:
    - year must start with '20'

### Note:
- Index page's video has no sound.
- Menu and Kitchen pages are not working yet.
- Delete buttons on Users page are not working yet.
- Order sample is hard-coded for the demo purpose only.
