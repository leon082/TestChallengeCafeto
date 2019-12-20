Feature: Login to aws site
  Login to aws.amazon.com site with user credentials 

  Scenario Outline: Login with valid credentials
    Given The user is on the login page
    When The user fills in account id with "<username>"
    And The user press next button
    Then The users should be on the user home page
    And The users sees "<message>"

Examples:

      | username                    | message              |

      | pepitoperez@gmail.com       | Login Succesful!     |

      | pepitoramirez@test.com      | Invalid Credentials! |
