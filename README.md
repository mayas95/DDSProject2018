# ShoppingCart [![HitCount](http://hits.dwyl.io/ikismail/ShoppingCart.svg)](http://hits.dwyl.io/ikismail/ShoppingCart)

Developed an end to end **Ecommerce web Application using Spring MVC** with multiple
modules

### Functionalities:

1. User Registeration

2. **CRUD Operations** like

* User can add product to his cart
* Admin can add product to the product list
* Admin can edit the product details
* Admin can delete the product from the list

3. **Spring Security**

* User can login the site
* The entire site will change according the role. Whether the client is User or Admin
* user can logout after completing.

4. **Spring WebFlow**

* after adding products the cart the User can checkout using spring WebFlow
* Confirming User Details
* Confirming Shipping and Billing Address
* Receipt
* If the user cancel the webflow it will go to cancel Page
* If the user submits the checkout it will go to thank you page with the timing of delivery Report

### Tools and Technologies:

* **Technology** : Bootstrap, Java, Spring MVC, Hibernate, JSP, Maven.
* **Application Servicer**: Apache Tomcat Server
* **Database** : H2 Database.

### Installation:

1. Development Platform - Eclipse / IntelliJ Idea
   * [Download Eclipse](https://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/mars2)
   * [Download IntelliJ Idea](https://www.jetbrains.com/idea/download/#section=windows)
2. Server - Apache Tomcat Server

   * [Download Apache Server](https://tomcat.apache.org/download-70.cgi)

3. Build Tool - Maven

   * [Download Maven](https://maven.apache.org/download.cgi)

4. Database - H2 Database

   * [Download H2 Database](http://www.h2database.com/html/download.html)


5. Run your H2 Database.

6. Configure your database configuration in **application-context.xml**

   * Database properties:


        <!-- database properties DataSource -->

            <bean id="dataSource"
              class="org.springframework.jdbc.datasource.DriverManagerDataSource">
              <property name="driverClassName" value=YOUR DB DRIVER CLASS NAME" />
              <property name="url" value="YOUR DB URL" />
              <property name="username" value="YOUR DB USERNAME" />
              <property name="password" value="YOUR DB PASSWORD" />
            </bean>

      * Database Dialect:

            <prop key="hibernate.dialect">YOUR DB DIALECT</prop>

7. Run the server.

I have also filmed a video on how to setup our project simply:
https://youtu.be/6xnnpKh4YHw

### ScreenShots:

* Home Page:

![Alt text](https://github.com/ikismail/ShoppingCart/blob/master/src/main/webapp/WEB-INF/resource/images/screenshots/Home.jpg "Home Page")

* Contact Us:

![Alt text](https://github.com/ikismail/ShoppingCart/blob/master/src/main/webapp/WEB-INF/resource/images/screenshots/ContactUs.png)

11. Populate the database
After installing the H2 database and running the application on Tomcat, the database should be populated.
First step: Create a normal user from Registration
Second step: In order to get the admin user, change the 38 line in the file ShoppingCart-master/src/main/java/com/dao/CustomerDaoImpl.java
The line should be changed from 
authorities.setAuthorities("ROLE_USER");
to
authorities.setAuthorities("ROLE_ADMIN");
After that, the application should be restarted and then it would be able to login with the Admin account.
After logging in with the admin account, there is an option to add the product and that is how the products are added to the database.
Now the application is populated with Products and you can go to the normal account and choose products from the Product list, add them to the Cart and make Checkout.
