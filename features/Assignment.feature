Feature: Verify the header and footer details of health sites dashboard

Scenario: Verify the header and footer details of health sites dashboard
    Given User moves to "Data" tab and select "Dashboards" option
    Then user navigates to "Health Sites" dashboard
    And user verifies page is navigated to "Health Sites"
    And user verifies page title is "Health Sites"
    And user header, body, logo and footer is present
    And user navigate to about the dashboard and verify url "https://data.hrsa.gov/Content/Documents/topics/About%20the%20Health%20Sites%20Dashboard.pdf" is loaded
    And user navigate to dashboard export instructions and verify url "https://data.hrsa.gov/Content/Documents/topics/Dashboard_Export_UserGuide_v1.2.pdf" is loaded
    And user verify data as of now is showing todays date 
    Then user verifies bread crumb of the page as "Home>Data>Dashboards>Health Sites"
    
    
 Scenario:  Verify the header and footer details of COVID-19 Testing dashboard
    Given User moves to "Data" tab and select "Dashboards" option
    Then user navigates to "COVID-19 Testing" dashboard
    And user verifies page is navigated to "COVID-19 Testing"
    And user verifies page title is "COVID-19 Testing"
    Then user verifies bread crumb of the page as "Home>Topics>Health Centers>COVID-19 Testing"
    
  Scenario:  Verify the header and footer details of Applicant dashboard
    Given User moves to "Data" tab and select "Dashboards" option
    Then user navigates to "Applicant Dashboards" dashboard
    And user verifies page is navigated to "Bureau of Health Workforce Program Applicant Dashboards"
    And user verifies page title is "Bureau of Health Workforce Program Applicant Dashboards"
    Then user verifies bread crumb of the page as "Home>Topics>Health Workforce>Bureau of Health Workforce Program Applicant Dashboards"  


  Scenario:  Verify the header and footer details of Health Center UDS Data
    Given User moves to "Tools" tab and select "Health Center UDS Data" option
    And user verifies page is navigated to "Health Center Program UDS Data"
    And user verifies page title is "Health Center Program Uniform Data System (UDS) Data"
    Then user verifies bread crumb of the page as "Home>Tools>Health Center Program UDS Data"    