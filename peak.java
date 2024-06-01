// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    public int findPeakElement(int[] nums) {

        if(nums == null || nums.length==0){
            return -1;
        }

        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int middle = low + (high - low) / 2;
            if( (middle == low || nums[middle-1] < nums[middle] ) && (  middle == nums.length-1 || nums[middle] > nums[middle+1]) ){
                return middle; // check if middle is the peak
            }else if(nums[middle] < nums[middle+1]){ // moving towards lesser number
                    low = middle + 1;
            }else{
                high =  middle - 1;
            }
        }
        return 0 ;
    }
}