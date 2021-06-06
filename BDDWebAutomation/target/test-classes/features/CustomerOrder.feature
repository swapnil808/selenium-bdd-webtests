Feature: Customer Orders

  @order
  Scenario Outline: Verify Confirmation of Order on Order history page
  Given I am on homepage
  And I login with <UserName> and <Password>
  When I add tshirt to cart with <Size>
  And I confirm my order
  Then I should see my order confirmation on order history
  
  Examples:
  | UserName                 | Password  | Size |
  | testautouser05@gmail.com | qualitest | M    |
  
  
  @update
  Scenario Outline: Verify that Personal information of User is updated successfully
    Given I am on homepage
    And I login with <UserName> and <Password>
    When I update my <FirstName> and confirm <Password>
    Then I should see my personal information is updated with <FirstName> successfully

    Examples: 
      | UserName                 | Password  | FirstName    |
      | testautouser05@gmail.com | qualitest | Testnewfname |
