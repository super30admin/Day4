// Time Complexity : O(log N) We reduce the search space by half
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//The approach uis to use the binary search. Check if the mid value is greater than its immediate neighbours, if true then return mid
//else check check which neighbour value is greater than mid value and update the low and high accordingly

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0) return -1;

        int low=0, high = nums.length-1;

        while(low<=high){
            int mid = low + (high-low)/2;

            //check if the mid is greater than its neighbours
            if((mid==0 || nums[mid-1]<nums[mid]) &&
                    (mid==nums.length-1 || nums[mid]>nums[mid+1])){
                return mid;
            }
            else {
                //check if left of mid has grater value
                if( mid>0 && (nums[mid-1]>nums[mid])){
                    high = mid-1;
                }
                else {
                    //right of mid element has greater value
                    low = mid+1;
                }
            }
        }
        return -1;
    }
}
