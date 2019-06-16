
Feature: Company controller /company


  Scenario Outline: client makes call to post /company
    Given company "<name>"
    When  client call api post /company
    And the client receives company status <companyStatus>
      Examples:
        | name      |  companyStatus  |
        |    test 1 |     ACTIVE     |
        |    test 3 |     ACTIVE      |


  Scenario Outline: client makes call to GET /company by name
    Given company "<name>"
    When  client call api get /company
    And the client receives companies with status <companyStatus>
    Examples:
      | name      |  companyStatus  |
      |    test 1 |     ACTIVE      |
      |    test 3 |     ACTIVE      |
