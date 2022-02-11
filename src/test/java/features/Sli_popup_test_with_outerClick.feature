@outerClickTest
Feature: SLI POP UP test_with outer click

@withoutlogintest
  Scenario: SLI popup test with outer click without login
  Given Go to Home page
  Then Enter "HR" data in search field
  Then press the escape key
  Then verify the popup is visible or not?
  Then open Sli listing page and verify the popup 
  
  @withlogintest
  Scenario: SLI popup test with outer click with login
  Then Click on Signin button  
  And Enter free valid username "nishadhiman0027@gmail.com" and password "Qwerty@1"
  Then Enter "Management" data in Search fields
  Then Press the Escape key
  Then verify the Popupi
  Then Open Sli listing pages and verify the pop-up 
  Then Click on the sign out button and verify the page