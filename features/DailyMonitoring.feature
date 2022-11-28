
  Feature: Daily monitoring the websites

    Scenario: Verify the all the dates for daily monitoring
      Given User moves to "Data" tab and select "About the Data" option
      And user verifies page is navigated to "About the Data"
      Then User verifies all the refresh cycle which are "Daily" is Data of Source Data is "today"