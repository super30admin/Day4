// Time Complexity : O(log(N) , as we are using binary search
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO



public class Problem3 {
    public int findPeakElement(int[] nums) {

        int low =0;
        int high = nums.length-1;

        //null check
        if(nums == null || nums.length == 0) return -1;

        while(low <=high){

            int mid = low +(high-low)/2;
            //if mid is the peak element
            if((mid ==0 || nums[mid]>nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1])){
                return mid;
            }
            //moving to greater side
            else if(mid > 0 && nums[mid-1] > nums[mid]){
                high = mid -1;

            }
            else
            {
                low = mid+1;
            }

        }

        return -1;
    }
}
