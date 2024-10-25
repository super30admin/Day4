//153. Find Min in Rotated Array - https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
//Time Complexity: O(n)
//Space Complexity: O(1)

class Solution {
    public int findMin(int[] nums) {

        int low = 0, high = nums.length-1;

        while(low<=high){
            //if we are in sorted part of the array
            if(nums[low] < nums[high])
                return nums[low];
            //calculate mid
            int mid = low + (high-low)/2;
            //check if mid is the minimum
            if((mid == low || nums[mid] < nums[mid-1]) &&
                    (mid == high || nums[mid] < nums[mid+1])){
                return nums[mid];
            }
            //sorted side - move to unsorted part
            else if(nums[low] <= nums[mid]){ //Right sorted
                low = mid+1;
            }else {
                high=mid-1; //left sorted
            }
        }
        return -1;
    }
}