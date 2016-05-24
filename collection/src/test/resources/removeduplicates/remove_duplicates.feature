Feature: Remove duplicates
  To remove duplicates from any give Integer array.
 
  Scenario Outline: Remove duplicates from Integer array
    When I use set to remove duplicates from array: <input>
    Then I should get: <output>
    When I use iteration to remove duplicates from array: <input>
    Then I should get: <output>
    When I use removeDuplicates method to remove duplicates from array: <input>
    Then I should get: <output>
    Examples:
    |input|output|
    |1,2,2,3,3,4,4,2,3,5|1,2,3,4,5|
    |1,2,2,3,3,4,4,2,3,5,6,7,8,5,5,10,6,8|1,2,3,4,5,6,7,8,10|
    |1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11|1,2,34,25,45,3,26,85,4,86,43,10000,11,16,19,18,9,20,17,8,15,6,5,10,14,12,13,7|                
      