# Reseller Application

**_ResellerApp_** must represent the online marketplace dedicated to buying and selling new or used items.

**Requirements:**

**_1.Database Requirements_**

The Database of the Reseller application needs to support 3 entities:

- User
- Offer
- Condition

![Screenshot](assets/Reseller_EER_Diagram.png)

**_2.Initialize conditions_**

The application should have a method that checks (when the application is started) whether the database does not have conditions and method must autofill conditions data.

**_3.Pages Requirements_**

- Index Page (logged out user)

![Screenshot](assets/sc01-index-page-logged-out-user.png)

- Login Page (logged out user)

![Screenshot](assets/sc02-login-page-logged-out-user.png)

    - Login Page validations

![Screenshot](assets/sc03-login-page-validations-unexisting-user.png)

![Screenshot](assets/sc04-login-page-validations-fields.png)

- Register Page (logged out user)

![Screenshot](assets/sc05-register-page-logged-out-user.png)

    - Register Page validations

![Screenshot](assets/sc06-register-page-validations.png)

- Home Page (without having any offers)

![Screenshot](assets/sc07-home-page-without-having-any-oofers.png)

- Add offer

![Screenshot](assets/sc08-add-offer.png)

    - Add offer validations

![Screenshot](assets/sc09-add-offer-validations.png)

- Home Page (with offers)

![Screenshot](assets/sc10-home-page-with-offers.png)

**_4.Functional Requirements_**

- The application should provide Guest (not logged in) users with the functionality to log in, register and view the Index page.
- The application should provide Users (logged in) with the functionality to log out, add a new offer (Add offer page), view all offers (Home page) and buy an offer from All Other Offers to Bought Items.
- Reseller Application in navbar should redirect to the appropriate URL depending on that if the user is logged in.
- The application should provide functionality for adding offers with conditions of Excellent, Good or Acceptable.
- The offers should be separated into different sections according to their ownership.
- When the user clicks on the BUY NOW button of some offer, he buys the offer to his Bought Items. You should not delete this offer from DB. The offer should be removed from the collection with offers from the seller and should be added to the collection with boughtOffers of the buyer.
- The Remove button in My Offers section should remove the offer from DB.
- Bellow the All Other Offers banner is located an info bar that shows the sum of the offers in this field.

**_5.Security Requirements_**

- Guest (not logged in) users can access the Index page.
- Guest (not logged in) users can access the Login page.
- Guest (not logged in) users can access the Register page.
- Users (logged in) can access the Home page.
- Users (logged in) can access Add Offer page.
- Users (logged in) can access Logout functionality.