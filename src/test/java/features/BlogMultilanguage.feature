@MultilanguageCheckOnBlog
Feature: Multilunguage check for Blog page



@without_Login
  Scenario: Multilunguage check for Blog page
  Given User is on Home Pagei
  Then click on Blog button
  Then select language from dropdown list and verify the url
  
@With_login
Scenario: Multilunguage check for Blog page with login 
  Then Click on signin page
  Then Enter username "nishadhiman0027@gmail.com" and passwordi "Qwerty@1"
  Then click on Blog button
  Then select language from dropdown list and verify the url
  Then click on Sign out button and verify the pagei