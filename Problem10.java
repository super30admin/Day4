// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Problem10 {
    public int findMin(int[] nums) {
        int min = 5001;
        int left = 0;
        int right = nums.length - 1;
        while(left<=right){
            int mid = left + (right - left)/2;
            //check if min value is greater than mid value
            //if it is greater change the min to mid value
            if(min>nums[mid]){
                min = nums[mid];
            }
            //Then check for sorted side in the array
            //if left side is sorted
            if(nums[left]<=nums[mid]){
                //if min value is greater than left value 
                //assign left value to min
                if(min>nums[left]){
                    min = nums[left];
                }
                //And eliminate left half
                left = mid + 1; // Search in the right half
            }else{
                //means right side is sorted
                //if min value is greater than mid value 
                //assign mid value to min
                if(min>nums[mid]){
                    min = nums[mid];
                }
                //And eliminate right half
                right = mid - 1; // Search in the left half
            }
        }
        return min;
    }
}