Feature: Exercise one

  @Test-1
  Scenario: Different Elements Page test
    Given I open JDI GitHub site
    And I login as username 'Roman' and password 'Jdi1234'
    When I click on 'Service' button in Header
    And I click on 'Different Elements' button in Service dropdown
    And I select checkbox as 'Water'
    And I select checkbox as 'Wind'
    And I select radio as 'Selen'
    And I select color as 'Yellow'
    Then Checkbox log should be 'Water'
    And Checkbox log should be 'Wind'
    And Radio log should be 'Selen'
    And Color log should be 'Yellow'
