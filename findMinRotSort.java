// Time Complexity : All the operations are done in O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* APPROACH:
set minimum as first value of array.
Now check:
1. if middle value is less than min, update min to the middle value and set high to mid - 1;
2. id middle value is greater than min, update start to mid + 1;
*/

import java.util.Arrays;

public class findMinRotSort {

    // no need to take an initial minimum value, algorithm should terminate as soon as minimum is found
//     public int findMin(int[] nums) {
//         int low = 0;
//         int high = nums.length - 1;
//         int mid = 0;
//         int min = nums[0];

//         while(low <= high){
//             mid = low + (high - low)/2;
//             if(nums[mid] < min){
//                 min = nums[mid];
//                 high = mid-1;
//             } else {
//                 low = mid + 1;
//             }

//         }
//         return min;
//     }

    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while(low<=high) {
            mid = low + (high - low)/2;
            //complete array is sorted
            if (nums[low] <= nums[high]) {
                return nums[low];
            }
            //if the mid is the minimum itself
            if (nums[mid] < nums[mid+1] && nums[mid] < nums[mid-1]){
                return nums[mid];
            }//left is sorted, thus minimum would be in right
            else if(nums[mid] >= nums[low]){
                low = mid + 1;
            } //right is sorted, thus minimum would be in left
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        int[] nums = {3,4,5,1,2}; //1
        System.out.println("nums1 sol: " + findMin(nums));

        int[] nums2 = {4,5,6,7,0,1,2}; //0
        System.out.println("nums2 sol: " + findMin(nums2));

        int[] nums3 = {11,13,15,17}; //11
        System.out.println("nums3 sol: " + findMin(nums3));
    }
}
