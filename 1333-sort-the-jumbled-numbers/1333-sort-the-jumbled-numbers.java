import java.util.Arrays;

class Solution {
  
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
      
        int[][] mappedWithIndex = new int[n][2];
      
        for (int i = 0; i < n; ++i) {
            int originalNum = nums[i];   
            int mappedNum = originalNum == 0 ? mapping[0] : 0;  // Map the number based on mapping rules.
            int placeValue = 1;   // To reconstruct the mapped number based on individual digits.
          
            // Map each digit of the original number based on the 'mapping' array.
            while (originalNum > 0) {
                int digit = originalNum % 10;  // Retrieve the last digit.
                mappedNum += placeValue * mapping[digit];  // Map the digit and add to mappedNum considering the place value.
                placeValue *= 10;  // Move to the next place value (tens, hundreds, etc.).
                originalNum /= 10;  // Drop the last digit.
            }
          
            // Store the mapped number and the original index in the array.
            mappedWithIndex[i] = new int[] {mappedNum, i};
        }
      
        // Sort the array 'mappedWithIndex' based on the mapped numbers and indices.
        Arrays.sort(mappedWithIndex, (a, b) -> 
            a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]); // If mapped numbers are equal, compare index.
      
        // Prepare the final sorted array based on the mapped values.
        int[] sortedArray = new int[n];
        for (int i = 0; i < n; ++i) {
            sortedArray[i] = nums[mappedWithIndex[i][1]];
        }
      
        // Return the sorted array.
        return sortedArray;
    }
}