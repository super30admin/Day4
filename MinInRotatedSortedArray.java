/**Leetcode Question 153 - Find Minimum in Rotated Sorted Array */

/**Algorithm  - Binary Search
 * Divide the array into two parts and compare the element at mid with mid-1 and mid+1
 * If mid >mid-1 && mid<mid+1, return mid
 * else set the low and high accordingly
 */

/**TC - O(log N)
 * SC - O(1)
 */
public class MinInRotatedSortedArray {
    class Solution {
        public int findMin(int[] nums) {
            int low =0; 
            int high = nums.length-1;
            if(nums ==null ||nums.length == 0){
                return -1;
            }
            while(low<=high){
                if(nums[low]<= nums[high]){
                    return nums[low];
                }
                int mid = low + (high - low)/2;
                if((mid == low || nums[mid] <nums[mid-1]) && (mid == high ||nums[mid]< nums[mid + 1])){
                    return nums[mid];
                }
                else if(nums[low] <= nums[mid]){
                    low = mid +1;
                }
                else{
                    high = mid -1;
                }
            }
            return -1;
        }
    }
    
}
