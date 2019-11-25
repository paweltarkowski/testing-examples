#Spock

##Introduction
* Framework for write tests for java and groovy
* **Based on groovy** where only limited knowledge of this langugage is needed
* **Compatible with most IDEs**, build tools
* **Many features are out of the box**, e.g. mocking, test parametrization, bdd 
* **Simplification** and speed up writing tests

##How to start
* **Starting point** is import spock into your project by adding maven or gradle configuration 
* Download groovy language - http://groovy-lang.org/download.html
* Remember that spock tests have **different name** and file extension – ***Spec.groovy** 
* **Spock Web Console** - http://meetspock.appspot.com/  - you can check writing test directly on web browser

##What’s next
* **Imports** – import spock.lang.*
* **File name** - *Spec.groovy
* **Class name** – ExampleSpec extends Specification
* **Fixture methods**
    * def **setupSpec()** – runs once, before the first test method
    * def **setup()** – runs before every test method
    * def **cleanup()** – runs after every test method
    * def **cleanupSpec()** – runs after last test method
* **Feature method** – real methods which test your functionality 
e.g. def „validation should be failed because ...” (){....}

##Feature method blocks
Each feature method can be splitted into several block of codes which are:
* **given**: or **setup**: optional block, you can use both names but preferable way is to use same block name for all tests
* **when**: run code to get result of test object method
* **then**: verify result.
* **expect**: this is when/then in one line 
* **cleanup**: to cleanup test, rarely used
* **where**: parametrization, runs before all blocks

##Parametrization
* **Where** – used to parametrize test
  * Most common is table format when you define columns names used in „when” and rows with real values
  * You can use here objects which are static or @Shared. 
  * This block always comes as last block
* **@Unroll**
  * naming pattern for parametrized test
  * useful to find out which case is failed 
  * parameter from where: block can be used in method name def „should be failed for #paramName”() or directly in adnotation @Unroll(„should be failed for #paramName”) 

##When/Then
* Both blocks are **stick together** 
* **When** – define part of code which should be tested
* **Then** – define assertions to verify the code
* Can be combined with **where:** block

##Expect
* **Combination of when/then in one method** 
* Used for simple method verification
* Can be combined with **where:** block

