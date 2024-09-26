// Time Complexity : O(LogN)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


public class Main {

    public static void main(String[] args) {
        int[] arr = {2,2};		// test case
        int[] resultset = new int[2];
        resultset = searchRange(arr,6);
        System.out.println(resultset[0] + " , " + resultset[1]); 		// print statements
    }

    public static int[] searchRange(int[] nums, int target) {
        int right = nums.length - 1;
		int left = 0;
        int[] set ={-1,-1};			// initial the set to null case.

        while (left <= right) {		// initial binary search exit case
            int mid = left + (right - left)/2;	// mid point calculation
            if (nums[mid] > target) {			// If the value at the mid is greater the target, decrement the right to (mid - 1) 
                right = mid - 1;
            } else if (nums[mid] < target) {	// If the value at the mid is greater the target, increment the right to (mid + 1) 
                left = mid + 1;
            } else {
                int idx = mid;
              
                while (mid >= left && nums[mid] == target) {		// traverse the left side of the mid point of array
                    set[0] = mid;
                    mid--;
                }
                mid = idx;
                
                while (mid <= right && nums[mid] == target) {		// traverse the right side of the mid point of array
                    set[1] = mid;
                    mid++;
                }
                break;
            }
        }
        return set; 		// return the result set
    }
}
