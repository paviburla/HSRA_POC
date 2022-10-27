Feature: Verify the header and footer details of health sites dashboard

Scenario: Verify the header and footer details of health sites dashboard
    Given User navigates to site "https://data.hrsa.gov/"
    And User moves to "Data" tab and select "Dashboards" option
    Then user navigates to "health sites" dashboard
    And user verifies page is navigated to "Health Sites"
    And user verifies page title is "Health Sites"
    And user header, body, logo and footer is present
    And user navigate to about the dashboard and verify url "https://data.hrsa.gov/Content/Documents/topics/About%20the%20Health%20Sites%20Dashboard.pdf" is loaded
    And user navigate to dashboard export instructions and verify url "https://data.hrsa.gov/Content/Documents/topics/Dashboard_Export_UserGuide_v1.2.pdf" is loaded
    And user verify data as of now is showing todays date 