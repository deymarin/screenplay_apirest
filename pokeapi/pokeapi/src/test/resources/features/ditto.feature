Feature: PokeAPI Ditto
  As user i need to get the information from a pokemon

  @DittoSuccessful
  Scenario: Get abilities successful
    When get the information of ditto
    Then i should get the abilities limber and imposter
    And i should get the held items ruby emerald and diamond
