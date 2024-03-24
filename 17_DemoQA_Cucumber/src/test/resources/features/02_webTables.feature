@webTables
Feature: WebTables
  This feature includes /WebTables tests

#  Background: TC00 WebTables Tests First and must
#    Given open "https://demoqa.com/webtables" page
#    And click "Web Tables" button

  Scenario: TC01 WebTables Tests First and must
    Given open "https://demoqa.com/webtables" page
    And click "Web Tables" button

  @formInput
  Scenario Outline: TC02 Fill a Registration Form (only 1 / multi) Record
    When click "Add" button
    When Enter '<myFirstName>','<myLastName>','<myEmail>',<myAge>,<mySalary>,'<myDepartment>' fields
    And wait 1 seconds
    And click "Submit" button
    And wait 1 seconds
    Examples:
      | myFirstName | myLastName | myEmail      | myAge | mySalary | myDepartment |
      | ayşe        | can        | ayse@can.com | 35    | 50000    | QA           |
      | ali         | kara       | ali@can.com  | 40    | 45000    | Dev          |

  Scenario: TC03 Check fourth Record
    Then Check fourth Record

  @formInput
  Scenario: TC04 Edit a Registration Form
    Then click "Edit" button
    But  fix Registration Form from table
      | firstName | ayşegül         |
      | email     | aysegul@can.com |
    And click "Submit" button
    And wait 1 seconds

  @formInput
    Scenario: TC05 Get Data From json File
      Given open "https://demoqa.com/webtables" page
      And click "Web Tables" button
      When Get data from file and fill form
      And wait 1 seconds
