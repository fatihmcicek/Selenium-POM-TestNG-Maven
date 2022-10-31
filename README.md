<h2  align="center" > Automation Exercise Test Cases</h2>

![App Screenshot](https://user-images.githubusercontent.com/50528457/197885512-a78cd142-7626-4ef3-8f1c-9035102ffb69.PNG)

### Used technologies

**Java:** The programming language in which the project is written

**TestNG:** Test Authoring Tool used for writing Test Cases and controlling outputs.

**Selenium:** Test Automation Tool used to test
Website [Selenium WebDriver](https://www.selenium.dev/documentation/webdriver/).

**Page Object Model:** It is the architectural structure used in the project.

**Maven:** Automation and build tool that is usually used during the compilation of commands on the Java platform.

**Faker:** This library is a port of Ruby's [faker](https://github.com/faker-js/faker) gem (as well as Perl's Data::
Faker library) that generates fake data.
It's useful when you're developing a new project and need some pretty data for showcase.

### Test Scenarios

    Scenario: Test Case 1_Register User
    Scenario: Test Case 2_Login User with correct email and password
    Scenario: Test Case 3_Login User with incorrect email and password
    Scenario: Test Case 4_Logout User
    Scenario: Test Case 5_Register User with existing email
    Scenario: Test Case 6_Contact Us Form
    Scenario: Test Case 7_Verify Test Cases Page

### Pom.xml Dependencies

        <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.5.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/org.testng/testng -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.6.1</version>
            <scope>test</scope>
        </dependency>

        <!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>5.3.0</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.github.javafaker/javafaker -->
        <dependency>
            <groupId>com.github.javafaker</groupId>
            <artifactId>javafaker</artifactId>
            <version>1.0.2</version>
        </dependency>

        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-simple</artifactId>
            <version>2.0.3</version>
            <scope>test</scope>
        </dependency>

       