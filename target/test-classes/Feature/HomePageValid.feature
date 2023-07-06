Feature: Home Page Verification

	@Regression
  Scenario: Verify Cards are present as expected
    Given verify previous update is present as card titile.
    Then verify last transcation detail along with transDETAIL is displayed
    And verify checkbox along with content when it clicked.
	@Run
  Scenario: Add new Transcation
  	Given verify the transcation popup is visible
  	Then check transcationType dropdown has options
  	| transcatinType |
  	| income |
  	| expence |
  	Then check user able to add the transcation details <category> <notes> <amount>
  	And verify the total accounts in accountDetail and add the transcation
  	|The default account|
  	Then check whether the transcation got added to the section
  Examples:
  | category | notes | amount |
  | "Milk" | "Added milk" | 4 |
  | "Vegetables" | "Added new Vegetable" | 10 |
  | "Curd" | "Added one curd" | 1 |
  	 
  	