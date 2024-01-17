Feature: Login feature

  Scenario: Login Success
    Given I open browser
    And I open login page
    And I enter email "valentyna.bihdash@testpro.io"
    And I enter password "TestTest1!"
    And I submit
    Then I am logged in