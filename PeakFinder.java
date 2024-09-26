// Time Complexity : O(logN)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : finding the pattern took most of the time.


public class Main {

    public static void main(String[] args) {
        int[] Arr = {1,2,1,3,5,6,4};        // Test case
        System.out.println(findPeakElement(Arr));   // Print statement
    }

    public static int findPeakElement(int[] nums) {
        int left = 0;                       // initialising the start and end points of the array accordingly
        int right = nums.length - 1;
        if(nums.length == 1){               // if the array is of length 1, return the index 0
            return 0;
        }

        while(left < right){                // binary search until the left index crosses over right - exit case
            int mid = left + (right -left)/2;      // mid point calculation

            if(nums[mid] > nums[mid+1]){        // compare if the mid value is greater than the one next to it
                right = mid;                    // if yes, decrement the right to mid point and check if the precedence value is lesser -
            }                                   // - to confirm peak
            else{
                left = mid + 1;                 // else increment the left to mid and check the right half of the array
            }
        }
        return left;                            // at this point, left and right are equal, returning left to indicate the index of the peak.
    }
}
