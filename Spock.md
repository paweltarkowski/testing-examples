# Spock

## Introduction
* Framework for write tests for java and groovy
* **Based on groovy** where only limited knowledge of this langugage is needed
* **Compatible with most IDEs**, build tools
* **Many features are out of the box**, e.g. mocking, test parametrization, bdd 
* **Simplification** and speed up writing tests

## How to start
* **Starting point** is import spock into your project by adding maven or gradle configuration 
* Download groovy language - http://groovy-lang.org/download.html
* Remember that spock tests have **different name** and file extension – ***Spec.groovy** 
* **Spock Web Console** - http://meetspock.appspot.com/  - you can check writing test directly on web browser

## What’s next
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

## Feature method blocks
Each feature method can be splitted into several block of codes which are:
* **given**: or **setup**: optional block, you can use both names but preferable way is to use same block name for all tests
* **when**: run code to get result of test object method
* **then**: verify result.
* **expect**: this is when/then in one line 
* **cleanup**: to cleanup test, rarely used
* **where**: parametrization, runs before all blocks

## Parametrization
* **Where** – block used to parametrize test
  * Most common is table format when you define columns names used in „when” and rows with real values
  * You can use here objects which are static or @Shared. 
  * This block always comes as last block
* **@Unroll**
  * naming pattern for parametrized test
  * useful to find out which case is failed 
  * parameter from where: block can be used in method name def „should be failed for #paramName”() or directly in adnotation @Unroll(„should be failed for #paramName”) 

## When/Then
* Both blocks are **stick together** 
* **When** – define part of code which should be tested
* **Then** – define assertions to verify the code
* Can be combined with **where:** block

## Expect
* **Combination of when/then in one method** 
* Used for simple method verification
* Can be combined with **where:** block

## @Shared
* Used for complicated objects shared across all feature methods
* Good to define this field at the point of declaration
* Equivalent to this adnotation is to initialize field at very beginning of the setupSpec()
* You can use this object in where: block

## Mock
* Create:
    ```
    def someMock = Mock()/Mock(class)
    ```
* Return value:
    ```
    def SOME_RESULT = any value you want
    
    someMock.someMethod() >> SOME_RESULT
    someMock.someMethod("SOME_VALUE") >> SOME_RESULT
    someMock.someMethod(_,_) >> SOME_RESULT
    someMock.someMethod(*_) >> SOME_RESULT
   ```
* Throw exception
    ```
    someMock.someMethod() >> { throw new Exception()}
  ``` 
* Check method invocations count  - you can verify how many time specific method was run by using
    ```
    1 * someMock.someMethod() - check if method was run without parameters
    1 * someMock.someMethod("SOME_VALUE") - check if method was run with parameter value
    1 * someMock.someMethod(_,_) - check if method was run with 2 parameter but values of them are not important 
    1 * someMock.someMethod(*_) - check if method was run but number of parameters and their values are not important  
  ```
  
## Stub
* Create:
  ```
    def someStub= Stub()/Stub(class)
  ```
* simpler than Mock - lower time 
* method mocking is same as using Mock
* **main difference to Mock**: you can not check invocation method number, if you try to check you will get Exception

## Spy
* create
```
    def someSpy= Spy(class)
    def someSpy= Spy(class){
          someMethod() >> SOME_VALUE
    }
  ```
* based on real object
* change behaviour of specific methods and not mock the whole class

## Mock static methods/final class
* When we want to mock static methods/final class we can use 
    ```
    @RunWith(PowerMockRunner.class)
    @PowerMockRunnerDelegate(Sputnik.class)
    @PrepareForTest([SomeUtils.class, SomeFinalClass.class])
    ```
* For mocking static method we can use PowerMockito.mockStatic and PowerMockito.when
    ```
    mockStatic(SomeUtils.class)
    when(SomeUtils.someMehtod(anyLong())).thenReturn(SOME_VALUE)
    ```
* For mocking final class we can then use standard Mock, Stub or Spy
    ```
    SomeFinalClass = Stub()
    ```
## Worth to remember about spock
* **Maven/pom.xml** – verify if spock tests are running during maven build to confirm configuration is proper
* **Object initialization** – verify if objects are initialized in correct method. Remember difference between setup or setupSpec
* Block **Where:** run before all steps except setupSpec, in this block you can use only static or shared object, commonly use with @**Unroll adnotation** 
* **Mocking final/static class**– use PowerMock

## Good tests in general
* **Clearly** defined method name for test case 
* Use **smart value**s rather than „magic number” like 20, 30
* Verify all kind of scenarios – **not only happy path**
* Create method per specific scenario
* **Parametrize tests**
* Test real logic and avoid mocks verification
* Good to follow rule: **RED GREEN REFACTOR**


## Summary
* **prons** - helpful during write clean and easy do read tests, has many features are out of the box
* **cons** - spock require learning, hope you find this time worth of that
* if you do not like spock but like writing test in **junit4/5/other framework** – it is completely good, keep doing that

