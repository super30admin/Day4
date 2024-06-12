// Time Complexity :O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public int findPeakElement(int[] nums) {
    if(nums == null || nums.length==0) return -1;
    
    int low = 0;
    int high = nums.length-1;
    
    while(low<=high){
        int mid = low + (high-low)/2;
        //checking the condition if mid is greater than both the left and right elements
        if((mid==0 || nums[mid] > nums[mid-1]) && (mid == nums.length-1 || nums[mid] > nums[mid+1])){
            return mid;
        }else if(mid == nums.length-1 || nums[mid] < nums[mid+1]){ // moving towards the greater element
            low = mid+1;
        }else{
            high=mid-1;
        }
    }
    return 5454;
}
