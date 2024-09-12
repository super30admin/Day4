package BinarySearch2;

public class problem9_minValRotatedArray {

    /*
    Brute Force ---->
        Time Complexity : O(n)
        Space Complexity: O(1)
    */
    private int findMin(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length ; i++) {
            minVal = Math.min(nums[i], minVal);
        }
        return minVal;
    }

    /*
    Binary search Technique ---->
    A)
        Time Complexity: O(log n)
        Space Complexity: O(1)
     */
    private int findMin2(int[] nums) {
        if(nums == null) return -1;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[low] <= nums[high]) return nums[low]; // it means it is perfectly sorted array

            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) {
                return nums[mid];
            } else if(nums[low] <= nums[mid]) { //this will be the sorted side
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 99999;
    }

    public static void main(String[] args) {
        /*
        Sample 1:
            Input: [3,4,5,1,2]
            Output: 1

        Sample 2:
            Input: [4,5,6,7,0,1,2]
            Output: 0
         */
    }
}
