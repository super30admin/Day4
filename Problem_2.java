// Time Complexity :O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO.

//so here the hack is that if you see the min will always exist on the unsorted side.
class Problem_2 {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int low = 0;
        int high = nums.length -1;

        while(low <= high){
            //if the first at 0 index is less than or equal to last index then it means either there is only 1 element or the lowest is the min element what we're finding.
            if(nums[low] <= nums[high]) return nums[low];
            int mid = low + (high - low)/2;

            if(((mid != 0) &&(nums[mid-1] > nums[mid])) && ((mid != nums.length-1) &&(nums[mid]<nums[mid+1]))){
                return nums[mid];
            }
            //check if the left side is sorted if yes move to right
            if(nums[low] <= nums[mid]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return 234567; // return anything
    }
}