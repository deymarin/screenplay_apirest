Feature: PlaceholderAPI
  As user i need to create a post

  @PostsSuccessful
  Scenario Outline: Create a post successfully
    When i send the post information <title>, <body> and <userId>
    Then i should create the post successfully
    Examples:
      | title               | body   | userId |
      | hate to be lame     | lizzy  | 11     |
      | crying isn't like u | billie | 11     |
